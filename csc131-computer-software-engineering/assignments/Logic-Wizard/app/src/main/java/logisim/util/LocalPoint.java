package logisim.util;

public class LocalPoint extends SpecializedPoint {

    public LocalPoint(int x, int y) {
        super(x, y);
    }

    public LocalPoint copy() {
        return new LocalPoint(x, y);
    }

}
