public class Node {
    public Node left;
    public Node right;
    public int data;
    public boolean check;

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public void addNode(int data) {

        if (data < this.data) {
            if (this.left == null) {
                this.left = new Node(data);
            } else
                this.left.addNode(data);
        } else if (data > this.data) {
            if (this.right == null) {
                this.right = new Node(data);
            } else
                this.right.addNode(data);
        }
        return;
    }

    public Node remove(int data) {
        // if (this == null) return this;

        if (data == this.data) {
            if (this.left == null && this.right == null) { // no children
                return null;
            } else if (this.left != null && this.right != null) { // 2 children
                this.data = this.right.findMinValue();
                this.right = this.right.remove(this.data);
            } else { // 1 children
                if (this.left != null) {
                    return this.left;
                } else if (this.right != null) {
                    return this.right;
                }
            }
        } else if (data < this.data) {
            if (this.left != null) {
                this.left = this.left.remove(data);
            }
        } else if (data > this.data) {
            if (this.right != null) {
                this.right = this.right.remove(data);
            }
        }
        return this;
    }

    public int findMinValue() {
        int min = this.data;
        if (this.left != null) {

            min = this.left.findMinValue();
            return min;
        }
        return min;
    }

    public boolean contains(int data) {
        if (data == this.data) {
            return true;
        } else if (data < this.data) {
            if (this.left != null) {
                check = this.left.contains(data);
            }
        } else if (data > this.data) {
            if (this.right != null) {
                check = this.right.contains(data);
            }
        } else {
            return false;
        }
        return check;
    }

    public void printTree(int indent) {
        String pad = "";

        // === Print current node
        // This is ugly. Other languages, such as C#, have useful string methods for
        // padding.
        for (int n = 0; n < indent; n++) {
            pad += "  "; // 2 spaces
        }

        System.out.println(pad + "+-- " + this.data);

        // == Recursion
        if (this.left != null) {
            this.left.printTree(indent + 1);
        }

        if (this.right != null) {
            this.right.printTree(indent + 1);
        }
    }

    public void printValues() {
        if (this.left != null) {
            this.left.printValues();
        }

        // Infix
        System.out.print(this.data + ' '); // Just print the data (no newline) and a space

        if (this.right != null) {
            this.right.printValues();
        }
    }
}