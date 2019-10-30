/**
 * This Node class will provide left and right links to other nodes, store data
 * in said nodes and define constructors.
 * 
 * @author Miles Christensen
 *
 */
public class Node {
  public Object data; // actual value stored here.
  public Node left;
  public Node right;

  /**
   * If only data is assigned, pointers to left/right will be null(constructor for
   * leaves).
   * 
   * @param data
   */

  public Node(Object data) {
    this(data, null, null);
  }

  /**
   * This constructor will define child nodes.
   * 
   * @param data1
   * @param lChild
   * @param rChild
   */

  public Node(Object data1, Node lChild, Node rChild) {
    data = data1;
    left = lChild;
    right = rChild;
  }

  /**
   * This method will print the values in infix notation.
   */

  public void printValues() {

    if (data == null)
      return; // safe exit.

    System.out.print(data + " "); // Print value in Node.

    if (left != null) { // Recur to left child if not null.
      left.printValues();
    }

    if (right != null) {
      right.printValues(); // Recur to right child if not null.
    }

  }

  /**
   * This method will print the values mimicking a tree structure.
   */
  public void printTree(int indent) {
    for (int i = 0; i < indent; i++) {
      System.out.print(" ");
    }

    System.out.print("+--"); // Helps the tree visual effect.
    System.out.println(data); // Actual value.

    if (left != null) { // Recur to left child if not null.
      left.printTree(indent + 1);
    }

    if (right != null) {
      right.printTree(indent + 1); // Recur to right child if not null.
    }
  }
}// End Node class.
