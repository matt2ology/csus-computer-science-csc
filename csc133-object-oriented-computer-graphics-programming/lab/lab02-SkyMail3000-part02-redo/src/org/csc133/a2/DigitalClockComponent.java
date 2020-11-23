package org.csc133.a2;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Calendar;

import com.codename1.charts.util.ColorUtil;

import javafx.scene.image.Image;

/**
 * DigitalClockComponent
 */
public class DigitalClockComponent extends Component {
    Image[] digitImages = new Image[10];
    Image colonImage;

    private int ledColor;
    private static int HM_COLON_IDX = 2;
    private static int MS_COLON_IDX = 5;
    private static final int numDigitsShowing = 8;
    Image[] clockDigits = new Image[numDigitsShowing];

    public DigitalClockComponent() {
        try {
            digitImages[0] = Image.createImage("/LED_digit_0.png");
            digitImages[1] = Image.createImage("/LED_digit_1.png");
            digitImages[2] = Image.createImage("/LED_digit_2.png");
            digitImages[3] = Image.createImage("/LED_digit_3.png");
            digitImages[4] = Image.createImage("/LED_digit_4.png");
            digitImages[5] = Image.createImage("/LED_digit_5.png");
            digitImages[6] = Image.createImage("/LED_digit_6.png");
            digitImages[7] = Image.createImage("/LED_digit_7.png");
            digitImages[8] = Image.createImage("/LED_digit_8.png");
            digitImages[9] = Image.createImage("/LED_digit_9.png");

            colonImage = Image.createImage("/LED_colon.png");

        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < numDigitsShowing; i++) {
            clockDigits[i] = digitImages[0];
        }
        clockDigits[HM_COLON_IDX] = colonImage;
        clockDigits[MS_COLON_IDX] = colonImage;
        ledColor = ColorUtil.CYAN;
    }

    private void setTime(int hours, int minutes, int seconds) {
        clockDigits[0] = digitImages[hours / 10];
        clockDigits[1] = digitImages[hours % 10];
        clockDigits[3] = digitImages[minutes / 10];
        clockDigits[4] = digitImages[minutes % 10];
        clockDigits[6] = digitImages[seconds / 10];
        clockDigits[7] = digitImages[seconds % 10];
    }

    private void setCurrentTime() {
        Calendar rightNow = Calendar.getInstance();
        int hour = rightNow.get(Calendar.HOUR);
        setTime(hour == 0 ? 12 : hour, rightNow.get(Calendar.MINUTE), rightNow.get(Calendar.SECOND));
    }

    public void setLedColor(int ledColor) {
        this.ledColor = ledColor;

    }

    public void start() {
        getComponentForm().registerAnimated(this);
    }

    public void stop() {
        getComponentForm().deregisterAnimated(this);
    }

    public void laidOut() {
        this.start();
    }

    public boolean animate() {
        setCurrentTime();
        return true;
    }

    protected Dimension calcPreferredSize() {
        return new Dimension(colonImage.getWidth() * numDigitsShowing, colonImage.getHeight());
    }

    public void paint(Graphics g) {
        super.paint(g);
        final int COLOR_PAD = 1;
        int digitWidth = clockDigits[0].getWidth();
        int digitHeight = clockDigits[0].getHeight();
        int clockWidth = numDigitsShowing * digitWidth;

        float scaleFactor = Math.min(getInnerHeight() / (float) digitHeight, getInnerWidth() / (float) clockWidth);

        int displayDigitWidth = (int) (scaleFactor * digitWidth);
        int displayDigitHeight = (int) (scaleFactor * digitHeight);
        int displayClockWidth = displayDigitWidth * numDigitsShowing;

        int displayX = getX() + (getWidth() - displayClockWidth) / 2;
        int displayY = getY() + (getHeight() - displayDigitHeight) / 2;

    }

    public void paint(Graphics g) {
        g.setColor(ColorUtil.BLACK);
        g.fillRect(getX(), getY(), getWidth(), getHeight());

        g.setColor(ledColor);
        g.fillRect(displayX + COLOR_PAD, displayY + COLOR_PAD, displayClockWidth - COLOR_PAD * 2,
                displayDigitHeight - COLOR_PAD * 2);
        for (int digitIndex = 0; digitIndex < numDigitsShowing; digitIndex++) {
            g.drawImage(clockDigits[digitIndex], displayX + digitIndex * displayClockWidth, displayY, displayDigitWidth,
                    displayDigitHeight);
        }
    }

}