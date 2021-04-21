package abstractions;

import java.awt.*;

public interface IBall extends Runnable, IDrawable{
    int getScore(int playerIndex);
    Rectangle getRectangle();
    void setRectangle(Rectangle rectangle);
    void setxDirection(int xDirection);
    void setyDirection(int yDirection);
}
