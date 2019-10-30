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
        this.root.add(value);
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

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();
        tree.add(10); // Why doesn't this work?
        tree.add(6);  // Why doesn't this work?
        tree.add(8);  // Why doesn't this work?
        tree.add(15); // Why doesn't this work?
        tree.add(43); // Why doesn't this work?
        tree.add(18); // Why doesn't this work?
        tree.add(50); // Why doesn't this work?
        System.out.println();
        System.out.println();
        System.out.print("Preorder traversal of binary tree is : ");
        tree.printPreOrder();
        System.out.println();
        System.out.println();
        System.out.println("Binary tree printed ");
        tree.printTree();
    }
}