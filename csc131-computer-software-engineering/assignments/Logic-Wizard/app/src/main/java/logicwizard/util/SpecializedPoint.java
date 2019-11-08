package logicwizard.util;

import android.graphics.Point;

import androidx.annotation.NonNull;

public class SpecializedPoint extends Point {

    public SpecializedPoint(int x, int y) {
        super(x, y);
    }

    @NonNull
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

}
