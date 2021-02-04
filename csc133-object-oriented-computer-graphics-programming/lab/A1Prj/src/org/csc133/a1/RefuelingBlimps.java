package org.csc133.a1;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;

/**
 * RefuelingBlimps are fixed game objects. If the player helicopter is running
 * low on fuel, it must go to an refueling blimp that is not empty before it
 * runs out of fuel; otherwise it cannot move.
 */
public class RefuelingBlimps extends FixedObject {
    /**
     * Attribute capacity (amount of fuel an refueling blimp contains).
     */
    private int capacity;

    public RefuelingBlimps(int color, int size) {
        super(ColorUtil.GREEN, size);

    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return null;
    }
}
