package org.csc133.a2;
import java.nio.channels.AcceptPendingException;

import com.codename1.ui.Form;

import org.graalvm.compiler.core.common.type.ArithmeticOpTable.BinaryOp.And;

import jdk.nashorn.internal.runtime.regexp.joni.ast.AnchorNode;
public class Game extends Form{
    private GameWorld gw;
    public Game() {
        gw = new GameWorld();
        gw.init();
        play();
    }
    private void play() {
        // code here to accept and
        // execute user commands that
        // operate on the game world
        // (refer to "Appendix - CN1 Notes"
        // for AcceptPendingExceptionkeyboard commands via a text
        // field located on the form)
    }
}
