// A class's description to be provided by student
// Fill in code in ALL commented areas

public class LinkedList {
   // Defined Node class
   private class Node {
      private Object Data = null;
      private Node Next = null;
      public Node() { 
          Data = null; 
          Next = null; 
      }
      public Node(Object element) { 
          Data = element; 
      }
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
      public Object getElement() {  
         return Data; 
      }
      public void setElement(Object element) { 
         Data = element; 
      }
   }

   // Internal data for LinkedList
   private Node head = null;
   private Node current = null;
   private int size = 0;
   
   // LinkedList constructor
   public LinkedList() {
      head = null;
      current = head;
   }
   
   // Move the current position forward one position
   public void forward() {

   }
   
   // Move the current position backward one position
   public void backward() {

   }   
 
   // Get current object's data element
   public Object currentData() {
  
   }
  
  
   // Add object to the first of the list
   public void addFirst(Object o) {

   }
	
   
   // resetCurrent at the first position
   public void resetCurrent() {

   }
   
   // Add object to the last of the list
   public void addLast(Object o) {

   }
	
   // Add an object o before the current position
   public void insertBefore(Object o) {

   }
   
   // Add an object o after the current position
   public void insertAfter(Object o) {

   }
   
   // Get first object
   public Object getFirst() {
     
   }
	
   // Get last object
   public Object getLast() {

   }
	
   // Remove the first object
   public Object removeFirst(){

   }
	
   // Remove the last object
   public Object removeLast() {

   }
	
   // Remove object o from the list
   public void remove(Object o) {

   }
   
   // Returns the number of elements on the list
   public int size() {
      return size;
   }
	
   // Is the list emptied?
   public boolean isEmpty() {

   }

   // Display a content of a list
   public String toString() {
      String r = "( HEAD -> ";
      // Node l = head.getNext();
      Node l = head;
      while (l != null) {
         r = r + l.getElement() + " -> " ;
         l = l.getNext();
      }
      return  r + " )";
   }
	
   public static void main(String args[]) {
      LinkedList lst = new LinkedList();
      // creat instances for testing
      CsusStudent instance1 = new CsusStudent("John Doe 1", 1, "1 Somewhere", "916-555-1211", "johndoe1@somewhere.com");
      CsusStudent instance2 = new CsusStudent("John Doe 2", 2, "2 Somewhere", "916-555-1212", "johndoe2@somewhere.com");
      CsusStudent instance3 = new CsusStudent("John Doe 3", 3, "3 Somewhere", "916-555-1213", "johndoe3@somewhere.com");
      CsusStudent instance4 = new CsusStudent("John Doe 4", 4, "4 Somewhere", "916-555-1214", "johndoe4@somewhere.com"); 
      CsusStudent instance5 = new CsusStudent("John Doe 5", 5, "5 Somewhere", "916-555-1215", "johndoe5@somewhere.com");
      CsusStudent instance6 = new CsusStudent("John Doe 6", 6, "6 Somewhere", "916-555-1216", "johndoe6@somewhere.com");
      CsusStudent instance7 = new CsusStudent("John Doe 7", 7, "7 Somewhere", "916-555-1217", "johndoe7@somewhere.com");
      CsusStudent instance8 = new CsusStudent("John Doe 8", 8, "8 Somewhere", "916-555-1218", "johndoe8@somewhere.com"); 
      CsusStudent instance9 = new CsusStudent("John Doe 9", 9, "9 Somewhere", "916-555-1219", "johndoe9@somewhere.com");         
     
      // begin adding instance1 to the list 
      
      
      // test forward and backward for single entry
     
      
      // now add instance2 and instance3 via addFirst and instance4, instance5, instance6 via addLast

      
      // move current forward a few times
   
      // insert instance 9 after
      
      // remove instance9
      
      
      // print out the first and last entries
      System.out.println("Show the first entry and last entry:");
    
      
      // print out the whole list
      System.out.println("Show the whole list:");

   	
      // remove entries starting from the last entry 
      System.out.println("Check for the content of the emptied list");

   }
}