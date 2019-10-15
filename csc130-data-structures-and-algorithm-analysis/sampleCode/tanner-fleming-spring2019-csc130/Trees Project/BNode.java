/*
      Tanner Fleming & Justin Roldan
      Project 3 - working with Trees
      
      
*/
public class BNode<AnyType> {

   BinarySearchTree bst = new BinarySearchTree();
   AnyType element;
   int height;
   BNode<AnyType> left;
   BNode<AnyType> right;

   BNode(AnyType theElement) {
      this(theElement, null, null);
   }

   BNode(AnyType theElement, BNode<AnyType> left, BNode<AnyType> right) {
      element = theElement;
      left = left;
      right = right;
   }

   public AnyType getData() {
      return element;
   }

   public BNode<AnyType> getLeft() {
      return left;
   }

   public BNode<AnyType> getRight() {
      return right;
   }

   public int getNodeHeight() {
      return height;
   }

   public void setHeight(int h) {
      h = bst.getBSTHeight();
      height = h;
   }

   public void setLeft(BNode<AnyType> x) {
      left = x;
   }

   public void setRight(BNode<AnyType> x) {
      right = x;
   }

}