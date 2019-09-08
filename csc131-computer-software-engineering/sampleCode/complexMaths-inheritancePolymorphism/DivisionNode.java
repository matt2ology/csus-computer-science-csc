

public class DivisionNode extends OpNode{
	int evaluate(){
		if((left/right) == 0){
			return left % right;
		}
		else {
			return left / right;
		}
	}
}