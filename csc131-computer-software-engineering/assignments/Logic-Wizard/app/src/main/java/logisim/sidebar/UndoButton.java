package logisim.sidebar;

import logisim.history.ActionHistory;
import logisim.util.LocalPoint;
import logisim.util.Size;

public class UndoButton extends HistoryButton {

    public UndoButton(LocalPoint point, Size size, String label, ComponentSidebar sidebar, ActionHistory history) {
        super(point, size, label, sidebar, history);
    }

    @Override
    public void onTap() {
        history.undo();
    }
}
