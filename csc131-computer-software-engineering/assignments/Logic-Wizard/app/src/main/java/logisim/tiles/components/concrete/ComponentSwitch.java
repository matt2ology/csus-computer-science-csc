package logisim.tiles.components.concrete;

import android.graphics.Canvas;

import androidx.annotation.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import logisim.Grid;
import logisim.R;
import logisim.history.UndoProcedure;
import logisim.tiles.components.Component;
import logisim.util.LocalPoint;

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
    public void drawWires(Canvas canvas) {

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
    public void setInputInternal(int input, Component component) {

    }

    /**
     * Returns the point local to grid partition of the input that the wire should be
     * routed to.
     */
    public LocalPoint getInputPosFor(Component component) {
        return null;
    }

}
