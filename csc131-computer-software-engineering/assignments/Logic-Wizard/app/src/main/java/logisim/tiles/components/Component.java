package logisim.tiles.components;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import logisim.Grid;
import logisim.IInteractable;
import logisim.state.modes.ComponentInteractMode;
import logisim.tiles.IDraggable;
import logisim.util.DebugTextDrawer;
import logisim.util.GridPoint;
import logisim.util.LocalPoint;
import logisim.util.PaintBuilder;
import logisim.util.Paints;
import logisim.util.Util;

public abstract class Component implements IDraggable, IInteractable {

    protected Grid grid;

    private Bitmap image;
    protected Canvas canvas;

    protected final DebugTextDrawer debugText;

    private final Set<Component> outputs = new HashSet<>();

    /**
     * The location of the component on the grid;
     * Mutable but should not be modified except by the grid.
     */
    private GridPoint point;

    private boolean onGrid = false;

    public Component(Grid grid) {
        this.grid = grid;
        this.debugText = new DebugTextDrawer(true);
        createCanvas();
    }

    /**
     * A wire is being dragged to the component. It is up to the component to decide what
     * to do.
     */
    public abstract void processConnection(Component source);

    public abstract int getRresource();

    public abstract String getStorageID();

    public abstract boolean hasOutputPin();

    public abstract boolean hasInputPin();

    public boolean canAcceptWire(Component component) {
        return true;
    }

    public abstract void drawWires(Canvas canvas);

    /**
     * Get the result of the component, by evaluating a tree of connected inputs recursively,
     * as shown in Daryl Posnett's Logisim Evaluation Example.
     */
    public abstract boolean eval();

    public abstract List<Component> getInputs();

    public final List<Component> getOutputs() {
        return new LinkedList<>(outputs);
    }

    @Nullable
    public abstract Component getInput(int input);

    public abstract void removeInput(Component component);

    public final void setInput(int input, Component component) {
        Component compPreUpdate = getInput(input);
        if (compPreUpdate != null)
            compPreUpdate.removeOutput(this);

        setInputInternal(input, component);

        Component compPostUpdate = getInput(input);
        if (compPostUpdate != null)
            compPostUpdate.addOutput(this);
    }

    protected abstract void setInputInternal(int input, Component component);

    public final void setInputs(List<Component> inputList) {
        // Clear existing inputs
        for (int i = 0; i < getInputs().size(); i++) {
            setInput(i, null);
        }
        for (int i = 0; i < inputList.size(); i++) {
            setInput(i, inputList.get(i));
        }
    }

    private void removeOutput(Component component) {
        outputs.remove(component);
    }

    private void addOutput(Component component) {
        outputs.add(component);
    }

    /**
     * Returns the point local to grid partition of the input that the wire should be
     * routed to.
     */
    public abstract LocalPoint getInputPosFor(Component component);

    /**
     * Gets the string representing any additional data needed to recreate the component from disk.
     */
    public abstract String getAdditionalStorageData();

    /**
     * Loads additional data; The output from {@link Component#getAdditionalStorageData()}
     * @param scanner A scanner attached to the line from storage representing this component
     *                with the storageID and component's coordinate already parsed.
     */
    public abstract void loadAdditionalStorageData(Scanner scanner);

    public final Bitmap getRenderImage() {
        return image;
    }

    public final Bitmap getComponentImage() {
        return BitmapFactory.decodeResource(grid.screenManager.appContext.getResources(), getRresource());
    }

    public void draw() {
//        validate();
        createCanvas();
        debugText.addText("gpos: " + getPoint());
        debugText.addText("pos: " + grid.convertToLocalPoint(getPoint()));
        drawComponentImage();
        drawDebugText();
    }

    public void drawDebugText() {
        debugText.draw(canvas);
    }

    @Override
    public void onTouch() {
        grid.stateManager.setMode(new ComponentInteractMode(grid.stateManager, this, grid));
    }

    @Override
    public void onTap() {
    }

    @Override
    public IDraggable onDrag() {
        return this;
    }

    public final GridPoint getPoint() {
        return this.point.copy();
    }

    /**
     * Returns the point local to the grid partition of the output that the wire should draw from
     */
    public LocalPoint getOutputPos() {
        return convertToGridSpace(new LocalPoint((int) ((128.0 / 150) * grid.tileLength), getRect().centerY()));
    }

    public void setOnGrid(boolean onGrid) {
        this.onGrid = onGrid;
    }

    public boolean notOnGrid() {
        return !onGrid;
    }

    public final Rect getRect() {
        return new Rect(0, 0, grid.tileLength, grid.tileLength);
    }

//    @CallSuper
//    public void validate() {
//        for (int i = 0; i < getInputs().size(); i++) {
//            Component input = getInputs().get(i);
//            if (input == null || input.notOnGrid()) {
//                setInput(i, null);
//            }
//        }
//    }

    @NonNull
    @Override
    public String toString() {
        return getName() + getPoint();
    }

    /**
     * This method is for use by the Grid class. To move a component call {@link Grid#moveTile(GridPoint, GridPoint)}
     * Otherwise things will come out of sync.
     */
    public final void setPoint(GridPoint point) {
        this.point = point.copy();
    }

    protected LocalPoint convertToGridSpace(LocalPoint localTilePoint) {
        return new LocalPoint(localTilePoint.x + grid.tileLength * getPoint().x, localTilePoint.y + grid.tileLength * getPoint().y);
    }

    protected void drawWire(Canvas canvas, Component source, Component dest) {
        if (source != null && dest != null)
            Util.drawWire(canvas, source, dest);
    }

    private void drawComponentImage() {
        Bitmap componentImage = getComponentImage();
        Rect orgRect = new Rect(0, 0, componentImage.getWidth(), componentImage.getWidth());
        Rect transformRect = new Rect(0, 0, grid.tileLength, grid.tileLength);
        transformRect.offsetTo(0, grid.tileLength / 4);
        canvas.drawBitmap(componentImage, orgRect, transformRect, Paints.IMAGE_OPAQUE);
    }

    private void createCanvas() {
        image = Bitmap.createBitmap(grid.tileLength, grid.tileLength, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(image);
    }
}
