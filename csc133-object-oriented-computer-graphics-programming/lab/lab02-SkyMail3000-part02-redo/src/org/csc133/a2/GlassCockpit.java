package org.csc133.a2;

import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 * <h1><code>GlassCockpit</code></h1> Manages all of the components in its view
 * including their construction and initialization.
 */
public class GlassCockpit extends Container {
    Image[] digitImages = new Image[10];
    Image[] tenthImages = new Image[10];
    Image colonImage;
    private int ledColorClock, ledColorFuel, ledColorLife, ledColorLast, ledColorDamage, ledColorHeading;
    private Label clockValueLabel;
    private Label fuelLevelValueLabel;
    private Label damageLevelValueLabel;
    private Label lifeValueLabel;
    private Label lastSkyScraperReachedValueLabel;
    private Label headingValueLabel;

    public GlassCockpit() {
        try {
            // Create instances for each LED number
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

            tenthImages[0] = Image.createImage("/LED_digit_0_with_dot.png");
            tenthImages[1] = Image.createImage("/LED_digit_1_with_dot.png");
            tenthImages[2] = Image.createImage("/LED_digit_2_with_dot.png");
            tenthImages[3] = Image.createImage("/LED_digit_3_with_dot.png");
            tenthImages[4] = Image.createImage("/LED_digit_4_with_dot.png");
            tenthImages[5] = Image.createImage("/LED_digit_5_with_dot.png");
            tenthImages[6] = Image.createImage("/LED_digit_6_with_dot.png");
            tenthImages[7] = Image.createImage("/LED_digit_7_with_dot.png");
            tenthImages[8] = Image.createImage("/LED_digit_8_with_dot.png");
            tenthImages[9] = Image.createImage("/LED_digit_9_with_dot.png");

            colonImage = Image.createImage("/LED_colon.png");
            setLayout();
            setClockLabel();
            setFuelLevelValueLabel();
            setDamageLevelValueLabel();
            setLifeValueLabel();
            setLastSkyScraperReachedValueLabel();
            setHeadingValueLabel();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }// end constructor

    public void setLayout() {
        setLayout(new BoxLayout(BoxLayout.X_AXIS));
    }

    public void setClockLabel() {
        Label clockLabel = new Label("Time:");
        clockLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
        clockValueLabel = new Label("0");
        clockValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
        clockValueLabel.getAllStyles().setPadding(RIGHT, 2);
        add(clockLabel);
        add(clockValueLabel);
    }

    public void setFuelLevelValueLabel() {
        Label fuelLabel = new Label("Fuel");
        fuelLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
        fuelLabel.getAllStyles().setPadding(1, 1, 1, 1);
        fuelLevelValueLabel = new Label("0");
        fuelLevelValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
        fuelLevelValueLabel.getAllStyles().setPadding(RIGHT, 2);
        add(fuelLabel);
        add(fuelLevelValueLabel);
    }

    public void setDamageLevelValueLabel() {
        Label damageLabel = new Label("Damage");
        damageLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
        damageLabel.getAllStyles().setPadding(1, 1, 1, 1);
        damageLevelValueLabel = new Label("0");
        damageLevelValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
        damageLevelValueLabel.getAllStyles().setPadding(RIGHT, 2);
        add(damageLabel);
        add(damageLevelValueLabel);
    }
    public void setLifeValueLabel() {
        Label lifeLabel = new Label("Lives");
        lifeLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
        lifeLabel.getAllStyles().setPadding(1, 1, 1, 1);
        lifeValueLabel = new Label("0");
        lifeValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
        lifeValueLabel.getAllStyles().setPadding(RIGHT, 2);
        add(lifeLabel);
        add(lifeValueLabel);
    }

    public void setLastSkyScraperReachedValueLabel() {
        Label lastSkyScraperLabel = new Label("Last");
        lastSkyScraperLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
        lastSkyScraperLabel.getAllStyles().setPadding(1, 1, 1, 1);
        lastSkyScraperReachedValueLabel = new Label("0");
        lastSkyScraperReachedValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
        lastSkyScraperReachedValueLabel.getAllStyles().setPadding(RIGHT, 2);
        add(lastSkyScraperLabel);
        add(lastSkyScraperReachedValueLabel);
    }
    public void setHeadingValueLabel() {
        Label headingLabel = new Label("Heading");
        headingLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
        headingLabel.getAllStyles().setPadding(1, 1, 1, 1);
        headingValueLabel = new Label("0");
        headingValueLabel.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
        headingValueLabel.getAllStyles().setPadding(RIGHT, 2);
        add(headingLabel);
        add(headingValueLabel);
    }
}// end class