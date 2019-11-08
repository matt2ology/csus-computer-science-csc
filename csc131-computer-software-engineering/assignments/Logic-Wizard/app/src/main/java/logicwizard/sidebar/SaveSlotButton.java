package logicwizard.sidebar;

import android.graphics.Paint;

import logicwizard.state.modes.SaveMode;
import logicwizard.util.LocalPoint;
import logicwizard.util.Paints;
import logicwizard.util.Size;

/**
 * Button for saving or loading the grid depending on the mode of the app.
 */
public class SaveSlotButton extends CenterLabelButton {

    public SaveSlotButton(LocalPoint point, Size size, String label, ComponentSidebar sidebar) {
        super(point, size, label, sidebar);
    }

    @Override
    Paint getPaint() {
        return Paints.SAVE_BUTTON_TEXT;
    }

    /**
     * Saves the grid to the slot corresponding to this button if the app is in save mode.<br>
     * Loads the grid from this save slot otherwise.<br>
     * Provides feedback to the result of the operation in the status bar.
     */
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
