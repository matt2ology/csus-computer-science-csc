/**
 * BinarySearchTree
 */
public class BinarySearchTree {
    public Node root;

    public BinarySearchTree() {
        this.root = null;
    }
    public BinarySearchTree(Node root) {
        this.root = root;
    }

    public void add(int value) {
        if (root.contain){
            this.root = new Node(value);
        }
    }

    /**
     * Starts recursion from the root node.
     */
    public void printPreOrder() {
        this.root.printPreOrder();
    }

    /**
     * Starts recursion from the root node.
     */
    public void printTree() {
        this.root.printTree(0);
    }
}