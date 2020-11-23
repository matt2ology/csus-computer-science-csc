package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;

/**
 * <h1>Helicopter</h1> are <b><i>moveable</i></b> and <b><i>steerable</i></b>
 * game objects with attributes: <code>stickAngle</code>,
 * <code>maximumSpeed</code>, <code>fuelLevel</code>,
 * <code>fuelConsumptionRate</code>, <code>damageLevel</code>, and
 * <code>lastSkyScraperReached</code>.
 */
public class Helicopter extends Moveable implements ISteerable {
    /**
     * The stickAngle of a helicopter indicates how the control stick is turned in
     * relation to the front of the helicopter. That is, the stickAngle of a
     * helicopter indicates the change the player would like to apply to the heading
     * along which the helicopter is moving (the stickAngle actually gets applied to
     * the heading when the clock ticks given that the helicopter has not run out of
     * fuel or does not have the maximum damage). Changing the heading will rotate
     * the helicopter even if the speed is zero.
     */
    private int stickAngle;
    /**
     * The maximumSpeed of a helicopter is the upper limit of its speed attribute;
     * attempts to accelerate a helicopter beyond its maximumSpeed are to be ignored
     * (that is, a helicopter can never go faster than its maximumSpeed). Note that
     * different helicopters may have different maximumSpeed values, although
     * initially they all start out with zero speed value.
     */
    private int maximumSpeed;
    /**
     * The fuelLevel of a helicopter indicates how much fuel it has left;
     * helicopters with no fuel would have zero speed and cannot move. You should
     * set this value to the same initial reasonable value for all helicopters.
     */
    private int fuelLevel;
    /**
     * The fuelConsumptionRate of a helicopter indicates how much fuel the
     * helicopter would spend each time the clock ticks. You should set this value
     * to the same reasonable value for all helicopters.
     */
    private int fuelConsumptionRate;
    /**
     * Since helicopters are able to hover, as long as there is fuel remaining and
     * the helicopter is not damaged.
     */
    private int damageLevel;
    /**
     * The damageLevel of a helicopter starts at zero and increases each time the
     * helicopter collides with another helicopter or a bird
     */
    private int maxDamageLevel;
    private int lastSkyScraperReached;

    public Helicopter() {
        // size of all helicopters can be 40
        super(ColorUtil.GREEN, 40);
        super.setSpeed(0);
        super.setHeading(0);
        setStickAngle(0);
        setMaximumSpeed(30);
        setFuelConsumptionRate(1);
        setFuelLevel(20);
        setDamageLevel(0);
        setLastSkyScraperReached(1);
    }
    // TODO: Make sub-class playerHelicopter
    public void resetHelicopter(float x, float y) {
        this.setX(x);
        this.setY(y);
        this.setHeading(0);
        this.setMaximumSpeed(30);
        this.setFuelConsumptionRate(1);
        this.setFuelLevel(20);
        this.setDamageLevel(0);
        this.life--;
    }

    @Override
    public void turnLeft() {
        int currentHeading = this.getStickAngle();
        if (currentHeading == 0) {
            /**
             * The stickAngle can only modify the heading in units of, at most, 5 degrees
             * per tick of the simulation
             */
            currentHeading -= 5;
            this.setStickAngle(currentHeading);
            if (this.getHeading() == 0) {
                this.setHeading(360 + currentHeading);
            } else {
                this.setHeading(this.getHeading() + currentHeading);
            }
        } else {
            if (currentHeading > -40) {
                /**
                 * The stickAngle can only modify the heading in units of, at most, 5 degrees
                 * per tick of the simulation
                 */
                currentHeading -= 5;
                this.setStickAngle(currentHeading);
                if (this.getHeading() == 0) {
                    this.setHeading(360 + currentHeading);
                } else {
                    this.setHeading(this.getHeading() + currentHeading);
                }
            } else {
                // The stickAngle is limited to a maximum of
                System.out.println("Can only turn left max 40");
            }
        }
    }

