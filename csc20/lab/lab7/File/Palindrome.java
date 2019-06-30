// This class provides method to test if a string is a Palindrome 
// using Stack/Queue ADTs.
// Csc20 lab 7 assignment
// Csc20's student to provide more inputs here.
import java.util.Stack;
import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
class Palindrome {
    // This is a main method to test checkPalindrome method
    public static void main(String[] args) {
        String inputString = new String("");
        Scanner in = new Scanner(System.in);
        do {
         // please put your code to test checkPalindrome method here
          } while ( inputString.equals("y") && inputString.length() == 1 );   
        System.out.print("Bye!"); 
    }

    /* This is checkPalindrome method. It checks if an input string is
    Palindrome or not. It returns 0 if a string is a Palindrome. Otherwise, it 
    returns a position of a character where it finds a different value.
    Pre-Condition: string must not be null. 
    Post-Condition: Return 0 if input string is a Palindrome. Return a positive 
    number indicate the location where a difference found. */
    public static int checkPalindrome(String strValue) {  
        Stack<Character> stack = new Stack<Character>();
        Queue<Character> queue = new LinkedList<Character>();
  
        // check if string is null. If it is null, return a -1 
        
        // normalize the string values to lower case, remove spaces
        strValue = strValue.toLowerCase().replaceAll("\\W", "");

        // store data on stack/queue adts first
         
        // loop: comparing, retrieving text, terminate loop if stack is emptied or found a difference

        return indexVal;
    }
}