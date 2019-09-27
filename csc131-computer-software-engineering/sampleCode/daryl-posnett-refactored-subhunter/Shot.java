/**
 * Shot extends the abstract state to represent the state for each cell.
 * 
 * @author Daryl Posnett, Ph.D.
 */
public class Shot extends AbstractGridCell {
    /**
     * @author Daryl Posnett, Ph.D.
     * @param myCell
     */
    Shot(AbstractGridCell myCell) {
        super(myCell);
    }

    /**
     * @author Daryl Posnett, Ph.D.
     * @param canvas
     * @param paint
     */
    public void drawGrid(Canvas canvas, Paint paint) {
        super.drawGrid(canvas, paint, Color.BLUE);
    }

    /**
     * @author Daryl Posnett, Ph.D.
     * @return new EmptyGridCell(this)
     */
    public AbstractGridCell clearShot() {
        return new EmptyGridCell(this);
    }

}