package logicwizard.state.modes;

import android.graphics.Paint;

import java.util.LinkedList;
import java.util.List;

import logicwizard.Grid;
import logicwizard.history.UndoProcedure;
import logicwizard.state.StateManager;
import logicwizard.tiles.components.Component;
import logicwizard.util.Paints;
import logicwizard.util.ScreenPoint;
import logicwizard.util.Util;

/**
 * The mode when a user is connecting a wire from one component to another.
 * Activated by quickly dragging away from a component after touching it.
 */
public class WireMode extends AbstractMode {

    private final Grid grid;

    public WireMode(StateManager stateManager, Grid grid) {
        super(stateManager);
        this.grid = grid;
    }

    @Override
    public void updateDrag(ScreenPoint screenPoint) {

    }

    @Override
    public void processTap(Object touchedObject) {
        stateManager.resetMode();
    }

    /**
     * Connects the source component to dest if doing so would not create a loop in the evaluation tree.
     *
     * @param screenPoint The point where the finger was released.
     * @param dest The object that is currently at screenPoint
     */
    @Override
    public void processDrag(ScreenPoint screenPoint, Object dest) {
        if (dest instanceof Component) {
            Component component = (Component) dest;
            if (isLoopSafe((Component) stateManager.getDraggedObject(), (Component) dest)) {
                List<Component> oldComponents = new LinkedList<Component>(component.getInputs());
                component.processConnection((Component) stateManager.getDraggedObject());
                addWiringToHistory(oldComponents, new LinkedList<>(component.getInputs()), component);
            }
        }
        stateManager.resetMode();
    }

    private void addWiringToHistory(List<Component> oldInputs, List<Component> newInputs, Component dest) {
        stateManager.history.pushAction("Updating inputs for " + dest, new UndoProcedure() {
            @Override
            public void performUndo() {
                dest.setInputs(oldInputs);
            }

            @Override
            public void performRedo() {
                dest.setInputs(newInputs);
            }
        });
    }

    private boolean isLoopSafe(Component source, Component dest) {
        boolean isSafe = true;
        for (Component input : source.getInputs()) {
            if (input == null)
                continue;
            if (input.equals(dest))
                isSafe = false;
            else
                isSafe = isLoopSafe(input, dest);
        }
        return isSafe;
    }

    /**
     * Draws a wire to the position of the finger on the screen.<br>
     * Also draws an outline around the component where the wire would be attached.
     */
    @Override
    public void draw() {
        drawLine();
        drawSelection();
    }

    private void drawLine() {
        stateManager.debugText.addText("Source: " + stateManager.getTouchedObjectStart());
        Component source = (Component) stateManager.getTouchedObjectStart();
        ScreenPoint start = grid.convertToScreenPoint(source.getOutputPos());
        ScreenPoint end = stateManager.getDragPoint();
        stateManager.debugText.addText("Start: " + start);
        stateManager.debugText.addText("End: " + end);
        stateManager.canvas.drawLine(start.x, start.y, end.x, end.y, Paints.WIRE);
    }

    private void drawSelection() {
        Util.drawTileOutline((Component) stateManager.getTouchedObjectStart(), grid, stateManager.canvas, Paints.TILE_OUTLINE_SOURCE);
        ScreenPoint screenPoint = stateManager.getDragPoint();
        if (grid.containsTouch(screenPoint)) {
            Component hoverTile = grid.getTile(grid.convertToGridPoint(screenPoint));
            if (hoverTile != null && hoverTile != stateManager.getDraggedObject()) {
                boolean isLoopSafe = isLoopSafe((Component) stateManager.getTouchedObjectStart(), hoverTile);
                stateManager.debugText.addText("loopSafe: " + isLoopSafe);
                Paint paint = isLoopSafe ? Paints.TILE_OUTLINE_ALLOW_PLACE : Paints.TILE_OUTLINE_DENY_PLACE;
                Util.drawTileOutline(hoverTile, grid, stateManager.canvas, paint);
            }
        }
    }

    @Override
    public void finalizeMode() {

    }
}
