/*=============================================================================
AUTHOR: Matthew Mendoza
CSC 130: Data Structures and Algorithm Analysis - Fall 2019
Assignment #3 – Binary Search Tree ADT
=============================================================================*/
/**
 * <h1>Overview</h1>The BinarySearchTree is a tad more sophisticated than the
 * last version. Now, nodes aren't simply linked together and assigned to the 
 * tree's node. In fact, the root must be private. So, the constructor, in the
 * last assignment that assigned the root, must be removed. All values are
 * added to the using the add() method. It will find the correct position in
 * the tree and store it there.
 * 
 * <h2>Interface</h2>Just like before, the BinarySearchTree's methods will 
 * start recursion on the Node class.
 * @author Matthew Mendoza
 */
public class BinarySearchTree {
    // Root of Binary Tree
    private Node root;

    /**
     * Create new empty binary tree
     */
    public BinarySearchTree() {
        root = null;
    }

    /**
     * Returns text about you – the author of this class.
     */
    public String about() {
        return "Hello, I'm Matt and I like milk tea.\n";

    }

    /**
     * Starts recursion from the root node.
     */
    public void printValues() {
        root.printValues();
    }

    /**
     * Starts recursion from the root node.
     */
    public void printTree() {
        root.printTree(1);
    }

    /**
     * Adds the value to the correct position in the BST. If the value
     * already exists, do nothing. So, basically, you are creating a proper-
     * set of numbers.
     * @param value
     */
    public void add(int value){
        root = root.add(value);
    }

    /**
     * 
     * @param value
     * @return Returns True if the specified value is in the tree
     */
    public boolean contains(int value) {
        if (root == value) {
            
        }
    }

    /**
     * 
     */
    public void findMax() {

    }

    /**
     * 
     */
    public void findMin() {
        
    }
    /**
     * To implement the remove() method, you will need to find (and remove) 
     * the max or minimum node. The algorithm uses the same basic logic as
     * contains(), but takes special actions if the node is found. 
     * Search the tree and remove the value if it is found. If it is not found,
     * do nothing.
     * @param value
     */
    public void remove(int value) {
        
    }

    /**
     * Removes all the nodes from the tree. It is best to use a recursive
     * postorder. Set left and right to null.
     */
    public void clear() {
        
    }
} // END OF BinaryTree CLASS
