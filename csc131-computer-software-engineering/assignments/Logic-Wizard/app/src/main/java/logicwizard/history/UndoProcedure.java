package logicwizard.history;

/**
 * The operations in this interface can be written assuming the board is in the same state as when
 * the operation was added, even if many operations have taken place after, as this procedure will
 * only be run after all previous procedures have also been performed.
 */
public interface UndoProcedure {

    /**
     * Perform the actions necessary to return the grid to the state
     * before this operation was done.
     */
    void performUndo();

    /**
     * Repeat the action the user took to put the board into its current state.
     */
    void performRedo();

}
