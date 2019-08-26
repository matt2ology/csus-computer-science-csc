// Description: Test module to test single linear 
// linkedlist with CsusStudent objects
// Author: Doan Nguyen 
// Date: 1/8/18 (Updated)
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LinkedListTest1 {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   CsusStudent instance1, instance2, instance3, instance4, instance5, instance6, instance7, instance8; 
   @Before public void setUp() {
      instance1 = new CsusStudent("John Doe 1", 1, "1 Somewhere", "916-555-1211", "johndoe1@somewhere.com");
      instance2 = new CsusStudent("John Doe 2", 2, "2 Somewhere", "916-555-1212", "johndoe2@somewhere.com");
      instance3 = new CsusStudent("John Doe 3", 3, "3 Somewhere", "916-555-1213", "johndoe3@somewhere.com");
      instance4 = new CsusStudent("John Doe 4", 4, "4 Somewhere", "916-555-1214", "johndoe4@somewhere.com"); 
      instance5 = new CsusStudent("John Doe 5", 5, "5 Somewhere", "916-555-1215", "johndoe5@somewhere.com");
      instance6 = new CsusStudent("John Doe 6", 6, "6 Somewhere", "916-555-1216", "johndoe6@somewhere.com");
      instance7 = new CsusStudent("John Doe 7", 7, "7 Somewhere", "916-555-1217", "johndoe7@somewhere.com");
      instance8 = new CsusStudent("John Doe 8", 8, "8 Somewhere", "916-555-1218", "johndoe8@somewhere.com"); 
   }

   // test addFirst and getFirst
   @Test public void testaddGetFirst() {
		LinkedList lst = new LinkedList(); 
		lst.addFirst(instance1);
      int expResult = 1;   
      assertEquals(expResult, lst.size());
      CsusStudent instance = (CsusStudent) lst.getFirst();
      assertEquals("John Doe 1", instance.getName());
   }      
   
   // test list traversal 1 with forward, getFirst, and getLast
   @Test public void testTraversal1() {
  		LinkedList lst = new LinkedList(); 
      lst.addFirst(instance1);
		lst.addFirst(instance2);
		lst.addFirst(instance3);
		lst.addLast(instance4);
		lst.addLast(instance5);
		lst.addLast(instance6);     
      lst.forward();
      lst.forward();
      lst.insertAfter(instance7);
      CsusStudent stf = (CsusStudent)lst.getFirst();
      CsusStudent stl = (CsusStudent)lst.getLast();
      assertEquals("John Doe 3", stf.getName());
      assertEquals("John Doe 6", stl.getName());
   } 
   
    // test list traversal 2 with backward, getFirst, getLast, and size
   @Test public void testTraversal2() {
  		LinkedList lst = new LinkedList(); 
      lst.addFirst(instance1);
		lst.addFirst(instance2);
		lst.addFirst(instance3);
		lst.addLast(instance4);
		lst.addLast(instance5);
		lst.addLast(instance6);     
      lst.backward();
      lst.backward();
      lst.insertBefore(instance7);
      CsusStudent stf = (CsusStudent)lst.getFirst();
      CsusStudent stl = (CsusStudent)lst.getLast();
      assertEquals("John Doe 7", stf.getName());
      assertEquals("John Doe 6", stl.getName());
      assertEquals(7,lst.size());
   } 
   
}