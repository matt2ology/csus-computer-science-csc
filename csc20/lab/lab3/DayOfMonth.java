/*=============================================================================
AUTHOR: Matthew Mendoza
CSc 020: Programming Concepts and Methodology II - Spring 2018
LAB ASSIGNMENT #: Assignment_Name
LAST EDIT DATE: ##/##/####
=============================================================================*/
import java.util.Calendar;

public class DayOfMonth {
    JulianDate JD = new JulianDate();
    int date = JD.toJulian(2018, 2, 6);
    CalFormat cf = new CalFormat();
    int dayOfWeek;

    /**
     * COMMENTS DESCRIBING WHAT THE METHOD/CONSTRUCTOR DOES
     */
    public DayOfMonth() {

    }// END OF ReplaceWithClassName CONSTRUCTOR

    /**
     * COMMENTS DESCRIBING WHAT THE WHAT THE METHOD DOES
     */
    private void evaluateDayOfWeek() {

        dayOfWeek = ((date + 1) % 7); // 0 means Sunday, 1 means Monday, etc.

    }// END OF evaluateDayOfWeek METHOD

    /**
     * COMMENTS DESCRIBING WHAT THE WHAT THE METHOD DOES
     */
    public int getDayOfWeek() {

        return dayOfWeek;

    }// END OF getDayOfWeek METHOD

    /**
     * COMMENTS DESCRIBING WHAT THE WHAT THE METHOD DOES
     */
    public void displayDayOfWeek() {
        switch (getDayOfWeek()) {
        case 0:
            ListOfDays d0 = ListOfDays.SU;
            cf.formatDayOfWeek(d0);
            break;
        case 1:
            ListOfDays d1 = ListOfDays.MO;
            cf.formatDayOfWeek(d1);
            break;
        case 2:
            ListOfDays d2 = ListOfDays.TU;
            cf.formatDayOfWeek(d2);
            break;
        case 3:
            ListOfDays d3 = ListOfDays.WE;
            cf.formatDayOfWeek(d3);
            break;
        case 4:
            ListOfDays d4 = ListOfDays.TH;
            cf.formatDayOfWeek(d4);
            break;
        case 5:
            ListOfDays d5 = ListOfDays.FR;
            cf.formatDayOfWeek(d5);
            break;
        case 6:
            ListOfDays d6 = ListOfDays.SA;
            cf.formatDayOfWeek(d6);
            break;
        default:
            System.out.printf("\nERROR IN displayDayOfWeek Switch\n");
            break;
        }// END OF switch STATEMENT
    }// END OF displayDayOfWeek METHOD
}// END OF DayOfMonth CLASS
