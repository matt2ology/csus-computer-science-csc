package com.example.sprint3;

// These are all the classes of other people's
// (Android) code that we use in Sub Hunt
import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.util.Log;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.Display;
import android.widget.ImageView;
import java.util.Random;

/**
 * @author Matthew Mendoza
 */
public class MainActivity extends Activity {
    // These variables can be "seen"
    // throughout the SubHunter class
    int numberHorizontalPixels;
    int numberVerticalPixels;
    int blockSize;
    int gridWidth = 40;
    int gridHeight;
    float horizontalTouched = -100;
    float verticalTouched = -100;
    int horizontalGap;
    int verticalGap;
    boolean debugging = false;

    // Here are all the objects(instances)
    // of classes that we need to do some drawing
    ImageView gameView;
    Bitmap blankBitmap;
    Canvas canvas;
    Paint paint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        // Get the current device's screen resolution
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);

        // Initialize our size based variables based on the screen resolution
        numberHorizontalPixels = size.x;
        numberVerticalPixels = size.y;
        blockSize = numberHorizontalPixels / gridWidth;
        gridHeight = numberVerticalPixels / blockSize;

        // Initialize all the objects ready for drawing
        blankBitmap = Bitmap.createBitmap(numberHorizontalPixels, numberVerticalPixels, Bitmap.Config.ARGB_8888);

        canvas = new Canvas(blankBitmap);
        gameView = new ImageView(this);
        paint = new Paint();

        // Tell Android to set our drawing
        // as the view for this app
        // setContentView(gameView);
        setContentView(R.layout.schematic);

        Log.d("Debugging", "In onCreate");
        draw();
    }

    /*
     * Here we will do all the drawing. The grid lines, the HUD and the touch
     * indicator
     */
    void draw() {
        gameView.setImageBitmap(blankBitmap);

        // Wipe the screen with a white color
        canvas.drawColor(Color.argb(255, 255, 255, 255));

        // Change the paint color to black
        paint.setColor(Color.argb(255, 0, 0, 0));

        // Draw the vertical lines of the grid
        for (int i = 0; i < gridWidth; i++) {
            canvas.drawLine(blockSize * i, 0, blockSize * i, numberVerticalPixels, paint);
        }

        // Draw the horizontal lines of the grid
        for (int i = 0; i < gridHeight; i++) {
            canvas.drawLine(0, blockSize * i, numberHorizontalPixels, blockSize * i, paint);
        }

        // Re-size the text appropriate for the
        // score and distance text
        paint.setTextSize(blockSize * 2);
        paint.setColor(Color.argb(255, 0, 0, 255));

        Log.d("Debugging", "In draw");
        if (debugging) {
            printDebuggingText();
        }
    }

    /*
     * This part of the code will handle detecting that the player has tapped the
     * screen
     */
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        Log.d("Debugging", "In onTouchEvent");
        // Has the player removed their finger from the screen?
        if ((motionEvent.getAction() & MotionEvent.ACTION_MASK) == MotionEvent.ACTION_UP) {

            // Process the player's shot by passing the
            // coordinates of the player's finger to takeShot
            screenTouch(motionEvent.getX(), motionEvent.getY());
        }

        return true;
    }

    /*
     * The code here will execute when the player taps the screen It will calculate
     * distance from the sub' and determine a hit or miss
     */
    void screenTouch(float touchX, float touchY) {
        Log.d("Debugging", "In takeShot");

        // Convert the float screen coordinates
        // into int grid coordinates
        horizontalTouched = (int) touchX / blockSize;
        verticalTouched = (int) touchY / blockSize;

        draw();
    }

    // This code prints the debugging text
    public void printDebuggingText() {
        paint.setTextSize(blockSize);
        canvas.drawText("numberHorizontalPixels = " + numberHorizontalPixels, 50, blockSize * 3, paint);
        canvas.drawText("numberVerticalPixels = " + numberVerticalPixels, 50, blockSize * 4, paint);
        canvas.drawText("blockSize = " + blockSize, 50, blockSize * 5, paint);
        canvas.drawText("gridWidth = " + gridWidth, 50, blockSize * 6, paint);
        canvas.drawText("gridHeight = " + gridHeight, 50, blockSize * 7, paint);
        canvas.drawText("horizontalTouched = " + horizontalTouched, 50, blockSize * 8, paint);
        canvas.drawText("verticalTouched = " + verticalTouched, 50, blockSize * 9, paint);
        canvas.drawText("horizontalGap = " + horizontalGap, 50, blockSize * 10, paint);
        canvas.drawText("verticalGap = " + verticalGap, 50, blockSize * 11, paint);
        canvas.drawText("debugging = " + debugging, 50, blockSize * 14, paint);

    }
}
