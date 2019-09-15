/*
   Tanner Fleming
   CSC130 - 06
   Stacks and Queues Review
 
 */

public class MyStack {

	private String[] stackArray;

	/* Getters and Setters */
	public class ListStackNode {

		private ListStackNode list;
		private String d;

		public ListStackNode(String d) {
			this.d = d;
		}

		public ListStackNode getlist() {
			return list;
		}

		public void setlist(ListStackNode list) {
			this.list = list;
		}

		public String getInfo() {
			return d;
		}

		public void setInfo(String d) {
			this.d = d;
		}

	}

	public ListStackNode head;

	/* Constructor */
	public MyStack(String[] list) {

		head = null;

		stackArray = new String[list.length];
		for (int i = 0; i < list.length; i++) {
			push(list[i]);
		}

	}

	/* Checks if the stack is empty */
	public boolean isEmpty() {
		if (head == null) {
			return true;
		} else
			return false;

	}

	/* Stores new data to the front */
	public void push(String item) {
		ListStackNode temp = new ListStackNode(item);
		temp.setlist(head);
		head = temp;

	}

	/* Takes the first value and stores in temp */
	public String pop() {

		String s = "";
		if (!isEmpty()) {
			String temp = head.getInfo();
			head = head.getlist();
			return temp;
		} else
			return s += "the Stack is empty";

	}

	/* prints the values in the stack to the console */
	public void printStack() {
		while (!isEmpty())
			System.out.print(pop());
	}
}
