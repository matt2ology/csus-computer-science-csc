package logicwizard.sidebar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Rect;

import java.lang.reflect.Constructor;

import logicwizard.Grid;
import logicwizard.state.modes.AddMode;
import logicwizard.tiles.IDraggable;
import logicwizard.util.GridPoint;
import logicwizard.util.LocalPoint;
import logicwizard.util.Paints;
import logicwizard.util.ScreenPoint;
import logicwizard.util.Size;
import logicwizard.tiles.components.Component;
import logicwizard.util.TextDrawUtil;

/**
 * A button that can start the drag to add a component to the grid.
 */
public class ComponentSidebarButton extends SidebarButton implements IDraggable {

    /**
     * The value for the component's image as found in R.drawable
     */
    private final int Rresource;

    /**
     * The constructor for the represented component that takes the grid object as its only parameter.
     */
    private Constructor componentConstructor;

    private final Grid grid;

    /**
     * @param point The point on the sidebar to render the button
     * @param length The size of the button in pixels.
     * @param componentName The name of the component, used as the label and shown in the status bar while dragging.
     * @param Rresource The value for the component's image as found in R.drawable.
     * @param sidebar A reference to the sidebar.
     * @param representedComponent The component class that this button is meant to add.
     * @param grid A reference to the grid.
     */
    public ComponentSidebarButton(LocalPoint point, int length, String componentName, int Rresource, ComponentSidebar sidebar, Class<? extends Component> representedComponent, Grid grid) {
        super(point, new Size(length, length), componentName, sidebar);
        this.Rresource = Rresource;
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

    /**
     * @return The image of the component as found in R.drawable
     */
    public Bitmap getComponentImage() {
        return BitmapFactory.decodeResource(sidebar.screenManager.appContext.getResources(), Rresource);
    }

    @Override
    public String getName() {
        return this.label;
    }

    /**
     * Sets the app into AddMode
     */
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

    /**
     * Creates a new component at gridPoint using the componentConstructor.
     * @return The created component.
     */
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
