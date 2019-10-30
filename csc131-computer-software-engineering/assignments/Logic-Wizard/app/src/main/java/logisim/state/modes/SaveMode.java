package logisim.state.modes;


import logisim.sidebar.SaveSlotButton;
import logisim.state.StateManager;
import logisim.util.ScreenPoint;

public class SaveMode extends AbstractMode {

    public SaveMode(StateManager stateManager) {
        super(stateManager);
        stateManager.setStatusBarText("Select A Save Slot");
    }

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
