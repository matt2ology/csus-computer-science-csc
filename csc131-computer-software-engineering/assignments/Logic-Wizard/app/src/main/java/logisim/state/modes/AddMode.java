package logisim.state.modes;

import android.graphics.Canvas;

import logisim.Grid;
import logisim.history.UndoProcedure;
import logisim.sidebar.ComponentSidebarButton;
import logisim.state.StateManager;
import logisim.tiles.components.Component;
import logisim.util.Paints;
import logisim.util.ScreenPoint;
import logisim.util.Util;

public class AddMode extends AbstractMode {

    private final ComponentSidebarButton button;
    private final Grid grid;

    public AddMode(StateManager stateManager, ComponentSidebarButton button, Grid grid) {
        super(stateManager);
        this.button = button;
        this.grid = grid;
        stateManager.setStatusBarText(button.label);
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
        if (dest == null) {
            Component newComponent = button.createNewComponent(grid.convertToGridPoint(screenPoint), grid);
            if (newComponent != null)
                pushActionToHistory(newComponent);
        }
        stateManager.resetMode();
    }

    private void pushActionToHistory(Component componentAdded) {
        stateManager.history.pushAction("Adding " + componentAdded, new UndoProcedure() {
            @Override
            public void performUndo() {
                grid.removeTile(componentAdded.getPoint(), false);
            }

            @Override
            public void performRedo() {
                grid.setTile(componentAdded.getPoint(), componentAdded);
            }
        });
    }

    @Override
    public void draw() {
        ScreenPoint dragPoint = stateManager.getDragPoint();
        Util.drawDraggedObject(stateManager.canvas, button.getComponentImage(), dragPoint);
        drawTileOutlines(stateManager.canvas);
    }

    private void drawTileOutlines(Canvas mainCanvas) {
        ScreenPoint dragPoint = stateManager.getDragPoint();
        Component compOver = grid.getTile(grid.convertToGridPoint(dragPoint));
        if (grid.containsTouch(dragPoint)) {
            Util.drawTileOutline(grid.convertToGridPoint(dragPoint), grid, mainCanvas,
                    compOver == null ? Paints.TILE_OUTLINE_ALLOW_PLACE : Paints.TILE_OUTLINE_DENY_PLACE);
        }
    }

    @Override
    public void finalizeMode() {
        stateManager.setStatusBarText("");
    }
}
