package logisim.state;

import android.graphics.Canvas;

import java.util.Timer;
import java.util.TimerTask;

import logisim.history.ActionHistory;
import logisim.IInteractable;
import logisim.ScreenManager;
import logisim.state.modes.IMode;
import logisim.state.modes.NormalMode;
import logisim.tiles.IDraggable;
import logisim.util.DebugTextDrawer;
import logisim.util.LocalPoint;
import logisim.util.ScreenPoint;
import logisim.util.TouchAction;

public class StateManager {

    public final Canvas canvas;
    public final ScreenManager screenManager;
    public final DebugTextDrawer debugText;

    private IMode mode = new NormalMode();

    public final ActionHistory history = new ActionHistory(this);

    private boolean touchInProgress;
    private boolean dragInProgress;
    private IInteractable touchedObjectStart;
    private IDraggable draggedObject;
    private ScreenPoint dragPoint;

    private String statusBarText = "";
    private Timer statusMessageTimer = new Timer();

    public StateManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
        this.canvas = this.screenManager.getCanvas();
        debugText = new DebugTextDrawer(new LocalPoint(screenManager.getDisplaySize().width - 4, 4), true);
        debugText.alignRight = true;
    }

    public void update(ScreenPoint screenPoint, TouchAction action) {

        dragPoint = screenPoint;
        if (action == TouchAction.UP) {
            touchInProgress = false;
            dragInProgress = false;
            IInteractable touchedObject = screenManager.getTouchedObject(screenPoint);
            if (touchedObject != null && touchedObjectStart == touchedObject) {
                IMode tempMode = mode;
                touchedObject.onTap();
                tempMode.processTap(touchedObjectStart);
            } else {
                mode.processDrag(screenPoint, touchedObject);
            }
        } else if (action == TouchAction.DOWN) {
            if (!touchInProgress) {
                touchedObjectStart = screenManager.getTouchedObject(screenPoint);
                if (touchedObjectStart != null)
                    touchedObjectStart.onTouch();
            }
            touchInProgress = true;
        } else if (action == TouchAction.MOVE) {
            mode.updateDrag(screenPoint);
            if (!dragInProgress && touchedObjectStart != null)
                draggedObject = touchedObjectStart.onDrag();
            dragInProgress = true;
        }

    }

    public void draw() {
        debugText.addText("Mode: " + mode.getClass().getSimpleName());
        mode.draw();
        debugText.addText("");
        history.addDebugInformation();
        debugText.draw(canvas);
    }

    public void resetMode() {
        touchedObjectStart = null;
        draggedObject = null;
        dragPoint = null;
        setMode(new NormalMode());
    }

    public void setMode(IMode mode) {
        this.mode.finalizeMode();
        this.mode = mode;
        screenManager.draw();
    }

    public IMode getMode() {
        return mode;
    }

    public IInteractable getTouchedObjectStart() {
        return touchedObjectStart;
    }

    public IDraggable getDraggedObject() {
        return draggedObject;
    }

    public ScreenPoint getDragPoint() {
        return dragPoint;
    }

    public void setStatusBarText(String text) {
        statusMessageTimer.cancel();
        if (text == null || text.equals("")) {
            statusBarText = "";
        } else {
            statusBarText = text;
            statusMessageTimer = new Timer();
            statusMessageTimer.schedule(new TimerTask() {
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

}
