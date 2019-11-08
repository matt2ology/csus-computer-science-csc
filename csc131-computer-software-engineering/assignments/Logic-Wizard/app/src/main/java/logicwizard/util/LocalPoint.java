package logicwizard.util;

/**
 * A ScreenPoint that's been offset to the origin of a canvas.
 */
public class LocalPoint extends SpecializedPoint {

    public LocalPoint(int x, int y) {
        super(x, y);
    }

    public LocalPoint copy() {
        return new LocalPoint(x, y);
    }

}
