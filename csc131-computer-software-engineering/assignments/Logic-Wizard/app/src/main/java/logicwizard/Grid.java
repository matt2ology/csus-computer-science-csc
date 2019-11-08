package logicwizard;

import android.graphics.Paint;
import android.graphics.Rect;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import logicwizard.history.UndoProcedure;
import logicwizard.state.StateManager;
import logicwizard.tiles.components.Component;
import logicwizard.tiles.components.concrete.ANDGate;
import logicwizard.tiles.components.concrete.ComponentLED;
import logicwizard.tiles.components.concrete.ComponentSwitch;
import logicwizard.tiles.components.concrete.NOTGate;
import logicwizard.tiles.components.concrete.ORGate;
import logicwizard.util.GridPoint;
import logicwizard.util.LocalPoint;
import logicwizard.util.Paints;
import logicwizard.util.ScreenPoint;
import logicwizard.util.Size;
import logicwizard.util.TextDrawUtil;

/**
 * Maintains the grid and components.
 *
 * - Empty tiles are null - GridPoints refer to a tile on the grid - LocalPoints
 * are ScreenPoints that have already been offset to the grid's canvas. -
 * ScreenPoints are the actual pixels on the screen. (0, 0) refers to the top
 * left pixel of the screen.
 */
public class Grid extends AbstractScreenPartition {
    // The length of the grid in tiles (not pixels).
    public final Size gridSize;
    // the length in pixels of a tile. The tiles are square so only 1 value is
    // needed.
    public final int tileLength;

    /**
     * A map of all the components.<br>
     * Each GridPoint corresponds to a component if it is present currently on the
     * grid.<br>
     * Removed components get removed from this map.<br>
     * Use the set, move and removeTile methods to update the map.
     */
    private final Map<GridPoint, Component> components;

    /**
     * A list of components for use during loading to check if it matches the storageID
     * in the file.
     */
    private List<Component> componentRegistry;

    /**
     * Grid constructor
     *
     * @param width      The width of the grid in tiles.
     * @param height     The height of the grid in tiles.
     * @param tileLength the length in pixels of each tile. Tiles are squares.
     * @param origin     The top-left corner of the grid in screen pixels.
     * @param size       The size of the grid in pixels
     */
    public Grid(int width, int height, int tileLength, ScreenManager screenManager, StateManager stateManager,
            ScreenPoint origin, Size size) {
        super(origin, size, screenManager, stateManager);
        this.gridSize = new Size(width, height);
        this.tileLength = tileLength;
        this.components = new HashMap<>();
        resetGrid();

        componentRegistry = new LinkedList<>(Arrays.asList(
                new ANDGate(this),
                new ORGate(this),
                new NOTGate(this),
                new ComponentSwitch(this),
                new ComponentLED(this)
        ));
    }

    public void resetGrid() {
        getComponents().clear();
        stateManager.history.clear();
    }

    /**
     * Sets the tile at point to component if the space is empty.
     */
    public void setTile(GridPoint point, Component component) {
        if (component != null) {
            Component existingComp = getComponents().get(point);
            if (existingComp != null)
                existingComp.setOnGrid(false);
            getComponents().put(point, component);
            component.setPoint(point);
            component.setOnGrid(true);
        }
    }

    /**
     * Calls {@link Grid#removeTile(GridPoint, boolean)} and adds the action to
     * {@link logicwizard.history.ActionHistory}
     * 
     * @param point The tile to remove
     */
    public void removeTile(GridPoint point) {
        removeTile(point, true);
    }

    /**
     * Removes the component and disconnects wires.
     *
     * @param point          The tile to remove
     * @param writeToHistory when true, writes the removal to
     *                       {@link logicwizard.history.ActionHistory}
     */
    public void removeTile(GridPoint point, boolean writeToHistory) {
        Component component = getComponents().get(point);
        if (component != null) {
            Map<Component, List<Component>> connections = new HashMap<>();
            for (Component output : component.getOutputs()) {
                connections.put(output, new LinkedList<>(output.getInputs()));
                output.removeInput(component);
            }
            component.setOnGrid(false);

            if (writeToHistory) {
                Grid grid = this;
                stateManager.history.pushAction("Removing " + component, new UndoProcedure() {

                    @Override
                    public void performUndo() {
                        grid.setTile(point, component);
                        for (Map.Entry<Component, List<Component>> connection : connections.entrySet()) {
                            connection.getKey().setInputs(connection.getValue());
                        }
                    }

                    @Override
                    public void performRedo() {
                        grid.removeTile(point, false);
                    }
                });
            }
        }

        getComponents().remove(point);
    }

