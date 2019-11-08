package logicwizard.tiles.components.concrete;

import logicwizard.Grid;
import logicwizard.R;
import logicwizard.tiles.components.UnaryComponent;

public class ComponentLED extends UnaryComponent {

    public ComponentLED(Grid grid) {
        super(grid);
    }

    @Override
    public String getName() {
        return "LED";
    }

    @Override
    public boolean eval() {
        return evalInput();
    }

    @Override
    public String getStorageID() {
        return "led";
    }

    @Override
    public int getRresource() {
        return this.eval() ? R.drawable.led_on : R.drawable.led_off;
    }

    @Override
    public boolean hasOutputPin() {
        return false;
    }

}
