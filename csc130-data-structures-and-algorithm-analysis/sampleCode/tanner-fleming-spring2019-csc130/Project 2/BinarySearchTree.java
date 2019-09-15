/*
 * Author: Pawan Chandra & Pawan Khatri
 * Date: June 11, 2018
 */

public class BinarySearchTree<AnyType extends Comparable<? super AnyType>>{
    
    public BinaryNode<AnyType> root;
    
    public BinarySearchTree (){
       root=null;
    }
  //Information taken from slide
    public boolean contains(AnyType x, BinaryNode<AnyType> t){
        if (t == null) return false;
        int compareResult = x.compareTo (t.element);
        if (compareResult <0) 
            return contains(x, t.left);
        else if (compareResult >0) 
            return contains (x, t.right);
        else 
            return true;
    }

    public BinaryNode<AnyType> insert(AnyType x){
        root = insert(x, root);
        return root;
    }

    public BinaryNode<AnyType> remove(AnyType x){
        root = remove(x, root);
        return root;
    }



    protected BinaryNode<AnyType> insert(AnyType x, BinaryNode<AnyType> t) {
        if (t == null) {
            return new BinaryNode<>(x, null, null);
        }
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0) 
            t.left = insert(x, t.left);
        else if (compareResult > 0) 
            t.right = insert(x, t.right);
        else
        	return t;
        return t;
    }
  //Information taken from slide
    protected BinaryNode<AnyType> remove(AnyType x, BinaryNode<AnyType> t){
        if (t == null) return t;
        int compareResult = x.compareTo(t.element);
        if (compareResult < 0)
            t.left = remove(x, t.left);
        else if (compareResult > 0)
            t.right = remove(x, t.right);
        else if (t.left != null && t.right != null){
            t.element = findMin(t.right).element;
            t.right = remove(t.element,t.right);
        }
        else
            t = (t.left != null) ? t.left :t.right;

        return t;
    }

    public BinaryNode<AnyType> remove(BinaryNode<AnyType> j){
        remove(j.getData());
        return j;
    }

    public BinaryNode<AnyType> findMin (BinaryNode<AnyType> t){
        if (t == null)
            return null;
        else if (t.left == null)
            return t;
        else 
            return findMin(t.left);
    }

    public BinaryNode<AnyType> findMax(BinaryNode<AnyType> t){
        if (t != null){
            while (t.right != null){
                t=t.right;
            }
        }
        return t;
    }

    public BinaryNode<AnyType> getRoot(){
        return root;
    }

    public int height(){
        return height(root);
    }

    public int height(BinaryNode<AnyType> t){
        if (t == null)
            return -1;
        else{
            int totalHeight = Math.max(height(t.left),height(t.right));
            return totalHeight +1;
        }
    }

}