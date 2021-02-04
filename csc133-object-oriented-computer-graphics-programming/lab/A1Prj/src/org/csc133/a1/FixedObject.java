package org.csc133.a1;

/**
 * This class represents a fixed game object in a game world. It inherits
 * GameObject.
 */
public abstract class FixedObject extends GameObject {

    public FixedObject(int color,int size) {
        super(color,size);
    }

    public FixedObject(int color, int size, FloatingPointPosition location) {
        super(color, size, location);
    }

}
