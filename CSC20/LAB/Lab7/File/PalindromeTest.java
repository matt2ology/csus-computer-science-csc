/** Unit test cases for checking the Palindrome method **/
/** Doan Nguyen: CSC 20 - Spring 2018 **/
import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class PalindromeTest {

   /** Fixture initialization (common initialization
    *  for all tests). **/
   String testStr = new String(""); 
   @Before public void setUp() {
      testStr = "";
   
   }

   /** Step on no pets test. **/
   @Test public void defaultTest() {
      testStr = "Step on no pets";
      int check = Palindrome.checkPalindrome(testStr);
      assertEquals(0, check);
   }
   
      /** null test. **/
   @Test public void nullTest() {
      testStr = null;
      int check = Palindrome.checkPalindrome(testStr);
      assertEquals(-1, check);
   }
   
   /** BelphegorPrime number test. **/
   @Test public void BelphegorPrimeTest() {
      testStr = "1000000000000066600000000000001";
      int check = Palindrome.checkPalindrome(testStr);
      assertEquals(0, check);
   }
   
   /** fail lonely tylenol test. **/
   @Test public void failTest() {
      testStr = "Lonely Tvlenol";
      int check = Palindrome.checkPalindrome(testStr);
      assertEquals(6, check);
   }
}
