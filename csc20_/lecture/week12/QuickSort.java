import java.util.Arrays;
public class QuickSort
{
   public static void main(String[] args)
   {
      // Create an int array with test values.
      int[] A = { 54, 25, 93, 17, 77, 31, 44, 55, 19 };
      
      // Display the array's contents.
      System.out.println("Original order: " + Arrays.toString(A));
      
      // Sort the array.
      QuickSorter.quickSort(A);
      System.out.println();

      System.out.println("After sorting: \n" + Arrays.toString(A));
   }
}