public abstract class ThreeDimensionalShape extends Shape
{
    private int dimension1;
    private int dimension2;
    private int dimension3;
    
    public ThreeDimensionalShape(final int n, final int n2, final int dimension1, final int dimension2, final int dimension3) {
        super(n, n2);
        this.dimension1 = dimension1;
        this.dimension2 = dimension2;
        this.dimension3 = dimension3;
    }
    
    public void setDimension1(final int dimension1) {
        this.dimension1 = dimension1;
    }
    
    public void setDimension2(final int dimension2) {
        this.dimension2 = dimension2;
    }
    
    public void setDimension3(final int dimension3) {
        this.dimension3 = dimension3;
    }
    
    public int getDimension1() {
        return this.dimension1;
    }
    
    public int getDimension2() {
        return this.dimension2;
    }
    
    public int getDimension3() {
        return this.dimension3;
    }
    
    public abstract int getArea();
    
    public abstract int getVolume();
}