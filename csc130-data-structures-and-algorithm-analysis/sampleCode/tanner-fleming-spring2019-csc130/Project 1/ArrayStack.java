/*
 * Author: Pawan Chandra
 * Author: Pawan Khatri
 * 
 * Date: 6/5/2108
 * Version: 1.0
 */
import java.util.EmptyStackException;
	
public class ArrayStack implements DStack {
		
	private int sizeOfArray; 
	private double[] array; 
	private int firstElement; 
	
	/*Constructor*/
	public ArrayStack() {
		sizeOfArray = 10;
		array = (double[]) new double[sizeOfArray];
		firstElement = -1;
	}
	
	/*Checks if the first index is -1. Empty if true*/
	public boolean isEmpty() {
		if (firstElement == -1)
			return true;
		else
			return false;
	}
	
	/*Checks the size of Array*/
	public boolean isFull() {
		if (firstElement == (array.length - 1))
			return true;
		else 
			return false;
	}
	
	/*If the array is full then double its size else add data and update firstElement*/
	public void push(double d) {
		if (isFull()) {
			double[] tempArray = (double[]) new double[sizeOfArray*2];
			for(int i = 0; i< sizeOfArray; i++) {
				tempArray[i] = array[i];	
			}
			sizeOfArray = sizeOfArray*2;
			array = tempArray;
		}
		firstElement++;
		array[firstElement] = d;
	}
	
	/*Remove the first element in the array and update firstElement*/
	public double pop() {
		if (!isEmpty()) {
			double top = array[firstElement];
			firstElement--; 
			return top;
		} else 
			throw new EmptyStackException();
		
	}

	/*Displays the firstElement*/
	public double peek() {
		if (!isEmpty())
			return array[firstElement];	
		else 
			throw new EmptyStackException();
		
	}
}