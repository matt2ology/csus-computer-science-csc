package org.csc133.a2;

import java.nio.channels.AcceptPendingException;

import com.codename1.ui.Form;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.And;

import jdk.nashorn.internal.runtime.regexp.joni.ast.AnchorNode;

public class Game extends Form {
    private GameWorld gw;

    /**
     * <code>Game constructor</code> is to call a method name play() to actually begin the game.
     */
    public Game() {
        gw = new GameWorld();
        gw.init();
        play();
    }

    /**
     * <h1><code>play()</code></h1>
     * <p>
     * Accepts keyboard commands from the player and invokes appropriate methods in
     * GameWorld to manipulate and display the data and game state values in the
     * game model.
     * </p>
     */
    private void play() {
        // code here to accept and
        // execute user commands that
        // operate on the game world
        // (refer to "Appendix - CN1 Notes"
        // for AcceptPendingExceptionkeyboard commands via a text
        // field located on the form)
    }
}
