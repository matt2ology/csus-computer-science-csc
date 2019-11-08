/*=============================================================================
AUTHOR: Matthew Mendoza
CSC 130: Data Structures and Algorithm Analysis - Fall 2019
Assignment #3 – Binary Search Tree
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
    public int data; // The value that the node contains.
    // Assign pointers to left and right node.
    public Node left;
    public Node right;
    public boolean test;

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
        this.data = theData;
        this.left = leftChild;
        this.right = rightChild;
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
        if (value < getData()) {
            if (getLeft() == null) {
                setLeft(new Node(value));
            } else {
                getLeft().add(value);
            }
        } else if (value > getData()) {
            if (getRight() == null) {
                setRight(new Node(value));
            } else {
                getRight().add(value);
            }
        }
    }

    /**
     * To implement the remove() method, you will need to find (and remove) the max
     * or minimum node. The algorithm uses the same basic logic as contains(), but
     * takes special actions if the node is found. Search the tree and remove the
     * value if it is found. If it is not found, do nothing.
     * 
     * @param value
     */
    public Node remove(int value) {
        if (value == getData()) {
            if (getLeft() == null && getRight() == null) { // Case for no children
                return null;
            } else if (getLeft() != null && getRight() != null) { // Case for two children
                setData(getRight().findMin());
                setRight(getRight().remove(getData()));
            } else { // Case for one child
                if (getLeft() != null) {
                    return getLeft();
                } else if (getRight() != null) {
                    return getRight();
                }
            }
        } else if (value < getData()) {
            if (getLeft() != null) {
                setLeft(getLeft().remove(value));
            }
        } else if (value > getData()) {
            if (getRight() != null) {
                setRight(getRight().remove(value));
            }
        }
        return this;
    }

    /**
     * 
     * @param value
     * @return Returns True if the specified value is in the tree
     */
    public boolean contains(int value) {
        if (value == getData()) {
            return true;
        } else if (value < getData()) {
            if (getLeft() != null) {
                setTest(getLeft().contains(value));
            }
        } else if (value > getData()) {
            if (getRight() != null) {
                setTest(getRight().contains(value));
            }
        } else {
            return false;
        }
        return isTest();
    }

    /**
     * Prints the contents of the tree using an Postorder tree traversal. They
     * should be sent to standard out with spaces between each value. Feel free to
     * redirect the stream if you like.
     */
    public void printPostorder() {
        /* first print data of node */
        if (getLeft() != null) {
            /* then recur on left sutree */
            getLeft().printPostorder();
        }
        if (getRight() != null) {
            /* now recur on right subtree */
            getRight().printPostorder();
        }
        System.out.print(getData() + "  ");
    }

    /**
     * Prints the contents of the tree using an Inorder tree traversal. They should
     * be sent to standard out with spaces between each value. Feel free to redirect
     * the stream if you like.
     */
    public void printInorder() {
        /* first print data of node */
        if (getLeft() != null) {
            /* then recur on left sutree */
            getLeft().printInorder();
        }
        System.out.print(getData() + "  ");
        if (getRight() != null) {
            /* now recur on right subtree */
            getRight().printInorder();
        }
    }

    /**
     * Prints the contents of the tree using an infix (preorder) tree traversal.
     * They should be sent to standard out with spaces between each value. Feel free
     * to redirect the stream if you like.
     */
    public void printPreOrder() {
        /* first print data of node */
        System.out.print(getData() + "  ");
        if (getLeft() != null) {
            /* then recur on left sutree */
            getLeft().printPreOrder();
        }
        if (getRight() != null) {
            /* now recur on right subtree */
            getRight().printPreOrder();
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
        for (int spacePadding = 0; spacePadding < indent; spacePadding++) {
            System.out.print("  ");
        }
        System.out.println("||---" + getData()); // Node
        if (getLeft() != null) {
            getLeft().printTree(indent + 1);
        } // Left
        if (getRight() != null) {
            getRight().printTree(indent + 1);
        } // Right
    }

    /**
     * 
     * @return Maximum value in binary tree.
     */
    public int findMax() {
        int maximumValue = getData();
        if (getRight() != null) {
            maximumValue = getRight().findMin();
            return maximumValue;
        }
        return maximumValue;
    }

    /**
     * 
     * @return Minimum value in binary tree.
     */
    public int findMin() {
        int minimumValue = getData();
        if (getLeft() != null) {
            minimumValue = getLeft().findMin();
            return minimumValue;
        }
        return minimumValue;
    }

    /**
     * Removes all the nodes from the tree. It is best to use a recursive postorder.
     * Set left and right to null.
     */
    public void clear(Node root) {
        if (root == null) {
            return;
        } else {
            clear(root.getLeft());
            clear(root.getRight());
            root = null;
        }
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

    /**
     * 
     * @return
     */
    public boolean isTest() {
        return test;
    }

    /**
     * 
     * @param test
     */
    public void setTest(boolean test) {
        this.test = test;
    }
} // END OF Node CLASS
