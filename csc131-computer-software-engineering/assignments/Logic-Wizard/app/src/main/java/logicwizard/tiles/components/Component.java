package logicwizard.tiles.components;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import logicwizard.Grid;
import logicwizard.IInteractable;
import logicwizard.state.modes.ComponentInteractMode;
import logicwizard.tiles.IDraggable;
import logicwizard.util.DebugTextDrawer;
import logicwizard.util.GridPoint;
import logicwizard.util.LocalPoint;
import logicwizard.util.Paints;
import logicwizard.util.Util;

public abstract class Component implements IDraggable, IInteractable {

    protected Grid grid;

    /**
     * Image connected to the canvas object.
     */
    private Bitmap image;
    /**
     * The canvas just for this component.
     */
    protected Canvas canvas;

    protected final DebugTextDrawer debugText;

    /**
     * All components that this output leads to
     */
    private final Set<Component> outputs = new HashSet<>();

    /**
     * The location of the component on the grid;
     * Mutable but should not be modified except by the grid.
     */
    private GridPoint point;

    /**
     * If the component is on the grid.
     * False if the component has been dragged off the grid or it hasn't been added yet.
     */
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

    /**
     * The value found inside R.drawable
     */
    public abstract int getRresource();

    /**
     * The storage ID written to disk to identify this component.
     */
    public abstract String getStorageID();

    public abstract boolean hasOutputPin();

    /**
     * @return If this component has any input pins. It does not matter if the pins are filled or not.
     */
    public abstract boolean hasInputPin();

    /**
     * Returns if this component can accept a wire from component.
     * A wire is considered accepted if it would cause some kind of change to the inputs
     */
    public boolean canAcceptWire(Component component) {
        return true;
    }

    public void drawWires(Canvas canvas) {
        List<Component> inputs = getInputs();
        for (int i = 0; i < inputs.size(); i++) {
            if (inputs.get(i) != null) {
                debugText.addText("i" + i + ": " + inputs.get(i));
                drawWire(canvas, inputs.get(i), this);
            }
        }
    }
    /**
     * Get the result of the component, by evaluating a tree of connected inputs recursively,
     * as shown in Daryl Posnett's Logisim Evaluation Example.
     */
    public abstract boolean eval();

    /**
     * Returns all components that are connected to the input pins of this component.
     */
    public abstract List<Component> getInputs();

    /**
     * Returns all the components that this component is an input for.
     */
    public final List<Component> getOutputs() {
        return new LinkedList<>(outputs);
    }

    /**
     * Retrieves the component in the specified input.
     * @param input The index of the input pin
     * @return The Component at index `input`
     */
    @Nullable
    public abstract Component getInput(int input);

    /**
     * Disconnects the provided component from the inputs.
     */
    public abstract void removeInput(Component component);

    /**
     * This method should always be called instead of setInputInternal.
     * This method also updates the output list of the connected components if a change was made.
     * This prevents wires from lingering after a component has been removed.
     *
     * @param input The index where to attach a component
     * @param component The component to set to the input. Pass null to disconnect that component.
     */
    public final void setInput(int input, @Nullable Component component) {
        // Preemptevly remove this component from the output list of whatever component is connected to input 'input'.
        // If after setInputInternal is run, that input is removed, there would be no way to update it's output list.
        Component compPreUpdate = getInput(input);
        if (compPreUpdate != null)
            compPreUpdate.removeOutput(this);

        // Connect or disconnect 'input'.
        setInputInternal(input, component);

        // Update 'input' to add this component to it's output list if something was attached by setInputInternal.
        Component compPostUpdate = getInput(input);
        if (compPostUpdate != null)
            compPostUpdate.addOutput(this);
    }

    /**
     * Updates the input list of this component only.
     * <br>Do not call this!
     * <br><strong>Call {@link Component#setInput(int, Component)} instead!</strong>
     */
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

    /**
     * Removes component from the output list.
     */
    private void removeOutput(Component component) {
        outputs.remove(component);
    }

    /**
     * Adds component to the output list.
     */
    private void addOutput(Component component) {
        outputs.add(component);
    }

    /**
     * Returns the point local to grid partition of the input that the wire should be
     * routed to visually.
     */
    public abstract LocalPoint getInputPosFor(Component component);

    /**
     * Gets the string representing any additional data needed to recreate the component from disk.
     */
    public abstract String getAdditionalStorageData();

    /**
     * Loads additional data; The output from {@link Component#getAdditionalStorageData()}
     * @param scanner A scanner attached to the line from disk representing this component
     *                with the storageID and component's coordinate already parsed.<br>
     *                ex: all switch needs to do is parse it's state; Not gate - its inputs.
     */
    public abstract void loadAdditionalStorageData(Scanner scanner);

    /**
     * The image attached to the canvas intended for drawing to the grid.
     */
    public final Bitmap getRenderImage() {
        return image;
    }

    /**
     * The gate images as present in the drawables folder
     */
    public final Bitmap getComponentImage() {
        return BitmapFactory.decodeResource(grid.screenManager.appContext.getResources(), getRresource());
    }

