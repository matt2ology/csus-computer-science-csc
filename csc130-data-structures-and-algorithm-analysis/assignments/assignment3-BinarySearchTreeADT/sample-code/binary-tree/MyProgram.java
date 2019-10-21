class MyProgram {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // ====================== First example
        System.out.println("The following shows the tree structure printed by printTree().");
        tree.root = new Node(4, new Node(7, new Node(11), new Node(14)),
                new Node(54, new Node(76), new Node(33, new Node(18, new Node(4), null), new Node(5))));

        tree.printTree();

        // ====================== Second example
        System.out.println("\nInfix is quite useful if the tree is an expression.");

        tree.root = new Node("*", new Node("+", new Node(11), new Node(14)),
                new Node("/", new Node(76), new Node("^", new Node(18), new Node(5))));

        tree.printTree();
        System.out.println(); // Blank line
        tree.printValues();
    }
}