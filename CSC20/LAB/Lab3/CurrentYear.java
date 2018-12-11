/*=============================================================================
AUTHOR: Matthew Mendoza
CSc 020: Programming Concepts and Methodology II - Spring 2018
LAB ASSIGNMENT #: Assignment_Name
LAST EDIT DATE: ##/##/####
=============================================================================*/
import java.util.Calendar;

public class CurrentYear extends BaseEvaluation {
    /**
     * Returns system's current year
     */
    int evaluate() {
        return Calendar.getInstance().get(Calendar.YEAR);
    }// END OF evaluate METHOD
}// END OF CurrentYear CLASS
