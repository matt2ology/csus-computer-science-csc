/*=============================================================================
AUTHOR: Matthew Mendoza
CSC 130: Data Structures and Algorithm Analysis - Fall 2019
Assignment #2 – Basic Binary Tree
=============================================================================*/
/*
 * Create a Binary tree by hand of structure
 *          (ROOT)
 *            1
 *        /       \
 *       3          5
 *     /   \       /   \
 *   42    26     7     74
 *              /  \
 *             9    12
 * *****************************
 * +-- 1
 *   +--3
 *      +--42
 *      +--26
 *   +--5
 *      +--7
 *        +--9
 *        +--12
 *      +--74 
 */
public class mainBasicBinaryTreeTest {
    public static void main(String args[]) {

        BinaryTree tree = new BinaryTree();

        /* create root */
        tree.root = new Node(1);
        tree.root = new Node(20);
        tree.root.left = new Node(3);
        tree.root.left.left = new Node(42);
        tree.root.left.right = new Node(26);
        tree.root.right = new Node(5);
        tree.root.right.left = new Node(7);
        tree.root.right.left.left = new Node(9);
        tree.root.right.left.right = new Node(12);

        tree.printValues();
        tree.printTree();

    } // END OF main METHOD
}