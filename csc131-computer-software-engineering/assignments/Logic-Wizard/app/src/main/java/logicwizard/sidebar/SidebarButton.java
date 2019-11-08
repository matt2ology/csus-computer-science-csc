package logicwizard.sidebar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import logicwizard.IInteractable;
import logicwizard.tiles.IDraggable;
import logicwizard.util.DebugTextDrawer;
import logicwizard.util.LocalPoint;
import logicwizard.util.Paints;
import logicwizard.util.Size;

public abstract class SidebarButton implements IInteractable {

    /**
     * The text that renders on the button. For the component button, this label is set to the status bar.
     */
    public final String label;

    protected final ComponentSidebar sidebar;
    private Bitmap image;
    protected Canvas canvas;

    /**
     * The pixel location of the top-left corner of the button.
     */
    public final LocalPoint point;
    /**
     * The size of the button in pixels.
     */
    public final Size size;

    protected final DebugTextDrawer debugText;

    public SidebarButton(LocalPoint point, Size size, String label, ComponentSidebar sidebar) {
        this.point = point;
        this.size = size;
        this.label = label;
        createCanvas();
        this.sidebar = sidebar;
        this.debugText = new DebugTextDrawer(false);
    }

    /**
     * Creates a new transparent canvas the size of the button.
     */
    private void createCanvas() {
        image = Bitmap.createBitmap(size.width, size.height, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(image);
    }

    public void draw() {
        createCanvas();
        debugText.addText("Button Loc: " + point);
        debugText.addText("Button Size: " + size);

        drawBackground();
        drawLabel();
        drawBounds();

        debugText.draw(canvas);
    }

    public abstract void drawLabel();

    public void drawBackground() {}

    @Override
    public void onTouch() {

    }

    @Override
    @Nullable
    public IDraggable onDrag() {
        return null;
    }

    /**
     * Draws a full outline around the button.
     */
    private void drawBounds() {
        Rect bounds = new Rect(0, 0, size.width - 1, size.height - 1);
        canvas.drawRect(bounds, Paints.BUTTON_BORDER_COLOR);
    }

    /**
     * @return The point relative to the sidebar of the center of this button.
     */
    public LocalPoint getCenterForPartition() {
        return new LocalPoint(point.x + size.width / 2, point.y + size.height / 2);
    }

    /**
     * @return The center of this button relative to the top-left corner of this button.
     */
    public LocalPoint getLocalCenter() {
        return new LocalPoint(size.width / 2, size.height / 2);
    }

    /**
     * The rendered image of this button for placement onto the sidebar.
     */
    public Bitmap getImage() {
        return image;
    }

    @NonNull
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + label + ")";
    }

}
