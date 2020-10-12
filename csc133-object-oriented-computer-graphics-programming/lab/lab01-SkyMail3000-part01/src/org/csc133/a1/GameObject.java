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
    GameWorld=new GameWorld();

    // For use of GameWorld values WorldWidth and WorldHeight
    /**
     * Constructs a game object, setting its RGB color values and location in the
     * world.
     * 
     * @param redValue
     * @param greenValue
     * @param blueValue
     * @param sizeValue
     */
    public GameObject(int redValue, int greenValue, int blueValue, int sizeValue) {
        setColor(redValue, greenValue, blueValue);
        setSize(sizeValue);
        Random randomValue = new Random();
        // Arbitrary method to get random xCoordinate
        double xCoordinate = Math.round((GameWorld.getWorldWidth() * randomValue.nextDouble() * 10.0)) / 10.0;
        // Arbitrary method to get random yCoordinate
        double yCoordinate = Math.round((GameWorld.getWorldHeight() * randomValue.nextDouble() * 10.0)) / 10.0;
        // Instances xCoordinate or yCoordinate will be greater than WORLD max values
        if (xCoordinate > GameWorld.getWorldWidth()) {
            xCoordinate = GameWorld.getWorldWidth();
        }
        if (yCoordinate > GameWorld.getWorldHeight()) {
            yCoordinate = GameWorld.getWorldHeight();
        }

        location = new Point2D(xCoordinate, yCoordinate);
    }

    /**
     * Constructs a game object, setting its color and location in the world.
     * 
     * @param colorValue
     * @param sizeValue
     */
    public GameObject(int colorValue, int sizeValue) {
        setColor(colorValue);
        setSize(sizeValue);
        Random randomValue = new Random();
        // Arbitrary method to get random xCoordinate
        double xCoordinate = Math.round((GameWorld.getWorldWidth() * randomValue.nextDouble() * 10.0)) / 10.0;
        // Arbitrary method to get random yCoordinate
        double yCoordinate = Math.round((GameWorld.getWorldHeight() * randomValue.nextDouble() * 10.0)) / 10.0;
        // Instances xCoordinate or yCoordinate will be greater than WORLD max values
        if (xCoordinate > GameWorld.getWorldWidth()) {
            xCoordinate = GameWorld.getWorldWidth();
        }
        if (yCoordinate > GameWorld.getWorldHeight()) {
            yCoordinate = GameWorld.getWorldHeight();
        }

        location = new Point2D(xCoordinate, yCoordinate);
    }

    /**
     * Constructs a game object, setting only its color.
     * 
     * @param colorValue
     */
    public GameObject(int colorValue) {
        setColor(colorValue);
        Random randomValue = new Random();
        // Arbitrary method to get random xCoordinate
        double xCoordinate = Math.round((GameWorld.getWorldWidth() * randomValue.nextDouble() * 10.0)) / 10.0;
        // Arbitrary method to get random yCoordinate
        double yCoordinate = Math.round((GameWorld.getWorldHeight() * randomValue.nextDouble() * 10.0)) / 10.0;
        // Instances xCoordinate or yCoordinate will be greater than WORLD max values
        if (xCoordinate > GameWorld.getWorldWidth()) {
            xCoordinate = GameWorld.getWorldWidth();
        }
        if (yCoordinate > GameWorld.getWorldHeight()) {
            yCoordinate = GameWorld.getWorldHeight();
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
     * Assigns the size of a game object
     * 
     * @param sizeValue
     */
    public void setSize(int sizeValue) {
        this.size = sizeValue;
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
     * @return The double value for the X Coordinate in world space
     */
    public double getXcoordinate() {
        return location.getX();
    }

    /**
     * @return The double value for the Y Coordinate in world space
     */
    public double getYcoordinate() {
        return location.getY();
    }

    /**
     * By default, game objects provide the ability to have their location changed,
     * unless it is explicitly stated that a certain type of game object has a
     * location which cannot be changed once it is created.
     * 
     * @param newX
     * @param newY
     */
    public void setLocation(double newX, double newY) {
        this.location.setX(Math.round((newX * 10.0)) / 10);
        this.location.setY(Math.round((newY * 10.0)) / 10);
    }

    /**
     * @param newLocation - location of the object in world space
     */
    public void SetLocation(Point2D newLocation) {
        location.setX(Math.round((newLocation.getX() * 10.0)) / 10.0);
        location.setY(Math.round((newLocation.getY() * 10.0)) / 10.0);
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
     * By default, game objects <b>provide the ability to have their color
     * changed</b>, unless it is explicitly stated that a certain type of game
     * object has a color which cannot be changed once it is created.
     * 
     * @param color
     */
    public void setColor(int color) {
        this.color = color;
    }

}
