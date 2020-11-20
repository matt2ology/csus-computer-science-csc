package org.csc133.a2;

import java.util.ArrayList;
import java.util.Random;

import com.codename1.charts.util.ColorUtil;

/**
 * This class manipulates data in the game model. The game world contains a
 * collection which aggregates objects of abstract type GameObject.
 */
public class GameWorld extends Observable {
    private static final int WORLD_WIDTH = 1024;
    // non-negative values X initially should be in the range 0.0 to 1024.0
    private static final int WORLD_HEIGHT = 768;
    // non-negative values Y initially should be in the range 0.0 to 768.0
    private int timer;
    private ArrayList<GameObject> gameObjects;
    private int skyScraperCount;
    private int refulingBlimpCount;
    private int birdCount;
    private int helicopterCount;
    private boolean gameOver;
    Random random = new Random();

    public void init() {
        // code here to create the
        // initial game objects/setup
        this.timer = 0;
        gameObjects = new ArrayList<GameObject>();
        this.skyScraperCount = 0;
        this.refulingBlimpCount = 0;
        this.birdCount = 0;
        this.helicopterCount = 0;
        this.gameOver = false;
        addGameObjects();
    }

    // Adding GameObjects to the GameWorld
    public void addGameObjects() {
        int skyScraperObject = 4 + random.nextInt(5);
        int refulingBlimpObject = 2 + random.nextInt(5);

        for (int i = 1; i < skyScraperObject; i++) {
            gameObjects.add(new SkyScraper(i));
            skyScraperCount++;
        }
        for (int i = 0; i < refulingBlimpObject; i++) {
            gameObjects.add(new RefuelingBlimps());
            refulingBlimpCount++;
        }
        for (int i = 0; i < refulingBlimpObject; i++) {
            gameObjects.add(new Bird());
            birdCount++;
        }
        gameObjects.add(new Helicopter());
        helicopterCount++;
    }

    // additional methods here to
    /**
     * @return The int value of max world width
     */
    public static int getWorldWidth() {
        return WORLD_WIDTH;
    }

    /**
     * @return The int value of max world height
     */
    public static int getWorldHeight() {
        return WORLD_HEIGHT;
    }

