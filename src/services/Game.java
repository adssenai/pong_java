package services;

import abstractions.*;

import java.awt.*;
import javax.swing.JFrame;

public class Game extends JFrame implements IGame, IDrawable {

    int x, y, xDirection, yDirection;

    Rectangle bola;


    private static final long serialVersionUID = 1L;

    int gWidth = 500;
    int gHeight = 400;
    Dimension screenSize = new Dimension(gWidth, gHeight);

    Image dbImage;
    Graphics dbGraphics;

    static boolean jogo = true;
    boolean gameOver;

    private IBall _ball;

    public IPlayer _one;
    public IPlayer _two;



    public Game(IBall ball, IPlayer one, IPlayer two) {

        this._one = one;
        this._two = two;
        this._ball = ball;
        this.setTitle("Pong!");
        this.setSize(screenSize);
        this.setResizable(false);
        this.setVisible(true);
        this.setBackground(Color.DARK_GRAY);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(new AL(this._one, this._two));
        this.bola = _ball.getRectangle();
    }
    /*
    @Override
    public void run() {
        try {
            while (Game.isJogo()) {
                moveBall();
                _ball.draw(dbGraphics);
                Thread.sleep(8);
            }
        } catch (Exception e) {
            Game.setJogo(false);
        }

    }
     */
    @Override
    public void paint(Graphics g) {
        dbImage = createImage(getWidth(), getHeight());
        dbGraphics = dbImage.getGraphics();
        draw(dbGraphics);
        g.drawImage(dbImage, 0, 0, this);
    }

    public void draw(Graphics g) {
        _ball.draw(g);
        _one.draw(g);
        _two.draw(g);
        getScore(g);
        repaint();
    }

    private void getScore(Graphics g) {
        int p1ponto = _ball.getScore(0);
        int p2ponto = _ball.getScore(1);
        g.setColor(Color.WHITE);
        g.drawString("Jogador 1 " + p1ponto , 40, 40);
        g.drawString("Jogador 2 " + p2ponto, 385, 40);
        g.setColor(Color.WHITE);
        if (p1ponto >= 6 || p2ponto >= 6) {
            setJogo(false);
            gameOver = true;
        }
        if (gameOver)
            g.drawString("Game Over", 200, 200);
        g.setColor(Color.WHITE);
    }

    public static boolean isJogo() {
        return jogo;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public static void setJogo(boolean jogo) {
        jogo = jogo;
    }
}
