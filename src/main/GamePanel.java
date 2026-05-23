package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

// GamePanel allows us to draw on the screen and we can do that using JPanel(Part of JFrame collection)
// Analogy -> Just like a painting, the wooden frame is the JFrame and the actual painting ing JPanel
public class GamePanel extends JPanel {

    private MouseInputs mouseInputs;
    private int xDelta, yDelta; // expects new x, y axis values

    public GamePanel(){
        mouseInputs = new MouseInputs();
        xDelta = yDelta = 0; // 0, cause we want to move the paint from the place it sits

        addKeyListener(new KeyboardInputs(this)); // Listens to keyboard inputs, passed gamePanel to repaint
        addMouseListener(mouseInputs); // Listens to mouse inputs
        addMouseMotionListener(mouseInputs); // Listens to mouse inputs (Motion)
    }

    public void changeXDelta(int value){
        this.xDelta += value; // adding new value to xDelta
        repaint(); // repaints with the new value
    }

    public void changeYDelta(int value){
        this.yDelta += value; // adding new value to yDelta
        repaint(); // repaints with the new value
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

        g.fillRect(100 + xDelta, 100 + yDelta, 200, 50);
    }
}
