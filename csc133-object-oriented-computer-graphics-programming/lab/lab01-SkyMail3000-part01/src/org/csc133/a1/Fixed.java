package org.csc133.a1;

// All fixed game objects are not allowed to change location once they are created.
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
