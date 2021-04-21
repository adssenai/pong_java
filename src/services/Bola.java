package services;

import abstractions.IBall;
import abstractions.IPlayer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Bola implements IBall {
    int x, y, xDirection, yDirection;
    Graphics dbGraphics;

    private Rectangle _bola;
    int p1ponto, p2ponto;
    private IPlayer _one, _two;

    public int getScore(int playerIndex){
        int [] scores = {p1ponto, p2ponto};;
        return scores[playerIndex];
    }

    public Bola(int xBall, int yBall, IPlayer one, IPlayer two) {
        p1ponto = p2ponto = 0;
        this.x = xBall;
        this.y = yBall;
        this._one = one;
        this._two = two;

        Random r = new Random();
        moveBola(r);

        this._bola = new Rectangle(this.x, this.y, 15, 15);
    }
    public void setRectangle(Rectangle rectangle){
        this._bola = rectangle;
    }
    public Rectangle getRectangle() {
        return this._bola;
    }



    private void moveBola(Random r) {
        int rXDir = r.nextInt(1);
        if (rXDir == 0)
            rXDir--;
        setxDirection(rXDir);
        int rYDir = r.nextInt(1);
        if (rYDir == 0)
            rYDir--;
        setyDirection(rYDir);
    }
    @Override
    public void run() {
        try {
            while (Game.isJogo()) {
                moveBall();
                Thread.sleep(8);
            }
        } catch (Exception e) {
            Game.setJogo(false);
        }

    }
    private void moveBall() {
        colisao();
        _bola.x += xDirection;
        _bola.y += yDirection;

        if (_bola.x <= 0) {
            setxDirection(+1);
            p2ponto++;
            _bola.setLocation(x, y);
        }
        if (_bola.x >= 485) {
            setxDirection(-1);
            p1ponto++;
            _bola.setLocation(x, y);
        }
        if (_bola.y <= 15) {
            setyDirection(+1);
        }
        if (_bola.y >= 385) {
            setyDirection(-1);
        }
        setRectangle(_bola);
    }


    private void colisao() {
        if(_bola.intersects(_one.getRectangle()))
            setxDirection(+1);
        if(_bola.intersects(_two.getRectangle()))
            setxDirection(-1);
    }

    public void draw(Graphics gb) {
        gb.setColor(Color.WHITE);
        gb.fillOval(_bola.x, _bola.y, 15, 15);
    }

    public void setxDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public void setyDirection(int yDirection) {
        this.yDirection = yDirection;
    }
}
