/**
 * Node
 */
public class Node {
    public int data; // data stored at this node
    public Node left; // reference to left subtree
    public Node right; // reference to right subtree

    // Constructs a leaf node with the given data.
    public Node(int data) {
        this(data, null, null);
    }

    // Constructs a branch node with the given data and links.
    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void printPreOrder() {
        System.out.print(this.data + " ");
        if (this.left != null) {
            this.left.printPreOrder();
        } else if (this.right != null) {
            this.right.printPreOrder();
        }
    }

    public Node add(Node node, int value) {
        if (node == null) {
            node = new Node(value);
        } else if (value < node.data) {
            node.left = add(node.left, value);
        } else if (value > node.data) {
            node.right = add(node.right, value);
        } // else a duplicate

        return node;
    }

    public boolean contains(Node root, int value) {
        if (root == null) {
            return false;
        } else if (root.data == value) {
            return true;
        } else if (root.data > value) {
            return contains(root.left, value);
        } else { // root.data < value
            return contains(root.right, value);
        }
    }

    public Node remove(Node root, int value) {
        if (root == null) {
            return null;
        } else if (root.data > value) {
            root.left = remove(root.left, value);
        } else if (root.data < value) {
            root.right = remove(root.right, value);
        } else { // root.data == value; remove this node
            if (root.right == null) {
                return root.left; // no R child; replace w/ L
            } else if (root.left == null) {
                return root.right; // no L child; replace w/ R
            } else {
                // both children; replace w/ min from R
                root.data = getMin(root.right);
                root.right = remove(root.right, root.data);
            }
        }
        return root;
    }

    public int getMin(Node root) {
        if (root.left == null) {
            return root.data;
        } else {
            return getMin(root.left);
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