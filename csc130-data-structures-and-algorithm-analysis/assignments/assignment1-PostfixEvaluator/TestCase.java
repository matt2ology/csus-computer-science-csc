/**
 * Part 3: Testing Once you have finished your code, you need to test it using
 * some real postfix expressions. Make sure to make come up some good test data.
 * Have at least 5 different ones. Hard-code these tests into your program.
 */
public class TestCase {
    Evaluator input = new Evaluator();

    /**
     * test 1 : Produce output 42.0
     * 
     * Postfix Notation : 9 7 - 21 *
     * 
     * Infixed Notation : (9 - 7) * 21
     */
    public void testONE() {
        System.out.printf("[Test 1 - Expecting Result : 42.0]\n");
        input.enqueue("9");
        input.enqueue("7");
        input.enqueue("-");
        input.enqueue("21");
        input.enqueue("*");
        input.evaluate();
        System.out.printf("[Test 1 - Final Result : %s]\n\n", input.getQueStack());
        input.resetQueStack(); // Clear stack
    }

    /**
     * test 2 : Produce output 70.0
     * 
     * Postfix Notation : 5 3 2 * 8 + *
     * 
     * Infixed Notation : 5 * (3 * 2 + 8)
     */
    public void testTWO() {
        System.out.printf("[Test 2 - Expecting Result : 70.0]\n");
        input.enqueue("5");
        input.enqueue("3");
        input.enqueue("2");
        input.enqueue("*");
        input.enqueue("8");
        input.enqueue("+");
        input.enqueue("*");
        input.evaluate();
        System.out.printf("[Test 2 - Final Result : %s]\n\n", input.getQueStack());
        input.resetQueStack(); // Clear stack
    }

    /**
     * test 3 : Produce output 116.0
     * 
     * Postfix Notation : 3 4 * 2 5 + / 3 4 + *
     * 
     * Infixed Notation : 3 * 4 / (2 + 5) * (3 + 4)
     */
    public void testTHREE() {
        System.out.printf("[Test 3 - Expecting Result : 12.0]\n");
        input.enqueue("3");
        input.enqueue("4");
        input.enqueue("*");
        input.enqueue("2");
        input.enqueue("5");
        input.enqueue("+");
        input.enqueue("/");
        input.enqueue("3");
        input.enqueue("4");
        input.enqueue("+");
        input.enqueue("*");
        input.evaluate();
        System.out.printf("[Test 3 - Final Result : %s]\n\n", input.getQueStack());
        input.resetQueStack(); // Clear stack
    }

    /**
     * test 4 : Produce output 116.0
     * 
     * Postfix Notation : 3 53 * 36 + 2 88 4 2 / / * - 3 3 * +
     * 
     * Infixed Notation : 3 * 53 + 36 - 2 * 88 / (4 / 2) + 3 * 3
     */
    public void testFOUR() {
        System.out.printf("[Test 4 - Expecting Result : 116.0]\n");
        input.enqueue("3");
        input.enqueue("53");
        input.enqueue("*");
        input.enqueue("36");
        input.enqueue("+");
        input.enqueue("2");
        input.enqueue("88");
        input.enqueue("4");
        input.enqueue("2");
        input.enqueue("/");
        input.enqueue("/");
        input.enqueue("*");
        input.enqueue("-");
        input.enqueue("3");
        input.enqueue("3");
        input.enqueue("*");
        input.enqueue("+");
        input.evaluate();
        System.out.printf("[Test 4 - Final Result : %s]\n\n", input.getQueStack());
        input.resetQueStack(); // Clear stack
    }

    /**
     * test 5 : Produce output 30.8285714286
     * 
     * Postfix Notation : 9 3 ^ 5 7 * / 10 +
     * 
     * Infixed Notation : 9 ^ 3 / (5 * 7) + 10
     */
    public void testFIVE() {
        System.out.printf("[Test 5 - Expecting Result : 30.8285714286]\n");
        input.enqueue("9");
        input.enqueue("3");
        input.enqueue("^");
        input.enqueue("5");
        input.enqueue("7");
        input.enqueue("*");
        input.enqueue("/");
        input.enqueue("10");
        input.enqueue("+");
        input.evaluate();
        System.out.printf("[Test 5 - Final Result : %s]\n\n", input.getQueStack());
        input.resetQueStack(); // Clear stack
    }

}