package logisim.util;

import android.graphics.Paint;
import android.graphics.Rect;

public class TextDrawUtil {

    public static int getTextWidthPx(String text, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect.width();
    }

    public static int getTextHeightPx(String text, Paint paint) {
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect.height();
    }

}
