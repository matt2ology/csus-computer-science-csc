/*
   Tanner Fleming
   CSC130 - 06
   Stacks and Queues Review
 
 */
import java.util.EmptyStackException;

public class ListStack {
	
	/* Getters and Setters*/
	public class ListStackNode {
		
		private ListStackNode list;
		private double d;
		
		public ListStackNode(double d) {
			this.d= d;
		}
		
		public ListStackNode getlist() {
			return list;
		}
		
		public void setlist(ListStackNode list) {
			this.list = list;
		}
		
		public double getInfo() {
			return d;
		}
		
		public void setInfo(double d) {
			this.d= d;
		}
	}
	
	
	private ListStackNode head;
	
	/*Constructor*/
	public ListStack() {
		head = null;
	}
	
	/*Checks if the stack is empty*/
	public boolean isEmpty() { 
		if (head == null) 
			return true;
		 else 
			return false;
	}
	
	/*Stores new data to the front*/
	public void push(double d) {
		ListStackNode temp = new ListStackNode(d);
		temp.setlist(head);
		head = temp;
	}
	
	/*Takes the first value and stores in temp*/
	public double pop() {
		if (!isEmpty()) {
			double temp = head.getInfo();
			head = head.getlist();
			return temp;
		} else 
			throw new EmptyStackException();
	}
	
	/*Shows the first value without removal*/
	public double peek() {
		if (!isEmpty()) 
			return head.getInfo(); 			
		else 
			throw new EmptyStackException();
	}
}
