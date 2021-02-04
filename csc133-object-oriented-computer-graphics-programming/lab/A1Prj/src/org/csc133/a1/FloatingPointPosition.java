package org.csc133.a1;

/**
 * This class is used to have float values to represent the x and y loction of
 * an object on screen
 */
public class FloatingPointPosition {
    /** x value for 2D location */
    private float x_position;
    /** y value for 2D location */
    private float y_position;

    /**
     * Construct a position point where point (X,Y) is the center of the object.
     * 
     * @param x_position
     * @param y_position
     */
    public FloatingPointPosition(float x_position, float y_position) {
        this.x_position = x_position;
        this.y_position = y_position;
    }

    public float getX_position() {
        return x_position;
    }

    private void setX_position(float x_position) {
        this.x_position = x_position;
    }

    public float getY_position() {
        return y_position;
    }

    private void setY_position(float y_position) {
        this.y_position = y_position;
    }

    /**
     * Sets a new point location for objects. The point (X,Y) is the center of the
     * object.
     * 
     * @param new_x_position
     * @param new_y_position
     */
    public void setLocation(float new_x_position, float new_y_position) {
        setX_position(new_x_position);
        setY_position(new_y_position);
    }
}
