// Notice that the BinaryTree class is technically not needed. All the major logic is in the Node. 
// This is usually the case for recursive structures. This class merely starts recursion
// with default values.

public class BinaryTree {
    public Node root;

    public String about() {
        return "Written by D. Cook for CSC 130.";
    }

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(Node root) {
        this.root = root;
    }

    public void printTree() {
        if (this.root != null) {
            this.root.printTree(0); // Start with a zero indent
        }
    }

    public void printValues() {
        if (this.root != null) {
            this.root.printValues();
        }
    }
}