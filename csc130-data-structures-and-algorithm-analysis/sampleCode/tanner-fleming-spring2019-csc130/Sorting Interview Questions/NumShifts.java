import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class NumShifts {

    // Complete the runningTime function below.
    static int runningTime(int[] arr) {
            //use this variable and update it each time the array shifts an element in the sorting process
            int shifts = 0;
            for(int i = 1; i < arr.length; i++){
                int value = arr[i];
                int j = i - 1;
                while(j >= 0 && arr[j] > value){//using while logic from the previous example for array iteration
                    arr[j + 1] = arr[j];
                    j = j - 1;
                    shifts++;//update the counter each time the shift in the array happens
            }
            arr[j + 1] = value;
        }

        return shifts;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = runningTime(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}