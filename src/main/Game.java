package main;

// It consists all the other classes like player, enemies, level, handlers and game loop
public class Game {

    private GameWindow gameWindow; // used to render game window
    private GamePanel gamePanel; // used to render graphics inside game window

    public Game(){
        System.out.println("I am alive");

        gamePanel = new GamePanel(); // create GamePanel object
        gameWindow = new GameWindow(gamePanel); // create GameWindow object, passing gamePanel to attach gameWindow with gamePanel

    }
}
