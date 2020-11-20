package org.csc133.a2;

import java.lang.Math;

/**
 * <h1>Moveable</h1> game objects have integer attributes <code>heading</code>
 * and <code>speed</code>. Telling a moveable object to <code>move()</code>
 */
public class Moveable extends GameObject {
    private int heading;
    private int speed;

    public Moveable(int colorValue) {
        super(colorValue);
    }

    public Moveable(int colorValue, int sizeValue) {
        super(colorValue, sizeValue);
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * <h1><code>move()</code></h1> causes the object to update its location based
     * on its current <code>heading</code> and <code>speed</code>. The movable game
     * objects all move the same way and they move simultaneously according to their
     * individual <code>heading</code> and <code>speed</code>. <code>Heading</code>
     * is specified by a compass angle in degrees: 0 means heading north (upwards on
     * the screen), 90 means heading east (rightward on the screen), etc. See below
     * for details on updating an movable object’s position when its
     * <code>move()</code> method is invoked.
     */
    public void move() {
        double radian = (90 - this.getHeading()) * (double) Math.PI / 180;
        double newX = this.getXcoordinate() + (double) Math.cos(radian) * this.getSpeed();
        double newY = this.getYcoordinate() + (double) Math.sin(radian) * this.getSpeed();
        this.setLocation(newX, newY);
    }

}
