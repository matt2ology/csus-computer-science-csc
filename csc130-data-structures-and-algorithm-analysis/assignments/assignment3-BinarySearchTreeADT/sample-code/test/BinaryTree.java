/**
 * Basic Binary tree class, makes use of another class named Node.
 * 
 * @author miles
 *
 */
  public class BinaryTree {
	Node root;                             //Root node.
	
	/**
	 * Method returns information about author.
	 */
	
	public String about() {
	  return "CSUS student Miles Christensen: novice programmer. =)";
	}
	
    public BinaryTree() {                  //Empty constructor.
	  root = null;
    }
  
    /**
     * Constructor with root node.
     * 
     * @param root
     */
  
    public BinaryTree(Node root) {
	  this.root = new Node(root);
    }
    
    public void printValues() {          //Recur from Root.
      root.printValues();
    }
    
    public void printTree() {
      root.printTree(1);
    }

}//End BinaryTree class.
