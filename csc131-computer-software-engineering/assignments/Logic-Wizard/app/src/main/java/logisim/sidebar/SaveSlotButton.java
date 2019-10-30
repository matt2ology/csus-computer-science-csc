package logisim.sidebar;

import android.graphics.Paint;

import logisim.state.modes.SaveMode;
import logisim.util.LocalPoint;
import logisim.util.Paints;
import logisim.util.Size;

public class SaveSlotButton extends CenterLabelButton {

    public SaveSlotButton(LocalPoint point, Size size, String label, ComponentSidebar sidebar) {
        super(point, size, label, sidebar);
    }

    @Override
    Paint getPaint() {
        return Paints.SAVE_BUTTON_TEXT;
    }

    @Override
    public void onTap() {
        String feedback;
        if (sidebar.stateManager.getMode() instanceof SaveMode) {
            boolean result = sidebar.grid.saveGrid(label);
            feedback = result ? "Layout saved to " + label : "Failed to save layout";
        } else {
            boolean result = sidebar.grid.loadGrid(label);
            feedback = result ? "Loaded layout " + label : "Failed to load layout " + label;
        }
        sidebar.stateManager.resetMode();
        sidebar.stateManager.setStatusBarText(feedback);
    }

}
