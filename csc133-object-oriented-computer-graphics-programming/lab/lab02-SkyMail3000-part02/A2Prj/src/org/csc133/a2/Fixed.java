package org.csc133.a2;

// All fixed game objects are not allowed to change location once they are created.
public class Fixed extends GameObject {

    public Fixed(int colorValue) {
        super(colorValue);
    }

    public Fixed(int colorValue, int sizeValue) {
        super(colorValue, sizeValue);
    }

    public Fixed(int redValue, int greenValue, int blueValue, int sizeValue) {
        super(redValue, greenValue, blueValue, sizeValue);
    }
}
