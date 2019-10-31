/*=============================================================================
AUTHOR: Matthew Mendoza
CSC 130: Data Structures and Algorithm Analysis - Fall 2019
Assignment #3 – Binary Search Tree ADT
=============================================================================*/
/*
 * Create a Binary tree by hand of structure
 *          (ROOT)
 *            10
 *        /       \
 *       6         43
 *         \      /  \
 *          8    18    50
 * *****************************
 * ||-- 1
 *   ||-- 6
 *     ||-- 8
 *   ||-- 43
 *     ||-- 18
 *     ||-- 50
 */
public class mainBasicBinaryTreeTest {
    public static void main(String args[]) {

        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10);
        tree.add(43);
        tree.add(18);
        tree.add(6);
        tree.add(50);
        tree.add(8);
        tree.printInorder();
        tree.printPostorder();
        tree.printPreOrder();
        System.out.println();
        tree.printTree();
        System.out.println();
        int[] numberTestArray = { 10, 43, 18, 6, 50, 8, 4, 48, 1, 99, 555, 9000, 9001 };
        for (int numbers : numberTestArray) {
            System.out.println("Tree contains " + numbers + " : " + tree.contains(numbers));
        }
        tree.clear();

        System.out.println("\nGROWING SECOND BINARY TREE\n");
        int[] numberArray = { 5, 12, 1, 3, 42, 7, 9, 26, 74 };
        for (int numbers : numberArray) {
            System.out.println("Number : " + numbers + " is added to second tree.");
            tree.add(numbers);
        }
        tree.printTree();
        System.out.println("Clearing second tree.");
        tree.clear();
        tree.printTree();

    } // END OF main METHOD
}
