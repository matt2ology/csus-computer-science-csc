/**
 * Node
 */
public class Node {
    protected int data;
    protected Node left, right;

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
     * @param data
     * @param left
     * @param right
     */
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    /**
     * 
     * @param value
     */
    public void add(int value) {
        if (value <= this.data) {
            if (this.left == null) {
                this.left = new Node(value);
            } else {
                this.left.add(value);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(value);
            } else {
                this.add(value);
            }
        }
    }

    public boolean contains(int value) {
        if (value == this.data) {
            return true;
        } else if (value < this.data) {
            if (this.left == null) {
                return false;
            } else {
                return this.left.contains(value);
            }
        } else {
            if (this.right == null) {
                return false;
            } else {
                return this.right.contains(value);
            }
        }
    }

    public void printPreOrder() {
        System.out.print(this.data);
        if (this.left != null) {
            this.left.printPreOrder();
        } else if (this.right != null) {
            this.right.printPreOrder();
        }
    }

    public void printTree(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.print("||---");
        System.out.println(this.data); // Node
        if (this.left != null) {
            this.left.printTree(indent + 1);
        } // Left
        else if (this.right != null) {
            this.right.printTree(indent + 1);
        } // Right
    }
}