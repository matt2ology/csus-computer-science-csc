package org.csc133.a1;

public class Fixed extends GameObject {
    private static int sequenceNumberID = 0;

    public Fixed() {
        sequenceNumberID++;
    }

    /**
     * @return Returns the next sequenceNumberID for the SkyScrapers to distinguish
     */
    public int getSequenceNumberID() {
        return sequenceNumberID;
    }
}
