/**
 * SubHunterRFActivity
 * 
 * @author Daryl Posnett, Ph.D.
 */
public class SubHunterRFActivity extends Activity {
    SubHunterGame game;

    protected void onCreate(Bundle savedInstanceStatus) {
        // ... Setup game.
    }

    /**
     * @author Daryl Posnett, Ph.D.
     * @param motionEvent
     * @return
     */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if ((motionEvent.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {
            game.takeShot(motionEvent.getX(), motionEvent.getY());
        }
        return true;
    }

}