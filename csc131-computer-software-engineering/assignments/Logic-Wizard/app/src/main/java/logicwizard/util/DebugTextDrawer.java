package logicwizard.util;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import logicwizard.LogicWizard;

/**
 * Draws a vertical list of text.<br>
 * Add text using {@link DebugTextDrawer#addText(String)} and render it with {@link DebugTextDrawer#draw(Canvas)}.
 * Text must be re-added every draw pass.<br>
 * <br>
 * It's important to call the draw method even if not active as this clears the input text list.<br>
 * <br>
 * The draw method should be called after all other rendering is completed because the result of this
 * can be overwritten by subsequent draw operations.
 */
public class DebugTextDrawer {

    private static final int VERTICAL_SPACING = 1;

    /**
     * The point where the text will start to be drawn on the canvas supplied to draw on.
     */
    private final LocalPoint startPos;
    /**
     * Will only render text if active is set to true.
     */
    private boolean active;

    /**
     * When true, the text will start at startPos and draw subsequent text below it.
     * When false, new text will be drawn above the previous one.
     */
    public boolean drawDownwards = true;
    /**
     * When true, the end of text will be at startPoint allowing text to be rendered on the
     * right side of the canvas.
     */
    public boolean alignRight = false;
    private final List<String> textToDraw = new LinkedList<>();

    /**
     * @param pos The point relative to the canvas (supplied at draw time) where text will be drawn.<br>
     *            Top-left corner if aligned left, Top-Right corner if aligned right.
     * @param active Text will only be rendered if this is set to true.
     */
    public DebugTextDrawer(LocalPoint pos, boolean active) {
        this.startPos = pos;
        this.active = active;
    }

    /**
     * Constructor that defaults to drawing at (1,1).
     * @param active Text will only be rendered if this is set to true.
     */
    public DebugTextDrawer(boolean active) {
        this(new LocalPoint(1, 1), active);
    }

    public void addText(String string) {
        if (string != null)
            textToDraw.add(string);
    }

    /**
     * Draws to the canvas starting at {@link DebugTextDrawer#startPos} and clears the text list.
     */
    public void draw(Canvas canvas) {
        if (getActive()) {
            if (this.drawDownwards)
                drawDownwards(canvas);
            else
                drawUpwards(canvas);
        }
        textToDraw.clear();
    }

    private void drawDownwards(Canvas canvas) {
        int yCoord = startPos.y + Paints.DEBUG_TEXT_SIZE;
        // Cloning the list prevents ConcurrentModificationExceptions when the app is being
        // overloaded with draw requests.
        for (String text : new LinkedList<>(textToDraw)) {
            drawString(canvas, text, yCoord);
            yCoord += Paints.DEBUG_TEXT_SIZE + VERTICAL_SPACING;
        }
    }

    private void drawUpwards(Canvas canvas) {
        // Cloning the list prevents ConcurrentModificationExceptions when the app is being
        // overloaded with draw requests.
        List<String> reversed = new LinkedList<>(textToDraw);
        Collections.reverse(reversed);
        int yCoord = startPos.y;
        for (String text : reversed) {
            drawString(canvas, text, yCoord);
            yCoord -= Paints.DEBUG_TEXT_SIZE + VERTICAL_SPACING;
        }
    }

    @SuppressWarnings("unused")
    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean getActive() {
        return active && LogicWizard.DEBUG_TEXT_ENABLED;
    }

    private void drawString(Canvas canvas, String text, int yCoord) {
        drawBackground(canvas, text, yCoord);
        if (alignRight)
            canvas.drawText(text, startPos.x - TextDrawUtil.getTextWidthPx(text, Paints.DEBUG_TEXT), yCoord, Paints.DEBUG_TEXT);
        else
            canvas.drawText(text, startPos.x, yCoord, Paints.DEBUG_TEXT);
    }

    private void drawBackground(Canvas canvas, String text, int yCoord) {
        Paint paint = Paints.DEBUG_BACKGROUND_COLOR;
        float width = TextDrawUtil.getTextWidthPx(text, paint);
        float height = TextDrawUtil.getTextHeightPx(text, paint);
        if (alignRight)
            canvas.drawRect(startPos.x - width, yCoord - height, startPos.x, yCoord + 2, paint);
        else
            canvas.drawRect(startPos.x, yCoord - Paints.DEBUG_TEXT_SIZE, startPos.x + (int) width, yCoord + 2, paint);
    }

}
