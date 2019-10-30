package logisim.sidebar;

import android.graphics.Paint;

import logisim.state.modes.SaveMode;
import logisim.util.LocalPoint;
import logisim.util.Paints;
import logisim.util.Size;

public class SaveButton extends CenterLabelButton {

    public SaveButton(LocalPoint point, Size size, String label, ComponentSidebar sidebar) {
        super(point, size, label, sidebar);
    }

    @Override
    public void drawBackground() {
        if (sidebar.stateManager.getMode() instanceof SaveMode)
            canvas.drawRect(0, 0, size.width, size.height, Paints.SAVE_MODE_SAVE_BUTTON_BACKGROUND_COLOR);
    }

    @Override
    Paint getPaint() {
        return sidebar.stateManager.getMode() instanceof SaveMode ?
                Paints.SAVE_MODE_SAVE_BUTTON_TEXT : Paints.SAVE_BUTTON_TEXT;
    }

    @Override
    public void onTap() {
        if (!(sidebar.stateManager.getMode() instanceof SaveMode)) {
//            sidebar.stateManager.setState(new ShowMessageState("Select A Save Slot"));
            sidebar.stateManager.setMode(new SaveMode(sidebar.stateManager));
        } else {
            sidebar.stateManager.resetMode();
        }
    }
}
