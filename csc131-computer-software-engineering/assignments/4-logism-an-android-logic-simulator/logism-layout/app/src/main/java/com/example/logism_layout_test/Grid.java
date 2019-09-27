import java.util.Vector;

/**
 * Grid is the heart of the application and manages a collection of grid cells
 * and their interaction.
 * 
 * @author Daryl Posnett, Ph.D.
 */
public class Grid {
    private class GridPosition {
        int x, y;

        /**
         * @author Daryl Posnett, Ph.D.
         * @param x
         * @param y
         */
        public GridPosition(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // ... size of grid is comprised of private variables in this class, see code
    private Vector<AbstractGridCell> gridCells;
    private List<Sub> subs;

    /**
     * @author Daryl Posnett, Ph.D.
     * @param x
     * @param y
     */
    public Grid(int x, int y) {
        // ... // Setup the private class size variables
        reset();
    }
    
    /**
     * @author Daryl Posnett, Ph.D.
     */
    public void reset() {
        rand = new URandomK(gridHeight * gridWidth);
        for (int h = 0; h < gridWidth; h++) {
            for (int v = 0; v < gridHeight; v++) {
                gridCells.add(new EmptyGridCell(h * blockSize, v * blockSize, blockSize, blockSize));
            }
        }
    }
    
    /**
     * @author Daryl Posnett, Ph.D.
     */
    public void spawnNewSub() {
        int subCell = rand.nextInt();
        gridCells.set(subCell, new Sub(gridCells.get(subCell)));
    }
    
    /**
     * @author Daryl Posnett, Ph.D.
     * @return sunkSubs count
     */
    public int sinkSubCount() {
        int sunkSubs = 0;
        for (AbstractGridCell agc : gridCells) {
            if (agc instanceof SunkSub) { // <-- Not the use of instanceof to determine object type
                sunkSubs++;
            }
        }
        return sunkSubs;
    }
    
    /**
     * @author Daryl Posnett, Ph.D.
     * @param p (grid's position)
     * @return Grid cell number.
     */
    private int gridCellN(GridPosition p) {
        return (gridHeight*p.x+p.y);        
    }
    
    /**
     * @author Daryl Posnett, Ph.D.
     * @param shotP
     * @return
     */
    private int distanceToClosestSubFrom(GridPosition shotP){
        int subDistance=gridWidth*gridHeight;
        for (int i = 0; i < gridCells.size(); i++) {
            AbstractGridCell agc = gridCells.get(i);
            if (agc instanceof Sub) {
                // Set subDistance to existing min, or distance from agc to shootP
            }
        }
        return subDistance;
    }
    
    /**
     * @author Daryl Posnett, Ph.D.
     * @param touchX
     * @param touchY
     * @return the distance to closest sub from last touched input.
     */
    public int takeShot(float touchX, float touchY) {
        GridPosition touchedPosition = new GridPosition((int) touchX / blockSize, (int) touchY / blockSize);
        // Note that the essence of changing state happens here.
        gridCells.set(lastShot,gridCells.get(lastShot).clearShot());
        gridCells.set(gridCellN(touchedPosition),gridCells.get(gridCellN(touchedPosition)).takeShot());
        lastShot=gridCellN(touchedPosition);
        return distanceToClosestSubFrom(touchedPosition);
    }
    public void drawGrid(Canvas canvas, Paint paint) {
        for (AbstractGridCell agc : gridCells) {
            agc.drawGrid(canvas,paint);
        }
    }
    
    /**
     * @author Daryl Posnett, Ph.D.
     * @return The blockSize of grid (DUH)
     */
    public int getBlockSize() {
        return blockSize;
    }
}