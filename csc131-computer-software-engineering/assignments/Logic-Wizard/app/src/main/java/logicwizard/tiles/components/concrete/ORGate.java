package logicwizard.tiles.components.concrete;


import logicwizard.Grid;
import logicwizard.R;
import logicwizard.tiles.components.CommutativeComponent;

public class ORGate extends CommutativeComponent {

    public ORGate(Grid grid) {
        super(grid);
    }

    @Override
    public String getName() {
        return "OR Gate";
    }

    public boolean eval() {
        boolean state = false;
        for (int i = 0; i < getInputs().size(); i++)
            state = state || evalInput(i);
        return state;
    }

    @Override
    public String getStorageID() {
        return "or";
    }

    @Override
    public int getRresource() {
        return R.drawable.or_gate;
    }
}
