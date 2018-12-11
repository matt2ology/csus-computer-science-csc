/*=============================================================================
AUTHOR: Matthew Mendoza
CSc 020: Programming Concepts and Methodology II - Spring 2018
LAB ASSIGNMENT 4: Magic Squares
LAST EDIT DATE: 02/17/2018
MagicSquareTest.java
=============================================================================*/
/**   This lab's objective is to exercise with usages of Java’s array features.
 * We would like to apply this learning to determine if a two-dimensional array
 * is a magic square. A magic square is a square matrix in which the sum of
 * every row, every column, and both diagonals is the same. */

import java.util.Scanner;
/* Signals that an I/O exception of some sort has occurred. This class is the
general class of exceptions produced by failed or interrupted I/O operations.*/
import java.io.IOException;
/* An abstract representation of file and directory pathnames.
User interfaces and operating systems use system-dependent pathname strings 
to name files and directories. This class presents an abstract, 
system-independent view of hierarchical pathnames. */
import java.io.File;
/** File MagicSquareTest.java contains the shell for a program that reads input
 * for squares from a file named magicText.txt and tells whether each square is
 * a magic square.*/
public class MagicSquareTest {
  /** The main method reads the size of a square, then after constructing the
   * square of that size, it calls the readSquare method to read the square in.
   * The readSquare method must be sent the Scanner object as a parameter. */
  public static void main(String[] args) throws IOException {
    Scanner scan = new Scanner(new File("magicText.txt"));

    // Make sure that the file magicData is in the current directory
    int count = 1; // Count which square we're on
    int size = scan.nextInt(); // Size of next square

    // Expecting -1 at bottom of input file
    while (size != -1) {

      // Create a new Square of the given size 
      MagicSquare ms = new MagicSquare(size);

      // Call its read method to read the values of the square
      System.out.printf("\n***** Square %d *****\n", count);
      ms.readSquare(scan);

      // Print the square
      ms.printSquare();

      // Print the square id
      System.out.printf("***** Square %d *****\n\n", count);

      // Print the sums
      ms.printMagicSquareSums();

      // Determine and print whether it is a magic square
      System.out.printf("Is it a magic square: %b\n", ms.isMagicSquare());
      // Get size of next square
      size = scan.nextInt();
      count++;
    } // END OF WHILE LOOP
  }// END OF main METHOD
}// END OF CLASS MagicSquareTest
