package org.csc133.a2;

import java.util.Observer;
import java.util.Observable;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Point;
import com.codename1.ui.plaf.Border;

/**
 * <h1><code>MapView</code></h1>
 * <p>
 * Will also display the contents of the game graphically in the container in
 * the middle of the game screen (in addition to displaying it in the text form
 * on the console)
 * </p>
 * <br>
 * <br>
 * When the MapView update() is invoked, it should call repaint() on itself. As
 * described in the lecture, one way to implement this is to have MapView
 * override paint(), which will be invoked as a result of calling repaint(). It
 * is then the duty of paint() to iterate through the game objects invoking
 * draw() in each object – thus redrawing all the objects in the world in the
 * container. Note that paint() must have access to the GameWorld. That means
 * that the reference to the GameWorld must be saved when MapView is
 * constructed,+ or alternatively the update() method must save it prior to
 * calling repaint(). Note that the modified MapView class communicates with the
 * rest of the program exactly as it did previously (e.g., it is an observer of
 * GameWorld).
 */
public class MapView extends Container implements Observer {
    private IIterator gi;
    private GameWorldProxy gwp;
    private GameObjectCollection gameObjectCollection;

    public MapView(GameWorldProxy gwp) {
        this.gwp = gwp;
        this.gameObjectCollection = this.gwp.getCollection();
        this.gi = this.gameObjectCollection.getIterator();
        this.getAllStyles().setBorder(Border.createLineBorder(2, ColorUtil.BLACK));
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        while (this.gi.hasNext()) {
            GameObject go = this.gi.getNext();
            Point pCmpRelPrnt = new Point(this.getX(), this.getY());
            go.draw(g, pCmpRelPrnt);
        }

    }

    @Override
    public void update(Observable o, Object arg) {
        IGameWorld gw = (IGameWorld) arg;
        this.gameObjectCollection = gw.getCollection();
        this.gi = this.gameObjectCollection.getIterator();
        this.repaint();
    }
}
