public abstract class Shape
{
    private int x;
    private int y;
    
    public Shape(final int x, final int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setX(final int x) {
        this.x = x;
    }
    
    public void setY(final int y) {
        this.y = y;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    @Override
    public String toString() {
        return String.format("[%d, %d]", this.getX(), this.getY());
    }
    
    public abstract String getName();
}