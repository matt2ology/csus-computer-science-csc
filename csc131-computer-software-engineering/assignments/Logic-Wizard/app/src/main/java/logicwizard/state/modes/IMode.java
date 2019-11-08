package logicwizard.state.modes;


import logicwizard.util.ScreenPoint;

/**
 * A mode for the app to be in corresponding to an action that the user is performing, like
 * adding or moving a component.
 */
public interface IMode {

    /**
     * Updates the mode with the current position of the finger.<br>
     * {@link ComponentInteractMode} uses this to determine if a finger left the area of a tile
     * so it can switch to WireMode.
     */
    void updateDrag(ScreenPoint screenPoint);

    /**
     * Update mode with the current state.
     */
    void processTap(Object touchedObject);

    /**
     * Called when a drag is released.
     * @param screenPoint The point where the finger was released.
     * @param dest The object that is currently at screenPoint
     */
    void processDrag(ScreenPoint screenPoint, Object dest);

    /**
     * Draw things related to this mode - So far just drawing dragged objects and outlines.
     */
    void draw();

    /**
     * Clean up before switching mode. Used in ComponentInteractMode to stop the timer.
     */
    void finalizeMode();

}
