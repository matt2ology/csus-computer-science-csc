package logicwizard;

import androidx.annotation.Nullable;

import logicwizard.tiles.IDraggable;

public interface IInteractable {

    /**
     * Called when the user, touches and releases their finger on top of this object.
     * Used by switches to update their state.
     */
    void onTap();

    /**
     * Called when a finger is placed on top of this object, but has not been released.
     */
    void onTouch();

    /**
     * @return The draggable object for rendering purposes.
     */
    @Nullable
    IDraggable onDrag();

}
