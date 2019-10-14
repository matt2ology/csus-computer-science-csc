/*=============================================================================
AUTHOR: Matthew Mendoza
CSC 130: Data Structures and Algorithm Analysis - Fall 2019
Assignment #2 – Basic Binary Tree
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

        /* create root */
        tree.add(10);
        tree.add(43);
        tree.add(18);
        tree.add(6);
        tree.add(50);
        tree.add(8);
        System.out.println();
        System.out.println();
        System.out.print("Preorder traversal of binary tree is : ");
        tree.printValues();
        System.out.println();
        System.out.println();
        System.out.println("Binary tree printed ");
        tree.printTree();

    } // END OF main METHOD
}