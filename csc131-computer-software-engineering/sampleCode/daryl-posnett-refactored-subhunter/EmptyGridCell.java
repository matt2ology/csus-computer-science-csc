/**
 * EmptyGridCell extends the abstract state to represent the state for each cell.
 * 
 * @author Daryl Posnett, Ph.D.
 * 
 */
public class EmptyGridCell extends AbstractGridCell {
    /**
     * @author Daryl Posnett, Ph.D.
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public EmptyGridCell(int x, int y, int w, int h) {
        super(x, y, w, h);
    }

    /**
     * @author Daryl Posnett, Ph.D.
     * @param myCell
     */
    public EmptyGridCell(AbstractGridCell myCell) {
        super(myCell);
    }

    /**
     * @author Daryl Posnett, Ph.D.
     * @return new Shot(this)
     */
    public AbstractGridCell takeShot() {
        return new Shot(this);
    }
}