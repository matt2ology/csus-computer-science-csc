import java.io.*;
import java.util.*;

public class Quicksort {

    public static void main(String[] args) {
       Scanner in = new Scanner(System.in);
       int s = in.nextInt();
       int[] ar = new int[s];
       for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
       }
        
        System.out.println(partition(ar));
    }
    
    private static String partition(int arr[]){
        int pivot = arr[0];
        int partArr[] = new int[arr.length];
        partArr[arr.length/2] = pivot;
        int end = arr.length-1;
        int start = 0;
        String temp = "";

        for(int i = 1; i<arr.length; i++){
            if(arr[i] <= pivot){
                partArr[start] = arr[i];
                start++;
            }else{
                partArr[end] = arr[i];
                end--;
            }
        }
        
        
        for(int i = 0; i<partArr.length; i++){
            temp += partArr[i] + " ";
        }
        
        return temp;
    }
}