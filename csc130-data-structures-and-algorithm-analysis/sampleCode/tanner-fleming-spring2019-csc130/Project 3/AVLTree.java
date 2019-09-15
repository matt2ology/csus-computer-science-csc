public class AVLTree<E extends Comparable<E>> extends BinarySearchTree<E>
{
    public AVLTree()
    {
        overallRoot = null;
        size = 0;
    }

    public void incCount(E data)
    {
        if (overallRoot == null) {
            overallRoot = new BSTNode(data);
        } else {
            // traverse the tree
            BSTNode currentNode = overallRoot;
            while (true) {

                // compare the data to be inserted with the data at the current
                // node
                int cmp = data.compareTo(currentNode.data);

                if (cmp == 0) {
                    // current node is a match
                    currentNode.count++;
                    return;
                } else if (cmp < 0) {
                    // new data goes to the left of the current node
                    if (currentNode.left == null) {
                        currentNode.left = new BSTNode(data);
                        return;
                    }
                    currentNode = currentNode.left;
                } else {
                    // new data goes to the right of the current node
                    if (currentNode.right == null) {
                        currentNode.right = new BSTNode(data);
                        return;
                    }
                    currentNode = currentNode.right;

                }
            }
        }
    }

    private BSTNode balance(BSTNode node) {

        if (height(getLeft(node)) - height(getRight(node)) > 1) {
            if (height(getLeft(getLeft(node)))
                    >= height(getRight(getLeft(node)))) {
                node = singleRightRotation(node);    //Case 1
            } else {
                node = doubleLeftRightRotation(node);  //Case 2
            }
        } else if (height(getRight(node)) - height(getLeft(node)) > 1) {
            if (height(getRight(getRight(node)))
                    >= height(getLeft(getRight(node)))) {
                node = singleLeftRotation(node);  //Case 3
            } else {
                node = doubleRightLeftRotation(node);  //Case 4
            }
        }
        return node;
    }

    BSTNode singleRightRotation(BSTNode x)
    {
        if(x == null || x.left == null) return x;
        BSTNode y = x.left;
        x.left = y.right;
        y.right = x;
        x.setHeight();
        y.setHeight();
        return y;
    }

    BSTNode singleLeftRotation(BSTNode x)
    {
        if(x == null || x.right == null) return x;
        BSTNode y = x.right;
        x.right = y.left;
        y.left = x;
        x.setHeight();
        y.setHeight();
        return y;
    }

    BSTNode doubleLeftRightRotation(BSTNode x)
    {
        BSTNode y;
        y = x.left;
        x.left = singleLeftRotation(y);
        x = singleRightRotation(x);
        return y;
    }

    BSTNode doubleRightLeftRotation(BSTNode x)
    {
        BSTNode y;
        y = x.right;
        x.right = singleRightRotation(y);
        x = singleLeftRotation(x);
        return y;
    }

    int height(BSTNode node)
    {
        if(node == null) return 0;
        return node.height;
    }

    BSTNode getLeft(BSTNode node)
    {
        if(node == null) return null;
        return node.left;
    }

    BSTNode getRight(BSTNode node)
    {
        if(node == null) return null;
        return node.right;
    }

    int getBalance(BSTNode node)
    {
        int left, right;
        if(node == null) return 0;
        left = getHeight(node.left);
        right = getHeight(node.right);
        return left - right;
    }

    int getHeight(BSTNode node)
    {
        if(node == null) return 0;
        return node.height;
    }
}
