package logisim;

import android.graphics.Bitmap;
import android.graphics.Canvas;

import logisim.util.LocalPoint;
import logisim.util.ScreenPoint;
import logisim.util.Size;

public interface IScreenPartition {

    /**
     * 
     * @param screenPoint
     * @return
     */
    boolean containsTouch(ScreenPoint screenPoint);

    /**
     * 
     * @param localPoint
     * @return
     */
    IInteractable getTouchedObject(LocalPoint localPoint);

    /**
     * 
     * @param globalPoint
     * @return
     */
    LocalPoint convertToLocalPoint(ScreenPoint globalPoint);

    void draw();

    Bitmap getPartitionBitmap();

    String getName();

    ScreenPoint getOrigin();

    Size getSize();

}
