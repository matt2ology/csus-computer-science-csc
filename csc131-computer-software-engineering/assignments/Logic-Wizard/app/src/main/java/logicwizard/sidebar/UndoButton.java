package logicwizard.sidebar;

import logicwizard.history.ActionHistory;
import logicwizard.util.LocalPoint;
import logicwizard.util.Size;

public class UndoButton extends HistoryButton {

    public UndoButton(LocalPoint point, Size size, String label, ComponentSidebar sidebar, ActionHistory history) {
        super(point, size, label, sidebar, history);
    }

    @Override
    public void onTap() {
        history.undo();
    }
}
