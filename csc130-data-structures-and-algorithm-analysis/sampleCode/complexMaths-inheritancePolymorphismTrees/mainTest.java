public class mainTest {
	public static void main(String[] args) {
		Node vn = new ValueNode();
		OpNodeList ONL = new OpNodeList();
		MultiplicationNode m = new MultiplicationNode();
		DivisionNode d = new DivisionNode();
		AdditionNode a = new AdditionNode();
		SubtractionNode s = new SubtractionNode();

		ONL.include(m);
		ONL.include(d);
		ONL.include(a);
		ONL.include(s);
		ONL.setLeft(vn.evaluate());
		ONL.setRight(vn.evaluate());

		System.out.printf("%d * %d = %d%n", ONL.getLeft(0), ONL.getRight(0), ONL.evaluate(0));
		System.out.printf("%d / %d = %d%n", ONL.getLeft(1), ONL.getRight(1), ONL.evaluate(1));
		System.out.printf("%d + %d = %d%n", ONL.getLeft(2), ONL.getRight(2), ONL.evaluate(2));
		System.out.printf("%d - %d = %d%n", ONL.getLeft(3), ONL.getRight(3), ONL.evaluate(3));
	}
}