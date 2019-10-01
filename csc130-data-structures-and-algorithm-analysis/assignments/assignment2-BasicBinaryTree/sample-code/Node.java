/* Class containing left and right child of current 
   node and data value*/
class Node {
    public Object data;
    public Node left, right;

    public Node(Object theData) {
        data = theData;
        left = right = null;
    }

    /*
     * Given a binary tree, print its nodes according to the "bottom-up" postorder
     * traversal.
     */
    public void printPostorder() {
        if (data == null)
            return;

        // first recur on left subtree
        if (left != null) {
            left.printPostorder();
        }

        // then recur on right subtree
        if (right != null) {
            right.printPostorder();
        }

        // now deal with the node
        System.out.print(data + " ");
    }

    /* Given a binary tree, print its nodes in inorder */
    public void printInorder() {
        if (data == null)
            return;

        /* first recur on left child */
        if (left != null) {
            left.printInorder();
        }

        /* then print the data of node */

        System.out.print(data + " ");

        /* now recur on right child */
        if (right != null) {
            right.printInorder();
        }
    }

    /* Given a binary tree, print its nodes in preorder */
    public void printPreorder() {
        if (data == null)
            return;

        /* first print data of node */
        System.out.print(data + " ");

        /* then recur on left sutree */
        if (left != null) {
            left.printPreorder();
        }

        /* now recur on right subtree */
        if (right != null) {
            right.printPreorder();
        }
    }
}