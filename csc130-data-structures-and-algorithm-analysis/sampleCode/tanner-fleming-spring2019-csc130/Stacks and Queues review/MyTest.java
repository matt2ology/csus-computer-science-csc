public class MyTest {

   public static void main(String[] args) {

      String[] list = { "a b c" };
      MyStack stack = new MyStack(list);
      MyQueue queue = new MyQueue(list);

      System.out.println("Testing the isEmpty() method");
      System.out.println("I am expecting no result to pop up, as the stack isn't empty");
      stack.isEmpty();

      System.out.println("Testing the push method and the print stack method");
      System.out.println("The value I'm expecting is a, b, c");
      stack.push("a");
      stack.printStack();
      System.out.println();

      String[] list2 = { "a b c" };
      MyQueue queue2 = new MyQueue(list2);
      System.out.println("Testing the printQueue method: ");
      queue2.printQueue();

   }

}