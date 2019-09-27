/**
 * AbstractGridCell represents a single grid cell in the game grid. It is the
 * base class for each of the different state classes that each grid cell can
 * represent.
 * 
 * @author Daryl Posnett, Ph.D.
 */
public class AbstractGridCell {
    private int x, y, w, h;
    
    /**
     * @author Daryl Posnett, Ph.D.
     * @param x
     * @param y
     * @param w
     * @param h
     */
    public AbstractGridCell(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }
    
    /**
     * @author Daryl Posnett, Ph.D.
     * @param myCell
     */
    public AbstractGridCell(AbstractGridCell myCell) {
        this(myCell.x, myCell.y, myCell.w, myCell.h);
    }

    public void drawGrid(Canvas canvas, Paint paint, int fillColor) {
        // ... Here you draw the grid with the known size given in x,y,w,h
    }
    
    /**
     * @author Daryl Posnett, Ph.D.
     * @param canvas
     * @param paint
     */
    public void drawGrid(Canvas canvas, Paint paint) {
        drawGrid(canvas, paint, Color.WHITE);
    }
    
    /**
     * @author Daryl Posnett, Ph.D.
     * @return
     */
    public AbstractGridCell takeShot() {
        return this;
    }
    
    /**
     * @author Daryl Posnett, Ph.D.
     * @return
     */
    public AbstractGridCell clearShot() {
        return this;
    }
}