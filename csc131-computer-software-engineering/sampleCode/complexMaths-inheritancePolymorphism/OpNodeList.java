
public class OpNodeList {
	private OpNode[] objList = new OpNode[4];
	private int index = 0;

	public void include(OpNode opn) {
		if (index < objList.length) {
			objList[index] = opn;
			index++;
		}
	}

	public void setLeft(int j) {
		for (int x = 0; x < objList.length; x++) {
			objList[x].left = j;
		}
	}

	public void setRight(int j) {
		for (int x = 0; x < objList.length; x++) {
			objList[x].right = j;
		}
	}

	public int getLeft(int x) {
		return objList[x].left;
	}

	public int getRight(int x) {
		return objList[x].right;
	}

	public int evaluate(int x) {
		return objList[x].evaluate();
	}
}
