package logisim.state.modes;


import logisim.util.ScreenPoint;

/**
 * A long-term mode for the app to be in, requiring multiple steps to complete.
 */
public interface IMode {

    void updateDrag(ScreenPoint screenPoint);

    /**
     * Update mode with the current state.
     */
    void processTap(Object touchedObject);

    void processDrag(ScreenPoint screenPoint, Object dest);

    void draw();

    /**
     * Clean up before switching mode.
     */
    void finalizeMode();

}
