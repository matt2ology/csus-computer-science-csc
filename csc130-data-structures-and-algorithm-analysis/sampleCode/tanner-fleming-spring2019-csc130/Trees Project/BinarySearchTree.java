/*
      Tanner Fleming & Justin Roldan
      Project 3 - working with Trees
      
      
*/

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>> {

   public BNode<AnyType> root;

   public BinarySearchTree() {
      root = null;
   }

   public boolean contains(AnyType x, BNode<AnyType> t) {
      if (t == null)
         return false;
      int compareResult = x.compareTo(t.element);

      if (compareResult < 0) {
         return contains(x, t.left);
      } else if (compareResult > 0) {
         return contains(x, t.right);
      } else {
         return true;
      }
   }

   // Taken from slides, will be used later in a public format for the AVL Trees
   protected BNode<AnyType> insert(AnyType x, BNode<AnyType> t) {
      if (t == null) {
         return new BNode<>(x, null, null);
      }

      int compareResult = x.compareTo(t.element);

      if (compareResult < 0) {
         t.left = insert(x, t.left);
      } else if (compareResult > 0) {
         t.right = insert(x, t.right);
      } else {
         return t;
      }
      return t;
   }

   // same as above - will make public and just call this later for AVL trees
   protected BNode<AnyType> remove(AnyType x, BNode<AnyType> t) {
      if (t == null)
         return t;
      int compareResult = x.compareTo(t.element);
      if (compareResult < 0) {
         t.left = remove(x, t.left);
      } else if (compareResult > 0) {
         t.right = remove(x, t.right);
      } else if (t.left != null && t.right != null) {
         t.element = findMin(t.right).element;
         t.right = remove(t.element, t.right);
      } else {
         t = (t.left != null) ? t.left : t.right;
      }

      return t;
   }

   public BNode<AnyType> findMin(BNode<AnyType> t) {
      if (t == null) {
         return null;
      } else if (t.left == null) {
         return t;
      } else {
         return findMin(t.left);
      }
   }

   public BNode<AnyType> findMax(BNode<AnyType> t) {
      if (t != null) {
         while (t.right != null) {
            t = t.right;
         }
      }
      return t;
   }

   /*
    * These next few methods will be called later in AVL Trees to reuse code via
    * inheritance
    */

   public BNode<AnyType> remove(AnyType x) {
      root = remove(x, root);
      return root;
   }

   public BNode<AnyType> remove(BNode<AnyType> e) {
      remove(e.getData());
      return e;
   }

   public BNode<AnyType> insert(AnyType x) {
      root = insert(x, root);
      return root;
   }

   public int getBSTHeight(BNode<AnyType> t) {
      if (t == null) {
         return -1;
      } else {
         int height = Math.max(getBSTHeight(t.left), getBSTHeight(t.right)) + 1;
         return height;
      }
   }

   public int getBSTHeight() {
      return getBSTHeight(root);
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
      if (root == null)
         return;

      if (treeLevel == 1) {
         System.out.print(root.element + " ");
      } else if (treeLevel > 1) {
         printTrees(root.left, treeLevel - 1);
         printTrees(root.right, treeLevel - 1);
      }
   }

}
