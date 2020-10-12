package org.csc133.a1;

import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;

import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;

import java.lang.String;

/**
 * <h1>The top-level Game class</h1> also manages the flow of control in the
 * game (such a class is therefore sometimes called a controller). The
 * controller enforces rules such as what actions a player may take and what
 * happens as a result.
 * <p>
 * This class accepts input in the form of keyboard commands from the human
 * player and invokes appropriate methods in the game world to perform the
 * requested commands – that is, to manipulate data in the game model.
 * </p>
 * <b>In this first version of the program the top-level Game class</b> will
 * also be responsible for displaying information about the state of the game.
 * <b>In future</b> assignments we will learn about a separate kind of component
 * called a view which will assume that responsibility.
 * 
 * @author Matt
 * @version 1.0
 */
public class Game extends Form {
    private GameWorld gw;

    /**
     * The <b>Game constructor</b> instantiates a <b>GameWorld</b>, calls a
     * <b>GameWorld method</b> <code>init()</code> to set the initial state of the
     * game, and then starts the game by calling a <b>Game method</b>
     * <code>play()</code>.
     * 
     * @see play()
     */
    public Game() {
        gw = new GameWorld();
        gw.init();
        play();
    }

    /**
     * <b>play():</b> Accept and execute user commands. <><br>
     * code here to accept and execute user commands that operate on the game world
     * (refer to “Appendix - CN1 Notes” for accepting keyboard commands via a text
     * field located on the form)
     */
    private void play() {
        Label myLabel = new Label("Enter a Command:");
        this.addComponent(myLabel);
        final TextField myTextField = new TextField();
        this.addComponent(myTextField);
        this.show();
        myTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                String sCommand = myTextField.getText().toString();
                myTextField.clear();
                if (sCommand.length() != 0) {
                    switch (sCommand.charAt(0)) {
                        // ‘a’ – tell the game world to accelerate (immediately
                        // increase the speed of) the player helicopter by a
                        // small amount. Note that the effect of acceleration
                        // is to be limited Based on damage level, fuel level,
                        // and maximum speed as described above.
                        case 'a':
                            gw.increaseSpeed();
                            break;
                        // ‘b’ – tell the game world to brake (immediately
                        // reduce the speed of) the player helicopter by a
                        // small amount. Note that the minimum speed for a
                        // helicopter is zero.
                        case 'b':
                            gw.decreaseSpeed();
                            break;
                        // ‘l’ (the letter “ell”) – tell the game world to
                        // change the stickAngle of the player helicopter
                        // by 5 degrees to the left (in the negative
                        // direction on the compass). Note that this changes
                        // the angle of the helicopter’s control stick; it does
                        // not directly (immediately) affect the helicopter’s
                        // heading. See the “tick” command, below.
                        case 'l':
                            gw.turnLeftHelicopter();
                            break;
                        // ‘r’ – tell the game world to change the stickAngle
                        // of the player helicopter by 5 degrees to the right
                        // (in the positive direction on the compass).
                        // As above, this changes the angle of the
                        // helicopter’s control stick, not the helicopter’s heading.
                        case 'r':
                            gw.turnRightHelicopter();
                            break;
                        // ‘c’ – PRETEND that the player helicopter has collided
                        // with some other helicopter; tell the game world that
                        // this collision has occurred. (For this version of
                        // the program we won’t actually have any other
                        // helicopter in the simulation, but we need to provide
                        // for testing the effect of such collisions.)
                        // Colliding with another helicopter increases the
                        // damage level of the player helicopter and modifies
                        // the helicopter’s appearance. The simplest
                        // implementation of this behavior will be to make the
                        // helicopter appear more red. Motivated students may
                        // choose to implement this feature as a changing
                        // sprite. If the damage results in the player
                        // helicopter not being able to move then the game
                        // stops (the player loses a life).
                        case 'c':
                            gw.collsionHelicopter();
                            break;
                        // Case 1 -9
                        // ‘a number between 1-9’– PRETEND that the player helicopter has collided with
                        // the SkyScraper number x (which must have a value between 1-9); tell the game
                        // world that this collision has occurred. The effect of moving over a
                        // skyscraper is to check to see whether the number x is exactly one greater
                        // than the skyscraper indicated by lastSkyScraperReached field of the
                        // helicopter and if so to record in the helicopter the fact that the helicopter
                        // has now reached the next sequential skyscraper.
                        case '1':
                            gw.collisonSkyScraper(1);
                            break;
                        case '2':
                            gw.collisonSkyScraper(2);
                            break;
                        case '3':
                            gw.collisonSkyScraper(3);
                            break;
                        case '4':
                            gw.collisonSkyScraper(4);
                            break;
                        case '5':
                            gw.collisonSkyScraper(5);
                            break;
                        case '6':
                            gw.collisonSkyScraper(6);
                            break;
                        case '7':
                            gw.collisonSkyScraper(7);
                            break;
                        case '8':
                            gw.collisonSkyScraper(8);
                            break;
                        case '9':
                            gw.collisonSkyScraper(9);
                            break;
                        // ‘e’ – PRETEND that the player helicopter has
                        // collided with (intersected with) a refueling blimp;
                        // tell the game world that this collision has
                        // occurred. The effect of colliding an refueling blimp
                        // is to increase the helicopter’s fuel level by the
                        // capacity of the refueling blimp, reduce the capacity
                        // of the refueling blimp to zero, fade the color of
                        // the refueling blimp (e.g., change it to light green),
                        // and add a new refueling blimp with randomly-specified
                        // size and location into the game.
                        case 'e':
                            gw.collsionRefuelingBlimp();
                            break;
                        // ‘g’ – PRETEND that a bird has flown over (collided with, gummed up) the
                        // player helicopter. The effect of colliding with a bird is to increase the
                        // damage to the helicopter as described above under the description of birds
                        // and, initially, fades the color of the helicopter (i.e., the helicopter color
                        // becomes lighter red).
                        case 'g':
                            gw.collisonBird();
                            break;
                        // ‘t’ – tell the game world that the “game clock” has ticked. A clock tick in
                        // the game world has the following effects: (1) if the player helicopter moves
                        // (e.g., did not run out of fuel or does not have the maximum damage or zero
                        // speed), then the helicopter’s heading should be incremented or decremented as
                        // detailed above in the discussion of the helicopter’s stickAngle. (2) Birds
                        // also update their heading as indicated above. (3) all moveable objects are
                        // told to update their positions according to their current heading and speed,
                        // and (4) the helicopter’s fuel level is reduced by the amount indicated by its
                        // fuelConsumptionRate. (5) the elapsed time “game clock” is incremented by one
                        // (the game clock for this assignment is simply a variable which increments
                        // with each tick)
                        case 't':
                            gw.gameTick();
                            break;
                        // ‘d’ – generate a display by outputting lines of text on the console
                        // describing the current game/player-helicopter state values. The display
                        // should include (1) the number of lives left, (2) the current clock value
                        // (elapsed time), (3) the highest SkyScraper number the helicopter has reached
                        // sequentially so far, (4) the helicopter’s current fuel level and (5)
                        // helicopter’s current damage level. All output should be appropriately labeled
                        // in easily readable format.
                        case 'd':
                            gw.printCurrent();
                            ;
                            break;
                        // ‘m’ – tell the game world to output a “map” showing the current world (see
                        // below).
                        case 'm':
                            gw.printMap();
                            break;
                        // ‘x’ – exit, by calling the method System.exit(0) to terminate the program.
                        // Your program should confirm the user’s intent (see ‘y’ and ‘n’ commands
                        // below) to quit before actually exiting.
                        case 'x':
                            setKey(sCommand.charAt(0));
                            System.out.println("Are you sure to exit game?");
                            break;
                        // ‘y’ – user has confirmed the exit by saying yes
                        case 'Y':
                        case 'y':
                            if (getKey() == 'x') {
                                gw.exit();
                            } else {
                                System.out.println("Invalid input");
                            }
                            break;
                        // ‘n’ – user has not confirmed the exit by saying no.
                        case 'N':
                        case 'n':
                            if (getKey() == 'x') {
                                System.out.println("Game continue");
                            } else {
                                System.out.println("Invalid input");
                            }
                            break;
                        default:
                            System.out.println("\nYour Input is invalid.Please enter valid command!!!\n");
                            break;
                    }// END SWITCH (sCommand.charAt(0))
                } // END IF (sCommand.length() != 0)
            }// END actionPerformed(ActionEvent ev)
        }// END new ActionListener()
        );// END addActionListener
    }// END void play()
}// END class Game extends Form