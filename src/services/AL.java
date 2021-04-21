package services;

import abstractions.IPlayer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class AL extends KeyAdapter{
    private IPlayer _one, _two;

    public AL(IPlayer one, IPlayer two){
        this._one = one;
        this._two = two;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        _one.keyPressed(e);
        _two.keyPressed(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        _one.keyReleased(e);
        _two.keyReleased(e);
    }
}
