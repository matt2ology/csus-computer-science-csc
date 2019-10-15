public class Node {
    public Node left;
    public Node right;
    public Object data;

    public Node(Object data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(Object data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void printTree(int indent) {
        String pad = "";

        // === Print current node
        // This is ugly. Other languages, such as C#, have useful string methods for
        // padding.
        for (int n = 0; n < indent; n++) {
            pad += "  "; // 2 spaces
        }

        System.out.println(pad + "+-- " + this.data.toString());

        // == Recursion
        if (this.left != null) {
            this.left.printTree(indent + 1);
        }

        if (this.right != null) {
            this.right.printTree(indent + 1);
        }
    }

    public void printValues() {
        if (this.left != null) {
            this.left.printValues();
        }

        // Infix
        System.out.print(this.data.toString() + ' '); // Just print the data (no newline) and a space

        if (this.right != null) {
            this.right.printValues();
        }
    }
}