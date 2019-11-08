package logicwizard.state.modes;


import logicwizard.sidebar.SaveSlotButton;
import logicwizard.state.StateManager;
import logicwizard.util.ScreenPoint;

/**
 * The mode when the save button is pushed and highlighted.<br>
 * Finishes properly if a SaveSlotButton is pushed; Reset if anything else is touched.
 */
public class SaveMode extends AbstractMode {

    public SaveMode(StateManager stateManager) {
        super(stateManager);
        stateManager.setStatusBarText("Select A Save Slot");
    }

    /**
     * Resets the mode if the touchedObject is not a SaveSlotButton.<br>
     * The save slot buttons will complete the save if the app is in save mode.
     */
    @Override
    public void processTap(Object touchedObject) {
        if (!(touchedObject instanceof SaveSlotButton))
            stateManager.resetMode();
    }

    @Override
    public void updateDrag(ScreenPoint screenPoint) {

    }

    @Override
    public void processDrag(ScreenPoint screenPoint, Object dest) {
        stateManager.resetMode();
    }

    @Override
    public void draw() {

    }

    @Override
    public void finalizeMode() {
        stateManager.setStatusBarText("");
    }

}
