package logicwizard;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

import logicwizard.sidebar.ComponentSidebar;
import logicwizard.state.StateManager;
import logicwizard.util.ScreenPoint;
import logicwizard.util.Size;

public class LogicWizard extends Activity {

    /**
     * The width of the sidebar as a ratio of the display's width.
     */
    private static final double SIDEBAR_WIDTH_RATIO = 1.0 / 12;
    /**
     * The actual width of the sidebar in pixels.
     */
    private int sidebar_width;

    /**
     * The number of tiles to put in the grid horizontally.<br>
     * The tiles will resize to fit this many horizontally.<br>
     * Since tiles are squares, this also affects how many tiles fit vertically.
     */
    private static final int GRID_WIDTH_TILES = 12;

    public static final boolean DEBUG_TEXT_ENABLED = false;

    private ScreenManager screenManager;
    private StateManager stateManager;

    /**
     * Base android setup. Called automatically by the operating system.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupScreenManager();
    }

    public void setupScreenManager() {
        ImageView imageView = new ImageView(this);
        setScreenManager(
                new ScreenManager(getWindowManager().getDefaultDisplay(), imageView, this.getApplicationContext()));
        // Handles touches
        setStateManager(new StateManager(screenManager));
        getScreenManager().setStateManager(getStateManager());

        calculateSidebarWidth();

        Grid grid = setupGrid(GRID_WIDTH_TILES);
        addSidebarPartition(grid);
        getScreenManager().draw();

        setContentView(imageView);
    }

    private void calculateSidebarWidth() {
        setSidebar_width((int) (getScreenManager().getDisplaySize().width * SIDEBAR_WIDTH_RATIO));
    }

    private Grid setupGrid(int widthTiles) {
        Size displaySize = getScreenManager().getDisplaySize();
        int gridWidth = displaySize.width - getSidebar_width();
        int startX = sidebar_width;
        ScreenPoint origin = new ScreenPoint(startX, 0);
        Size size = new Size(gridWidth, displaySize.height);

        // Get the length of the tiles to fit the specified number of tiles.
        int tileLengthPx = gridWidth / (widthTiles + 1);
        // How many tiles will fit vertically given the width of the tile. Tiles are
        // squares.
        int heightTiles = size.height / tileLengthPx - 1;

        Grid grid = new Grid(widthTiles, heightTiles, tileLengthPx, screenManager, stateManager, origin, size);
        getScreenManager().addPartition(grid);
        return grid;
    }

    private void addSidebarPartition(Grid grid) {
        ScreenPoint origin = new ScreenPoint(0, 0);
        Size size = new Size(sidebar_width, getScreenManager().getDisplaySize().height);
        getScreenManager().addPartition(new ComponentSidebar(origin, size, screenManager, stateManager, grid));
    }

    /**
     * The touch event is part of the Activity class so it must be dispatched to the
     * screen manager from here.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction() & MotionEvent.ACTION_MASK;
        ScreenPoint point = new ScreenPoint((int) event.getX(), (int) event.getY());
        getScreenManager().handleTouch(point, action);
        return true;
    }

    public int getSidebar_width() {
        return sidebar_width;
    }

    public void setSidebar_width(int sidebar_width) {
        this.sidebar_width = sidebar_width;
    }

    public ScreenManager getScreenManager() {
        return screenManager;
    }

    public void setScreenManager(ScreenManager screenManager) {
        this.screenManager = screenManager;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public void setStateManager(StateManager stateManager) {
        this.stateManager = stateManager;
    }

    public static double getSidebarWidthRatio() {
        return SIDEBAR_WIDTH_RATIO;
    }

    public static int getGridWidthTiles() {
        return GRID_WIDTH_TILES;
    }

    public static boolean isDebugTextEnabled() {
        return DEBUG_TEXT_ENABLED;
    }

}
