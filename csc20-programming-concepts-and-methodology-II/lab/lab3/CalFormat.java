/*=============================================================================
AUTHOR: Matthew Mendoza
CSc 020: Programming Concepts and Methodology II - Spring 2018
LAB ASSIGNMENT #: Assignment_Name
LAST EDIT DATE: ##/##/####
=============================================================================*/
import java.util.Calendar;

public class CalFormat {
    private final String SPACING = "";

    /**
     * COMMENTS DESCRIBING WHAT THE METHOD/CONSTRUCTOR DOES
     */
    public CalFormat() {

        /* InsertCodeHere */

    }// END OF CalFormat CONSTRUCTOR

    /**
     * COMMENTS DESCRIBING WHAT THE WHAT THE METHOD DOES
     */
    public void displayMonth(ListOfMonths monthPar) {
        System.out.printf("\n%s\n", monthPar);
    }// END OF formatMonth METHOD

    /**
     * Displays the weeks from Sunday to Saturday.
     */
    public void displayDaysOfWeek() {
        for (ListOfDays alldays : ListOfDays.values()) {
            System.out.printf("%s%3s", alldays, SPACING);
        }
    }

    public void displayDaysOfMonth(Enum sun, Enum mon, Enum tue, Enum wed, Enum thu, Enum fri, Enum sat) {
        System.out.printf(
                "%s" + "%3s" + "%s" + "%3s" + "%s" + "%3s" + "%s" + "%3s" + "%s" + "%3s" + "%s" + "%3s" + "%s\n", sun,
                SPACING, mon, SPACING, tue, SPACING, wed, SPACING, thu, SPACING, fri, SPACING, sat);
    }// END OF getDayOfWeek METHOD
}// END OF CalFormat CLASS
