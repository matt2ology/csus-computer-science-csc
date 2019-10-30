package logisim.tiles.components.concrete;

import android.graphics.Canvas;

import androidx.annotation.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import logisim.Grid;
import logisim.R;
import logisim.tiles.components.Component;
import logisim.tiles.components.UnaryComponent;
import logisim.util.GridPoint;
import logisim.util.LocalPoint;

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
