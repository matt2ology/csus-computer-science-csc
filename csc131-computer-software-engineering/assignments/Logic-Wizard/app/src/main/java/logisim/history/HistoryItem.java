package logisim.history;

class HistoryItem extends AbstractHistoryItem {

    private UndoProcedure procedure;

    private AbstractHistoryItem prevItem = null;
    private AbstractHistoryItem nextItem = null;

    HistoryItem(UndoProcedure procedure) {
        this.procedure = procedure;
    }

    @Override
    void performUndo() {
        procedure.performUndo();
    }

    @Override
    void performRedo() {
        procedure.performRedo();
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
        return nextItem;
    }

    @Override
    void setNextItem(AbstractHistoryItem nextItem) {
        this.nextItem = nextItem;
    }

    @Override
    boolean hasPrevItem() {
        return true;
    }

    boolean hasNextItem() {
        return nextItem != null;
    }
}
