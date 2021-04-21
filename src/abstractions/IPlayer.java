package abstractions;

import java.awt.event.KeyEvent;
import java.awt.*;

public interface IPlayer extends Runnable, IDrawable{

    Rectangle getRectangle();
    void keyPressed(KeyEvent e);
    void keyReleased(KeyEvent e);
}
