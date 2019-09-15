/*
   Tanner Fleming
   1/26/19
   Write a method to print & after each integer
   ideas taken from previous csc20 practice and stack overflow printing an int line by line

*/

public class recursionPractice {

   public static void main(String[] args) {
      //andPrinter(5);
      andPrinter(43255);
   
   }
   
  public static void andPrinter(int n) {
      int count = n % 10;
      if (n / 10 == 0) {
         System.out.print(n); 
       } else {
         andPrinter(n/10);
         System.out.print("&" + count);
        } 
         
      
      
   }

}