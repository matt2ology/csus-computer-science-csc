package logicwizard.state.modes;

import java.util.Timer;
import java.util.TimerTask;

import logicwizard.Grid;
import logicwizard.state.StateManager;
import logicwizard.tiles.components.Component;
import logicwizard.util.ScreenPoint;

/**
 * The mode that the app gets put into immediately after a touch starts on a component.
 */
public class ComponentInteractMode extends AbstractMode {

    /**
     * Timer delay for putting the app into MoveMode.
     */
    private final static int DRAG_START_DELAY_MS = 500;

    private final Grid grid;
    private final Component component;

    private final Timer pressHoldTimer = new Timer();

    /**
     * Constructor for ComponentInteractMode - Starts a timer for putting the app into MoveMode.
     * @param component The component that was touched when entering this mode.
     */
    public ComponentInteractMode(StateManager stateManager, Component component, Grid grid) {
        super(stateManager);
        this.component = component;
        this.grid = grid;
        pressHoldTimer.schedule(new DragCountdownTimerTask(), DRAG_START_DELAY_MS);
    }

    /**
     * Checks if the current drag point is still over the component that started the touch.<br>
     * If it is, the timer continues, otherwise the app is put into WireMode or reset.
     */
    @Override
    public void updateDrag(ScreenPoint screenPoint) {
        if (component != grid.getTile(grid.convertToGridPoint(screenPoint))) {
            if (component.hasOutputPin())
                stateManager.setMode(new WireMode(stateManager, grid));
            else
                stateManager.resetMode();
            pressHoldTimer.cancel();
        }
    }

    @Override
    public void processTap(Object touchedObject) {
        stateManager.resetMode();
    }

    @Override
    public void processDrag(ScreenPoint screenPoint, Object dest) {

    }

    @Override
    public void draw() {

    }

    @Override
    public void finalizeMode() {
        pressHoldTimer.cancel();
    }

    /**
     * The task that the timer runs. Sets the mode to MoveMode after {@link ComponentInteractMode#DRAG_START_DELAY_MS} milliseconds.
     */
    private class DragCountdownTimerTask extends TimerTask {

        @Override
        public void run() {
            stateManager.setMode(new MoveMode(stateManager, component, grid));
        }
    }
}
