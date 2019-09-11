public class Circle extends TwoDimensionalShape
{
    public Circle(final int n, final int n2, final int n3) {
        super(n, n2, n3, n3);
    }
    
    public String getName() {
        return "Circle";
    }
    
    public int getArea() {
        return (int)(3.141592653589793 * this.getRadius() * this.getRadius());
    }
    
    public void setRadius(final int n) {
        this.setDimension1(n);
        this.setDimension2(n);
    }
    
    public int getRadius() {
        return this.getDimension1();
    }
    
    public String toString() {
        return String.format("%s %s: %d\n", super.toString(), "radius", this.getRadius());
    }
}