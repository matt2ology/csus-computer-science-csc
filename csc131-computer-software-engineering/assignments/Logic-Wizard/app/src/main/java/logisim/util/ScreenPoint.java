package logisim.util;

/**
 * Represents a pixel on the screen from the top left corner.
 */
public class ScreenPoint extends SpecializedPoint {

    public ScreenPoint(int x, int y) {
        super(x, y);
    }

    public ScreenPoint copy() {
        return new ScreenPoint(x, y);
    }

}
