/*
 * Author: Pawan Chandra & Pawan Khatri
 * Date: June 11, 2018
 */

public class AvlTree<AnyType extends Comparable <? super AnyType>> extends BinarySearchTree<AnyType> {

    public AvlTree (){
        root=null;
    }

    public BinaryNode<AnyType> getRoot(){
        return root;
    }

    protected BinaryNode<AnyType> insert(AnyType data, BinaryNode<AnyType> node){
        return balance(super.insert(data, node));

    }
    protected BinaryNode<AnyType> remove(AnyType data, BinaryNode<AnyType> node){
        return balance(super.remove(data, node));
    }

    public BinaryNode<AnyType> insert(AnyType x){
        root = insert(x, root);
        return root;
    }

    public BinaryNode<AnyType> remove(AnyType x){
        root = remove(x, root);
        return root;
    }

    //Information taken from slide
    private BinaryNode<AnyType> balance(BinaryNode<AnyType> node) {
        if (height(node.getLeft()) - height(node.getRight()) > 1) {
            if (height(node.getLeft().getLeft())
                    >= height(node.getLeft().getRight())) {
                node = singleRightRotation(node);    //Case 1
            } else {
                node = doubleLeftRightRotation(node);  //Case 2
            }
        } else if (height(node.getRight()) - height(node.getLeft()) > 1) {
            if (height(node.getRight().getRight())
                    >= height(node.getRight().getLeft())) {
                node = singleLeftRotation(node);  //Case 3
            } else {
                node = doubleRightLeftRotation(node);  //Case 4
            }
        }
        return node;
    }

  //Information taken from slide
    private  BinaryNode singleRightRotation(BinaryNode k2){
        BinaryNode  k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setHeight(Math.max(height(k2.getLeft()),  height(k2.getRight()))  + 1);
        k1.setHeight(Math.max(height(k1.getLeft()),  k2.getHeight()) +1);
        System.out.println("Single Right Rotation ");
        System.out.println(k2.element);
        return k1;
    }

  //Information taken from slide
    private  BinaryNode singleLeftRotation(BinaryNode k1){
        BinaryNode  k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.setHeight(Math.max(height(k1.getLeft()),  height(k1.getRight()))  + 1);
        k2.setHeight(Math.max(height(k2.getRight()),  k1.getHeight()) +1);
        System.out.println("Single Left Rotation: ");
        System.out.println(k1.element);
        return k2;
    }

    private BinaryNode doubleLeftRightRotation(BinaryNode k3){
        k3.setLeft(singleLeftRotation(k3.getLeft()));
        System.out.println("Double Left Rotation ");
        System.out.println(k3.element);
        return singleRightRotation(k3);
    }

    private BinaryNode doubleRightLeftRotation(BinaryNode k1){
        k1.setRight(singleRightRotation(k1.getRight()));
        System.out.println("Double Right Left Rotation ");
        System.out.println(k1.element);
        return singleLeftRotation(k1);
    }



}
