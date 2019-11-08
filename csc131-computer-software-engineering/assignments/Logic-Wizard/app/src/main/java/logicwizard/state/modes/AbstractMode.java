package logicwizard.state.modes;


import logicwizard.state.StateManager;

public abstract class AbstractMode implements IMode {

    protected final StateManager stateManager;

    public AbstractMode(StateManager stateManager) {
        this.stateManager = stateManager;
    }

}
