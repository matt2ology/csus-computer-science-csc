package logicwizard.tiles.components;

import androidx.annotation.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import logicwizard.Grid;
import logicwizard.util.GridPoint;
import logicwizard.util.LocalPoint;

public abstract class UnaryComponent extends Component {

    @Nullable
    private Component input;

    public UnaryComponent(Grid grid) {
        super(grid);
    }

    /**
     * Sets input to source, unless input <em>is</em> source, in which case it is set to null
     */
    @Override
    public void processConnection(Component source) {
        if (input == source)
            setInput(null);
        else
            setInput(source);
    }

    protected boolean evalInput() {
        return input != null && input.eval();
    }

    @Override
    protected void setInputInternal(int input, Component component) {
        if (input == 0)
            this.input = component;
    }

    private void setInput(Component component) {
        setInput(0, component);
    }

    @Override
    public void removeInput(Component component) {
        if (input == component)
            setInput(null);
    }

    @Nullable
    @Override
    public Component getInput(int input) {
        if (input == 0)
            return this.input;
        else
            return null;
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
    public String getAdditionalStorageData() {
        if (input != null) {
            return " " + input.getPoint().x + " " + input.getPoint().y;
        }
        return " ";
    }

    @Override
    public void loadAdditionalStorageData(Scanner scanner) {
        if (scanner.hasNextInt()) {
            Component component = grid.getTile(new GridPoint(scanner.nextInt(), scanner.nextInt()));
            setInput(component);
        }
    }

    public List<Component> getInputs() {
        if (input != null)
            return Collections.singletonList(input);
        else
            return Collections.emptyList();
    }

    /**
     * Returns the point local to grid partition of the input that the wire should be
     * routed to.
     */
    public LocalPoint getInputPosFor(Component component) {
        return convertToGridSpace(new LocalPoint((int) ((35.0 / 150) * grid.tileLength), getRect().centerY()));
    }
}
