package main;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

// GamePanel allows us to draw on the screen and we can do that using JPanel(Part of JFrame collection)
// Analogy -> Just like a painting, the wooden frame is the JFrame and the actual painting ing JPanel
public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private Color color; // set color of the recangle
    private Random random; // generates random number used to get random colors

    private double xDelta, yDelta; // expects new x, y axis values
    private int frames; // used to calculate fps
    private long lastCheck; // used to calculate pfs
    private double xDir, yDir; // used for visuals

    public GamePanel(){
        mouseInputs = new MouseInputs(this); // passing gamePanel so that, it can repaint with the new values4
        color = new Color(0, 0, 0); // initializing color object
        random = new Random(); // initializing random object

        xDelta = yDelta = 100; // used to move the paint
        xDir = yDir = 0.1; // works as an inverter
        lastCheck = frames = 0;

        addKeyListener(new KeyboardInputs(this)); // Listens to keyboard inputs, passed gamePanel to repaint
        addMouseListener(mouseInputs); // Listens to mouse inputs
        addMouseMotionListener(mouseInputs); // Listens to mouse inputs (Motion)
    }

    public void changeXDelta(int value){
        this.xDelta += value; // adding new value to xDelta
//        repaint(); // repaints as per the new value
    }

    public void changeYDelta(int value){
        this.yDelta += value; // adding new value to yDelta
//        repaint(); // repaints as per the new value
    }

    // sets the new position with new x and new y
    public void setRectPos(int x, int y){
        this.xDelta = x; // setting new XDelta value
        this.yDelta = y; // setting new YDelta value

        // repaint() technically calling paintComponent
//        repaint(); // repaints as per the new values
    }

    /**
     * we never call paintComponent directly. It gets call whenever we press play button
     * JPanel cant draw, so we need Graphics object to draw.
     * Analogy -> Like a paint brush
     */
    public void paintComponent(Graphics g){
        // calling JComponents paintComponent method. JComponent -> JPanel -> GamePanel
        // It basically does the cleaning, so that the painting can render without any glitch
        super.paintComponent(g);

//        g.fillRect(100 + xDelta, 100 + yDelta, 200, 50);
        updateRectangle(); // creates a visual

        g.setColor(color); // set color of the rectangle
        g.fillRect((int) xDelta, (int) yDelta, 200, 50);

        // fps counter
        // 1000 ms = 1s
        frames++;
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }

        /*
         * Using repaint() in paintComponent method creates a bad game loop which makes the game really inconsistent
         * This game loop uses large fps when the window is small and uses low fps when the window is big
         * This way all characters or other elements will move differently at different times
         * So, we need a good game loop where we can actually stabilize the elements and can set how many frames we want /s
         */
        repaint();
    }

    // creates visuals
    private void updateRectangle() {
        xDelta += xDir;

        // ensues position of the rectangle inside the game window
        if(xDelta > 400 || xDelta < 0){
            xDir *= -1;
            color = getRandomColor(); // sets the random color when ever element change its x axis
        }

        yDelta += yDir;
        // ensures position of the rectangle inside the game window
        if(yDelta > 400 || yDelta < 0){
            yDir *= -1;
            color = getRandomColor(); // sets the random color when ever element change its y axis
        }
    }

    // generates a random color using random int numbers
    private Color getRandomColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r, g, b);
    }
}
