package logisim.sidebar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Rect;

import java.lang.reflect.Constructor;

import logisim.Grid;
import logisim.state.modes.AddMode;
import logisim.tiles.IDraggable;
import logisim.util.GridPoint;
import logisim.util.LocalPoint;
import logisim.util.Paints;
import logisim.util.ScreenPoint;
import logisim.util.Size;
import logisim.tiles.components.Component;
import logisim.util.TextDrawUtil;

public class ComponentSidebarButton extends SidebarButton implements IDraggable {

    private final int Rresouce;

    private Constructor componentConstructor;

    private final Grid grid;

    public ComponentSidebarButton(LocalPoint point, int length, String componentName, int Rresource, ComponentSidebar partition, Class<? extends Component> representedComponent, Grid grid) {
        super(point, new Size(length, length), componentName, partition);
        this.Rresouce = Rresource;
        this.grid = grid;
        try {
            componentConstructor = representedComponent.getDeclaredConstructor(Grid.class);
        } catch (Exception ex) {
            System.err.println("Unable to get constructor for component: " + ex.getLocalizedMessage());
            System.err.println("The app will now close, as it will not work properly.");
            System.exit(1);
        }
    }

    @Override
    public void draw() {
        super.draw();
        drawComponentImage();
    }

    public Bitmap getComponentImage() {
        return BitmapFactory.decodeResource(sidebar.screenManager.appContext.getResources(), Rresouce);
    }

    @Override
    public String getName() {
        return this.label;
    }

    @Override
    public IDraggable onDrag() {
        sidebar.stateManager.setMode(new AddMode(sidebar.stateManager, this, grid));
        return this;
    }

    @Override
    public void onTap() {

    }

    @Override
    public void drawLabel() {
        Paint paint = Paints.LABEL_TEXT;
        int xPos = getLocalCenter().x - TextDrawUtil.getTextWidthPx(label, paint) / 2;
        int yPos = size.height - TextDrawUtil.getTextHeightPx(label, paint);
        debugText.addText("labelPos: " + new ScreenPoint(xPos, yPos));
        canvas.drawText(label, xPos, yPos, paint);
    }

    public Component createNewComponent(GridPoint gridPoint, Grid grid) {
        try {
            if (grid.getTile(gridPoint) == null) {
                Component newComponent = (Component) componentConstructor.newInstance(grid);
                grid.setTile(gridPoint, newComponent);
                return newComponent;
            }
        } catch (Exception ex) {
            System.out.println("Caught exception creating component: " + ex.getLocalizedMessage());
            ex.printStackTrace();
        }
        return null;
    }

    private void drawComponentImage() {
        Rect orgImgRect = new Rect(0, 0, getComponentImage().getWidth(), getComponentImage().getWidth());
        Rect transformImgRect = new Rect(0, 0, size.width, size.height);
        transformImgRect.offsetTo(0, size.height / 4);
        debugText.addText("Img size: " + new Size(transformImgRect.width(), transformImgRect.height()));
        debugText.addText("Img at: " + new ScreenPoint(transformImgRect.left, transformImgRect.top));
        canvas.drawBitmap(getComponentImage(), orgImgRect, transformImgRect, Paints.IMAGE_OPAQUE);
    }

}
