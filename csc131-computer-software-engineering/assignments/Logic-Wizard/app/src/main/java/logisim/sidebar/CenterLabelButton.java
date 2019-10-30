package logisim.sidebar;

import android.graphics.Paint;

import logisim.util.LocalPoint;
import logisim.util.ScreenPoint;
import logisim.util.Size;
import logisim.util.TextDrawUtil;

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
