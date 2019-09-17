
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
    private Queue<String> postfixInputQueue = new LinkedList<String>();
    private Stack<Double> queStack = new Stack<>();

    /**
     * COMMENTS DESCRIBING WHAT THE METHOD/CONSTRUCTOR DOES
     */
    public Evaluator() {
    }

    public void resetQueStack() {
        this.queStack.clear();
    }

    public Stack<Double> getQueStack() {
        return queStack;
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
        System.out.printf("Enqueued item : %s", item);
        System.out.println();
        postfixInputQueue.add(item);
    }

    public boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * This method tests to see whether the value of a String is a legal Reverse
     * Polish Notation mathematical operators or not.
     * 
     * @param input is the value to be tested.
     * @return whether the next value is a mathematical operator or not (True or
     *         False).
     */
    public static boolean inputIsOperator(String input) {
        return (input.equals("+") || input.equals("-") || input.equals("*") || input.equals("/") || input.equals("^"));
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
    public void evaluate() {
        while (!postfixInputQueue.isEmpty()) { // while there is data in the input queue
            String strValue = postfixInputQueue.peek();
            // read a token (value or operator) from queue
            if (isInteger(strValue)) { // if it's a value (a double).
                // push value on the stack
                System.out.printf("Push value on the stack : %s ", postfixInputQueue.peek());
                System.out.println("\n");
                queStack.push(Double.valueOf(postfixInputQueue.poll()));
            }

            if (inputIsOperator(strValue)) { // if it's an operator
                /*
                 * Pop two numbers from the stack. Because a stack is First-In-Last-Out the
                 * right operand needs to be assigned first before left to match natural left to
                 * right math.
                 */
                double rightOperand = queStack.pop();
                double leftOperand = queStack.pop();
                System.out.printf("leftOperand : %s \nrightOperand : %s\n", leftOperand, rightOperand);

                // compute the result (using the operator)
                System.out.printf("\tpostfixInputQueue.peek() : %s ", postfixInputQueue.peek());
                System.out.println();
                switch (postfixInputQueue.poll()) {
                // push the result on the stack
                case "+":
                    double result = (leftOperand + rightOperand);
                    queStack.push(leftOperand + rightOperand);
                    System.out.printf("\t%s + %s = %s\n", leftOperand, rightOperand, result);
                    System.out.println();
                    break;
                // push the result on the stack
                case "-":
                    double result2 = (leftOperand - rightOperand);
                    queStack.push(leftOperand - rightOperand);
                    System.out.printf("\t%s - %s = %s\n", leftOperand, rightOperand, result2);
                    System.out.println();
                    break;
                // push the result on the stack
                case "*":
                    double result3 = (leftOperand * rightOperand);
                    queStack.push(leftOperand * rightOperand);
                    System.out.printf("\t%s * %s = %s\n", leftOperand, rightOperand, result3);
                    System.out.println();
                    break;
                // push the result on the stack
                case "/": // Currently no checks for dividing by zero.
                    double result4 = (leftOperand / rightOperand);
                    queStack.push(leftOperand / rightOperand);
                    System.out.printf("\t%s / %s = %s\n", leftOperand, rightOperand, result4);
                    System.out.println();
                    break;
                // push the result on the stack
                case "^":
                    double result5 = (Math.pow(leftOperand, rightOperand));
                    queStack.push(Math.pow(leftOperand, rightOperand));
                    System.out.printf("\t%s ^ %s = %s\n", leftOperand, rightOperand, result5);
                    System.out.println();
                    break;

                default:
                    break;
                }
            }
        }

    }
} // END OF Evaluator CLASS
