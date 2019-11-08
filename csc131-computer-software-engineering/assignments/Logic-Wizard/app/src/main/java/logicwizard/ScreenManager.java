package logicwizard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import java.util.LinkedList;

import logicwizard.state.StateManager;
import logicwizard.util.DebugTextDrawer;
import logicwizard.util.LocalPoint;
import logicwizard.util.Paints;
import logicwizard.util.ScreenPoint;
import logicwizard.util.Size;
import logicwizard.util.TouchAction;
import logicwizard.util.Util;

public class ScreenManager {

    private final LinkedList<IScreenPartition> partitions;
    private final Display display;
    private Canvas mainCanvas;
    private Bitmap mainImage;
    private final ImageView imageView;
    protected final DebugTextDrawer debugText;

    private StateManager stateManager;

    public final Context appContext;

    /**
     * @param display    Android's display object
     * @param imageView  The view that holds all visible output from this class.
     * @param appContext Android's app context object
     */
    public ScreenManager(Display display, ImageView imageView, Context appContext) {
        this.partitions = new LinkedList<>();
        this.display = display;
        this.appContext = appContext;
        this.imageView = imageView;
        debugText = new DebugTextDrawer(new LocalPoint(getDisplaySize().width - 4, getDisplaySize().height - 4), true);
        getDebugText().drawDownwards = false;
        getDebugText().alignRight = true;
        createCanvas();
    }

    /**
     * @return The size of the screen in pixels
     */
    public Size getDisplaySize() {
        Point sizePoint = new Point();
        getDisplay().getSize(sizePoint);
        return new Size(sizePoint.x, sizePoint.y);
    }

    /**
     * Adds a new partition to the list of partitions to be drawn. Does not perform
     * sanity checks on the sizes and origins of the partition.
     */
    public void addPartition(IScreenPartition partition) {
        getPartitions().add(partition);
    }

    /**
     * Passes along the necessary information from a touch event to
     * {@link StateManager#update(ScreenPoint, TouchAction)} Also redraws the screen
     *
     * @param screenPoint The point in pixels that the display was touched.
     * @param action      The int value of the performed action
     *                    {@link android.view.MotionEvent}
     */
    public void handleTouch(ScreenPoint screenPoint, int action) {
        TouchAction touchAction = TouchAction.get(action);
        if (touchAction == null)
            return;
        getStateManager().update(screenPoint, touchAction);
        this.draw();
    }

    /**
     * Returns the object that was touched on the partition.
     *
     * @param screenPoint The touch on the screen relative to the actual display
     */
    @Nullable
    public IInteractable getTouchedObject(ScreenPoint screenPoint) {
        IScreenPartition partition = getTouchedPartition(screenPoint);
        if (partition != null) {
            return partition.getTouchedObject(partition.convertToLocalPoint(screenPoint));
        } else {
            return null;
        }
    }

    /**
     * Returns the first partition that intersects screenPoint
     */
    private IScreenPartition getTouchedPartition(ScreenPoint screenPoint) {
        for (IScreenPartition partition : partitions) {
            if (touchIsInside(partition, screenPoint)) {
                return partition;
            }
        }
        return null;
    }

    /**
     * Draws all partitions onto the main canvas.
     */
    public void draw() {
        getDebugText().addText("Display Size: " + getDisplaySize());
        for (IScreenPartition partition : partitions) {
            partition.draw();
            ScreenPoint origin = partition.getOrigin();
            getDebugText().addText("");
            getDebugText().addText(partition.getName() + " origin: " + partition.getOrigin());
            getDebugText().addText(partition.getName() + " size: " + partition.getSize());
            getMainCanvas().drawBitmap(partition.getPartitionBitmap(), origin.x, origin.y, Paints.IMAGE_OPAQUE);
        }
        getStateManager().draw();
        getDebugText().draw(mainCanvas);

        // IMPORTANT: The image view must be updated every draw for it to take effect.
        getImageView().setImageBitmap(getMainImage());
    }

    /**
     * Creates a new image and canvas.
     */
    private void createCanvas() {
        setMainImage(Bitmap.createBitmap(getDisplaySize().width, getDisplaySize().height, Bitmap.Config.ARGB_8888));
        setMainCanvas(new Canvas(getMainImage()));
    }

    public Canvas getCanvas() {
        return mainCanvas;
    }

    /**
     * Returns if a specific global point is inside a certain partition.
     */
    private boolean touchIsInside(IScreenPartition partition, ScreenPoint screenPoint) {
        Rect partitionBounds = Util.getRect(partition.getOrigin(), partition.getSize());

        return partitionBounds.contains(screenPoint.x, screenPoint.y);
    }

    /**
     * Sets the stateManager. required because StateManager and ScreenManager both
     * reference each other.
     */
    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public LinkedList<IScreenPartition> getPartitions() {
        return partitions;
    }

    public Display getDisplay() {
        return display;
    }

    public Canvas getMainCanvas() {
        return mainCanvas;
    }

    public void setMainCanvas(Canvas mainCanvas) {
        this.mainCanvas = mainCanvas;
    }

    public Bitmap getMainImage() {
        return mainImage;
    }

    public void setMainImage(Bitmap mainImage) {
        this.mainImage = mainImage;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public DebugTextDrawer getDebugText() {
        return debugText;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public Context getAppContext() {
        return appContext;
    }
}
