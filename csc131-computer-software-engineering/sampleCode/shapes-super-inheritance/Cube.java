public class Cube extends ThreeDimensionalShape
{
    public Cube(final int n, final int n2, final int n3) {
        super(n, n2, n3, n3, n3);
    }
    
    public String getName() {
        return "Cube";
    }
    
    public int getArea() {
        return 6 * this.getSide() * this.getSide();
    }
    
    public int getVolume() {
        return this.getSide() * this.getSide() * this.getSide();
    }
    
    public void setSide(final int dimension3) {
        this.setDimension1(dimension3);
        this.setDimension2(dimension3);
        this.setDimension3(dimension3);
    }
    
    public int getSide() {
        return this.getDimension1();
    }
    
    public String toString() {
        return String.format("%s %s: %d\n", super.toString(), "side", this.getSide());
    }
}