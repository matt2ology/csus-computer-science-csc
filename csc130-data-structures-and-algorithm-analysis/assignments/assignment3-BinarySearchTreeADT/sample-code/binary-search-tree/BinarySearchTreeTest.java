/**
 * BinarySearchTreeTest
 */
public class BinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* create root */
        tree.add(10);
        tree.add(43);
        tree.add(18);
        tree.add(6);
        tree.add(50);
        tree.add(8);
        System.out.println();
        System.out.println();
        System.out.print("Preorder traversal of binary tree is : ");
        tree.printPreOrder();
        System.out.println();
        System.out.println();
        System.out.println("Binary tree printed ");
        tree.printTree();
    }
}