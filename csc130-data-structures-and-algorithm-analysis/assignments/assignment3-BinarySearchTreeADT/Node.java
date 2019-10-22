/*=============================================================================
AUTHOR: Matthew Mendoza
CSC 130: Data Structures and Algorithm Analysis - Fall 2019
Assignment #2 – Basic Binary Tree
=============================================================================*/
/**
 * <h1>Overview</h1>In recursively defined structures, like trees, all the
 * coding (and complexity) is found in the recursive structure itself. In the
 * case of trees, the node will contain the vast amount of the logic and
 * behavior. The node has changed slightly. In particular, for this assignment,
 * let's use integers rather than the generic Object class. To implement the
 * remove() method, you will need to find (and remove) the max or minimum node.
 * The algorithm uses the same basic logic as contains(), but takes special
 * actions if the node is found. You only need to implement one of the two:
 * removeMax() or removeMin().
 * 
 * <h2>Interface</h2>Create a very basic node class. All this requires is a left
 * and right link (to another node) and a generic data field. It should also
 * have a few constructors. In particular, you need one that will create a node
 * with links to two other nodes.
 * 
 * @author Matthew Mendoza
 */
public class Node {
    protected int data; // The value that the node contains.
    // Assign pointers to left and right node.
    protected Node left;
    protected Node right;

    /**
     * If only data is entered this constructor will assign both left and right
     * child nodes to null.
     * 
     * @param data
     */
    public Node(int data) {
        this(data, null, null);
    }

    /**
     * Constructor that assigns the data, left and right nodes.
     * 
     * @param theData
     * @param leftChild
     * @param rightChild
     */
    public Node(int theData, Node leftChild, Node rightChild) {
        data = theData;
        left = leftChild;
        right = rightChild;
    }

    /**
     * Prints the contents of the tree using an infix (preorder) tree traversal.
     * They should be sent to standard out with spaces between each value. Feel free
     * to redirect the stream if you like.
     */
    public void printValues() {
        if ((Integer) getData() == null)
            return;

        /* first print data of node */
        System.out.print(data + "  ");

        /* then recur on left sutree */
        if (left != null) {
            left.printValues();
        }

        /* now recur on right subtree */
        if (right != null) {
            right.printValues();
        }
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
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.print("||---");
        System.out.println(data); // Node
        if (this.left != null) {
            this.left.printTree(indent + 1);
        } // Left
        else if (right != null) {
            this.right.printTree(indent + 1);
        } // Right
    }

    /**
     * <strong>To add an item to a BST:</strong>
     * <ul>
     * <li>Follow the algorithm for searching, until there is no child
     * <li>Insert at that point
     * <li>So, new node will be added as a leaf
     * <li>(We are assuming no duplicates allowed)
     * </ul>
     * Adds the value to the correct position in the BST. If the value already
     * exists, do nothing. So, basically, you are creating a proper- set of numbers.
     * To insert a value k into a tree, returning true if successful and false if
     * not
     * 
     * <pre>
     * {@code
     * Build a new node for k
     * If tree is empty
     *      add new node as root node, return true.
     * If k == value at root
     *      return false (no duplicates allowed).
     * If k < value at root
     *      If root has no left child
     *          add new node as left child of root, return true 
     *      Else insert k into left subtree of root. 
     * If k > value at root
     *      If root has no right child
     *          add new node as right child of root, return true 
     *      Else insert k into the right subtree of root. 
     * }
     * </pre>
     * <p>
     * 
     * @param value
     * @return
     */
    public void add(int value) {
        if (value <= this.data) {
            if (this.left == null) {
                this.left = new Node(value);
            } else {
                left.add(value);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(value);
            } else {
                this.right.add(value);
            }
        if (value < getData()) {
            this.left = setData(value);
        } else if (value > getData()) {
            this.right = add(value);
        }
    }

    /**
     * 
     * @param value
     * @return Returns True if the specified value is in the tree
     */
    public boolean contains(int value) {
        if (value == getData()) {
            return true;
        }
        return value < getData() ? this.left.contains(value) : this.right.contains(value);
    }

    /**
     * 
     */
    public void findMax() {

    }

    /**
     * Needed to implement remove.
     * 
     * @return
     */
    public Node removeMax() {

    }

    /**
     * 
     */
    public void findMin() {

    }

    /**
     * Needed to implement remove.
     * 
     * @return
     */
    public Node removeMin() {

    }

    /**
     * To implement the remove() method, you will need to find (and remove) the max
     * or minimum node. The algorithm uses the same basic logic as contains(), but
     * takes special actions if the node is found. Search the tree and remove the
     * value if it is found. If it is not found, do nothing.
     * 
     * @param value
     */
    public void remove(int value) {

    }

    /**
     * Removes all the nodes from the tree. It is best to use a recursive postorder.
     * Set left and right to null.
     */
    public void clear() {

    }

    /**
     * @return data
     */
    public int getData() {
        return data;
    }

    /** */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * @return left
     */
    public Node getLeft() {
        return left;
    }

    /** */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * @return right
     */
    public Node getRight() {
        return right;
    }

    /** */
    public void setRight(Node right) {
        this.right = right;
    }
} // END OF Node CLASS
