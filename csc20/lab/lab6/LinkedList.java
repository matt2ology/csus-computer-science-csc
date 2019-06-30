import javax.lang.model.util.ElementScanner6;
/*=============================================================================
AUTHOR: Matthew Mendoza
CSc 020: Programming Concepts and Methodology II - Spring 2018
LAB ASSIGNMENT 6: Linear Linked List
LAST EDIT DATE: 03/5/2018
LinkedList.java
=============================================================================*/
/**
 * This lab will give you a practice with writing a linear linked list. To this
 * work, you are building a list of any object. However, for testing, your list
 * data element would be CsusStudent.
*/
public class LinkedList {
    /** Defined Node class */
    private class Node {
        /* Class Object is the root of the class hierarchy. Every class has 
        Object as a superclass */
        private Object Data = null;
        private Node Next = null;

        /** Node constructor */
        public Node() {
            Data = null;
            Next = null;
        }

        public Node(Object element) {
            Data = element;
        }

        /** Takes in Object o and Node n to Data and Next respectively */
        public Node(Object o, Node n) {
            Data = o;
            Next = n;
        }

        public void setNext(Node n) {
            Next = n;
        }

        public Node getNext() {
            return Next;
        }

        public void setElement(Object element) {
            Data = element;
        }

        public Object getElement() {
            return Data;
        }
    }

    //Internal data for LinkedList
    private Node head = null;
    private Node current = null;
    private int size = 0; // Size of the list

    /** LinkedList constructor */
    public LinkedList() {
        head = null;
        current = head;
    }

    /** Move the current position forward one position
     * <li>
     * Pre-conditions: Must at least be more than one node in list
     * </li>
     * Post conditions: Moves current pointer forward one node
    */
    public void forward() {
        if (size() == 0) {
            return;
        }
        Node tmp = current.getNext();
        if (tmp != null) {
            current = tmp;
        }
    }

    /** Move the current position backward one position
     * <li>
     * Pre-conditions: Must at least be more than one node in list
     * </li>
     * Post conditions: Moves current pointer back one node
    */
    
    public void backward() {
        if (head != current) {
            //Create a node to traverse the list in order to
            // find the Node before the current one
            Node tmp = head;
            // While the next node for tmp is not the current one
            // and not the end of the list, step forward one node
            while ((tmp.getNext() != current) && (tmp.getNext() != null)) {
                tmp = tmp.getNext();
            }
            current = tmp;
        }
    }

    /** Get current object's data element 
     * <li>
     * Pre-conditions: N/A
     * </li>
     * Post conditions: Returns current position
    */
    public Object currentData() {
        if (current != null) {
            return current.getElement();
        } else {
            return null;
        }
    }
    
    ///////////////////////////////////////////////////////////////////////////
    //  addFirst: This method creates a node and prepends it at the beginning//
    //  of the list.                                                         //
    //=======================================================================//
    //  1) Create a new node. Have its next points to node head.             //
    //  2) update head to point to the new node.                             //
    //Do not forget:                                                         //
    //  3) Initialization of current node for first node added.              //
    //  4) Increase size.                                                    //
    ///////////////////////////////////////////////////////////////////////////
    /** Add object to the first of the list 
     * <li>
     * Pre-conditions: N/A
     * </li>
     * Post conditions: Adds a node to the start of the list and points head to
     * it that node
    */
    public void addFirst(Object o) {
        //Initialize a new Node with Object o and a null next pointer
        Node tmp = new Node(o, head);
        head = tmp;
        /* If current is currently pointing at null, point to the head, 
        otherwise stay where it is */
        current = (current == null) ? head : current;
        size++;
    }

    /** Reset the current position at the head element 
     * <li>
     * Pre-conditions: At least one node in list
     * </li>
     * Post conditions: Points current to where head pointer is.
    */
    public void resetCurrent() {
        current = head;
    }

