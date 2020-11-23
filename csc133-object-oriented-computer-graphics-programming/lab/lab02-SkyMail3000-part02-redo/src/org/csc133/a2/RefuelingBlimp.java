package org.csc133.a2;

/**
 * RefuelingBlimp is a fixed object. <br>
 * <br>
 */
public class RefuelingBlimp extends Fixed {

    // Sizes of the rest of the game objects are chosen randomly when created, and
    // constrained to a reasonable positive integer value (e.g., between 10 to 50).
    // For instance, size of one of the refueling blimp may be 15 while size of
    // another refueling blimp can may be 20.
    /**
     * RefuelingBlimps are fixed game objects that have an attribute capacity
     * (amount of fuel an refueling blimp contains). The initial capacity of the
     * refueling blimp is proportional to its size.
     */
    private int capacity;
}