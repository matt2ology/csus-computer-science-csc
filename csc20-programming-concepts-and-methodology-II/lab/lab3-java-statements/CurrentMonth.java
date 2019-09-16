/*=============================================================================
AUTHOR: Matthew Mendoza
CSc 020: Programming Concepts and Methodology II - Spring 2018
LAB ASSIGNMENT #: Assignment_Name
LAST EDIT DATE: ##/##/####
=============================================================================*/
import java.util.Calendar;

public class CurrentMonth extends BaseEvaluation {
    /**
     * Returns system's current month
     */
    int evaluate() {
        return Calendar.getInstance().get(Calendar.MONTH) - 1;
    }// END OF evaluate METHOD
}// END OF CurrentYear CLASS
