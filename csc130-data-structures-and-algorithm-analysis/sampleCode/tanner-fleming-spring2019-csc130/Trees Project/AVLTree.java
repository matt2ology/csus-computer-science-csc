/*
      Tanner Fleming & Justin Roldan
      Project 3 - working with Trees
      
      
*/
public class AVLTree<AnyType extends Comparable <? super AnyType>> extends BinarySearchTree<AnyType> {
   
   public AVLTree() {
      root = null;
   }  
   
   protected BNode<AnyType> insert(AnyType data, BNode<AnyType> node) {
      return balance(super.insert(data, node));
   }
   
   protected BNode<AnyType> remove(AnyType data, BNode<AnyType> node) {
      return balance(super.remove(data,node));
   }  
   
   public BNode<AnyType> insert(AnyType x) {
      root = insert(x, root);
      return root;
   }
   
   public BNode<AnyType> remote(AnyType x) {
      root = remove(x, root);
      return root;
   }   
          
   private BNode<AnyType> balance(BNode<AnyType> node) {
      
      if (getBSTHeight(node.getLeft()) - getBSTHeight(node.getRight()) > 1) {
         if (getBSTHeight(node.getLeft().getLeft()) >= getBSTHeight(node.getLeft().getRight())) {
            node = singleRightRotation(node);     //Case 1: Outside Left-Left rotation
           }
         else {
            node = doubleLeftRightRotation(node); //Case 2: Inside left-right rotation
           }
        } 
      else if (getBSTHeight(node.getRight()) - getBSTHeight(node.getLeft()) > 1) {
            if (getBSTHeight(node.getRight().getRight()) >= getBSTHeight(node.getRight().getLeft())) {
               node = singleLeftRotation(node); //case 4: Outside Right-Right rotation
             } else {
                  node = doubleRightLeftRotation(node);
                 }
               }
            return node;
         }              
         
         //Rotations taken from the slides
         
    private BNode singleRightRotation(BNode k2) {
          BNode k1 = k2.getLeft();
          k2.setLeft(k1.getRight());
          k1.setRight(k2);
          k2.setHeight(Math.max(getBSTHeight(k2.getLeft()), getBSTHeight(k2.getRight())) + 1);
          k1.setHeight(Math.max(getBSTHeight(k1.getLeft()), k2.getNodeHeight()) + 1);
            
          return k1;
     }  
   
 
   private BNode singleLeftRotation(BNode k1) {
         BNode k2 = k1.getRight();
         k1.setRight(k2.getLeft());
         k2.setLeft(k1);
         k1.setHeight(Math.max(getBSTHeight(k1.getLeft()), getBSTHeight(k1.getRight())) + 1); 
         k2.setHeight(Math.max(getBSTHeight(k2.getRight()), k1.getNodeHeight()) + 1);
         
         return k2;
  }
   
   private BNode doubleLeftRightRotation(BNode k3) {
         k3.setLeft(singleLeftRotation(k3.getLeft()));
         return singleRightRotation(k3);
      }
      
   private BNode doubleRightLeftRotation(BNode k1) {
         k1.setRight(singleRightRotation(k1.getRight())); 
         return singleLeftRotation(k1);
      } 
      
   
  public void treeLevels() {
      int level = getBSTHeight(root);
      for (int i = 1; i <= level; i++) {
         System.out.print("Level " + i + ": ");
         printTrees(root, i);
         System.out.println();
        }
     }
     
   public void printTrees(BNode<AnyType> root, int treeLevel) {
      if (root == null) return;
      
      if (treeLevel == 1) {
         System.out.print(root.element + " ");
      } else if (treeLevel > 1) {
         printTrees(root.left, treeLevel - 1);
         printTrees(root.right, treeLevel - 1);
     }
   }          
   
             
 }    
   




