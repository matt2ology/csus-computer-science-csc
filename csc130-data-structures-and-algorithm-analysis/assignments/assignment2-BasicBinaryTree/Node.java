/*=============================================================================
AUTHOR: Matthew Mendoza
CSC 130: Data Structures and Algorithm Analysis - Fall 2019
Assignment #2 – Basic Binary Tree
=============================================================================*/
/**
 * <h1>Overview</h1>In recursively defined structures, like trees, all the
 * coding (and complexity) is found in the recursive structure itelf. In thecase
 * of trees,the node will contain the vast amount of the logic andbehavior. You
 * are going to create a very, very basic node clwith a nice, well-documented,
 * ad well-written solution. We will build upon later, to crate more advance
 * tree structures.
 * 
 * <h2>Interface</h2>Create a very basic node class. All this requires is a left
 * and right link (to another node) and a generic data field. It should also
 * have a few constructors. In particular, you need one that will create a node
 * with links to two other nodes.
 */
public class Node {
    Object data; // The value that the node contains.
    // Assign pointers to left and right node.
    Node left;
    Node right;

    /**
     * COMMENTS DESCRIBING WHAT THE METHOD/CONSTRUCTOR DOES
     */
    public Node(Object data) {
        this(data, null, null);
    }

    /**
     * Constructor that assigns the data, left and right nodes.
     */
    public Node(Object data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @return the left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public Node getRight() {
        return right;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * @param right the right to set
     */
    public void setRight(Node right) {
        this.right = right;
    }

    /**
     * Prints the contents of the tree using an infix tree traversal. They should be
     * sent to standard out with spaces between each value. Feel free to redirect
     * the stream if you like.
     */
    public void printValues() {
        if (getData() == null)
            return;

        /* first print data of node */
        System.out.print(getData() + " ");

        /* then recur on left sutree */
        getLeft();

        /* now recur on right subtree */
        getRight();
    }

   
    /**
     * Unlike the other print method, this one will print the structure of the tree.
     * One node will be printed per line. You should use prefix tree traversal. Feel
     * free to redirect the stream if you like.
     * 
     * To print the tree, you will use the same recursion logic as printing the
     * values. However, rather than an infix traversal (does he mean Preorder?),
     * this will use prefix. Don't worry, it is not hard. If you wrote the other
     * print method already, this will be easy.
     * 
     * <pre>
     * {@code
     * Method printTree(int indent)
     *      Print spaces for indent
     *      Print Node.data & newline
     *      left.printTree(indent + 1)
     *      right.printTree(indent + 1)
     * End Method 
     * }
     * </pre>
     */
    public void printTree(int indent) {
        /*
            for (int numberOfSpaces = 0; numberOfSpaces <= indent; numberOfSpaces++) {
                System.out.print(" ");
            }
            System.out.println(getData() + "/n");
            left.printTree(indent + 1);
            right.printTree(indent + 1); 
         */
        if (this.data == null)
            return;

        if (indent == 1) {
            System.out.print(root.element + " ");
        } else if (indent > 1) {
            printTrees(root.left, indent + 1);
            printTrees(root.right, indent + 1);
        }
    }
} // END OF Node CLASS
