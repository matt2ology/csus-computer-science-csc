package org.csc133.a1;

import com.codename1.charts.util.ColorUtil;

import javafx.scene.input.GestureEvent;

/**
 * <h1>SkyScrapers</h1> are fixed game objects that have an attribute
 * <code>sequenceNumberID</code>. Each SkyScraper is a numbered marker that acts
 * as a waypoint on the flight path; following the flight path is accomplished
 * by moving over the top of SkyScrapers in sequential order.
 * 
 * SkyScrapers are not allowed to change color once they are created. All
 * SkyScrapers should be assigned to locations chosen by you at the time of
 * creation.
 * 
 * <b>Later</b> we will add the ability for helicopters to pick up and deliver
 * mail as they pass over a skyscraper.
 */
public class SkyScraper extends Fixed {

    Random random = new Random();
    // Size of all SkyScrapers can be 10
    private int sequenceNumberID;

    public SkyScraper(int sequenceNumberID) {
        super(ColorUtil.GRAY);
        final int MIN_SIZE = 1;
        final int MAX_SIZE = 10;
        super.setSize(new Random().nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE);
        setSequenceNumberID(sequenceNumberID);
    }

    /**
     * @return Returns the next sequenceNumberID for the SkyScrapers to distinguish
     */
    public int getSequenceNumberID() {
        return sequenceNumberID;
    }

    public void setSequenceNumberID(int sequenceNumberID) {
        this.sequenceNumberID = sequenceNumberID;
    }

}
