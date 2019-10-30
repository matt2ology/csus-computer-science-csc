package logisim.history;

import androidx.annotation.NonNull;

import logisim.state.StateManager;

class StackFloorDummyItem extends AbstractHistoryItem {

    private StateManager stateManager;

    private AbstractHistoryItem nextItem;

    StackFloorDummyItem(StateManager stateManager) {
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
        return this;
    }

    @Override
    void setPrevItem(AbstractHistoryItem prevItem) {
        // This is the bottom of the stack
        // Do nothing.
    }

    @Override
    AbstractHistoryItem getNextItem() {
        return nextItem;
    }

    @Override
    void setNextItem(AbstractHistoryItem nextItem) {
        this.nextItem = nextItem;
    }

    @Override
    boolean hasPrevItem() {
        return false;
    }

    @Override
    boolean hasNextItem() {
        return nextItem != null;
    }

    @NonNull
    @Override
    public String toString() {
        return "[ End of History ]";
    }
}
