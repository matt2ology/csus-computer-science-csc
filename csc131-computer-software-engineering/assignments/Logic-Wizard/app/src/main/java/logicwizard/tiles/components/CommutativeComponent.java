package logicwizard.tiles.components;


import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import logicwizard.Grid;
import logicwizard.tiles.components.concrete.ANDGate;
import logicwizard.tiles.components.concrete.ORGate;
import logicwizard.util.GridPoint;
import logicwizard.util.LocalPoint;

/**
 * Refers to a component, where the order of inputs is unimportant.
 * Named as this instead of binary component, because future implementations may allow
 * for components with an arbitrary amount of inputs.
 *
 * @see ANDGate
 * @see ORGate
 */
public abstract class CommutativeComponent extends Component {

    private static final int MAX_INPUTS = 2;

    /**
     * An array of components representing wires connected to this component.
     * a pin with no input is null. When wires are disconnected, any subsequent non-null
     * inputs are shifted to fill its place meaning all nulls are at the end of the array.
     */
    private final Component[] inputs = new Component[MAX_INPUTS];

    public CommutativeComponent(Grid grid) {
        super(grid);
    }

    @Override
    public void processConnection(Component source) {
        if (hasInput(source))
            // Disconnect the wire if drawn from a component already connected.
            removeInput(source);
        else
            connectInput(source);
    }

    private void connectInput(Component component) {
        int slotsInUse = slotsInUse();
        if (slotsInUse >= MAX_INPUTS) {
            System.out.println("Not adding connection; Gate full");
        } else {
            setInput(slotsInUse, component);
        }
    }

    @Override
    public void removeInput(Component component) {
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == component)
                setInput(i, null);
            // Shift null to end of array.
            if (i < inputs.length - 1 && inputs[i] == null && inputs[i+1] != null) {
                Component swap = inputs[i];
                inputs[i] = inputs[i+1];
                inputs[i+1] = swap;
            }
        }
    }

    private int slotsInUse() {
        int count = 0;
        for (Component input : inputs) {
            if (input != null)
                count++;
            else
                return count;
        }
        return count;
    }

    private int getIndex(Component component) {
        for (int i = 0; i < inputs.length; i++) {
            if (inputs[i] == component)
                return i;
        }
        return -1;
    }

    private boolean hasInput(Component component) {
        return getIndex(component) != -1;
    }

    /**
     * @return true if the input is on, and false if it is off.
     */
    protected final boolean evalInput(int input) {
        if (input < slotsInUse()) {
            return inputs[input].eval();
        } else {
            return false;
        }
    }

    @Override
    protected void setInputInternal(int input, Component component) {
        inputs[input] = component;
    }

    @Override
    public boolean hasInputPin() {
        return true;
    }

    @Override
    public boolean hasOutputPin() {
        return true;
    }

    @Override
    public boolean canAcceptWire(Component component) {
        return slotsInUse() < MAX_INPUTS || hasInput(component);
    }

    @Override
    public String getAdditionalStorageData() {
        String ret = " ";
        for (Component input : inputs) {
            ret += input.getPoint().x + " " + input.getPoint().y + " ";
        }
        return ret;
    }

    @Override
    public void loadAdditionalStorageData(Scanner scanner) {
        while (scanner.hasNextInt()) {
            Component component = grid.getTile(new GridPoint(scanner.nextInt(), scanner.nextInt()));
            if (component != null)
                connectInput(component);
        }
    }

    public List<Component> getInputs() {
        return Arrays.asList(inputs);
    }

    @Nullable
    @Override
    public Component getInput(int input) {
        return inputs[input];
    }

    /**
     * Returns the point local to grid partition of the input that the wire should be
     * routed to.
     */
    public LocalPoint getInputPosFor(Component component) {
        int input = getIndex(component);
        if (input != -1) {
            if (input == 0) {
                return convertToGridSpace(new LocalPoint((int) ((35.0 / 150) * grid.tileLength), getRect().centerY() - (int) ((15.0 / 150) * grid.tileLength)));
            } else {
                return convertToGridSpace(new LocalPoint((int) ((35.0 / 150) * grid.tileLength), getRect().centerY() + (int) ((15.0 / 150) * grid.tileLength)));
            }
        } else {
            return grid.convertToLocalPoint(new GridPoint(0, 0));
        }
    }

}
