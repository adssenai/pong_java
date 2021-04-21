package pong;

import abstractions.IApplication;
import application.GameApplication;
public class Main {

    private static IApplication application = new GameApplication();

    public static void main(String[] args) {
        application.Execute();
    }
}
