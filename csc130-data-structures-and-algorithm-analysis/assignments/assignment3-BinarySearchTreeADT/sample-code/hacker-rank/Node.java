/**
 * Node
 */
public class Node {
    protected int data;
    protected Node left, right;

    public Node() {

    }
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
    public Node(int data, Node leftChild, Node rightChild) {
        this.data = data;
        this.left = leftChild;
        this.right = rightChild;
    }

    /**
     * 
     * @param value
     */
    public void add(int value) {
        System.out.println("[TEST LOG] \t Value : " + value + " <=? " + "Data : " + data + "\n");
        if (value <= getData()) {
            if (getLeft() == null) {
                setLeft(new Node(value));
                System.out.println("[TEST LOG] Left Node Crated with : " + value);
            } else {
                getLeft().add(value);
                System.out.println("[TEST LOG] Added Left : " + value);
            }
        } else {
            if (getRight() == null) {
                setRight(new Node(value));;
                System.out.println("[TEST LOG] Right Node Crated with : " + value);
            } else {
                getRight().add(value);
                System.out.println("[TEST LOG] Added Right : " + value);
            }
        }
    }

    /**
     * 
     * @param value
     * @return
     */
    public boolean contains(int value) {
        boolean test;
        if (value == getData()) {
            return true;
        } else if (value < getData()) {
            if (getLeft() == null) {
                return false;
            } else {
                test = getLeft().contains(value);
            }
        } else {
            if (getRight() == null) {
                return false;
            } else {
                test = getRight().contains(value);
            }
        }
        return test;
    }

    /**
     * 
     */
    public void printPreOrder() {
        System.out.print(getData() + " ");
        if (getLeft() != null) {
            getLeft().printPreOrder();
        } else if (getRight() != null) {
            getRight().printPreOrder();
        }
    }

    public void printTree(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.print("||---");
        System.out.println(getData()); // Node
        if (getLeft() != null) {
            getLeft().printTree(indent + 1);
        } // Left
        else if (getRight() != null) {
            getRight().printTree(indent + 1);
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

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}