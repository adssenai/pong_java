package application;

import abstractions.IApplication;
import abstractions.*;
import services.Bola;
import services.Game;
import services.Jogador;

public class GameApplication implements IApplication {

    private IBall _ball;
    private IGame _game;
    private IPlayer _one, _two;

    public GameApplication(){
        this._one = new Jogador(10, 25, 1);
        this._two = new Jogador(485, 25, 2);
        this._ball = new Bola(250, 200, _one, _two);
        this._game = new Game(this._ball, this._one, this._two);
    }
    public void Execute(){

        //Thread game = new Thread(_game);
        Thread ball = new Thread(_ball);
        ball.start();
        Thread p1 = new Thread(_one);
        Thread p2 = new Thread(_two);
        p2.start();
        p1.start();
    }
    public void Stop(){

    }
}