    ///////////////////////////////////////////////////////////////////////////
    //  addLast: Appends the node to the end of the list. Requires           //
    //  trasversing, but make you stop at the last node.                     //
    //=======================================================================//
    //  1) traverse to the last node.                                        //
    //  2) create a new node. Have its next points to null.                  //
    //  3) have the last node points to the new node.                        //
    //-----------------------------------------------------------------------//
    //Note:                                                                  //
    //  4) Initialization of cur for first node added.                       //
    //  5) Increase size                                                     //
    ///////////////////////////////////////////////////////////////////////////
    /** Add object to the last of the list
     * <li>
     * Pre-conditions: N/A
     * </li>
     * Post conditions:Adds a node to the end of the list 
    */
    public void addLast(Object o) {
        //If a list has at least one element
        if (size() > 0) {
            /* 1. traverse to the last node. */
            // Initialize tmp to start from head
            Node tmp = head;
            // Loop till run into null at the end:
            while (tmp.Next != null) {
                tmp = tmp.Next;
            }
            // 2.
            Node myNode = new Node(o, null);
            // 3. tmp is computed from step 1
            tmp.setNext(myNode);
            // 4. Increase size
            size += 1;
        } else {
            // add first element on the list
            addFirst(o); // size increased here
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    //  insertBefore: Inserting "before"                                     //
    //=======================================================================//
    //  1) find a previous node using current node.                          //
    //  2) create a new node.                                                //
    //  3) have previous node points to new node.                            //
    //  4) have the new node points to current node.                         //
    //-----------------------------------------------------------------------//
    //  Pre-condition: list must have one element to insert before           //
    ///////////////////////////////////////////////////////////////////////////  
    /** Add an object o before the current position 
     * <li>
     * Pre-conditions: List must have at least one element to insert before
     * </li>
     * Post conditions: Inserts one node before current pointer
    */
    public void insertBefore(Object o) {
        //If a list is null, return
        if (size() == 0) {
            return;
        } else if (head == current) { //Else if a list has one element
            addFirst(o);
        } else { // List has two or more elements
            // 1. get previous node
            backward();
            Node prev = current;
            forward();
            // 2. create new node
            Node myNode = new Node(o, null);
            // 3. previous node points to new node
            prev.setNext(myNode);
            // 4. new node point to current node
            myNode.setNext(current);
            size += 1;
        }
    }

    ///////////////////////////////////////////////////////////////////////////
    //insertAfter: Inserting "after"                                         //
    //=======================================================================//
    //1. create new node.                                                    //
    //2. have new node point to where current node points to.                //
    //3. have current node points to new node.                               //
    //-----------------------------------------------------------------------//
    // Pre-condition: list must have one element to insert after. Else return//
    //null.                                                                  //
    ///////////////////////////////////////////////////////////////////////////
    /** Add an object o after the current position 
     * <li>
     * Pre-condition: list must have one element to insert after. Else return 
     * null.  
     * </li>
     * Post conditions: Inserts one node after current pointer
    */
    public void insertAfter(Object o) {
        /* If a list has at least one element */
        if (size() > 0) {
            // 1. Create new node
            Node myNode = new Node(o, null);
            // 2. new node points to where current pointed to
            myNode.setNext(current.getNext());
            // 3. current node points to new node
            current.setNext(myNode);
            size += 1;
        } else {
            // Void methods cannot return a value
            return;
        }
    }

    /** Get first object 
     * <li>
     * Pre-condition: Must have at least two node in list
     * </li>
     * Post conditions: Returns head element
    */
    public Object getFirst() {
        return (head == null) ? null : head.getElement();
    }

    /** Get last object 
     * <li>
     * Pre-condition: Must have at least two node in list
     * </li>
     * Post conditions: Returns tail element
    */
    public Object getLast() {
        if (size() == 0) {
            return null;
        }
        // Initialize tmp to start from head
        Node tmp = head;
        // Loop till run into null at the end:
        while (tmp.Next != null) {
            tmp = tmp.Next;
        }
        return tmp.getElement();
    }

    /** Remove the first object 
     * <li>
     * Pre-condition: Must have at least two nodes in list
     * </li>
     * Post conditions: Removes first node in list and assigns head pointer to the
     * second, now first, node in list
    */
    public Object removeFirst() {
        if (size() == 0) {
            return null;
        } else {
            head = head.Next;
            size--;
            return head;
        }
    }

    /** Remove the last object 
     * <li>
     * Pre-condition: Must have at least two nodes in list
     * </li>
     * Post conditions: removes last node in list
    */
    public Object removeLast() {
        //Test if list is populated
        if (head != null) {
            // Initialize tmp to start from head
            Node tmp = head;
            // Loop till run into null at the end:
            while (tmp.Next != null) {
                tmp = tmp.Next;
            }
            tmp.setNext(tmp.Next);
            size--;
            return tmp;
        } else
            return null;
    }

    /** Remove object o from the list 
     * <li>
     * Pre-condition: Must have at leadt one node
     * </li>
     * Post conditions: Removes node from list
    */
    public void remove(Object o) {
        if (size != 0) {
            //Node prev will point to the Node just before the node being removed
            Node prev = null;
            Node tmp = head;
            while ((tmp.getNext() != null) && (tmp.getElement() != o)) {
                prev = tmp;
                tmp = tmp.getNext();
            }
            if (tmp.getElement() == o) {
                current = (current == tmp) ? prev : current;
                prev.setNext(tmp.getNext()); // General condition
                size--;
            }
        }
    }

    /** Returns the number of elements on the list 
     * <li>
     * Pre-condition: N/A
     * </li>
     * Post conditions: Retruns size of list
    */
    public int size() {
        return size;
    }

    /** Is the list emptied? 
     * <li>
     * Pre-condition: N/A
     * </li>
     * Post conditions: Returns true if the list is empty else false
    */
    public boolean isEmpty() {
        return (size() == 0) ? true : false;
    }

    /** Display a content of a list */
    public String toString() {
        String r = "( HEAD -> ";
        /** Node l = head.getNext(); */
        Node l = head;
        while (l != null) {
            r = r + l.getElement() + " -> ";
            l = l.getNext();
        }
        return r + " )";
    }

    public static void main(String args[]) {
        LinkedList lst = new LinkedList();//Where head is initialized
        /** create instances for testing */
        CsusStudent instance1 = new CsusStudent("John Doe 1", 1, "1 Somewhere", "916-555-1211",
                "johndoe1@somewhere.com");
        CsusStudent instance2 = new CsusStudent("John Doe 2", 2, "2 Somewhere", "916-555-1212",
                "johndoe2@somewhere.com");
        CsusStudent instance3 = new CsusStudent("John Doe 3", 3, "3 Somewhere", "916-555-1213",
                "johndoe3@somewhere.com");
        CsusStudent instance4 = new CsusStudent("John Doe 4", 4, "4 Somewhere", "916-555-1214",
                "johndoe4@somewhere.com");
        CsusStudent instance5 = new CsusStudent("John Doe 5", 5, "5 Somewhere", "916-555-1215",
                "johndoe5@somewhere.com");
        CsusStudent instance6 = new CsusStudent("John Doe 6", 6, "6 Somewhere", "916-555-1216",
                "johndoe6@somewhere.com");
        CsusStudent instance7 = new CsusStudent("John Doe 7", 7, "7 Somewhere", "916-555-1217",
                "johndoe7@somewhere.com");
        CsusStudent instance8 = new CsusStudent("John Doe 8", 8, "8 Somewhere", "916-555-1218",
                "johndoe8@somewhere.com");
        CsusStudent instance9 = new CsusStudent("John Doe 9", 9, "9 Somewhere", "916-555-1219",
                "johndoe9@somewhere.com");

        /** begin adding instance1 to the list  */
        lst.addFirst(instance1);

        /** test forward and backward for single entry */
        lst.forward();
        lst.backward();

        /** now add instance2 and instance3 via addFirst and instance4, 
         * instance5, instance6 via addLast */
        lst.addFirst(instance2);
        lst.addFirst(instance3);
        lst.addLast(instance4);
        lst.addLast(instance5);
        lst.addLast(instance6);
        /** move current forward a few times */
        lst.forward();
        lst.forward();

        /** insert instance 9 after */
        lst.insertAfter(instance9);

        /** remove instance9 */
        lst.remove(instance9);

        /** print out the first and last entries */
        System.out
                .println("Show the first entry and last entry:" + lst.getFirst().toString() + lst.getLast().toString());

        /** print out the whole list */
        System.out.println("Show the whole list:" + lst.toString());

        /** remove entries starting from the last entry  */
        System.out.println("Check for the content of the emptied list");
        if (!lst.isEmpty()) {
            lst.removeLast();
        }
    }
}
