
public class MainBinaryTree {
	public static void main(String args[]) {
		BinaryTree bt = new BinaryTree();
		
		/**
		 * Assemble tree identical to requirements.
		 */
		
		bt.root = new Node(1);
		bt.root.left = new Node(3);
		bt.root.left.left = new Node(42);
		bt.root.left.right = new Node(26);
		bt.root.right = new Node(5);
		bt.root.right.left = new Node(7);
		bt.root.right.left.left = new Node(9);
		bt.root.right.left.right = new Node(12);
		bt.root.right.right = new Node(74);
		
		System.out.println();
		System.out.print("Infix Binary Tree: ");
		System.out.println();
		bt.printValues();
		
		System.out.println();
		System.out.println("Print Tree structure: ");
		bt.printTree();
		
	}
}//End Main test.
