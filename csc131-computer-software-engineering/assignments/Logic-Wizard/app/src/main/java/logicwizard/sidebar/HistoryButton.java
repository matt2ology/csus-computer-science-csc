package logicwizard.sidebar;

import android.graphics.Paint;

import logicwizard.history.ActionHistory;
import logicwizard.util.LocalPoint;
import logicwizard.util.Paints;
import logicwizard.util.Size;

/**
 * Simple base class for undo/redo buttons.
 */
public abstract class HistoryButton extends CenterLabelButton {

    final ActionHistory history;

    public HistoryButton(LocalPoint point, Size size, String label, ComponentSidebar sidebar, ActionHistory history) {
        super(point, size, label, sidebar);
        this.history = history;
    }

    @Override
    Paint getPaint() {
        return Paints.LABEL_TEXT;
    }

}
