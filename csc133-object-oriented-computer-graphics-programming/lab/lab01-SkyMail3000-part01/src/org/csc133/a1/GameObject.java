package org.csc133.a1;

import java.util.Vector;

/**
 * <b>Holds a collection of game objects and other state variables.</b><br>
 * <br>
 * 
 * There are <b>two kinds of abstract game objects</b> called: <b>fixed
 * objects</b> of type <code>Fixed</code> with fixed locations <i>(which are
 * fixed in place)</i> and <b>moveable objects</b> of type <code>Movable</code>
 * with changeable locations <i>(which can move or be moved about the
 * world).</i>
 */
public abstract class GameObject {
    /**
     * All game objects have an integer attribute size. <br>
     * <br>
     * <b>NOTE:</b> However, they do not provide the ability to have their size
     * changed once it is created.
     */
    private int size;

    // As will be specified in the later assignments, each type of game object has a
    // different shape which can be bounded by a square. The size attribute provides
    // the length of this bounding square. All SkyScrapers and all helicopters have
    // the same size (chosen by you), assigned when they are created (e.g, size of
    // all SkyScrapers can be 10 and size of all helicopters can be 40). Sizes of
    // the rest of the game objects are chosen randomly when created, and
    // constrained to a reasonable positive integer value (e.g., between 10 to 50).
    // For instance, size of one of the refueling blimp may be 15 while size of
    // refueling blimp can may be 20.

    private Vector<Float> location;
    // All game objects have a location

    // All objects of the same class have the same color (chosen by you), assigned
    // when the object is created (e.g, SkyScrapers could be blue, helicopters could
    // be red, refueling blimps can be green).

    private int color;
    // All game objects have a color
    public static final int WORLD_WIDTH = 1024;
    // non-negative values X initially should be in the range 0.0 to 1024.0
    public static final int WORLD_HEIGHT = 768;
    // non-negative values Y initially should be in the range 0.0 to 768.0

    /**
     * All game objects provide the ability for external code to obtain their size.
     * 
     * @return Game object size
     */
    public int getSize() {
        return size;
    }

    /**
     * The point (X,Y) is the center of the object. Hence, initial locations of all
     * game objects should always be set to values such that the objects’ centers
     * are contained in the world. All game objects provide the ability for external
     * code to obtain their location.
     * 
     * @return float
     */
    public float getLocation() {
        return location;
    }

    /**
     * By default, game objects provide the ability to have their location changed,
     * unless it is explicitly stated that a certain type of game object has a
     * location which cannot be changed once it is created.
     * 
     * @param newX
     * @param newY
     */
    public void setLocation(float newX, float newY) {
        this.location.set(0, newX);
        this.location.set(1, newY);
    }

}
