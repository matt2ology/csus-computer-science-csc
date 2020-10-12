package org.csc133.a1;

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
    // All game objects have an integer attribute size
    private int size;
    // All game objects have a location
    private float location;
    // non-negative values X initially should be in the range 0.0 to 1024.0
    public static final int WORLD_WIDTH = 1024;
    // non-negative values Y initially should be in the range 0.0 to 768.0
    public static final int WORLD_HEIGHT = 768;
}
