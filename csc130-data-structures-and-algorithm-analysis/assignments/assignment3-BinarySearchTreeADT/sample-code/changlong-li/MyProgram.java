class MyProgram
{
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        
        int[] numberArray = { 10, 43, 18, 6, 50, 8 };
        for (int numbers : numberArray) {
            tree.add(numbers);
        }
        
        int[] numberTestArray = { 10, 43, 18, 6, 50, 8, 4, 48, 1, 99, 555, 9000, 9001 };
        for (int numbers : numberTestArray) {
            System.out.println("Tree contains " + numbers + " : " + tree.contains(numbers));
        }
        System.out.println("The following shows the tree structure printed by printTree().");
        tree.printTree();
        System.out.println("remove node 4 with 0 children");
        tree.remove(4);
        tree.printTree();
        System.out.println("remove node 6 with 1 children");
        tree.remove(6);
        tree.printTree();
        System.out.println("remove node 43 with 2 children");
        tree.remove(43);       
        tree.printTree();
        System.out.println("remove node 100 come from no where");
        tree.remove(100);

    }
}