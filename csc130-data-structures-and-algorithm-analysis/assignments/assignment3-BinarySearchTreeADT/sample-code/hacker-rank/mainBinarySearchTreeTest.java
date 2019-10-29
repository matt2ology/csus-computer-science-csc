/**
 * mainBinarySearchTreeTest
 */
public class mainBinarySearchTreeTest {

    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        /* create root */
        tree.add(10); // Why doesn't this work?
        tree.add(43); // Why doesn't this work?
        tree.add(18); // Why doesn't this work?
        tree.add(6); // Why doesn't this work?
        tree.add(50); // Why doesn't this work?
        tree.add(8); // Why doesn't this work?
       
        /* tree.root = new Node(4, new Node(7, new Node(11), new Node(14)),
                new Node(54, new Node(76), new Node(33, new Node(18, new Node(4), null), new Node(5))));
  */
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