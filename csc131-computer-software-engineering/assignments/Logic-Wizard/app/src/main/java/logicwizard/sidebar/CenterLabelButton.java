package logicwizard.sidebar;

import android.graphics.Paint;

import logicwizard.util.LocalPoint;
import logicwizard.util.ScreenPoint;
import logicwizard.util.Size;
import logicwizard.util.TextDrawUtil;

/**
 * A button with only text rendered at its center.
 */
public abstract class CenterLabelButton extends SidebarButton {

    public CenterLabelButton(LocalPoint point, Size size, String label, ComponentSidebar sidebar) {
        super(point, size, label, sidebar);
    }

    abstract Paint getPaint();

    @Override
    public void drawLabel() {
        Paint paint = getPaint();
        int xPos = getLocalCenter().x - TextDrawUtil.getTextWidthPx(label, paint) / 2;
        int yPos = getLocalCenter().y + TextDrawUtil.getTextHeightPx(label, paint) / 2;
        debugText.addText("labelPos: " + new ScreenPoint(xPos, yPos));
        canvas.drawText(label, xPos, yPos, paint);
    }

}
