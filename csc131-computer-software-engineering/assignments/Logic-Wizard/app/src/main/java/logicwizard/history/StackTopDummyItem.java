package logicwizard.history;

import androidx.annotation.NonNull;

import logicwizard.state.StateManager;

/**
 * Always sits on the top of the history stack. Acts as a place for the currentItem to rest
 * after the redo's been exhausted. Provides feedback via the status bar if the buttons keep
 * being pressed.
 */
class StackTopDummyItem extends AbstractHistoryItem {

    StateManager stateManager;

    private AbstractHistoryItem prevItem;

    StackTopDummyItem(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    @Override
    void performUndo() {
        stateManager.setStatusBarText("Nothing to undo!");
    }

    @Override
    void performRedo() {
        stateManager.setStatusBarText("Nothing to redo!");
    }

    @Override
    AbstractHistoryItem getPrevItem() {
        return prevItem;
    }

    @Override
    void setPrevItem(AbstractHistoryItem prevItem) {
        this.prevItem = prevItem;
    }

    @Override
    AbstractHistoryItem getNextItem() {
        return null;
    }

    @Override
    void setNextItem(AbstractHistoryItem nextItem) {

    }

    @Override
    boolean hasPrevItem() {
        return true;
    }

    @Override
    boolean hasNextItem() {
        return false;
    }

    @NonNull
    @Override
    public String toString() {
        return "[ Redo Exhausted ]";
    }
}
