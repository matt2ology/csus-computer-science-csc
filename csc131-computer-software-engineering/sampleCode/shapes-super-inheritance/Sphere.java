public class Sphere extends ThreeDimensionalShape
{
    public Sphere(final int n, final int n2, final int n3) {
        super(n, n2, n3, n3, n3);
    }
    
    public String getName() {
        return "Sphere";
    }
    
    public int getArea() {
        return (int)(12.566370614359172 * this.getRadius() * this.getRadius());
    }
    
    public int getVolume() {
        return (int)(4.1887902047863905 * this.getRadius() * this.getRadius() * this.getRadius());
    }
    
    public void setRadius(final int dimension3) {
        this.setDimension1(dimension3);
        this.setDimension2(dimension3);
        this.setDimension3(dimension3);
    }
    
    public int getRadius() {
        return this.getDimension1();
    }
    
    public String toString() {
        return String.format("%s %s: %d\n", super.toString(), "radius", this.getRadius());
    }
}