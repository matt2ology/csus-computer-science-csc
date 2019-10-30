package logisim.history;

import androidx.annotation.NonNull;

import logisim.state.StateManager;

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
