/*=============================================================================
AUTHOR: Matthew Mendoza
CSc 020: Programming Concepts and Methodology II - Spring 2018
LAB ASSIGNMENT #: Assignment_Name
LAST EDIT DATE: ##/##/####
=============================================================================*/
/**
 * An enumeration of abbreviated days to represent Sunday, Monday, Tuesday,
 * Wednesday, Thursday, and Friday.
 */
public class mainCalTest {
    public static void main(String args[]) {
        JulianDate JD = new JulianDate();
        CurrentMonth CM = new CurrentMonth();
        CurrentYear CY = new CurrentYear();
        int date = JD.toJulian(CY.evaluate(), CM.evaluate(), 1);
        int dayOfWeek = ((date + 1) % 7); // 0 means Sunday, 1 means Monday, etc.
        CalFormat cf = new CalFormat();

        System.out.printf("\nYear: %d", CY.evaluate());
        System.out.printf("\nMonth: %d", CM.evaluate());

    }// END OF main METHOD
}// END OF mainCalTest CLASS
