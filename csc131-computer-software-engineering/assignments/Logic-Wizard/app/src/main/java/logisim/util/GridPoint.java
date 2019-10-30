package logisim.util;

/**
 * Represents the coordinate of a grid tile. (0, 0) is top-left.
 */
public class GridPoint extends SpecializedPoint {

    public GridPoint(int x, int y) {
        super(x, y);
    }

    public GridPoint copy() {
        return new GridPoint(x, y);
    }

}
