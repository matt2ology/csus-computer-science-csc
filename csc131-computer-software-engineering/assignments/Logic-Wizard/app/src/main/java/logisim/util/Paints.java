package logisim.util;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

public class Paints {


    //----------------------------------------------------------------------------------------------
    // TEXT PAINT
    //----------------------------------------------------------------------------------------------

    public static final int LARGE_TEXT = 24;
    public static final int STANDARD_TEXT_SIZE = 18;
    public static final int DEBUG_TEXT_SIZE = 14;

    /**
     * Labels like the save label, or the name of the component being dragged.
     */
    public static final Paint LABEL_TEXT = PaintBuilder.start()
            .setColor(Color.BLACK)
            .setTextSize(STANDARD_TEXT_SIZE).makePaint();

    /**
     * For text drawn by DebugTextDrawer
     */
    public static final Paint DEBUG_TEXT = PaintBuilder.start()
            .setColor(Color.BLACK)
            .setTypeface(Typeface.MONOSPACE)
            .setTextSize(DEBUG_TEXT_SIZE).makePaint();

    /**
     * For text drawn in the save button when in load mode, and for save slot buttons
     */
    public static final Paint SAVE_BUTTON_TEXT = PaintBuilder.start()
            .setColor(Color.BLUE)
            .setTextSize(STANDARD_TEXT_SIZE)
            .setBold(true).makePaint();

    /**
     * Save button text color when in save mode
     */
    public static final Paint SAVE_MODE_SAVE_BUTTON_TEXT = PaintBuilder.start()
            .setColor(Color.WHITE)
            .setTextSize(STANDARD_TEXT_SIZE)
            .setBold(true).makePaint();

    public static final Paint STATUS_BAR_TEXT = PaintBuilder.start()
            .setColor(Color.BLACK)
            .setTextSize(LARGE_TEXT).makePaint();


    //----------------------------------------------------------------------------------------------
    // BACKGROUND COLORS
    //----------------------------------------------------------------------------------------------

    /**
     * The transparent background behind debug text.
     */
    public static final Paint DEBUG_BACKGROUND_COLOR = PaintBuilder.start()
            .setTextSize(DEBUG_TEXT_SIZE)
            .setColor(Color.WHITE)
            .setAlpha(150).makePaint();

    public static final Paint GRID_BACKGROUND_COLOR = PaintBuilder.start()
            .setColor(Color.WHITE).makePaint();

    public static final Paint SIDEBAR_BACKGROUND_COLOR = PaintBuilder.start()
            .setColor(Color.GRAY).makePaint();

    public static final Paint SAVE_MODE_SAVE_BUTTON_BACKGROUND_COLOR = PaintBuilder.start()
            .setColor(Color.BLUE).makePaint();


    //----------------------------------------------------------------------------------------------
    // BORDER COLORS
    //----------------------------------------------------------------------------------------------

    /**
     * Color of the border surrounding buttons on the sidebar.
     */
    public static final Paint BUTTON_BORDER_COLOR = PaintBuilder.start()
            .setColor(Color.BLUE)
            .setStyle(Paint.Style.STROKE).makePaint();

    /**
     * Color of the borders of tiles forming the grid lines when drawBounds is called.
     */
    public static final Paint TILE_BORDER_COLOR_DEBUG = PaintBuilder.start()
            .setColor(Color.BLACK)
            .setStyle(Paint.Style.STROKE).makePaint();

    public static final Paint WIRE = PaintBuilder.start()
            .setStrokeWidth(3)
            .setColor(Color.BLACK).makePaint();

    public static final int TILE_OUTLINE_WIDTH = 3;

    /**
     * The outline color for tiles if a dragged component can be placed in that grid square.
     */
    public static final Paint TILE_OUTLINE_ALLOW_PLACE = PaintBuilder.start()
            .setColor(Color.BLUE)
            .setStrokeWidth(TILE_OUTLINE_WIDTH).makePaint();

    /**
     * The outline color for tiles if a dragged component <b>cannot</b> be placed in that grid square.
     */
    public static final Paint TILE_OUTLINE_DENY_PLACE = PaintBuilder.start()
            .setColor(Color.RED)
            .setStrokeWidth(TILE_OUTLINE_WIDTH).makePaint();

    public static final Paint TILE_OUTLINE_SOURCE = PaintBuilder.start()
            .setColor(0xFF27cc27) // Green
            .setStrokeWidth(TILE_OUTLINE_WIDTH).makePaint();

    //----------------------------------------------------------------------------------------------
    // BITMAP DRAWING - for calls to drawBitmap
    //----------------------------------------------------------------------------------------------


    public static final Paint IMAGE_OPAQUE = new Paint();

    public static final Paint IMAGE_TRANSLUCENT = PaintBuilder.start()
            .setAlpha(150).makePaint();

}
