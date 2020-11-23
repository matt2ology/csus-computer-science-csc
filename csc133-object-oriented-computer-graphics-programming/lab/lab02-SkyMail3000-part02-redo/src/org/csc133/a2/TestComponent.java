package org.csc133.a2;


import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Component;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;


/**
 * TestComponent
 */
public class TestComponent extends Component {
    private int xPosition = 5;
    private int yPosition = 5;
    private int width = 50;
    private int height = 50;
    
    public TestComponent() {
        super();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(ColorUtil.BLUE);
        g.fillRect(xPosition, yPosition, width, height);
        calcPreferredSize();
    }
    @Override
    protected Dimension calcPreferredSize() {
        return new Dimension((4*xPosition)+width,(4*yPosition)+height);
    }
}