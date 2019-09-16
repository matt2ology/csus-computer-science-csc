/*=============================================================================
AUTHOR: Matthew Mendoza
CSC 130: Data Structures and Algorithm Analysis - Fall 2019
Assignment #: Assignment_Name
=============================================================================*/

public class mainEvaluatorTest {
    public static void main(String args[]) {

        Evaluator input = new Evaluator();

        /*
         * // Test 1 System.out.printf("// Test 1 - Expecting Result : 42.0\n");
         * input.enqueue("9"); input.enqueue("7"); input.enqueue("-");
         * input.enqueue("21"); input.enqueue("*"); input.evaluate();
         * System.out.printf("// Test 1 Final Result : %s\n\n", input.getQueStack());
         * input.resetQueStack(); // Clear stack
         * 
         * // Test 2 System.out.printf("// Test 2 - Expecting Result : 70.0\n");
         * input.enqueue("5"); input.enqueue("3"); input.enqueue("2");
         * input.enqueue("*"); input.enqueue("8"); input.enqueue("+");
         * input.enqueue("*"); input.evaluate();
         * System.out.printf("// Test 2 Final Result : %s\n\n", input.getQueStack());
         * input.resetQueStack(); // Clear stack
         * 
         * // Test 3 System.out.printf("// Test 3 - Expecting Result : 42.0\n");
         * input.enqueue("5"); input.enqueue("2"); input.enqueue("^");
         * input.enqueue("5"); input.enqueue("5"); input.enqueue("*");
         * input.enqueue("/"); input.enqueue("10"); input.enqueue("+");
         * input.evaluate(); System.out.printf("// Test 3 Final Result : %s\n\n",
         * input.getQueStack()); input.resetQueStack(); // Clear stack
         * 
         * // Test 4 System.out.printf("// Test 4 - Expecting Result : 1.0\n");
         * input.enqueue("9"); input.enqueue("3"); input.enqueue("-");
         * input.enqueue("700"); input.enqueue("-"); input.enqueue("9");
         * input.enqueue("/"); input.enqueue("20"); input.evaluate();
         * System.out.printf("// Test 4 Final Result : %s\n\n", input.getQueStack());
         * input.resetQueStack(); // Clear stack
         * 
         * // Test 5 System.out.printf("// Test 5 - Expecting Result : 42.0\n");
         * input.enqueue("9"); input.enqueue("7"); input.enqueue("-");
         * input.enqueue("21"); input.enqueue("*"); input.evaluate();
         * System.out.printf("// Test 5 Final Result : %s\n\n", input.getQueStack());
         * input.resetQueStack(); // Clear stack
         */
        // Test 3
        System.out.printf("// Test 3 - Expecting Result : 42.0\n");
        input.enqueue("9");
        input.enqueue("1");
        input.enqueue("^");
        input.enqueue("21");
        input.enqueue("*");
        input.evaluate();
        System.out.printf("// Test 3 Final Result : %s\n\n", input.getQueStack());
        input.resetQueStack(); // Clear stack

    } // END OF main METHOD
}