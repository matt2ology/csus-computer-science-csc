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
        System.out.println("[TEST LOG] \t Value : " + value + " <=? " + "Data : " + data + "\n");
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
                System.out.println("[TEST LOG] Left Node Crated with : " + value);
            } else {
                left.add(value);
                System.out.println("[TEST LOG] Added Left : " + value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
                System.out.println("[TEST LOG] Right Node Crated with : " + value);
            } else {
                right.add(value);
                System.out.println("[TEST LOG] Added Right : " + value);
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
        System.out.print(this.data + " ");
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
    public static void main(String[] args) {
        Node tree = new Node();
        tree.add(10); // Why doesn't this work?
        tree.add(6); // Why doesn't this work?
        tree.add(8); // Why doesn't this work?
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
        tree.printTree(0);
    }
}