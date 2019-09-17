/*=============================================================================
AUTHOR: Matthew Mendoza
CSC 130: Data Structures and Algorithm Analysis - Fall 2019
Assignment #1 – Postfix Evaluator
=============================================================================*/

public class mainEvaluatorTest {

    public static void main(String args[]) {
        Evaluator input = new Evaluator();
        TestCase runTestCase = new TestCase();
        /* Returns text about you – the author of this class. */
        input.about();
        /* Five hard-coded tests */
        runTestCase.testONE(); // Produce output 42.0
        runTestCase.testTWO(); // Produce output 70.0
        runTestCase.testTHREE();// Produce output 12.0
        runTestCase.testFOUR(); // Produce output 116.0
        runTestCase.testFIVE(); // Produce output 30.8285714286
        //////////////////////////////
        /// Enqueue your own below ///
        //////////////////////////////
        input.enqueue("9");
        input.enqueue("7");
        input.enqueue("-");
        //////////////////////////////
        input.evaluate();
        System.out.printf("Final Result : %s\n\n", input.getQueStack());
        input.resetQueStack(); // Clear stack

    } // END OF main METHOD

}