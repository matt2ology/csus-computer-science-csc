package logicwizard.util;

import android.graphics.Paint;
import android.graphics.Typeface;

public class PaintBuilder {

    private final Paint paint;

    private PaintBuilder() {
        paint = new Paint();
    }

    public static PaintBuilder start() {
        return new PaintBuilder();
    }

    public Paint makePaint() {
        return paint;
    }

    public PaintBuilder setAlpha(int alpha) {
        paint.setAlpha(alpha);
        return this;
    }

    public PaintBuilder setBold(boolean bold) {
        paint.setFakeBoldText(bold);
        return this;
    }

    public PaintBuilder setColor(int color) {
        paint.setColor(color);
        return this;
    }

    public PaintBuilder setStyle(Paint.Style style) {
        paint.setStyle(style);
        return this;
    }

    public PaintBuilder setTextSize(int size) {
        paint.setTextSize(size);
        return this;
    }

    public PaintBuilder setStrokeWidth(int px) {
        paint.setStrokeWidth(px);
        return this;
    }

    public PaintBuilder setTypeface(Typeface typeface) {
        paint.setTypeface(typeface);
        return this;
    }

}
