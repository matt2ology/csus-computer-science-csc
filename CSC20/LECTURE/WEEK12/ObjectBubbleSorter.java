/**
   The ObjectBubbleSorter class provides a public static
   method for performing a bubble sort on an array of
   objects implementing the Comparable interface.
*/

public class ObjectBubbleSorter {

    public static void main(String args[]) {

        int[] A = new int[] { 54, 25, 93, 17, 77, 31, 44, 55, 19 };

        System.out.println("Original order: ");
        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
        System.out.println("\n");

        bubbleSort(A);

        System.out.println("\nAfter sorting: ");
        for (int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");

    }//END OF main METHOD

    /**
      The bubbleSort method uses the bubble sort algorithm
      to sort an array of objects implementing Comparable
      @param array The array to sort.
    */

    public static void bubbleSort(int array[]) {
        int lastPos; // Marks the last element to compare
        int index; // Index of an element to compare
        int temp; // Used to swap to elements

        // The outer loop positions lastPos at the last element
        // to compare during each pass through the array. Initially
        // lastPos is the index of the last element in the array.
        // During each iteration, it is decreased by one.
        for (lastPos = array.length - 1; lastPos >= 0; lastPos--) {
            // The inner loop steps through the array, comparing
            // each element with its neighbor. All of the elements
            // from index 0 thrugh lastPos are involved in the
            // comparison. If two elements are out of order, they
            // are swapped.
            for (index = 0; index <= lastPos - 1; index++) {
                // Compare an element with its neighbor.
                if (array[index] > array[index + 1]) {
                    // Swap the two elements.
                    temp = array[index];
                    array[index] = array[index + 1];
                    array[index + 1] = temp;
                }
            }
        }
    }
}