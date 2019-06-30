// This Junit is used to validate students's lab 5
// It is also used to demostrate the functionality of Junit as student is first learning it.
// Author: Doan Nguyen
// Date: 2/16/18
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CsusStudentTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   CsusStudent instance; 
   Csc20Student instance2;
   @Before public void setUp() {
        instance = new CsusStudent("John Doe", 123, "123 Somewhere", "415-555-1212", "johndoe@somewhere.com");
        instance2 = new Csc20Student("John Doe", 123, "123 Somewhere", "415-555-1212", "johndoe@somewhere.com",true,15); 
        instance = instance2;     
   }

   // test getName
   @Test public void testGetName() {
         String expResult = "John Doe";
         String result = instance.getName();
         assertEquals(expResult, result);
   }

   // test getAddress
   @Test public void testgetAddress() {
         String expResult = "123 Somewhere";
         String result = instance.getAddress();
         assertEquals(expResult, result);
   }
   
   // test getPhone
   @Test public void testgetPhone() {
         String expResult = "415-555-1212";
         String result = instance.getPhone();
         assertEquals(expResult, result);
   }   

   // test getEmail
   @Test public void testgetEmail() {
         String expResult = "johndoe@somewhere.com";
         String result = instance.getEmail();
         assertEquals(expResult, result);
   }  
}
