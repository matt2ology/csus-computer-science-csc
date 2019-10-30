package logisim;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import logisim.sidebar.ComponentSidebar;
import logisim.state.StateManager;
import logisim.util.ScreenPoint;
import logisim.util.Size;


public class LogiSim extends Activity {

    private static final double SIDEBAR_WIDTH_RATIO = 1.0/12;
    private int sidebar_width;

    private static final int GRID_WIDTH_TILES = 12;

    public static final boolean DEBUG_TEXT_ENABLED = false;

    private ScreenManager screenManager;
    private StateManager stateManager;

    /**
     * Base android setup.
     * 
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupScreenManager();
    }

    public void setupScreenManager() {
        ImageView imageView = new ImageView(this);
        this.screenManager = new ScreenManager(getWindowManager().getDefaultDisplay(), imageView, this.getApplicationContext());
        this.stateManager = new StateManager(screenManager);
        screenManager.setStateManager(this.stateManager);

        calculateSidebarWidth();

        Grid grid = setupGrid(GRID_WIDTH_TILES);
        addSidebarPartition(grid);
        screenManager.draw();

        setContentView(imageView);

    }

    private void calculateSidebarWidth() {
        sidebar_width = (int) (screenManager.getDisplaySize().width * SIDEBAR_WIDTH_RATIO);
    }

    /**
     * 
     * @param widthTiles
     * @return
     */
    private Grid setupGrid(int widthTiles) {
        Size displaySize = screenManager.getDisplaySize();

        int gridWidth = displaySize.width - sidebar_width;
        int startX = sidebar_width;
        ScreenPoint origin = new ScreenPoint(startX, 0);
        Size size = new Size(gridWidth, displaySize.height);

        // Get the length of the tiles to fit the specified number of tiles.
        int tileLengthPx = gridWidth / (widthTiles + 1);
        // How many tiles will fit vertically given the width of the tile. Tiles are squares.
        int heightTiles = size.height / tileLengthPx - 1;

        Grid grid = new Grid(widthTiles, heightTiles, tileLengthPx, screenManager, stateManager, origin, size);
        screenManager.addPartition(grid);
        return grid;
    }

    /**
     * 
     * @param grid
     */
    private void addSidebarPartition(Grid grid) {
        ScreenPoint origin = new ScreenPoint(0, 0);
        Size size = new Size(sidebar_width, screenManager.getDisplaySize().height);
        screenManager.addPartition(new ComponentSidebar(origin, size, screenManager, stateManager, grid));
    }

    /**
     * The touch event is part of the Activity class so it must be dispatched to the
     * screen manager from here.
     * 
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction() & MotionEvent.ACTION_MASK;
        ScreenPoint point = new ScreenPoint((int) event.getX(), (int) event.getY());
        screenManager.handleTouch(point, action);
        return true;
    }

}
