package logisim.util;

import android.graphics.Canvas;
import android.graphics.Paint;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import logisim.LogiSim;

public class DebugTextDrawer {

    private static final int VERTICAL_SPACING = 1;

    private final LocalPoint startPos;
    private boolean active;

    public boolean drawDownwards = true;
    public boolean alignRight = false;
    private final List<String> textToDraw = new LinkedList<>();

    public DebugTextDrawer(LocalPoint pos, boolean active) {
        this.startPos = pos;
        this.active = active;
    }

    public DebugTextDrawer(boolean active) {
        this(new LocalPoint(1, 1), active);
    }

    public void addText(String string) {
        if (string != null)
            textToDraw.add(string);
    }

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
        return active && LogiSim.DEBUG_TEXT_ENABLED;
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
