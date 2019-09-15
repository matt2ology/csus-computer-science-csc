import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class InsertionSort2 {

    // Complete the insertionSort2 function below.
    static void insertionSort2(int n, int[] arr) {
       n = arr.length - 1;
       for (int i = 1; i < arr.length; i++) {
            
            int element = arr[n];
            int temp = i;

            while(n >= 1 && arr[temp-1] > element) {
                arr[n] = arr[n-1];
                temp--; 
                printArr(arr);
             }
             arr[n] = element;
             printArr(arr);

       }

 }    

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

        insertionSort2(n, arr);

        scanner.close();
    }
}