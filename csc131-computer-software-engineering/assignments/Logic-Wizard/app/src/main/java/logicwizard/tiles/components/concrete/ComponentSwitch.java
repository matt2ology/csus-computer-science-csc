package logicwizard.tiles.components.concrete;

import androidx.annotation.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import logicwizard.Grid;
import logicwizard.R;
import logicwizard.history.UndoProcedure;
import logicwizard.tiles.components.Component;
import logicwizard.util.LocalPoint;

public class ComponentSwitch extends Component {

    private boolean state;

    public ComponentSwitch(Grid grid) {
        super(grid);
    }

    @Override
    public String getName() {
        return "Switch";
    }

    @Override
    public void processConnection(Component source) {

    }

    /**
     * Flips switch to opposite state and writes the action to history.
     */
    @Override
    public void onTap() {
        boolean stateForUndo = this.state;
        this.state = !this.state;
        boolean stateForRedo = this.state;

        Component thisSwitch = this;
        grid.stateManager.history.pushAction("Set " + thisSwitch + " " + (state ? "on" : "off"), new UndoProcedure() {
            @Override
            public void performUndo() {
                state = stateForUndo;
            }

            @Override
            public void performRedo() {
                state = stateForRedo;
            }
        });
    }

    @Override
    public boolean eval() {
        return state;
    }

    @Override
    public String getStorageID() {
        return "switch";
    }

    @Override
    public String getAdditionalStorageData() {
        return " " + state;
    }

    @Override
    public void loadAdditionalStorageData(Scanner scanner) {
        this.state = scanner.nextBoolean();
    }

    @Override
    public int getRresource() {
        return state ? R.drawable.switch_on : R.drawable.switch_off;
    }

    @Override
    public boolean canAcceptWire(Component component) {
        return false;
    }

    /**
     * @return If this component has any input pins. It does not matter if the pins are filled or not.
     */
    @Override
    public boolean hasInputPin() {
        return false;
    }

    @Override
    public boolean hasOutputPin() {
        return true;
    }

    @Override
    public List<Component> getInputs() {
        return Collections.emptyList();
    }

    @Nullable
    @Override
    public Component getInput(int input) {
        return null;
    }

    @Override
    public void removeInput(Component component) {

    }

    @Override
    protected void setInputInternal(int input, Component component) {

    }

    /**
     * Returns the point local to grid partition of the input that the wire should be
     * routed to.
     */
    public LocalPoint getInputPosFor(Component component) {
        return null;
    }

}
