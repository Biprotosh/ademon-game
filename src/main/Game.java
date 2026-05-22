package main;

// It consists all the other classes like player, enemies, level, handlers and game loop
public class Game {

    private GameWindow gameWindow; // creation of gameWindow object

    public Game(){
        System.out.println("I am alive");

        gameWindow = new GameWindow(); // initializing gameWindow object

    }
}
