package org.csc133.a2;

/**
 * <h1>The GameClockComponent</h1> The real time game clock is not a merely a
 * view on game data, rather, it is a self-animating component and provides
 * elapsed real time information to the game world. This will run at the full
 * framerate of CN1 and is not dependent on the UITimer that is responsible for
 * updating the rest of the game. These methods are exposed to GameWorld via an
 * appropriate interface defined in GlassCockpit. <br>
 * <br>
 * GlassCockpit should expose only the functions that GameWorld needs and in the
 * language of the domain of GameWorld. For example, if the game never needs the
 * clock to restart from any time other than time zero, then there is no need to
 * separate reset and start as exposed to GameWorld.
 * <ul>
 * <li>resetResetElapsedTime()</li>
 * <li>startElapsedTime()</li>
 * <li>stopElapsedTime()</li>
 * <li>getElapsedTime()</li>
 * </ul>
 * <h2>Requirements</h2>

 * </ul>
 * 
 */
public class GameClockComponent {
    
    /**Game Time is reset to zero */
    public void resetResetElapsedTime() {

    }
    /**Game Time shows the elapsed time since it was reset */
    public void startElapsedTime() {

    }
    /**Game Time stops */
    public void stopElapsedTime() {

    }
    /**Time elapsed from when it was reset is computed */
    public void getElapsedTime() {

    }
}
