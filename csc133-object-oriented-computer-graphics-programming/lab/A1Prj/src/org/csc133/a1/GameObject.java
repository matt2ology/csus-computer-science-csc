package org.csc133.a1;

import java.util.Random;
import com.codename1.charts.util.ColorUtil;

public abstract class GameObject {
    /**
     * All game objects have a color and all objects of the same class have the same
     * color
     */
    private int color;
    /** All game objects have an integer attribute size. */
    private int size;
    /** All game objects have a location */
    private FloatingPointPosition location;

    /**
     * Create new object with given size, color, and random point-location
     * 
     * @param size
     * @param location
     * @param color
     */
    public GameObject(int color, int size) {
        Random randomGenerator = new Random();
        this.color = color;
        this.size = size;
        // 983 is within the 1024 x horizontal space with padding of 20
        // 728 is within the 768 y vertical space with padding of 20
        FloatingPointPosition point = new FloatingPointPosition((randomGenerator.nextInt(983)),
        (randomGenerator.nextInt(728) + 20));
        // Don't use setters as they are overridden down the chain to prevent use and
        // cause pointer errors
        this.location = point;
    }
    
    /**
     * Create new object with the given color, size, and location.
     * @param color
     * @param size
     * @param location
     */
    public GameObject(int color, int size, FloatingPointPosition location) {
        this.color = color;
        this.size = size;
        this.location = location;
    }

    // All game objects provide the ability for external code to obtain their size.
    // However, they do not provide the ability to have their size changed once it
    // is created.
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public FloatingPointPosition getLocation() {
        return location;
    }

    /**
     * Game objects provide the ability to have their location changed, unless it is
     * explicitly stated that a certain type of game object has a location which
     * cannot be changed once it is created. <b>Except SkyScrapers and
     * helicopters</b>, initial locations of all the game objects should be assigned
     * randomly when created.
     * 
     * @param location
     */
    public void setLocation(FloatingPointPosition location) {
        this.location = location;
    }

    /**
     * All game objects provide the ability for external code to obtain their color.
     * By default, game objects provide the ability to have their color changed,
     * unless it is explicitly stated that a certain type of game object has a color
     * which cannot be changed once it is created.
     * 
     * @return color
     */
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getColorToString() {
        return "[" + ColorUtil.red(this.color) + "," + ColorUtil.green(this.color) + "," + ColorUtil.blue(this.color)
                + "]";
    }

    // Every class will need to output a string for printing
    public abstract String toString();

}
