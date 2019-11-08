package logicwizard.state;

import android.graphics.Canvas;

import java.util.Timer;
import java.util.TimerTask;

import logicwizard.history.ActionHistory;
import logicwizard.IInteractable;
import logicwizard.ScreenManager;
import logicwizard.state.modes.IMode;
import logicwizard.state.modes.NormalMode;
import logicwizard.tiles.IDraggable;
import logicwizard.util.DebugTextDrawer;
import logicwizard.util.LocalPoint;
import logicwizard.util.ScreenPoint;
import logicwizard.util.TouchAction;

/**
 * Holds the current mode of the application.<br>
 * Finalize is always called on the current mode before switching to a new mode.
 * Reset mode should be called whenever a mode finishes its procedure or becomes
 * invalid.
 */
public class StateManager {

    /**
     * The canvas used to draw the dragged object - Uses the main canvas.
     */
    public final Canvas canvas;
    public final ScreenManager screenManager;
    public final DebugTextDrawer debugText;

    /**
     * The mode the app is in. Calling {@link StateManager#resetMode()} will return
     * the mode to normal and finalize the current mode.
     */
    private IMode mode = new NormalMode();

    public final ActionHistory history = new ActionHistory(this);

    /**
     * Set to true when a DOWN touch event is received, and set to false when an UP
     * event is received.
     */
    private boolean touchInProgress;
    /**
     * Set to true whenever a MOVE event is received regardless of whether the
     * starting object can be dragged.
     */
    private boolean dragInProgress;
    /**
     * The object that was touched when the DOWN event is received for a touch.
     */
    private IInteractable touchedObjectStart;
    /**
     * Set when the MOVE event is received by calling {@link IInteractable#onDrag()}
     * on touchedObjectStart.
     */
    private IDraggable draggedObject;
    /**
     * Always updated to the current point of the finger on the screen.
     */
    private ScreenPoint dragPoint;

    /**
     * A string of text to be rendered at the bottom center of the grid giving
     * feedback to the user.
     */
    private String statusBarText = "";
    /**
     * A timer for resetting the status bar text back to the empty string.
     */
    private Timer statusMessageTimer = new Timer();

    public StateManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.canvas = getScreenManager().getCanvas();
        debugText = new DebugTextDrawer(new LocalPoint(getScreenManager().getDisplaySize().width - 4, 4), true);
        debugText.alignRight = true;
    }

    /**
     * Updates the StateManager with touch events.<br>
     * The mode classes also get updated so they can update their state and renders.
     * 
     * @param screenPoint The location of the finger on the screen.
     * @param action      The action from the touch event (UP, DOWN, or MOVE)
     */
    public void update(ScreenPoint screenPoint, TouchAction action) {
        setDragPoint(screenPoint);
        if (action == TouchAction.UP) {
            setTouchInProgress(false);
            setDragInProgress(false);
            IInteractable touchedObject = getScreenManager().getTouchedObject(screenPoint);
            if (touchedObject != null && getTouchedObjectStart() == touchedObject) {
                IMode tempMode = mode;
                touchedObject.onTap();
                tempMode.processTap(getTouchedObjectStart());
            } else {
                mode.processDrag(screenPoint, touchedObject);
            }
        } else if (action == TouchAction.DOWN) {
            if (!touchInProgress) {
                setTouchedObjectStart(getScreenManager().getTouchedObject(screenPoint));
                if (touchedObjectStart != null) {
                    getTouchedObjectStart().onTouch();
                }
            }
            touchInProgress = true;
        } else if (action == TouchAction.MOVE) {
            mode.updateDrag(screenPoint);
            if (!dragInProgress && getTouchedObjectStart() != null) {
                draggedObject = getTouchedObjectStart().onDrag();
                dragInProgress = true;
            }
        }

    }

    /**
     * Calls the draw method for the current mode and draws the debug information
     * for both this class and the mode.
     */
    public void draw() {
        debugText.addText("Mode: " + mode.getClass().getSimpleName());
        mode.draw();
        debugText.addText("");
        history.addDebugInformation();
        debugText.draw(getCanvas());
    }

    /**
     * Returns the app to the default Normal mode.
     */
    public void resetMode() {
        setTouchedObjectStart(null);
        setDraggedObject(null);
        setDragPoint(null);
        setMode(new NormalMode());
    }

    /**
     * Sets the app to the new mode and finalizes the old mode.
     */
    public void setMode(IMode mode) {
        this.mode.finalizeMode();
        this.mode = mode;
        screenManager.draw();
    }

    public IMode getMode() {
        return mode;
    }

    /**
     * @return the first object touched when the finger touches the screen.
     */
    public IInteractable getTouchedObjectStart() {
        return touchedObjectStart;
    }

    /**
     * @return The object meant for rendering during a drag.
     */
    public IDraggable getDraggedObject() {
        return draggedObject;
    }

    /**
     * The current point of the finger on the screen.
     */
    public ScreenPoint getDragPoint() {
        return dragPoint;
    }

    /**
     * Sets the status bar to text. Will reset to "" after 3 seconds.
     */
    public void setStatusBarText(String text) {
        getStatusMessageTimer().cancel();
        if (text == null || text.equals("")) {
            statusBarText = "";
        } else {
            statusBarText = text;
            setStatusMessageTimer(new Timer());
            getStatusMessageTimer().schedule(new TimerTask() {
                @Override
                public void run() {
                    setStatusBarText("");
                    screenManager.draw();
                }
            }, 3000);
        }
    }

    public String getStatusBarText() {
        return statusBarText;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public DebugTextDrawer getDebugText() {
        return debugText;
    }

    public ActionHistory getHistory() {
        return history;
    }

    public boolean isTouchInProgress() {
        return touchInProgress;
    }

    public void setTouchInProgress(boolean touchInProgress) {
        this.touchInProgress = touchInProgress;
    }

    public boolean isDragInProgress() {
        return dragInProgress;
    }

    public void setDragInProgress(boolean dragInProgress) {
        this.dragInProgress = dragInProgress;
    }

    public void setTouchedObjectStart(IInteractable touchedObjectStart) {
        this.touchedObjectStart = touchedObjectStart;
    }

    public void setDraggedObject(IDraggable draggedObject) {
        this.draggedObject = draggedObject;
    }

    public void setDragPoint(ScreenPoint dragPoint) {
        this.dragPoint = dragPoint;
    }

    public Timer getStatusMessageTimer() {
        return statusMessageTimer;
    }

    public void setStatusMessageTimer(Timer statusMessageTimer) {
        this.statusMessageTimer = statusMessageTimer;
    }

}
