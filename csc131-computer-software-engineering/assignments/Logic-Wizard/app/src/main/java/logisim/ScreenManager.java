package logisim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.Display;
import android.widget.ImageView;

import java.util.LinkedList;

import logisim.state.StateManager;
import logisim.util.DebugTextDrawer;
import logisim.util.LocalPoint;
import logisim.util.Paints;
import logisim.util.ScreenPoint;
import logisim.util.Size;
import logisim.util.TouchAction;
import logisim.util.Util;

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
     * 
     * @param display
     * @param imageView
     * @param appContext
     */
    public ScreenManager(Display display, ImageView imageView, Context appContext) {
        this.partitions = new LinkedList<>();
        this.display = display;
        this.appContext = appContext;
        this.imageView = imageView;
        debugText = new DebugTextDrawer(new LocalPoint(getDisplaySize().width - 4, getDisplaySize().height - 4), true);
        debugText.drawDownwards = false;
        debugText.alignRight = true;
        createCanvas();
    }

    /**
     * 
     * @return
     */
    public Size getDisplaySize() {
        Point sizePoint = new Point();
        display.getSize(sizePoint);
        return new Size(sizePoint.x, sizePoint.y);
    }

    /**
     * 
     * @param partition
     */
    public void addPartition(IScreenPartition partition) {
        partitions.add(partition);
    }

    /**
     * 
     * @param screenPoint
     * @param action
     */
    public void handleTouch(ScreenPoint screenPoint, int action) {
        TouchAction touchAction = TouchAction.get(action);
        if (touchAction == null)
            return;
        stateManager.update(screenPoint, touchAction);
        this.draw();
    }

    /**
     * 
     * @param screenPoint
     * @return
     */
    public IInteractable getTouchedObject(ScreenPoint screenPoint) {
        IScreenPartition partition = getTouchedPartition(screenPoint);
        if (partition != null) {
            return partition.getTouchedObject(partition.convertToLocalPoint(screenPoint));
        } else {
            return null;
        }
    }

    /**
     * 
     * @param screenPoint
     * @return
     */
    private IScreenPartition getTouchedPartition(ScreenPoint screenPoint) {
        for (IScreenPartition partition : partitions) {
            if (touchIsInside(partition, screenPoint)) {
                return partition;
            }
        }
        return null;
    }

    public void draw() {
        debugText.addText("Display Size: " + getDisplaySize());
        for (IScreenPartition partition : partitions) {
            partition.draw();
            ScreenPoint origin = partition.getOrigin();
            debugText.addText("");
            debugText.addText(partition.getName() + " origin: " + partition.getOrigin());
            debugText.addText(partition.getName() + " size: " + partition.getSize());
            mainCanvas.drawBitmap(partition.getPartitionBitmap(), origin.x, origin.y, Paints.IMAGE_OPAQUE);
        }
        stateManager.draw();
        debugText.draw(mainCanvas);
        this.imageView.setImageBitmap(this.mainImage);
    }

    private void createCanvas() {
        this.mainImage = Bitmap.createBitmap(getDisplaySize().width, getDisplaySize().height, Bitmap.Config.ARGB_8888);

        this.mainCanvas = new Canvas(this.mainImage);
    }

    public Canvas getCanvas() {
        return mainCanvas;
    }

    /**
     * 
     * @param partition
     * @param screenPoint
     * @return
     */
    private boolean touchIsInside(IScreenPartition partition, ScreenPoint screenPoint) {
        Rect partitionBounds = Util.getRect(partition.getOrigin(), partition.getSize());

        return partitionBounds.contains(screenPoint.x, screenPoint.y);
    }

    /**
     * 
     * @param stateManager
     */
    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }
}
