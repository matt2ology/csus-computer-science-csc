/**
 * mainTest
 */
public class mainTest {

    // some basic test code
    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        int[] numberArray = { 10, 43, 18, 6, 50, 8 };
        for (int numbers : numberArray) {
            tree.insert(numbers);
        }

        int[] numberTestArray = { 10, 43, 18, 6, 50, 8 };
        for (int numbers : numberTestArray) {
            System.out.println("contains " + numbers + " : " + tree.contains(numbers));
        }

        tree.inorder();
        System.out.println();
        // There must be something wrong with my print tree
        //  The program says that all the numbers exist in the Binary Tree
        tree.printTree();
    }

}