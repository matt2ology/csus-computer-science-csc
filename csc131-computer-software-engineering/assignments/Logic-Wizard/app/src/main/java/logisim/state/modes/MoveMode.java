package logisim.state.modes;

import android.graphics.Canvas;

import logisim.Grid;
import logisim.state.StateManager;
import logisim.tiles.IDraggable;
import logisim.tiles.components.Component;
import logisim.util.Paints;
import logisim.util.ScreenPoint;
import logisim.util.Util;

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
