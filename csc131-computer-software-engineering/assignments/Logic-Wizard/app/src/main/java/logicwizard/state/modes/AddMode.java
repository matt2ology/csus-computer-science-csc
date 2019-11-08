package logicwizard.state.modes;

import android.graphics.Canvas;

import logicwizard.Grid;
import logicwizard.history.UndoProcedure;
import logicwizard.sidebar.ComponentSidebarButton;
import logicwizard.state.StateManager;
import logicwizard.tiles.components.Component;
import logicwizard.util.Paints;
import logicwizard.util.ScreenPoint;
import logicwizard.util.Util;

/**
 * Mode the app is put into after a drag begins on a component sidebar button.<br>
 * The name of the component being added is displayed in the status bar.
 */
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

    /**
     * Adds a new component to the grid at screenPoint
     * @param screenPoint The point where the finger was released.
     * @param dest The object that is currently at screenPoint
     */
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

    /**
     * Draws the component being added along with a outline around the grid space it would be placed in
     * if released at that point.
     */
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
