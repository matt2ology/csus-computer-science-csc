package logisim.sidebar;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

import androidx.annotation.NonNull;

import logisim.IInteractable;
import logisim.tiles.IDraggable;
import logisim.util.DebugTextDrawer;
import logisim.util.LocalPoint;
import logisim.util.Paints;
import logisim.util.Size;

public abstract class SidebarButton implements IInteractable {

    public final String label;

    protected final ComponentSidebar sidebar;
    private Bitmap image;
    protected Canvas canvas;

    public final LocalPoint point;
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
    public IDraggable onDrag() {
        return null;
    }

    private void drawBounds() {
        Rect bounds = new Rect(0, 0, size.width - 1, size.height - 1);
        canvas.drawRect(bounds, Paints.BUTTON_BORDER_COLOR);
    }

    public LocalPoint getCenterForPartition() {
        return new LocalPoint(point.x + size.width / 2, point.y + size.height / 2);
    }

    public LocalPoint getLocalCenter() {
        return new LocalPoint(size.width / 2, size.height / 2);
    }

    public Bitmap getImage() {
        return image;
    }

    @NonNull
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(" + label + ")";
    }

}
