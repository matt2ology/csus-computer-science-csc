package logisim;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import logisim.state.StateManager;
import logisim.util.LocalPoint;
import logisim.util.ScreenPoint;
import logisim.util.Size;

public abstract class AbstractScreenPartition implements IScreenPartition {

    public final ScreenManager screenManager;
    public final StateManager stateManager;

    private final ScreenPoint origin;
    private final Size size;

    protected final Canvas canvas;
    private final Bitmap image;

    /**
     * 
     * @param origin
     * @param size
     * @param screenManager
     * @param stateManager
     */
    public AbstractScreenPartition(ScreenPoint origin, Size size, ScreenManager screenManager, StateManager stateManager) {
        this.origin = origin;
        this.size = size;
        image = Bitmap.createBitmap(size.width, size.height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(image);
        this.screenManager = screenManager;
        this.stateManager = stateManager;
    }

    /**
     * 
     * @param screenPoint
     * @return
     */
    @Override
    public final boolean containsTouch(ScreenPoint screenPoint) {
        Rect bounds = new Rect(0, 0, size.width, size.height);
        LocalPoint localPoint = convertToLocalPoint(screenPoint);
        return bounds.contains(localPoint.x, localPoint.y);
    }

    /**
     * 
     * @param globalPoint
     * @return
     */
    public final LocalPoint convertToLocalPoint(ScreenPoint globalPoint) {
        LocalPoint newPoint = new LocalPoint(globalPoint.x, globalPoint.y);
        newPoint.offset(-origin.x, -origin.y);
        return newPoint;
    }

    /**
     * 
     * @param localPoint
     * @return
     */
    public final ScreenPoint convertToScreenPoint(LocalPoint localPoint) {
        ScreenPoint newPoint = new ScreenPoint(localPoint.x, localPoint.y);
        newPoint.offset(origin.x, origin.y);
        return newPoint;
    }

    /**
     * 
     * @return Image
     */
    @Override
    public Bitmap getPartitionBitmap() {
        return image;
    }

    /**
     * 
     * @return point of origin
     */
    public ScreenPoint getOrigin() {
        return origin;
    }

    /**
     * 
     * @return
     */
    public Size getSize() {
        return size;
    }
}
