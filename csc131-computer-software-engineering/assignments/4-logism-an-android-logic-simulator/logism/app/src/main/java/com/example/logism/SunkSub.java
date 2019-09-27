/**
 * SunkSub extends the abstract state to represent the state for each cell.
 * 
 * @author Daryl Posnett, Ph.D.
 */
public class SunkSub extends AbstractGridCell{
    /**
     * @author Daryl Posnett, Ph.D.
     * @param myCell
     */
    SunkSub(AbstractGridCell myCell) {
        super(myCell);
    }

    /**
     * @author Daryl Posnett, Ph.D.
     * @param Canvas
     * @param paint
     */
    public void drawGrid(Canvas Canvas, Paint paint) {
        super.drawGrid(canvas, paint, Color.RED);
    }
}