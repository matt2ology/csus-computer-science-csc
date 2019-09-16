
/*=============================================================================
AUTHOR: Matthew Mendoza
CSC 130: Data Structures and Algorithm Analysis - Fall 2019
Assignment #: Assignment_Name
=============================================================================*/
/*
 * The code that evaluates the input queue must use the stack-based approach we
 * went over in class. Naturally, your solution will contain both a private 
 * queue and a private stack. How you implement these is completely up to 
 * you – but I would strongly recommend using a linked-list.
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Evaluator {
    // Creating private empty priority queue
    private PriorityQueue<String> inputQueue = new PriorityQueue<String>();
    private Stack<Double> stack = new Stack<>();

    /**
     * COMMENTS DESCRIBING WHAT THE METHOD/CONSTRUCTOR DOES
     */
    public Evaluator() {
        about();

    }

    /**
     * @return Returns text about you – the author of this class.
     * @author Matthew Mendoza
     */
    public String about() {
        return String.format("Hello, I'm Matt. \n");
    }

    /**
     * @return Enqueue the item onto the postfix input queue.
     */
    public void enqueue(String item) {

    }

    // ===========================
    // Compute Postfix Pseudo-code
    // ===========================
    // while there is data in the input queue
    // ....read a token (value or operator) from queue
    // ....if it's a value, push it on the stack
    // ....if it's an operator
    // ........pop two numbers from the stack
    // ........compute the result (using the operator)
    // ........push the result on the stack
    // ....end if
    // end while // Afterwards, the final result is on the stack

    /**
     * The code that evaluates the input queue must use the stack-based approach we
     * went over in class. Naturally, your solution will contain both a private
     * queue and a private stack. How you implement these is completely up to you –
     * but I would strongly recommend using a linked-list.
     * 
     * @return Evaluates the values and returns a double result.
     */
    public double evaluate() {
        while (!inputQueue.isEmpty()) { // while there is data in the input queue
            // read a token (value or operator) from queue
            if (condition) { // if it's a value
                // push value on the stack
            }
            if (condition) { // if it's an operator
                // pop two numbers from the stack
                // compute the result (using the operator)
                // push the result on the stack
            }
        }

    }
} // END OF Evaluator CLASS
