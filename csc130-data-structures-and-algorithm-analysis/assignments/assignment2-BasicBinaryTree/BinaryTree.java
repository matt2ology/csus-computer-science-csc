/*=============================================================================
AUTHOR: Matthew Mendoza
CSC 130: Data Structures and Algorithm Analysis - Fall 2019
Assignment #2 – Basic Binary Tree
=============================================================================*/
/**
 * <h1>Overview</h1>While all the major logic will be found in the nodes, we
 * need to have a single, centralized class. The purpose of the BinaryTree class
 * is to start recursion, store some global attributes (for future versions),
 * and much more.
 * 
 * <h2>Interface</h2>The tree class needs to store the root node.
 */
public class BinaryTree {
    private Node root;

    /**
     * Create new empty binary tree
     */
    public BinaryTree() {
        this.setRoot(null);
    }

    /**
     * Create new binary tree with root node
     * @param root Root node
     */
    public BinaryTree(Node root) {
        this.setRoot(root);
    }

    /**
     * @return the root
     */
    public Node getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(Node root) {
        this.root = root;
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
        
    }
} // END OF BinaryTree CLASS