    // manipulate world objects and
    // related game state data
    // Game Methods
    // Press 'a'
    /**
     * ‘a’ – tell the game world to accelerate (immediately increase the speed of)
     * the player helicopter by a small amount. Note that the effect of acceleration
     * is to be limited Based on damage level, fuel level, and maximum speed as
     * described above.
     */
    public void increaseSpeed() {
		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext())
		{
			GameObjects tempObject = itr.getNext();
			if(tempObject instanceof Helicopter)
			{
				((Helicopter)tempObject).increaseSpeed();
			}
		}
		this.setChanged();
		this.notifyObservers(this);
    }

    // Press 'b'
    /**
     * ‘b’ – tell the game world to brake (immediately reduce the speed of) the
     * player helicopter by a small amount. Note that the minimum speed for a
     * helicopter is zero.
     */
    public void decreaseSpeed() {
        IIterator itr = gameObjects.getIterator();
        while (itr.hasNext()) {
            GameObjects tempObject = itr.getNext();
            if (tempObject instanceof Helicopter) {
                ((Helicopter) tempObject).decreaseSpeed();
            }
        }
        this.setChanged();
        this.notifyObservers(this);
    }

    // Press'l'
    /**
     * ‘l’ (the letter “ell”) – tell the game world to change the stickAngle of the
     * player helicopter by 5 degrees to the left (in the negative direction on the
     * compass). Note that this changes the angle of the helicopter’s control stick;
     * it does not directly (immediately) affect the helicopter’s heading. See the
     * “tick” command, below.
     */
    public void turnLeftHelicopter() {
    }

    // Press 'r'
    /**
     * ‘r’ – tell the game world to change the stickAngle of the player helicopter
     * by 5 degrees to the right (in the positive direction on the compass). As
     * above, this changes the angle of the helicopter’s control stick, not the
     * helicopter’s heading.
     */
    public void turnRightHelicopter() {
		IIterator itr = gameObjects.getIterator();
		while(itr.hasNext())
		{
			GameObjects tempObject = itr.getNext();
			if(tempObject instanceof Helicopter)
			{
				((Helicopter)tempObject).turnRight();
			}
		}
		
		this.setChanged();
		this.notifyObservers(this);        
    }

    // Press 'c'
    /**
     * ‘c’ – PRETEND that the player helicopter has collided with some other
     * helicopter; tell the game world that this collision has occurred. (For this
     * version of the program we won’t actually have any other helicopter in the
     * simulation, but we need to provide for testing the effect of such
     * collisions.) Colliding with another helicopter increases the damage level of
     * the player helicopter and modifies the helicopter’s appearance. The simplest
     * implementation of this behavior will be to make the helicopter appear more
     * red. Motivated students may choose to implement this feature as a changing
     * sprite. If the damage results in the player helicopter not being able to move
     * then the game stops (the player loses a life).
     */
    public void collsionHelicopter() {
    }

    // Case 1 -9
    /**
     * ‘a number between 1-9’– PRETEND that the player helicopter has collided with
     * the SkyScraper number x (which must have a value between 1-9); tell the game
     * world that this collision has occurred. The effect of moving over a
     * skyscraper is to check to see whether the number x is exactly one greater
     * than the skyscraper indicated by lastSkyScraperReached field of the
     * helicopter and if so to record in the helicopter the fact that the helicopter
     * has now reached the next sequential skyscraper.
     */
    public void collisonSkyScraper(int c) {
    }

    // Press'e'
    public void collsionRefuelingBlimp() {
    }

    // Press 'g'
    /**
     * ‘g’ – PRETEND that a bird has flown over (collided with, gummed up) the
     * player helicopter. The effect of colliding with a bird is to increase the
     * damage to the helicopter as described above under the description of birds
     * and, initially, fades the color of the helicopter (i.e., the helicopter color
     * becomes lighter red).
     */
    public void collisonBird() {
    }

    // Press 't'
    /**
     * ‘t’ – tell the game world that the “game clock” has ticked. A clock tick in
     * the game world has the following effects: (1) if the player helicopter moves
     * (e.g., did not run out of fuel or does not have the maximum damage or zero
     * speed), then the helicopter’s heading should be incremented or decremented as
     * detailed above in the discussion of the helicopter’s stickAngle. (2) Birds
     * also update their heading as indicated above. (3) all moveable objects are
     * told to update their positions according to their current heading and speed,
     * and (4) the helicopter’s fuel level is reduced by the amount indicated by its
     * fuelConsumptionRate. (5) the elapsed time “game clock” is incremented by one
     * (the game clock for this assignment is simply a variable which increments
     * with each tick)
     */
    public void gameTick() {
    }

    // Press 'd'
    /**
     * ‘d’ – generate a display by outputting lines of text on the console
     * describing the current game/player-helicopter state values. The display
     * should include (1) the number of lives left, (2) the current clock value
     * (elapsed time), (3) the highest SkyScraper number the helicopter has reached
     * sequentially so far, (4) the helicopter’s current fuel level and (5)
     * helicopter’s current damage level. All output should be appropriately labeled
     * in easily readable format.
     */
    public void printCurrent() {
    }

    // Press 'm'
    /**
     * ‘m’ – tell the game world to output a “map” showing the current world (see
     * below).
     */
    public void printMap() {
    }

    // Press 'x'
    /**
     * ‘x’ – exit, by calling the method System.exit(0) to terminate the program.
     * Your program should confirm the user’s intent (see ‘y’ and ‘n’ commands
     * below) to quit before actually exiting.
     */
    public int getTime() {
        return 0;
    }

    public void exit() {
        System.exit(0);
    }

}
