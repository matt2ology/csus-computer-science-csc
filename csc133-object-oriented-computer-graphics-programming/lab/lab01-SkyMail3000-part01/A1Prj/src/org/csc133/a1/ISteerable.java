package org.csc133.a1;

/**
 * Some movable game objects are steerable, meaning that they implement an
 * interface called <code>ISteerable</code> that allows other objects to change
 * their heading (direction of movement) after they have been created. <br>
 * <br>
 * <b>Note:</b> The difference between <code>steerable</code> and
 * <code>moveable</code> is that other objects can request a change in the
 * heading of steerable objects whereas other objects can only request that a
 * movable object update its own location according to its current
 * <code>speed</code> and <code>heading</code>.
 */
public interface ISteerable {
    public void turnLeft();

    public void turnRight();
}
