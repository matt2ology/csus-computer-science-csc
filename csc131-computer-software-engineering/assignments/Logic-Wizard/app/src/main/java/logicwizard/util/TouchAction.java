package logicwizard.util;

import android.view.MotionEvent;

/**
 * Provides names for the MotionEvent actions used in this app.
 */
public enum TouchAction {

    /**
     * The last finger is lifted from the screen
     */
    UP,
    /**
     * The first finger presses the screen, and remains on the screen
     * If another finger touches the screen touches, this event is not fired.
     */
    DOWN,
    /**
     * A finger already on the screen has moved
     */
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
