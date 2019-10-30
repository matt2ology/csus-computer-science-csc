package logisim.util;

import android.view.MotionEvent;

public enum TouchAction {

    UP,
    DOWN,
    MOVE;

    public static TouchAction get(int action) {

        if (action == MotionEvent.ACTION_UP)
            return UP;
        else if (action == MotionEvent.ACTION_DOWN)
            return DOWN;
        else if (action == MotionEvent.ACTION_MOVE)
            return MOVE;
        else
            return null;

    }

}
