package logisim;


import android.graphics.Paint;
import android.graphics.Rect;

import androidx.annotation.Nullable;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import logisim.history.UndoProcedure;
import logisim.state.StateManager;
import logisim.tiles.components.Component;
import logisim.tiles.components.concrete.ANDGate;
import logisim.tiles.components.concrete.ComponentLED;
import logisim.tiles.components.concrete.ComponentSwitch;
import logisim.tiles.components.concrete.NOTGate;
import logisim.tiles.components.concrete.ORGate;
import logisim.util.GridPoint;
import logisim.util.LocalPoint;
import logisim.util.Paints;
import logisim.util.ScreenPoint;
import logisim.util.Size;
import logisim.util.TextDrawUtil;
import logisim.util.Util;

/**
 * Maintains the grid and components.
 */
public class Grid extends AbstractScreenPartition {
    // The length of the grid in tiles (not pixels).
    public final Size gridSize;
    // the length in pixels of a tile. The tiles are square so only 1 value is needed.
    public final int tileLength;

    private final Map<GridPoint, Component> components;

    /**
     * 
     * @param width
     * @param height
     * @param tileLength
     * @param screenManager
     * @param stateManager
     * @param origin
     * @param size
     */
    public Grid(int width, int height, int tileLength, ScreenManager screenManager, StateManager stateManager, ScreenPoint origin, Size size) {
        super(origin, size, screenManager, stateManager);
        this.gridSize = new Size(width, height);
        this.tileLength = tileLength;
        this.components = new HashMap<>();
        resetGrid();
    }

    public void resetGrid() {
        components.clear();
        stateManager.history.clear();
    }

    /**
     * 
     * @param point
     * @param component
     */
    public void setTile(GridPoint point, Component component) {
        if (component != null) {
            Component existingComp = components.get(point);
            if (existingComp != null)
                existingComp.setOnGrid(false);
            components.put(point, component);
            component.setPoint(point);
            component.setOnGrid(true);
        }
    }

    /**
     * 
     * @param point
     */
    public void removeTile(GridPoint point) {
        removeTile(point, true);
    }

    /**
     * 
     * @param point
     * @param writeToHistory
     */
    public void removeTile(GridPoint point, boolean writeToHistory) {
        Component component = components.get(point);
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

        components.remove(point);
    }

    /**
     * 
     * @param point
     * @return
     */
    @Nullable
    public Component getTile(GridPoint point) {
        return components.get(point);
    }

    /**
     * 
     * @param localPoint
     * @return
     */
    @Override
    public IInteractable getTouchedObject(LocalPoint localPoint) {
        return getTile(convertToGridPoint(localPoint));
    }

    /**
     * 
     * @param src
     * @param dest
     */
    public void moveTile(GridPoint src, GridPoint dest) {
        moveTile(src, dest, true);
    }

    /**
     * 
     * @param src
     * @param dest
     * @param writeToHistory
     */
    public void moveTile(GridPoint src, GridPoint dest, boolean writeToHistory) {
        Component component = components.get(src);
        if (component != null && getTile(dest) == null) {
            components.remove(src);
            components.put(dest, component);
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

    
    @Override
    public void draw() {
        fillBackground();
        screenManager.debugText.addText("");
        screenManager.debugText.addText("Grid Size: " + gridSize);
        screenManager.debugText.addText("Tile Length: " + tileLength);
        for (Component component : components.values()) {
            component.draw();
            component.drawDebugText();
            LocalPoint drawPoint = convertToLocalPoint(component.getPoint());
            canvas.drawBitmap(component.getRenderImage(), drawPoint.x, drawPoint.y, Paints.IMAGE_OPAQUE);
        }
        for (Component component : components.values()) {
            component.drawWires(canvas);
        }
        drawStatusBar();
    }


    private void drawStatusBar() {
        Paint paint = Paints.STATUS_BAR_TEXT;
        String name = stateManager.getStatusBarText();
        canvas.drawText(name, getSize().width / 2 - TextDrawUtil.getTextWidthPx(name, paint), screenManager.getDisplaySize().height - TextDrawUtil.getTextHeightPx(name, paint) - 10, paint);
    }

    /**
     * Storage format
     * --------------
     * 1 component per line
     * | = whitespace
     * storageID | posX | posY | [additional whitespace delineated data for component]
     * @param slot
     * @return
     */
    public boolean saveGrid(String slot) {
        try {
            File outputFile = getSaveFile(slot);
            FileWriter writer = new FileWriter(outputFile);
            List<Component> savedTiles = new LinkedList<>();
            for (Component component : components.values()) {
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
     * 
     * @param savedTiles
     * @param writer
     * @param component
     * @throws IOException
     */
    private void writeRecursively(List<Component> savedTiles, FileWriter writer, Component component) throws IOException {
        for (Component input : component.getInputs()) {
            writeRecursively(savedTiles, writer, input);
        }
        writeTile(savedTiles, writer, component);
    }

    /**
     * 
     * @param savedTiles
     * @param writer
     * @param component
     * @throws IOException
     */
    private void writeTile(List<Component> savedTiles, FileWriter writer, Component component) throws IOException {
        if (component.getStorageID() == null || savedTiles.contains(component))
            return;
        savedTiles.add(component);
        String line = component.getStorageID() + " " + component.getPoint().x + " " + component.getPoint().y + " " + component.getAdditionalStorageData();
        writer.write(line + "\n");
    }

    /**
     * 
     * @param slot
     * @return
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
                    Component component = loadTileForID(id, xPos, yPos);
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
     * 
     * @param id
     * @param xPos
     * @param yPos
     * @return
     */
    private Component loadTileForID(String id, int xPos, int yPos) {
        GridPoint gridPoint = new GridPoint(xPos, yPos);
        if (id.equals("and"))
            setTile(gridPoint, new ANDGate(this));
        else if (id.equals("or"))
            setTile(gridPoint, new ORGate(this));
        else if (id.equals("not"))
            setTile(gridPoint, new NOTGate(this));
        else if (id.equals("switch"))
            setTile(gridPoint, new ComponentSwitch(this));
        else if (id.equals("led"))
            setTile(gridPoint, new ComponentLED(this));
        else {
            System.out.println("id not recognized for component trying to be added at " + gridPoint);
            return null;
        }

        return getTile(gridPoint);
    }

    /**
     * 
     * @param slot
     * @return
     */
    private File getSaveFile(String slot) {
        return new File(screenManager.appContext.getFilesDir(), slot + ".logisim");
    }

    @Override
    public String getName() {
        return "Grid";
    }

    private void fillBackground() {
        this.canvas.drawRect(new Rect(0, 0, getSize().width, getSize().height), Paints.GRID_BACKGROUND_COLOR);
    }

    /**
     * 
     * @param localPoint
     * @return
     */
    public GridPoint convertToGridPoint(LocalPoint localPoint) {
        int gridPointX = localPoint.x / tileLength;
        int gridPointY = localPoint.y / tileLength;
        return new GridPoint(gridPointX, gridPointY);
    }

    /**
     * 
     * @param screenPoint
     * @return
     */
    public GridPoint convertToGridPoint(ScreenPoint screenPoint) {
        return convertToGridPoint(convertToLocalPoint(screenPoint));
    }

    /**
     * 
     * @param gridPoint
     * @return
     */
    public LocalPoint convertToLocalPoint(GridPoint gridPoint) {
        return new LocalPoint(gridPoint.x * this.tileLength, gridPoint.y * this.tileLength);
    }

}
