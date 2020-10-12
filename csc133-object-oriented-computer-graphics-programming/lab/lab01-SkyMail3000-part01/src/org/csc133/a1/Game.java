package org.csc133.a1;

import com.codename1.ui.Form;

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
     * <b>play():</b> Accept and execute user commands.
     */
    private void play() {
        // code here to accept and
        // execute user commands that
        // operate on the game world
        // (refer to “Appendix - CN1
        // Notes” for accepting
        // keyboard commands via a text
        // field located on the form)
    }
}