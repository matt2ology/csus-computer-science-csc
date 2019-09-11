public class Square extends TwoDimensionalShape
{
    public Square(final int n, final int n2, final int n3) {
        super(n, n2, n3, n3);
    }
    
    public String getName() {
        return "Square";
    }
    
    public int getArea() {
        return this.getSide() * this.getSide();
    }
    
    public void setSide(final int n) {
        this.setDimension1(n);
        this.setDimension2(n);
    }
    
    public int getSide() {
        return this.getDimension1();
    }
    
    public String toString() {
        return String.format("%s %s: %d\n", super.toString(), "side", this.getSide());
    }
}