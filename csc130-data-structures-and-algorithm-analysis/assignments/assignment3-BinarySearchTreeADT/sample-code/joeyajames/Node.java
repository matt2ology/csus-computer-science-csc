
public class Node {
    public Node left;
    public Node right;
    public int data;

    /**
     * 
     * @param value
     */
    public Node(int value) {
        data = value;
        left = null;
        right = null;
    }

    /**
     * 
     * @param value
     * @return
     */
    public boolean insert(int value) {
        boolean added = false;
        if (value < this.data) {
            if (this.left == null) {
                this.left = new Node(value);
                return true;
            } else
                added = this.left.insert(value);
        } else if (value > this.data) {
            if (this.right == null) {
                this.right = new Node(value);
                return true;
            } else
                added = this.right.insert(value);
        }
        return added;
    }

    /**
     * 
     * @param value
     * @return
     */
    public boolean remove(int value) {
        boolean removed = false;
        if (value < this.data) {
            if (this.left == null) {
                removed = this.left.remove(value);
                return true;
            } else if (value > this.data) {
                removed = this.right.remove(value);
                return true;
            }else {  // data == value; remove this node
                if (right == null) {
                    return this.left;    // no R child; replace w/ L
                } else if (left == null) {
                    return this.right;   // no L child; replace w/ R
                } else {
                    // both children; replace w/ min from R
                    data = getMin(right);
                    right = remove(right, data);
                }
            }
            return removed;
        
    }

    /**
     * 
     * @param value
     * @return
     */
    public boolean contains(int value) {
        boolean found = false;
        if (value == this.data)
            return true;
        else if (value < this.data && this.left != null)
            found = this.left.contains(value);
        else if (value > this.data && this.right != null)
            found = this.right.contains(value);
        return found;
    }

    /** */
    public void preorder() {
        if (this != null) {
            System.out.println(this.data);
            if (this.left != null)
                this.left.preorder();
            if (this.right != null)
                this.right.preorder();
        }
    }

    /** */
    public void postorder() {
        if (this != null) {
            if (this.left != null)
                this.left.postorder();
            if (this.right != null)
                this.right.postorder();
            System.out.println(this.data);
        }
    }

    /** */
    public void inorder() {
        if (this != null) {
            if (this.left != null)
                this.left.inorder();
            System.out.print(this.data + " ");
            if (this.right != null)
                this.right.inorder();
        }
    }

    /**
     * 
     * @param indent
     */
    public void printTree(int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }
        System.out.print("||---");
        System.out.println(this.data); // Node
        if (this.left != null) {
            left.printTree(indent + 1);
        } // Left
        else if (this.right != null) {
            right.printTree(indent + 1);
        } // Right
    }
}