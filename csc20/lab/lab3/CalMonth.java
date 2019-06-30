/*=============================================================================
AUTHOR: Matthew Mendoza
CSc 020: Programming Concepts and Methodology II - Spring 2018
LAB ASSIGNMENT #: Assignment_Name
LAST EDIT DATE: ##/##/####
=============================================================================*/
import java.util.Calendar;

public class CalMonth {
    private static final ListOfMonths m0 = ListOfMonths.JANUARY;
    private static final ListOfMonths m1 = ListOfMonths.FEBRUARY;
    private static final ListOfMonths m2 = ListOfMonths.MARCH;
    private static final ListOfMonths m3 = ListOfMonths.APRIL;
    private static final ListOfMonths m4 = ListOfMonths.MAY;
    private static final ListOfMonths m5 = ListOfMonths.JUNE;
    private static final ListOfMonths m6 = ListOfMonths.JULY;
    private static final ListOfMonths m7 = ListOfMonths.AUGUST;
    private static final ListOfMonths m8 = ListOfMonths.SEPTEMBER;
    private static final ListOfMonths m9 = ListOfMonths.OCTOBER;
    private static final ListOfMonths m10 = ListOfMonths.NOVEMBER;
    private static final ListOfMonths m11 = ListOfMonths.DECEMBER;

    /**
     * COMMENTS DESCRIBING WHAT THE METHOD/CONSTRUCTOR DOES
     */
    public CalMonth() {

        /* InsertCodeHere */

    }// END OF CalMonth CONSTRUCTOR

    public ListOfMonths getJanuary() {
        return m0;
    }// END OF getJanuary METHOD

    public ListOfMonths getFebruary() {
        return m1;
    }// END OF getFebruary METHOD

    public ListOfMonths getMarch() {
        return m2;
    }// END OF getMarch METHOD

    public ListOfMonths getApril() {
        return m3;
    }// END OF getApril METHOD

    public ListOfMonths getMay() {
        return m4;
    }// END OF getMay METHOD

    public ListOfMonths getJune() {
        return m5;
    }// END OF getJune METHOD

    public ListOfMonths getJuly() {
        return m6;
    }// END OF getJuly METHOD

    public ListOfMonths getAugust() {
        return m7;
    }// END OF getAugust METHOD

    public ListOfMonths getSeptember() {
        return m8;
    }// END OF getSeptember METHOD

    public ListOfMonths getOctober() {
        return m9;
    }// END OF getOctober METHOD

    public ListOfMonths getNovember() {
        return m10;
    }// END OF getNovember METHOD

    public ListOfMonths getDecember() {
        return m11;
    }// END OF getDecember METHOD

    public void callMonth(int monthEnted) {
        switch (iterator) {
        case 0:

            break;
        case 1:

            break;
        case 2:

            break;
        case 3:

            break;
        case 4:

            break;
        case 5:

            break;
        case 6:

            break;
        case 7:

            break;
        case 8:

            break;
        case 9:

            break;
        case 10:

            break;
        case 11:

            break;
        default:
            System.out.printf("\nError in callMonth");
            break;
        }
    }
}// END OF CalMonth CLASS
