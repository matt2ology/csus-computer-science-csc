package logicwizard.state.modes;

import android.graphics.Canvas;

import logicwizard.Grid;
import logicwizard.state.StateManager;
import logicwizard.tiles.components.Component;
import logicwizard.util.Paints;
import logicwizard.util.ScreenPoint;
import logicwizard.util.Util;

/**
 * The mode when moving a tile already on the grid. Activated by holding down on a component.<br>
 * Also the mode used to remove a component, by dragging it into the sidebar.<br>
 * The name of the dragged object is displayed in the status bar
 */
public class MoveMode extends AbstractMode {

    private final Grid grid;
    private final Component start;

    public MoveMode(StateManager stateManager, Component start, Grid grid) {
        super(stateManager);
        this.start = start;
        this.grid = grid;
        stateManager.setStatusBarText(start.getName());
    }

    @Override
    public void updateDrag(ScreenPoint screenPoint) {

    }

    /**
     * Resets the mode if a tap is received. This should not be possible.
     */
    @Override
    public void processTap(Object touchedObject) {
        stateManager.resetMode();
    }

    @Override
    public void processDrag(ScreenPoint screenPoint, Object dest) {
        if (grid.containsTouch(screenPoint)) {
            grid.moveTile(start.getPoint(), grid.convertToGridPoint(screenPoint));
        } else {
            grid.removeTile(start.getPoint());
        }
        stateManager.resetMode();
    }

    /**
     * Draws the dragged component and outlines on the grid showing whether the component can
     * be dropped in that location.
     */
    @Override
    public void draw() {
        ScreenPoint dragPoint = stateManager.getDragPoint();
        Util.drawDraggedObject(stateManager.canvas, start.getComponentImage(), dragPoint);
        drawTileOutlines(stateManager.canvas);
    }

    private void drawTileOutlines(Canvas mainCanvas) {
        ScreenPoint dragPoint = stateManager.getDragPoint();
        Util.drawTileOutline((Component) stateManager.getTouchedObjectStart(), grid, mainCanvas, Paints.TILE_OUTLINE_SOURCE);
        Component compOver = grid.getTile(grid.convertToGridPoint(dragPoint));
        if (grid.containsTouch(dragPoint) && compOver != stateManager.getTouchedObjectStart()) {
            Util.drawTileOutline(grid.convertToGridPoint(dragPoint), grid, mainCanvas,
                    compOver == null ? Paints.TILE_OUTLINE_ALLOW_PLACE : Paints.TILE_OUTLINE_DENY_PLACE);
        }
    }

    @Override
    public void finalizeMode() {
        stateManager.setStatusBarText("");
    }
}
