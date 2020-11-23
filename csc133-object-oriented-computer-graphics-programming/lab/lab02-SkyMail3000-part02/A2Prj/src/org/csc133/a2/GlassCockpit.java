package org.csc133.a2;

import java.util.Observer;
import java.util.Observable;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.FlowLayout;

public class GlassCockpit extends Container implements Observer {

    private GameWorldProxy gwp;

    private Label scoreLabel;

    private Label clockLabel;

    private Label lifeLabel;

    public PointsView(IGameWorld gwp) {
		
		this.gwp = (GameWorldProxy)gwp;

		
		this.setLayout(new FlowLayout()); // Set a box layout. 
		
		/* Initially create the labels and set them */
		this.scoreLabel = new Label("Score: " + this.gwp.getScore());

		this.clockLabel = new Label("Elapsed Time: " + this.gwp.getClock());

		this.lifeLabel = new Label("Lives: " + this.gwp.getLives());
		
		
		/* Add all components to the container */
		this.add(this.scoreLabel);

		this.add(this.clockLabel);

		this.add(this.lifeLabel);
				
	}

    public void update(Observable o, Object arg) {

        IGameWorld gw = (IGameWorld) arg;

        this.scoreLabel.setText("Score: " + gw.getScore());

        this.clockLabel.setText("Elapsed Time: " + gw.getClock());

        this.lifeLabel.setText("Lives: " + gw.getLives());

        this.repaint();
    }

}
