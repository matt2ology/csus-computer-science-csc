/*=============================================================================
AUTHOR: Matthew Mendoza
CSc 020: Programming Concepts and Methodology II - Spring 2018
LAB ASSIGNMENT 7: Palindrome
LAST EDIT DATE: 03/15/2018
Palindrome.java
=============================================================================*/
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
            System.out.printf("Enter word here: ");
            String s = in.nextLine();
            // please put your code to test checkPalindrome method here
            checkPalindrome(s);

            System.out.printf("GO again [y/n]: ");
            inputString = in.nextLine();
        } while (inputString.equals("y") && inputString.length() == 1);
        System.out.print("Bye!");
    }

    // This is checkPalindrome method. It checks if an input string is Palindrome or
    // not.
    // It returns 0 if a string is a Palindrome. Otherwise, it returns a position of
    // a character where it finds
    // a different value.
    // Pre-Condition: string must not be null.
    // Post-Condition: Return 0 if input string is a Palindrome. Return a positive
    // number indicate the location where
    // a difference found.
    public static int checkPalindrome(String strValue) {
        int count = 1;
        Queue<Character> queue = new LinkedList<Character>();
        Stack<Character> stack = new Stack<Character>();

        // check if string is null. If it is null, return a -1
        if (strValue == null) {
            return -1;
        }

        // normalize the string values to lower case, remove spaces
        strValue = strValue.toLowerCase().replaceAll("\\W", "");

        // store data on stack/queue adts first
        int indexVal = 0;
        for (int i = 0; i < strValue.length(); i++) {
            char letter = strValue.charAt(i);
            queue.add(letter);
            stack.push(letter);
        }
        // loop: comparing, retrieving text, terminate loop if stack is emptied or found
        // a difference
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) {
                System.out.printf("NOT A PALINDROME at %d\n", count);
                indexVal = count;
                return indexVal;
            }
            count++;
        }
        System.out.printf("IS A PALINDROME\n");

        return 0;
    }
}