    /**
     * @param point The tile to retrieve
     * @return The tile at point if it exists, null otherwise
     */
    @Nullable
    public Component getTile(GridPoint point) {
        return getComponents().get(point);
    }

    /**
     * @return The tile at localPoint, or null if the tile is empty.
     */
    @Override
    @Nullable
    public IInteractable getTouchedObject(LocalPoint localPoint) {
        return getTile(convertToGridPoint(localPoint));
    }

    /**
     * Moves a tile from the src point to dest point. <br>
     * This method should be used to move tiles. Not setPoint in Component. <br>
     * This method should be used when not performing undos or redos.
     */
    public void moveTile(GridPoint src, GridPoint dest) {
        moveTile(src, dest, true);
    }

    /**
     * Moves the tile from src to dest. This method should be used to move tiles.
     * Not setPoint in Component. <br>
     * Use this method, with writeToHistory as false when performing undos and redos
     * to prevent corrupting the stack.
     *
     * @param writeToHistory When true, writes the move to history.
     */
    public void moveTile(GridPoint src, GridPoint dest, boolean writeToHistory) {
        Component component = getComponents().get(src);
        if (component != null && getTile(dest) == null) {
            getComponents().remove(src);
            getComponents().put(dest, component);
            component.setPoint(dest);

            if (writeToHistory) {
                Grid grid = this;
                stateManager.history.pushAction("Moving " + component + " from " + src, new UndoProcedure() {
                    @Override
                    public void performUndo() {
                        moveTile(dest, src, false);
                    }

                    @Override
                    public void performRedo() {
                        moveTile(src, dest, false);
                    }
                });
            }
        }
    }

    /**
     * Draws all components and the status bar.
     */
    @Override
    public void draw() {
        fillBackground();
        screenManager.debugText.addText("");
        screenManager.debugText.addText("Grid Size: " + getGridSize());
        screenManager.debugText.addText("Tile Length: " + getTileLength());
        for (Component component : getComponents().values()) {
            component.draw();
            component.drawDebugText();
            LocalPoint drawPoint = convertToLocalPoint(component.getPoint());
            canvas.drawBitmap(component.getRenderImage(), drawPoint.x, drawPoint.y, Paints.IMAGE_OPAQUE);
        }
        for (Component component : getComponents().values()) {
            component.drawWires(canvas);
        }
        drawStatusBar();
    }

    /**
     * Writes statusBarText to the bottom center of the screen. set the text by
     * calling {@link StateManager#setStatusBarText(String)}
     */
    private void drawStatusBar() {
        Paint paint = Paints.STATUS_BAR_TEXT;
        String name = stateManager.getStatusBarText();
        canvas.drawText(name, getSize().width / 2 - TextDrawUtil.getTextWidthPx(name, paint),
                screenManager.getDisplaySize().height - TextDrawUtil.getTextHeightPx(name, paint) - 10, paint);
    }

