package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import java.util.Random;

/**
 * <h1>RefuelingBlimps</h1> are <i>fixed game objects</i> that have an attribute
 * <code>capacity</code> (amount of fuel an refueling blimp contains). <b>The
 * initial capacity of the refueling blimp is proportional to its size.</b>
 *
 * If the player helicopter is running low on fuel, it must go to an refueling
 * blimp that is not empty before it runs out of fuel; otherwise it cannot move.
 *
 * Sizes of the rest of the game objects are chosen randomly when created, and
 * constrained to a reasonable positive integer value (e.g., between 10 to 50).
 * For instance, size of one of the refueling blimp may be 15 while size of
 * refueling blimp can may be 20.
 */
public class RefuelingBlimps extends Fixed {
    Random random = new Random();
    private int fuelCapacity;

    public RefuelingBlimps() {
        super(ColorUtil.GREEN);
        final int MIN_SIZE = 10;
        final int MAX_SIZE = 50;
        super.setSize(new Random().nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE);
        setfuelCapacity(this.getSize());
        ;
    }

    /**
     * Gives <code>fuelCapacity</code> value of RefulingBlimp
     * @return fuelCapacity of type int
     */
    public int getfuelCapacity() {
        return fuelCapacity;
    }

    /**
     * Sets <code>fuelCapacity</code> of RefulingBlimp <b>The initial capacity of
     * the refueling blimp is proportional to its size.</b>
     * <br><br>
     * <i>If the player helicopter is running low on fuel, it must go to an
     * refueling blimp that is not empty before it runs out of fuel; otherwise it
     * cannot move.</i>
     *
     * @param fuelCapacity
     */
    public void setfuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

}
