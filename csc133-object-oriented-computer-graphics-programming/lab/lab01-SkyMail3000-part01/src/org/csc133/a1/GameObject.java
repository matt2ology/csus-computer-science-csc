package org.csc133.a1;

import java.util.Random;
import com.codename1.ui.geom.Point2D;
import com.codename1.charts.util.ColorUtil;

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

    private Point2D location;
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
     * Constructs a game object, setting its location in the world.
     */
    public GameObject() {
        Random randomValue = new Random();
        // Arbitrary method to get random xCoordinate
        double xCoordinate = Math.round((getWorldWidth() * randomValue.nextDouble() * 10.0)) / 10.0;
        // Arbitrary method to get random yCoordinate
        double yCoordinate = Math.round((getWorldHeight() * randomValue.nextDouble() * 10.0)) / 10.0;
        // Instances xCoordinate or yCoordinate will be greater than WORLD max values
        if (xCoordinate > getWorldWidth()) {
            xCoordinate = getWorldWidth();
        }
        if (yCoordinate > getWorldHeight()) {
            yCoordinate = getWorldHeight();
        }

        location = new Point2D(xCoordinate, yCoordinate);
    }

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
     * @return The Point2D object representing the entire location of the object
     */
    public Point2D getLocation() {
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

    /**
     * All game objects <b>provide the ability for external code to obtain their
     * color.</b>
     */
    public int getColor() {
        return color;
    }

    /**
     * By default, game objects <b>provide the ability to have their color
     * changed</b>, unless it is explicitly stated that a certain type of game
     * object has a color which cannot be changed once it is created.
     * 
     * @param redValue
     * @param greenValue
     * @param blueValue
     */
    public void setColor(int redValue, int greenValue, int blueValue) {
        this.color = ColorUtil.rgb(redValue, greenValue, blueValue);
    }

    /**
     * @return The int value of max world width
     */
    public static int getWorldWidth() {
        return WORLD_WIDTH;
    }

    /**
     * @return The int value of max world height
     */
    public static int getWorldHeight() {
        return WORLD_HEIGHT;
    }

}
