package logicwizard.tiles.components.concrete;

import logicwizard.Grid;
import logicwizard.R;
import logicwizard.tiles.components.UnaryComponent;

public class NOTGate extends UnaryComponent {

    public NOTGate(Grid grid) {
        super(grid);
    }

    @Override
    public String getName() {
        return "NOT Gate";
    }

    @Override
    public boolean eval() {
        return !this.evalInput();
    }

    @Override
    public String getStorageID() {
        return "not";
    }

    @Override
    public int getRresource() {
        return R.drawable.not_gate;
    }
}
