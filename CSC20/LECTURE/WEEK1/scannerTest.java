import java.util.Scanner;
public class scannerTest{
   public static void main(String[] args) { 
      Scanner stdin= new Scanner(System.in);
      System.out.println("scannerTest IS RUNNING\n");
      do {
         if (stdin.hasNextInt()) {
            int n = stdin.nextInt();
            System.out.println("Integer entered: "+n);
         } 
         else if (stdin.hasNext("[a-zA-Z]*")) {
            String s = stdin.next();
            System.out.println("String entered: "+s);
         } 
         else {
            break;
         }
      } while (true);
   }
}