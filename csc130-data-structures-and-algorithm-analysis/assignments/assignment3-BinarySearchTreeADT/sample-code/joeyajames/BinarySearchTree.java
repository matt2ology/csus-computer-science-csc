
public class BinarySearchTree {
    public Node root;
    /**
     * 
     * @param value
     * @return
     */
    public boolean insert(int value) {
        if (root == null) {
            root = new Node(value);
            return true;
        } else
            return root.insert(value);
    }
    /**
     * 
     * @param value
     * @return
     */
    public boolean contains(int value) {
        if (root == null)
            return false;
        else
            return root.contains(value);
    }

    /** */
    public void preorder() {
        if (root != null) {
            System.out.println("Preorder:");
            root.preorder();
        }
    }
    /** */
    public void postorder() {
        if (root != null) {
            System.out.println("Postorder:");
            root.postorder();
        }
    }
    /** */
    public void inorder() {
        if (root != null) {
            System.out.print("Binary Tree Inorder : ");
            root.inorder();
        }
    }

    /**
     * Starts recursion from the root node.
     */
    public void printTree() {
        this.root.printTree(0);
    }
}