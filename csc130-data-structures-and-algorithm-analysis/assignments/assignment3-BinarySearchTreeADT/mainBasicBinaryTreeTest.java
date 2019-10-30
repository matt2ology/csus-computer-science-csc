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

        int[] numberArray = { 10, 43, 18, 6, 50, 8 };
        for (int numbers : numberArray) {
            tree.add(numbers);
        }

        int[] numberTestArray = { 10, 43, 18, 6, 50, 8, 4, 48, 1, 99, 555, 9000, 9001 };
        for (int numbers : numberTestArray) {
            System.out.println("Tree contains " + numbers + " : " + tree.contains(numbers));
        }
        /* create root */
        tree.printInorder();
        tree.printPostorder();
        tree.printPreOrder();
        System.out.println();
        tree.printTree();

    } // END OF main METHOD
}
