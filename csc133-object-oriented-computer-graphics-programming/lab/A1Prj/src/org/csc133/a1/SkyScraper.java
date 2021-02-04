package org.csc133.a1;

import com.codename1.charts.util.ColorUtil;
import java.text.DecimalFormat;

/**
 * Later we will TODO: Add the ability for helicopters to pick up and deliver
 * mail as they pass over a skyscraper.
 */
/**
 * SkyScrapers are not allowed to change color once they are created. All
 * SkyScrapers should be assigned to locations chosen by you at the time of
 * creation.
 */
public class SkyScraper extends FixedObject {

    /** Size of all SkyScrapers can be 10 */
    private int size;
    /**
     * SkyScrapers are fixed game objects that have an attribute sequenceNumber.
     * Each SkyScraper is a numbered marker that acts as a waypoint on the flight
     * path; following the flight path is accomplished by moving over the top of
     * SkyScrapers in sequential order.
     */
    private int sequenceNumber = 0;

    /**
     * 
     * @param location
     * @param color
     */
    public SkyScraper(int color, int size) {
        super(color, size);
        setSequenceNumber(++sequenceNumber);
    }

    /** Get the size of sky scraper */
    public int getSize() {
        return size;
    }

    /**
     * get the sequence number of this
     * 
     * @return Sequence number of sky scrapper
     */
    public int getSequenceNumber() {
        return sequenceNumber;
    }

    /**
     * Internal method to set the sequence number of a newly created pylon
     * 
     * @param sequenceNumber
     */
    private void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public String toString() {
        // Initialize the string
        String skyScraperDetails = "SkyScraper: ";

        // Decimal percision formatting
        DecimalFormat df = new DecimalFormat();
        df.applyPattern("##.#");

        // Add details to string for...
        // Location
        skyScraperDetails += "loc=" + df
                .format(this.getLocation().getX_position() + "," + df.format(this.getLocation().getY_position()) + " ");
        // Color
        skyScraperDetails += "color=" + this.getColorToString();
        // Size
        skyScraperDetails += "size=" + this.getSize() + " ";
        // Sky Scraper's sequence number
        skyScraperDetails += "seqNum=" + this.getSequenceNumber();
        return skyScraperDetails;
    }

}