    /**
     * Storage format
     * --------------
     * 1 component per line
     * | = whitespace
     * storageID | posX | posY | [additional whitespace delineated data for component]
     * 
     * @param slot The save slot corresponding to a button on the UI.
     * @return true if the save was successful, false if it was not.
     */
    public boolean saveGrid(String slot) {
        try {
            File outputFile = getSaveFile(slot);
            FileWriter writer = new FileWriter(outputFile);
            List<Component> savedTiles = new LinkedList<>();
            for (Component component : getComponents().values()) {
                writeRecursively(savedTiles, writer, component);
            }
            writer.flush();
            writer.close();
            return true;
        } catch (Exception ex) {
            System.out.println("Caught exception saving layout to slot " + slot + ": " + ex.getLocalizedMessage());
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Depth-First tree traversal to save all "children" (components connected to
     * inputs) of this node. This is important for loading as a child must exist for
     * it to be connected to. If the child has already been written it will be in
     * the savedTiles list and not be written twice.
     *
     * @param savedTiles List of components already saved
     * @param writer     The FileWriter connected to the output file
     * @param component  The component that will be saved after it's children
     */
    private void writeRecursively(List<Component> savedTiles, FileWriter writer, Component component)
            throws IOException {
        for (Component input : component.getInputs()) {
            writeRecursively(savedTiles, writer, input);
        }
        writeTile(savedTiles, writer, component);
    }

    /**
     * Writes an individual component if that component has not already been written
     *
     * @param savedTiles List of components already saved
     * @param writer     The FileWriter connected to the output file
     * @param component  The component being written
     */
    private void writeTile(List<Component> savedTiles, FileWriter writer, Component component) throws IOException {
        if (component.getStorageID() == null || savedTiles.contains(component))
            return;
        savedTiles.add(component);
        String line = component.getStorageID() + " " + component.getPoint().x + " " + component.getPoint().y + " "
                + component.getAdditionalStorageData();
        writer.write(line + "\n");
    }

    /**
     * Loads the grid corresponding to the slots available on the UI.
     * 
     * @param slot The save slot corresponding to a button on the UI.
     * @return true if the save was successful, false if it was not.
     */
    public boolean loadGrid(String slot) {
        resetGrid();
        try {
            File inputFile = getSaveFile(slot);
            if (inputFile.exists()) {
                Scanner fileScanner = new Scanner(inputFile);
                while (fileScanner.hasNextLine()) {
                    String entry = fileScanner.nextLine();
                    Scanner entryScanner = new Scanner(entry);
                    String id = entryScanner.next();
                    int xPos = entryScanner.nextInt();
                    int yPos = entryScanner.nextInt();
                    Component component = loadTileForID(id, xPos, yPos, entryScanner);
                    if (component != null)
                        component.loadAdditionalStorageData(entryScanner);
                    entryScanner.close();
                }
                fileScanner.close();
                return true;
            }
            return false;
        } catch (Exception ex) {
            System.out.println("Caught exception loading layout for slot " + slot + ": " + ex.getLocalizedMessage());
            ex.printStackTrace();
            resetGrid();
            return false;
        }
    }

    /**
     * Figure out which tile to load by the storageID present in the file
     *
     * @param id   The StorageID {@link Component#getStorageID()}
     * @param xPos The x of the grid point to load the component
     * @param yPos The y of the grid point to load the component
     * @return the created component or null if the storageID was not recognized
     */
    private Component loadTileForID(String id, int xPos, int yPos, Scanner scanner) {
        for (Component comp : componentRegistry) {
            Component created = comp.load(id, xPos, yPos, scanner);
            if (created != null) {
                setTile(new GridPoint(xPos, yPos), created);
                return created;
            }
        }
        return null;
    }

    /**
     * @param slot The slot representing the buttons on the UI.
     * @return The file corresponding to the slot.
     */
    private File getSaveFile(String slot) {
        return new File(screenManager.appContext.getFilesDir(), slot + ".logwiz");
    }

    /**
     * The name of this partition - For debugging purposes
     */
    @Override
    public String getName() {
        return "Grid";
    }

    private void fillBackground() {
        this.canvas.drawRect(new Rect(0, 0, getSize().width, getSize().height), Paints.GRID_BACKGROUND_COLOR);
    }

    /**
     * Finds the grid point relative to a point local to the grid canvas.
     */
    public GridPoint convertToGridPoint(LocalPoint localPoint) {
        // TODO Make gridPointX/Y as own function
        int gridPointX = localPoint.x / getTileLength();
        int gridPointY = localPoint.y / getTileLength();
        return new GridPoint(gridPointX, gridPointY);
    }

    /**
     * Finds the grid point relative to a point representing the <em>entire</em>
     * screen
     */
    public GridPoint convertToGridPoint(ScreenPoint screenPoint) {
        return convertToGridPoint(convertToLocalPoint(screenPoint));
    }

    /**
     * returns the top left corner in local pixels of the provided grid point.
     */
    public LocalPoint convertToLocalPoint(GridPoint gridPoint) {
        return new LocalPoint(gridPoint.x * getTileLength(), gridPoint.y * getTileLength());
    }

    public Size getGridSize() {
        return gridSize;
    }

    public int getTileLength() {
        return tileLength;
    }

    public Map<GridPoint, Component> getComponents() {
        return components;
    }

}
