package logisim.state.modes;


import logisim.state.StateManager;

public abstract class AbstractMode implements IMode {

    protected final StateManager stateManager;

    public AbstractMode(StateManager stateManager) {
        this.stateManager = stateManager;
    }

}
