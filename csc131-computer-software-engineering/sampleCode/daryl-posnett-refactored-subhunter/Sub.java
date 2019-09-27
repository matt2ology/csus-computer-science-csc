/**
 * Sub extends the abstract state to represent the state for each cell.
 */
public class Sub extends AbstractGridCell{
    /**
     * @author Daryl Posnett, Ph.D.
     * @param myCell
     */
    public Sub(AbstractGridCell myCell) {
        super(myCell);
    }
    
    /**
     * @author Daryl Posnett, Ph.D.
     * @return new SunkSub(this);
     */
    public AbstractGridCell takeShot() {
        return new SunkSub(this);
    }
}