/*
 * Author: Pawan Chandra & Pawan Khatri
 * Date: June 11, 2018
 */

public class BinaryNode<AnyType>
{
    BinarySearchTree bst = new BinarySearchTree();
    AnyType element;
    int height;
    BinaryNode<AnyType> left;
    BinaryNode<AnyType> right;

    BinaryNode(AnyType theElement)
    {
        this(theElement, null, null);
    }

    BinaryNode (AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt){
        element = theElement;
        left = lt;
        right = rt;
    }

    public AnyType getData(){
        return element;
    }

    public BinaryNode<AnyType> getLeft(){
        return left;
    }

    public BinaryNode<AnyType> getRight(){
        return right;
    }

    public void setHeight(int x){
        x=bst.height();
        height=x;
    }

    public void setLeft(BinaryNode<AnyType> x){
        left=x;
    }

    public void setRight(BinaryNode<AnyType> x){
        right=x;
    }

    public int getHeight(){
        return height;
    }
}
