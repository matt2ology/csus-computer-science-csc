import java.util.Scanner;
//Reused old csc 20 code for insertion sort, used the websites printArray method as well

public class insertionSort {
	
	 // Complete the insertionSort1 function below.
    static void insertionSort1(int n, int[] arr) {
        n = arr.length - 1;
        //Element in the array that will be inserted
        int element = arr[n];
        
        //decrement thru the array 
        while(n >= 1 && arr[n-1] > element) {
            arr[n] = arr[n-1];
            n--;
            printArr(arr);
        }
        arr[n] = element;
        printArr(arr);

 }      
      
    //Simple for loop to print out the array as each insertion takes place
    static void printArr(int[] arr) {
        for(int n: arr){
            System.out.print(n+" ");
            
        }
        System.out.println();
    }


    

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort1(n, arr);

        scanner.close();
    }
}


