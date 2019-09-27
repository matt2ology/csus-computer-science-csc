/**
 * SubHunterGame
 */
public class SubHunterGame {
    static final int numberOfSubs = 4;
    // .... Essential local vars go here including counts and bitmat et al.
    Grid grid;

    public SubHunterGame(Context context, Point size) {
        // canvas set up goes here
        grid = new Grid(size.x, size.y);
        newGame();
    }

    void newGame() {
        // ... reset game and grid.
        for (int i = 0; i < numberOfSubs; i++) {
            grid.spawnNewSub();
        }
        draw();
    }

    void draw() {
        // ... draw grid and any text
    }

    /**
     * @author Daryl Posnett, Ph.D.
     * @param touchX
     * @param touchY
     */
    void takeShot(float touchX, float touchY) {
        distanceFromSub = grid.takeShot(touchX, touchY);
        shotsTaken++;
        if (resetGame) {
            newGame();
        } else if (grid.sunkSubCount() >= numberOfSubs) {
            boom();
        } else {
            draw();
        }
    }

    /**
     * 
     */
    void boom() {
        // ... populate the body of this funciton.
    }

}