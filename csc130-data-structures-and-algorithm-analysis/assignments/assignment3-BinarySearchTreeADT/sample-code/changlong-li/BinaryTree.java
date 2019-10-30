// Notice that the BinaryTree class is technically not needed. All the major logic is in the Node. 
// This is usually the case for recursive structures. This class merely starts recursion
// with default values.

public class BinaryTree
{
    public Node root;

    public String about()
    {
        return "Written by Changlong Li for CSC 130.";
    }
    
    public BinaryTree()
    {
        this.root = null;
    }

    public BinaryTree(Node root)
    {
        this.root = root;
    }
    
    public void add(int data){
        if (this.root == null){
            this.root = new Node(data);
            return;
        }else{
            this.root.addNode(data);
        }
    }
    
    public boolean contains(int data){
        return this.root.contains(data);
    }
    
    public void remove(int data){
        boolean check = contains(data);
        if(check == true){
            this.root = this.root.remove(data);
        }else{
            System.out.println("The value isn't in this tree!");
        }
        
    }

    public void printTree()
    {
        if (this.root != null)
        {
            this.root.printTree(0);   //Start with a zero indent
        }
    }

    public void printValues()
    {
        if (this.root != null)
        {
            this.root.printValues();
        }
    }
}