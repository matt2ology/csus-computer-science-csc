/*=============================================================================
AUTHOR: Matthew Mendoza
CSc 020: Programming Concepts and Methodology II - Spring 2018
LAB ASSIGNMENT 4: Magic Squares
LAST EDIT DATE: 02/17/2018
MagicSquare.java
=============================================================================*/
/**     File MagicSquare.java contains the shell for a class that represents a
 * square matrix. It contains headers for a constructor that gives the size of
 * the square and methods to read values into the square, print the square, 
 * find the sum of a given row, find the sum of a given column, find the sum of
 * the main positive or negative diagonal, and determine whether the square is
 * magic.*/
import java.util.Scanner;

public class MagicSquare {
    // Declare 2D array 
    int square[][];

    /** This constructor takes int size and assigns them to be the size of
     * the two-dimensional array  */
    public MagicSquare(int size) {
        square = new int[size][size];
    }// END OF MagicSquare CONSTRUCTOR

    /** Return the sum of the values in the given row */
    private int sumMagicRow(int row) {
        int sum = 0;
        for (int c = 0; c < square.length; c++) {
            sum += square[row][c];
        }
        return sum;
    }// END OF sumMagicRow METHOD

    /** Return the sum of the values in the given column */
    private int sumMagicCol(int col) {
        int sum = 0;
        for (int r = 0; r < square.length; r++) {
            sum += square[r][col];
        }
        return sum;
    }// END OF sumMagicCol METHOD

    /** Return the sum of the values in the main ("positive") diagonal */
    private int sumMagicPosDiag() {
        int sum = 0;
        int row = square.length - 1;
        for (int col = 0; col < square.length; col++, row--) {
            sum += square[row][col];
        } // END OF OUTTER LOOP
        return sum;
    }// END OF sumMagicDiagMain METHOD

    /** Return the sum of the values in the other ("negative") diagonal */
    private int sumMagicNegDiag() {
        int sum = 0;
        for (int row = 0, col = 0; row < square.length; row++, col++) {
            sum += square[row][col];
        } // END OF OUTTER LOOP
        return sum;
    }// END OF sumMagicDiagNeg METHOD

    /** Return true if the square is magic (all rows, cols, and diags have same sum),
     * false otherwise */
    public boolean isMagicSquare() {
        boolean ANSWER = true;
        for(int index = 0; index < square.length; index++){
            ANSWER = ((sumMagicRow(index))==(sumMagicCol(index))) ? true : false;
        }
        ANSWER = ((sumMagicPosDiag())==(sumMagicNegDiag())) ? true : false;
        return ANSWER;
    }// END OF isMagicSquare METHOD

    /** Compute and display sums of square including row, column, positive main
     * diagonal, and other diagonal */
    public void printMagicSquareSums() {
        for (int row = 0; row < square.length; row++) {
            System.out.printf("The sum of row %d is: %d\n", row, sumMagicRow(row));
        }
        System.out.println();
        for (int col = 0; col < square.length; col++) {
            System.out.printf("The sum of col %d is: %d\n", col, sumMagicCol(col));
        }
        System.out.println();
        System.out.printf("The sum of the positive slope diagonal is: %d", sumMagicPosDiag());
        System.out.println();
        System.out.printf("The sum of the negative slope diagonal is: %d", sumMagicNegDiag());
        System.out.println();  
    }// END OF printMagicSquareSums METHOD

    /** Read info into the square from the input stream associated with the Scanner
     * parameter */
    public void readSquare(Scanner scan) {
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                square[row][col] = scan.nextInt();
            } // END OF INNER LOOP
        } // END OF OUTTER LOOP
    }// END OF readSquare METHOD

    /** Print the contents of the square, neatly formatted */
    public void printSquare() {
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square.length; col++) {
                System.out.printf("%3d", square[row][col]);
            }
            System.out.println();
        }
    }// END OF printSquare METHOD   
}// END OF CLASS MagicSquare
