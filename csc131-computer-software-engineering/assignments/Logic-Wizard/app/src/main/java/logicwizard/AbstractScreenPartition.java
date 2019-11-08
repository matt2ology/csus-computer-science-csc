package logicwizard;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import logicwizard.state.StateManager;
import logicwizard.util.LocalPoint;
import logicwizard.util.ScreenPoint;
import logicwizard.util.Size;

public abstract class AbstractScreenPartition implements IScreenPartition {

    public final ScreenManager screenManager;
    public final StateManager stateManager;

    private final ScreenPoint origin;
    private final Size size;

    protected final Canvas canvas;
    private final Bitmap image;

    /**
     * @param origin The screen point location of the top-left corner of this partition
     * @param size The size of the partition in pixels
     */
    public AbstractScreenPartition(ScreenPoint origin, Size size, ScreenManager screenManager, StateManager stateManager) {
        this.origin = origin;
        this.size = size;
        image = Bitmap.createBitmap(getSize().width, getSize().height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(image);
        this.screenManager = screenManager;
        this.stateManager = stateManager;
    }

    /**
     * Returns if the provided screen point falls within this partition.
     */
    @Override
    public final boolean containsTouch(ScreenPoint screenPoint) {
        Rect bounds = new Rect(0, 0, getSize().width, getSize().height);
        LocalPoint localPoint = convertToLocalPoint(screenPoint);
        return bounds.contains(localPoint.x, localPoint.y);
    }

    /**
     * Converts a screen point to a point local to the partition.
     */
    public final LocalPoint convertToLocalPoint(ScreenPoint globalPoint) {
        LocalPoint newPoint = new LocalPoint(globalPoint.x, globalPoint.y);
        newPoint.offset(-origin.x, -origin.y);
        return newPoint;
    }

    /**
     * Converts a point localized to this partition to the global display space
     */
    public final ScreenPoint convertToScreenPoint(LocalPoint localPoint) {
        ScreenPoint newPoint = new ScreenPoint(localPoint.x, localPoint.y);
        newPoint.offset(origin.x, origin.y);
        return newPoint;
    }

    /**
     * The rendered image of this partition
     * Used after {@link IScreenPartition#draw()}
     * @return Image
     */
    @Override
    public Bitmap getPartitionBitmap() {
        return image;
    }

    /**
     * The top-left corner of this partition
     * @return point of origin
     */
    public ScreenPoint getOrigin() {
        return origin;
    }

    /**
     * The size in pixels of this partition
     */
    public Size getSize() {
        return size;
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public Bitmap getImage() {
        return image;
    }
}
