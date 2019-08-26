public class SelectionSort {
      public static void main(String[] args) {
            int[] A = new int[] { 54, 25, 93, 17, 77, 31, 44, 55, 19 };

            System.out.println("Original order: ");
            for (int i = 0; i < A.length; i++)
                  System.out.print(A[i] + " ");
            System.out.println("\n");

            selectionSort(A);

            System.out.println("After sorting: ");
            for (int i = 0; i < A.length; i++)
                  System.out.print(A[i] + " ");
      }

      private static int selectionSort(int[] A) {
            int N = A.length;
            int total = 0;
            for (int last = N - 1; last >= 1; last--) {
                  int maxIndex = 0;
                  int count = 0;
                  for (int index = 1; index <= last; index++) {
                        count += 1;
                        if (A[index] > A[maxIndex])
                              maxIndex = index;
                  }

                  total += count;

                  int temp = A[maxIndex];
                  A[maxIndex] = A[last];
                  A[last] = temp;
            }
            return total;
      }
}