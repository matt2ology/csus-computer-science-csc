// Java program for different tree traversals 

class BinaryTree {
    // Root of Binary Tree
    Node root;

    BinaryTree() {
        root = null;
    }

    // Wrappers over above recursive functions
    void printPostorder() {
        root.printPostorder();
    }

    void printInorder() {
        root.printInorder();
    }

    void printPreorder() {
        root.printPreorder();
    }
}