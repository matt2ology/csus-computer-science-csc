package logisim.sidebar;

import android.graphics.Paint;
import android.graphics.Rect;

import java.util.Deque;
import java.util.LinkedList;

import logisim.AbstractScreenPartition;
import logisim.Grid;
import logisim.IInteractable;
import logisim.state.StateManager;
import logisim.util.LocalPoint;
import logisim.util.Paints;
import logisim.R;
import logisim.ScreenManager;
import logisim.util.ScreenPoint;
import logisim.util.Size;
import logisim.util.TextDrawUtil;
import logisim.util.Util;
import logisim.tiles.components.concrete.ANDGate;
import logisim.tiles.components.Component;
import logisim.tiles.components.concrete.ComponentLED;
import logisim.tiles.components.concrete.ComponentSwitch;
import logisim.tiles.components.concrete.NOTGate;
import logisim.tiles.components.concrete.ORGate;

public class ComponentSidebar extends AbstractScreenPartition {

    private static final double BUTTON_INSET_RATIO = 1.0 / 20;
    private int insetPx;

    private final Deque<SidebarButton> buttons = new LinkedList<>();

    private SidebarButton lastComponentButtonAdded;
    private SidebarButton lastSaveButtonAdded;

    public final Grid grid;

    public ComponentSidebar(ScreenPoint origin, Size size, ScreenManager screenManager, StateManager stateManager, Grid grid) {
        super(origin, size, screenManager, stateManager);
        this.grid = grid;
        calculateInsets();
        addButtons();
    }

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
     * Adds a new button below the last button added starting from the top of the sidebar.
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
     * Adds a save button above the previous button starting from the bottom of the sidebar.
     */
    private void addSaveSlotButton(String slot) {
        int width = getHalfButtonLength();
        int height = getHalfButtonLength();
        int xPos = insetPx;
        int yPos;
        if (lastSaveButtonAdded == null) {
            yPos = getSize().height - insetPx - height;
        } else {
            yPos = lastSaveButtonAdded.point.y - insetPx - height;
        }
        lastSaveButtonAdded = new SaveSlotButton(new LocalPoint(xPos, yPos), new Size(width, height), slot, this);
        buttons.addLast(lastSaveButtonAdded);

    }

    private void addSaveButton() {
        int width = getHalfButtonLength();
        int xPos = getButtonLength() / 2 + insetPx * 2;
        int yPos = lastSaveButtonAdded.point.y;
        int height = screenManager.getDisplaySize().height - yPos - insetPx;
        buttons.addLast(new SaveButton(new LocalPoint(xPos, yPos), new Size(width, height), "Save", this));
    }

    private void drawLoadLabel() {
        String text = "Load";
        Paint paint = Paints.LABEL_TEXT;
        int xPos = lastSaveButtonAdded.getCenterForPartition().x - TextDrawUtil.getTextWidthPx(text, paint) / 2;
        int yPos = lastSaveButtonAdded.point.y - insetPx;
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

    public SidebarButton getButtonPress(LocalPoint localPoint) {
        for (SidebarButton button : buttons) {
            Rect buttonBounds = Util.getRect(button.point, button.size);

            if (buttonBounds.contains(localPoint.x, localPoint.y))
                return button;
        }
        return null;
    }

    private void calculateInsets() {
        insetPx = (int) (getSize().width * BUTTON_INSET_RATIO);
    }

    public void fillBackground() {
        canvas.drawRect(new Rect(0, 0, getSize().width, getSize().height), Paints.SIDEBAR_BACKGROUND_COLOR);
    }

}
