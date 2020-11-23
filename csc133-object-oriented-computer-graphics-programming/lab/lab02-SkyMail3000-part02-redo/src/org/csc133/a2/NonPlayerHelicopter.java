/**
 * NonPlayerHelicopter
 */
public class NonPlayerHelicopter extends Helicopter {
    private IStrategy currStrategy;
	public void setStrategy(IStrategy s) 
	{
		currStrategy = s;
	}
	@Override
	public String toString() {
		return "placeholder";
	}
}