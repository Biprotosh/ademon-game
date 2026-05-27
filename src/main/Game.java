package main;

import javax.swing.*;

// It consists all the other classes like player, enemies, level, handlers and game loop
public class Game implements Runnable{

    private GameWindow gameWindow; // used to render game window
    private GamePanel gamePanel; // used to render graphics inside game window
    private Thread gameThread;

    private final int FPS_SET = 120; // we want our game to run at 120 frames per second

    public Game(){
        System.out.println("I am alive");

        gamePanel = new GamePanel(); // create GamePanel object
        gameWindow = new GameWindow(gamePanel); // create GameWindow object, passing gamePanel to attach gameWindow with gamePanel
        gamePanel.requestFocus(); // gets input focus
        startGameLoop();
    }

    private void startGameLoop(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() { // the actual game loop
        double timePerFrame = 1000000000.0 / FPS_SET; // calculating how long a frame should last
        long lastFrame = System.nanoTime(); // it stores the time of lastFrame
        long now;

        while (true){
            now = System.nanoTime();
            if(now - lastFrame >= timePerFrame){
                // it is time for another frame
                gamePanel.repaint();
                lastFrame = now;
            }
        }
    }
}