    @Override
    public void turnRight() {
        int currheading = this.getStickAngle();
        if (currheading == 0) {
            /**
             * The stickAngle can only modify the heading in units of, at most, 5 degrees
             * per tick of the simulation
             */
            currheading += 5;
            this.setStickAngle(currheading);
            if (this.getHeading() == 0) {
                this.setHeading(currheading);
            } else {
                this.setHeading(this.getHeading() + currheading);
            }
        } else {
            if (currheading < 40) {
                /**
                 * The stickAngle can only modify the heading in units of, at most, 5 degrees
                 * per tick of the simulation
                 */
                currheading += 5;
                this.setStickAngle(currheading);
                if (this.getHeading() == 0) {
                    this.setHeading(currheading);
                } else {
                    this.setHeading(this.getHeading() + currheading);
                }
            } else {
                // plus or minus 40 degrees
                System.out.println("Can only turn left max 40");
            }
        }

    }

    public int getStickAngle() {
        return stickAngle;
    }

    public void setStickAngle(int stickAngle) {
        this.stickAngle = stickAngle;
    }

    /**
     * The maximumSpeed of a helicopter is the upper limit of its speed attribute;
     * attempts to accelerate a helicopter beyond its maximumSpeed are to be ignored
     * (that is, a helicopter can never go faster than its maximumSpeed). <br>
     * <br>
     * <b>Note</b> that different helicopters may have different maximumSpeed
     * values, although initially they all start out with zero speed value.
     */
    public int getMaximumSpeed() {
        return maximumSpeed;
    }

    /**
     * The maximumSpeed of a helicopter is the upper limit of its speed attribute;
     * attempts to accelerate a helicopter beyond its maximumSpeed are to be ignored
     * (that is, a helicopter can never go faster than its maximumSpeed). <br>
     * <br>
     * <b>Note</b> that different helicopters may have different maximumSpeed
     * values, although initially they all start out with zero speed value.
     */
    public void setMaximumSpeed(int maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

    public void increaseSpeed() {
        int currentSpeed = getSpeed();
        if (!isMaximumSpeed()) {
            this.setSpeed(++currentSpeed);
        }
    }

    public void decreaseSpeed() {
        int currSpeed = getSpeed();
        if (currSpeed > 0) {
            this.setSpeed(--currSpeed);
        } else {

        }
    }

    public boolean isMaximumSpeed() {
        if (this.getSpeed() >= this.getMaximumSpeed()) {
            return true;
        }
        return false;
    }

    public int getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(int fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    public int getFuelConsumptionRate() {
        return fuelConsumptionRate;
    }

    public void setFuelConsumptionRate(int fuelConsumptionRate) {
        this.fuelConsumptionRate = fuelConsumptionRate;
    }

    public void fuelLevelTick() {
        this.setFuelLevel(this.getFuelLevel() - this.getfuelConsumptionRate());
    }

    public int getDamageLevel() {
        return damageLevel;
    }

    public void setDamageLevel(int damageLevel) {
        this.damageLevel = damageLevel;
    }

    public int getMaxDamageLevel() {
        return maxDamageLevel;
    }

    /**
     * Damage level affects the performance of a helicopter as follows: a helicopter
     * with zero damage can accelerate all the way up to its maximumSpeed;
     * helicopters with the maximum amount of damage would have zero speed and thus,
     * cannot move at all; and helicopters with damage between zero and the maximum
     * damage should be limited in speed to a corresponding percentage of their
     * speed range (for example, a helicopter with 50% of the maximum damage level
     * can only achieve 50% of its maximum speed). When a helicopter incurs damage
     * because it is involved in a collision (see below), its speed is reduced (if
     * necessary) so that this speed-limitation rule is enforced.
     */
    public void setMaxDamageLevel(int maxDamageLevel) {
        this.maxDamageLevel = maxDamageLevel;
    }

    public int getLastSkyScraperReached() {
        return lastSkyScraperReached;
    }

    /**
     * The lastSkyScraperReached of a helicopter indicates the sequence number of
     * the last SkyScraper that the helicopter has reached in the increasing order.
     * Initially, the player helicopter should be positioned at the location of
     * SkyScraper #1 (initially lastSkyScraperReached is assigned to 1) and its
     * heading and stickAngle should be set to zero, and speed should be set to an
     * appropriate positive (non-zero) value.
     *
     * @param lastSkyScraperReached
     */
    public void setLastSkyScraperReached(int lastSkyScraperReached) {
        this.lastSkyScraperReached = lastSkyScraperReached;
    }

}
