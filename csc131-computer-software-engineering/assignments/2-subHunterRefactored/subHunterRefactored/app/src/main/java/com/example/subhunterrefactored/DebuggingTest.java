package com.example.subhunterrefactored;
public abstract class DebuggingTest {
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
        canvas.drawText("subHorizontalPosition = " + subHorizontalPosition, 50, blockSize * 10, paint);
        canvas.drawText("subVerticalPosition = " + subVerticalPosition, 50, blockSize * 11, paint);
        canvas.drawText("hit = " + hit, 50, blockSize * 12, paint);
        canvas.drawText("shotsTaken = " + shotsTaken, 50, blockSize * 13, paint);
        canvas.drawText("debugging = " + debugging, 50, blockSize * 14, paint);

    }
}