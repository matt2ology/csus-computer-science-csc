import org.csc133.a1.Moveable;

import java.util.Random;

import com.codename1.charts.util.ColorUtil;

/**
 * Birds are moveable (but not steerable) objects that fly over the flight path.
 * They add (or subtract) small random values (e.g., 5 degrees) to their heading
 * while they move so as to not run in a straight line. If the bird’s center
 * hits a side of the world, it changes heading and does not move out of bounds.
 * If a bird flies directly over a helicopter it causes damage to the
 * helicopter; the damage caused by a bird is half the damage caused by
 * colliding with another helicopter but otherwise affects the performance of
 * the helicopter in the same way as described above. Birds are not allowed to
 * change color once they are created. Speed of birds should be initialized to a
 * reasonable random value (e.g., ranging between 5 and 10) at the time of
 * instantiation. Heading of birds should be initialized to a random value
 * (ranging between 0 and 359) at the time of instantiation.
 */
public class Bird extends Moveable {
    Random random = new Random();

    public Bird() {
        /*
         * Birds are not allowed to change color once they are created.
         */
        super(ColorUtil.BLUE);
        final int MIN_SIZE = 10;
        final int MAX_SIZE = 50;
        super.setSize(new Random().nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE);
        /*
         * Heading of birds should be initialized to a random value (ranging between 0
         * and 359) at the time of instantiation.
         */
        super.setHeading(random.nextInt(360));
        /*
         * Speed of birds should be initialized to a reasonable random value (e.g.,
         * ranging between 5 and 10) at the time of instantiation.
         */
        super.setSpeed(random.nextInt(10));
    }

    /**
     * Birds are moveable (but not steerable) objects that fly over the flight path.
     * They add (or subtract) small random values (e.g., 5 degrees) to their heading
     * while they move so as to not run in a straight line.
     */
    public void move() {
        this.setHeading(super.getHeading() + Random.nextInt(5));
    }

    /**
     * If the bird’s center hits a side of the world, it changes heading and does
     * not move out of bounds.
     */
    // TODO: If a bird flies directly over a helicopter it causes damage to the
    // TODO: helicopter; the damage caused by a bird is half the damage
    // TODO: caused by colliding with another helicopter but otherwise affects the
    // TODO: performance of the helicopter in the same way as described above.

    public void boundaryBird() {
        if ((this.getSize() + this.getXcoordinate()) > getWorldWidth() || (this.getXcoordinate() + this.getSize() > 0)) {
            this.setHeading(random.nextInt(180));

        }
        if ((this.getSize() + this.getYcoordinate()) > getWorldWidth() || (this.getSize() + this.getYcoordinate()) < 0) {
            this.setHeading(random.nextInt(180));
        }
    }
}
