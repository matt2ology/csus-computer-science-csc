public abstract class TwoDimensionalShape extends Shape
{
    private int dimension1;
    private int dimension2;
    
    public TwoDimensionalShape(final int n, final int n2, final int dimension1, final int dimension2) {
        super(n, n2);
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
    }
    
    public void setDimension1(final int dimension1) {
        this.dimension1 = dimension1;
    }
    
    public void setDimension2(final int dimension2) {
        this.dimension2 = dimension2;
    }
    
    public int getDimension1() {
        return this.dimension1;
    }
    
    public int getDimension2() {
        return this.dimension2;
    }
    
    public abstract int getArea();
}