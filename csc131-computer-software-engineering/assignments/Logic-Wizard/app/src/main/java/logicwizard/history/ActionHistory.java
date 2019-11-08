package logicwizard.history;

import java.util.LinkedList;
import java.util.List;

import logicwizard.state.StateManager;

/**
 * Contains a history of actions the user took allowing them to be undone or redone.
 */
public class ActionHistory {

    /**
     * Arbitrary limit to the size of the history stack.
     * Must be set to at least 3. pushAction performs unchecked calls to these entries
     * when removing the oldest items.
     */
    private static final int MAX_HISTORY = 100;

    private final StateManager stateManager;

    /**
     * Inserted items are added just below this item.<br>
     * When redo is pressed enough, currentItem is set to this
     * to prevent the actual top item from repeatedly having its redo action performed.
     */
    private StackTopDummyItem topItem;
    /**
     * The current place in the history.<br>
     * Travels up and down the stack as the undo and redo buttons are pressed, performing its
     * associated UndoProcedure.
     */
    private AbstractHistoryItem currentItem;
    /**
     * All stack items will appear above this item.<br>
     * When undo is pressed enough, currentItem is set to this
     * so the actual bottom item doesn't have its undo action performed.
     */
    private StackFloorDummyItem bottomItem;

    public ActionHistory(StateManager stateManager) {
        this.stateManager = stateManager;
        init();
    }

    /**
     * Adds the dummy items to the stack.
     */
    private void init() {
        topItem = new StackTopDummyItem(stateManager);
        bottomItem = new StackFloorDummyItem(stateManager);
        bottomItem.setNextItem(topItem);
        topItem.setPrevItem(bottomItem);
        currentItem = bottomItem;
    }

    /**
     * Runs the undo action for currentItem then sets currentItem to one action in the past.
     */
    public void undo() {
        // If currentItem is the top dummy item, reset the currentItem to the actual top of the stack
        // with the proper undo procedure.
        if (currentItem == topItem)
            currentItem = topItem.getPrevItem();
        currentItem.performUndo();
        if (currentItem.hasPrevItem())
            currentItem = currentItem.getPrevItem();
        stateManager.screenManager.draw();
    }

    /**
     * Sets currentItem to the next item, and runs that redo procedure.
     */
    public void redo() {
        if (currentItem.hasNextItem())
            currentItem = currentItem.getNextItem();
        currentItem.performRedo();
        stateManager.screenManager.draw();
    }

    /**
     * Inserts a new history item just below the dummy top item and sets the current item
     * to this new item.<br>
     * All items after currentItem are forgotten.
     * @param action A textual description of the action performed
     * @param procedure A group of methods to be called to perform the undo/redo
     */
    public void pushAction(String action, UndoProcedure procedure) {
        AbstractHistoryItem newItem = new HistoryItem(procedure);
        newItem.action = action;
        if (currentItem == topItem) {
            // We are at the top of the stack, in the StackTopDummyItem;
            // Set currentItem to the actual top of the stack.
            currentItem = topItem.getPrevItem();
        }
        topItem.setPrevItem(newItem);
        newItem.setNextItem(topItem);
        newItem.setPrevItem(currentItem);
        currentItem.setNextItem(newItem);
        currentItem = newItem;

        if (getHistorySize() > MAX_HISTORY) {
            AbstractHistoryItem newLastItem = bottomItem.getNextItem().getNextItem();
            newLastItem.setPrevItem(bottomItem);
            newLastItem.getNextItem().setPrevItem(newLastItem);
            bottomItem.setNextItem(newLastItem);
        }
    }

    /**
     * Removes all history items except the top and bottom dummy items.
     */
    public void clear() {
        bottomItem.setNextItem(topItem);
        topItem.setPrevItem(bottomItem);
        currentItem = bottomItem;
    }

    private int getHistorySize() {
        int i = 0;
        AbstractHistoryItem look = topItem;
        while (look.hasPrevItem()) {
            look = look.getPrevItem();
            i++;
        }
        // Subtract one to exclude the dummy floor item from being counted.
        return i-1;
    }

    /**
     * Render the contents of the history to StateManager's debugText.
     */
    public void addDebugInformation() {
        stateManager.debugText.addText("History [" + getHistorySize() + " of " + MAX_HISTORY + "]");
        stateManager.debugText.addText("------------------------");
        for (AbstractHistoryItem item : getHistoryList()) {
            stateManager.debugText.addText(item.toString() + (item == currentItem ? " <-- |" : "     |"));
        }
    }

    private List<AbstractHistoryItem> getHistoryList() {
        LinkedList<AbstractHistoryItem> items = new LinkedList<>();
        AbstractHistoryItem look = currentItem;
        if (look != null) {
            while (look.hasNextItem()) {
                look = look.getNextItem();
            }
            while (look.hasPrevItem()) {
                items.add(look);
                look = look.getPrevItem();
            }
            items.add(look);
        }
        return items;
    }

}
