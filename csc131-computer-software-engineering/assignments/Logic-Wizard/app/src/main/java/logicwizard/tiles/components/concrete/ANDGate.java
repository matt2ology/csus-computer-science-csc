package logicwizard.tiles.components.concrete;


import logicwizard.Grid;
import logicwizard.R;
import logicwizard.tiles.components.CommutativeComponent;
import logicwizard.tiles.components.Component;

public class ANDGate extends CommutativeComponent {

    public ANDGate(Grid grid) {
        super(grid);
    }

    @Override
    public String getName() {
        return "AND Gate";
    }

    public boolean eval() {
        boolean state = true;
        for (int i = 0; i < getInputs().size(); i++)
            state = state && evalInput(i);
        return state;
    }

    @Override
    public String getStorageID() {
        return "and";
    }

    @Override
    public int getRresource() {
        return R.drawable.and_gate;
    }

}
