package logicwizard.tiles;

import android.graphics.Bitmap;

/**
 * Represents the information necessary to render a dragged object.
 */
public interface IDraggable {

    Bitmap getComponentImage();

    String getName();

}
