import java.util.NoSuchElementException;

/**
 * BinarySearchTree
 */
public class BinarySearchTree {

    private Node root; // null for an empty tree

    public void add(int value) {
        root = root.add(root, value);
    }

    public boolean contains(int value) {
        return root.contains(root, value);
    }

    public void remove(int value) {
        root = root.remove(root, value);
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

    public int getMin() {
        if (root == null) {
            throw new NoSuchElementException();
        }
        return root.getMin(root);
    }

}