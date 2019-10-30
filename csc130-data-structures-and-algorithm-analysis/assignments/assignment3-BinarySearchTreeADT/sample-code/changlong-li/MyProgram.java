class MyProgram
{
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        
        System.out.println("The following shows the tree structure printed by printTree().");
        tree.add(10);
        tree.add(43);
        tree.add(18);
        tree.add(6);
        tree.add(50);
        tree.add(8);
        tree.add(4);
        tree.add(48);
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