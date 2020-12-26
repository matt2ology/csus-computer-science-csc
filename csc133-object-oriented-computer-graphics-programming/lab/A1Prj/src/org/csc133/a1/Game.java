package org.csc133.a1;

import com.codename1.ui.Form;

public class Game extends Form {
    private GameWorld gw;

    public Game() {
        gw = new GameWorld();
        gw.init();
        play();
    }

    private void play() {
        // Code here to accept and execute user commands that operate on the game world
        // (refer to "Apendix - CN1 Notes" for acception keyboard commands via a text
        // field location on the form)
    }
}
