// ****************************************************************
// MagicSquare.java
//
// Text below is to be filled by student. 
//
// ****************************************************************
import java.util.Scanner;
public class MagicSquare { 

    int[][] square;

    public MagicSquare(int size)
    {
      // ......       
    }
//--------------------------------------
//return the sum of the values in the given row
//--------------------------------------
 
    private int sumMagicRow(int row)
    {
      int sum = 0;
      // ......
      return sum;
    }
//--------------------------------------
//return the sum of the values in the given column
//--------------------------------------
 
    private int sumMagicCol(int col)
    {
      int sum = 0;
      // ......
      return sum;
    }
//--------------------------------------
//return the sum of the values in the main diagonal
//--------------------------------------
 
    private int sumMagicDiagMain()
    {
      int sum = 0;
      // ......
      return sum;
    }
//--------------------------------------
//return the sum of the values in the other ("reverse") diagonal
//--------------------------------------
 
    private int sumMagicDiagRev()
    {
      int sum = 0;
      // ......
      return sum;
    }
 
//--------------------------------------
//return true if the square is magic (all rows, cols, and diags
// have same sum), false otherwise
//-------------------------------------- 
    public boolean isMagicSquare()
    {
       boolean answer = true;
       // ......         
       return answer;
    }
//--------------------------------------
//compute and display sums of square including row, column, main diagonal, and other diagonal
//--------------------------------------
    public void printMagicSquareSums()
    {
      // ......
    }

//--------------------------------------
//read info into the square from the input stream associated with
//the Scanner parameter
//--------------------------------------
    public void readSquare(Scanner scan)
    {
        for (int row = 0; row < square.length; row++)
           for (int col = 0; col < square.length; col++)
              square[row][col] = scan.nextInt();
    }
//--------------------------------------
//print the contents of the square, neatly formatted
//--------------------------------------
    public void printSquare()
    {
      // ......
    }          
}