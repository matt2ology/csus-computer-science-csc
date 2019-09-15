public class MyQueue {

  private MyStack queStack;
  private MyStack tempStack;

  public MyQueue(String[] list) {

    queStack = new MyStack(list);
    tempStack = new MyStack(list);

  }

  public boolean isEmpty() {
    return queStack.isEmpty();
  }

  public void enqueue(String Item) {
    while (!queStack.isEmpty()) {
      queStack.push(tempStack.pop());
    }
  }

  public String dequeue() {
    if (queStack.isEmpty()) {
      return "The queue is Empty!";

    } else
      return queStack.pop();
  }

  public void printQueue() {
    while (!isEmpty()) {
      System.out.print(dequeue());
    }

  }

}