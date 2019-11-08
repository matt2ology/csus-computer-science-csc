package logicwizard;

import android.graphics.Bitmap;

import logicwizard.util.LocalPoint;
import logicwizard.util.ScreenPoint;
import logicwizard.util.Size;

public interface IScreenPartition {

    /**
     * @param screenPoint A point relative to the display's top-left
     * @return True if the point is inside this partition
     */
    boolean containsTouch(ScreenPoint screenPoint);

    /**
     * @param localPoint the point in pixels relative to the top-left corner of the partition.
     * @return The object at localPoint.
     */
    IInteractable getTouchedObject(LocalPoint localPoint);

    /**
     * 
     * @param globalPoint A point relative to the device's screen
     * @return The point relative to this partition
     */
    LocalPoint convertToLocalPoint(ScreenPoint globalPoint);

    void draw();

    Bitmap getPartitionBitmap();

    String getName();

    ScreenPoint getOrigin();

    Size getSize();

}