    public void draw() {
        createCanvas();
        debugText.addText("gpos: " + getPoint());
        debugText.addText("pos: " + grid.convertToLocalPoint(getPoint()));
        drawComponentImage();
        drawDebugText();
    }

    public void drawDebugText() {
        debugText.draw(canvas);
    }

    /**
     * Sets the program into ComponentInteractMode<br>
     * If after a short period, the finger remains pressed on the same button, the app will be set to MoveMode.<br>
     * If the finger moves off the component, the app will be set to WireMode.
     */
    @Override
    public void onTouch() {
        grid.stateManager.setMode(new ComponentInteractMode(grid.stateManager, this, grid));
    }

    /**
     * Called when the user, touches and releases their finger on top of this component.
     * Used by switches to update their state.
     */
    @Override
    public void onTap() {
    }

    /**
     * Called when a touch is in progress, and the finger moves while still on the screen.<br>
     * This sets draggedObject in {@link logicwizard.state.StateManager}
     */
    @Override
    public IDraggable onDrag() {
        return this;
    }

    /**
     * Returns the grid location of this component.<br>
     * This method will only return null if it has never been on the grid.<br>
     * Call {@link Component#notOnGrid()} to tell if a component is on the grid.
     */
    public final GridPoint getPoint() {
        return this.point.copy();
    }

    /**
     * Returns the point local to the grid partition of the output that the wire should draw from visually.
     */
    public LocalPoint getOutputPos() {
        return convertToGridSpace(new LocalPoint((int) ((128.0 / 150) * grid.tileLength), getRect().centerY()));
    }

    /**
     * Sets the onGrid field.<br>
     * Updated by grid class when adding and removing components.
     */
    public void setOnGrid(boolean onGrid) {
        this.onGrid = onGrid;
    }

    /**
     * @return True when the component is <strong>NOT</strong> on the grid.
     */
    public boolean notOnGrid() {
        return !onGrid;
    }

    /**
     * Returns the bounds of the Component's canvas. Top-Left is (0,0) with the tileLength.
     * Used in the methods for determining the endpoints of wires.
     */
    public final Rect getRect() {
        return new Rect(0, 0, grid.tileLength, grid.tileLength);
    }

    @NonNull
    @Override
    public String toString() {
        return getName() + getPoint();
    }

    /**
     * If the storageID in the save file matches this component, sets a new instance of the super class
     * of this component to the grid at (x,y) and returns it.
     */
    @Nullable
    public Component load(String storageID, int x, int y, Scanner scanner) {
        if (storageID.equals(getStorageID()))
            return load(x, y, scanner);
        else
            return null;
    }

    /**
     * Construct a new instance of the super class and put it on the grid at (x,y).
     * @return The instance of the loaded component.
     */
    private Component load(int x, int y, Scanner scanner) {
        try {
            Constructor constructor = this.getClass().getDeclaredConstructor(Grid.class);
            Component newComp = (Component) constructor.newInstance(grid);
            newComp.loadAdditionalStorageData(scanner);
            grid.setTile(new GridPoint(x, y), newComp);
        } catch (Exception ex) {
            System.out.println("Error loading component " + this.getClass());
        }
        return null;
    }

    /**
     * This method is for use by the Grid class. To move a component call {@link Grid#moveTile(GridPoint, GridPoint)}
     * Otherwise things will come out of sync.
     */
    public final void setPoint(GridPoint point) {
        this.point = point.copy();
    }

    /**
     * Returns the location on the grid of a point inside this tile.<br>
     * Used for determining endpoints of wires.
     */
    protected LocalPoint convertToGridSpace(LocalPoint localTilePoint) {
        return new LocalPoint(localTilePoint.x + grid.tileLength * getPoint().x, localTilePoint.y + grid.tileLength * getPoint().y);
    }

    /**
     * Draws a wire from the output of source to an input on dest.<br>
     * Uses {@link Component#getOutputPos()} and {@link Component#getInputPosFor(Component)} to
     * determine the exact location of the wire's endpoints.
     */
    protected void drawWire(Canvas canvas, Component source, Component dest) {
        if (source != null && dest != null)
            Util.drawWire(canvas, source, dest);
    }

    /**
     * Draws the image as found in R.drawable onto the component's canvas.
     */
    private void drawComponentImage() {
        Bitmap componentImage = getComponentImage();
        Rect orgRect = new Rect(0, 0, componentImage.getWidth(), componentImage.getWidth());
        Rect transformRect = new Rect(0, 0, grid.tileLength, grid.tileLength);
        transformRect.offsetTo(0, grid.tileLength / 4);
        canvas.drawBitmap(componentImage, orgRect, transformRect, Paints.IMAGE_OPAQUE);
    }

    /**
     * Creates a new blank transparent canvas.
     */
    private void createCanvas() {
        image = Bitmap.createBitmap(grid.tileLength, grid.tileLength, Bitmap.Config.ARGB_8888);
        canvas = new Canvas(image);
    }
}
