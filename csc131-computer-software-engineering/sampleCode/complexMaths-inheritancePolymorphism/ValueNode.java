import java.util.Random;
public class ValueNode extends Node{
	Random randNumObj = new Random();
	int evaluate(){
	    return randNumObj.nextInt(20);
	}
}