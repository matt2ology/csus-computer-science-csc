public class ShapeTest
{
    public static void main(final String[] array) {
        for (final Shape shape : new Shape[] { (Shape)new Circle(22, 88, 4), (Shape)new Square(71, 96, 10), (Shape)new Sphere(8, 89, 2), (Shape)new Cube(79, 61, 8) }) {
            System.out.printf("%s: %s", shape.getName(), shape);
            if (shape instanceof TwoDimensionalShape) {
                System.out.printf("%s's area is %s\n", shape.getName(), ((TwoDimensionalShape)shape).getArea());
            }
            if (shape instanceof ThreeDimensionalShape) {
                final ThreeDimensionalShape threeDimensionalShape = (ThreeDimensionalShape)shape;
                System.out.printf("%s's area is %s\n", shape.getName(), threeDimensionalShape.getArea());
                System.out.printf("%s's volume is %s\n", shape.getName(), threeDimensionalShape.getVolume());
            }
            System.out.println();
        }
    }
}