package logicwizard.sidebar;

import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Deque;
import java.util.LinkedList;

import logicwizard.AbstractScreenPartition;
import logicwizard.Grid;
import logicwizard.IInteractable;
import logicwizard.R;
import logicwizard.ScreenManager;
import logicwizard.state.StateManager;
import logicwizard.tiles.components.Component;
import logicwizard.tiles.components.concrete.ANDGate;
import logicwizard.tiles.components.concrete.ComponentLED;
import logicwizard.tiles.components.concrete.ComponentSwitch;
import logicwizard.tiles.components.concrete.NOTGate;
import logicwizard.tiles.components.concrete.ORGate;
import logicwizard.util.LocalPoint;
import logicwizard.util.Paints;
import logicwizard.util.ScreenPoint;
import logicwizard.util.Size;
import logicwizard.util.TextDrawUtil;
import logicwizard.util.Util;

public class ComponentSidebar extends AbstractScreenPartition {

    /**
     * The ratio of the sidebar that the button will be inset from the edge of the sidebar.
     */
    private static final double BUTTON_INSET_RATIO = 1.0 / 20;
    /**
     * The exact number of pixels for insets.
     */
    private int insetPx;

    /**
     * A list of all buttons. Uses a Deque type so the end of the list can be queried easily.
     */
    private final Deque<SidebarButton> buttons = new LinkedList<>();

    /**
     * A reference to the last component button added. Used so the next button can be placed
     * below this one.
     */
    private SidebarButton lastComponentButtonAdded;
    /**
     * A reference to the last save slot button added. Used so the next slot button can be added
     * above the current one, and so the height of the save button can be set to match the height
     * of the last slot button.
     */
    private SidebarButton lastSaveSlotButtonAdded;

    public final Grid grid;

    public ComponentSidebar(ScreenPoint origin, Size size, ScreenManager screenManager, StateManager stateManager, Grid grid) {
        super(origin, size, screenManager, stateManager);
        this.grid = grid;
        calculateInsets();
        addButtons();
    }

    /**
     * The name of the partition, for debugging purposes.
     */
    @Override
    public String getName() {
        return "Sidebar";
    }

    private void addButtons() {
        addUndoButton();
        addRedoButton();

        addComponentButton("AND Gate", R.drawable.and_gate, ANDGate.class);
        addComponentButton("OR Gate", R.drawable.or_gate, ORGate.class);
        addComponentButton("NOT Gate", R.drawable.not_gate, NOTGate.class);
        addComponentButton("Switch", R.drawable.switch_off, ComponentSwitch.class);
        addComponentButton("LED", R.drawable.led_on, ComponentLED.class);

        addSaveSlotButton("C");
        addSaveSlotButton("B");
        addSaveSlotButton("A");

        addSaveButton();
    }

    private void addUndoButton() {
        LocalPoint point = new LocalPoint(insetPx, insetPx);
        Size size = new Size(getHalfButtonLength(), getHalfButtonLength());
        lastComponentButtonAdded = new UndoButton(point, size, "Undo", this, stateManager.history);
        buttons.addLast(lastComponentButtonAdded);
    }

    private void addRedoButton() {
        int posX = lastComponentButtonAdded.point.x + lastComponentButtonAdded.size.width + insetPx * 2;
        int posY = insetPx;
        Size size = new Size(getHalfButtonLength(), getHalfButtonLength());
        lastComponentButtonAdded = new RedoButton(new LocalPoint(posX, posY), size, "Redo", this, stateManager.history);
        buttons.addLast(lastComponentButtonAdded);
    }

    /**
     * Adds a new ComponentSidebarButton below the last button added starting from the top of the sidebar.
     */
    private void addComponentButton(String componentName, int Rresource, Class<? extends Component> representation) {
        // Add button below last
        int yPos = insetPx;
        if (lastComponentButtonAdded != null) {
            yPos += lastComponentButtonAdded.point.y + buttons.getLast().size.height;
        }
        int xPos = insetPx;
        // Component buttons are squares.
        int length = getButtonLength();
        lastComponentButtonAdded = new ComponentSidebarButton(new LocalPoint(xPos, yPos), length, componentName, Rresource, this, representation, grid);
        buttons.addLast(lastComponentButtonAdded);
    }

    /**
     * Adds a save slot button above the previous button starting from the bottom of the sidebar.
     */
    private void addSaveSlotButton(String slot) {
        int width = getHalfButtonLength();
        int height = getHalfButtonLength();
        int xPos = insetPx;
        int yPos;
        if (lastSaveSlotButtonAdded == null) {
            yPos = getSize().height - insetPx - height;
        } else {
            yPos = lastSaveSlotButtonAdded.point.y - insetPx - height;
        }
        lastSaveSlotButtonAdded = new SaveSlotButton(new LocalPoint(xPos, yPos), new Size(width, height), slot, this);
        buttons.addLast(lastSaveSlotButtonAdded);

    }

    /**
     * Adds a save button to the right of the save slot buttons spanning the length of the save slot buttons.
     */
    private void addSaveButton() {
        int width = getHalfButtonLength();
        int xPos = getButtonLength() / 2 + insetPx * 2;
        int yPos = lastSaveSlotButtonAdded.point.y;
        int height = screenManager.getDisplaySize().height - yPos - insetPx;
        buttons.addLast(new SaveButton(new LocalPoint(xPos, yPos), new Size(width, height), "Save", this));
    }

    /**
     * Adds a load label above the save slot buttons.
     */
    private void drawLoadLabel() {
        String text = "Load";
        Paint paint = Paints.LABEL_TEXT;
        int xPos = lastSaveSlotButtonAdded.getCenterForPartition().x - TextDrawUtil.getTextWidthPx(text, paint) / 2;
        int yPos = lastSaveSlotButtonAdded.point.y - insetPx;
        canvas.drawText(text, xPos, yPos, paint);
    }

    private int getButtonLength() {
        return getSize().width - (insetPx * 2);
    }

    private int getHalfButtonLength() {
        return getButtonLength() / 2 - insetPx;
    }

    @Override
    public void draw() {
        fillBackground();

        for (SidebarButton button : buttons) {
            button.draw();
            canvas.drawBitmap(button.getImage(), button.point.x, button.point.y, Paints.IMAGE_OPAQUE);
        }

        drawLoadLabel();
    }

    @Override
    public IInteractable getTouchedObject(LocalPoint localPoint) {
        return getButtonPress(localPoint);
    }

    /**
     * Gets the button at the local point relative to the sidebar top-left.
     */
    public SidebarButton getButtonPress(LocalPoint localPoint) {
        for (SidebarButton button : buttons) {
            Rect buttonBounds = Util.getRect(button.point, button.size);

            if (buttonBounds.contains(localPoint.x, localPoint.y))
                return button;
        }
        return null;
    }

    /**
     * Sets {@link ComponentSidebar#insetPx} based on the ratio constant {@link ComponentSidebar#BUTTON_INSET_RATIO}
     */
    private void calculateInsets() {
        insetPx = (int) (getSize().width * BUTTON_INSET_RATIO);
    }

    public void fillBackground() {
        canvas.drawRect(new Rect(0, 0, getSize().width, getSize().height), Paints.SIDEBAR_BACKGROUND_COLOR);
    }

}
