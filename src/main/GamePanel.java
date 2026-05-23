package main;

import javax.swing.*;
import java.awt.*;

// GamePanel allows us to draw on the screen and we can do that using JPanel(Part of JFrame collection)
// Analogy -> Just like a painting, the wooden frame is the JFrame and the actual painting ing JPanel
public class GamePanel extends JPanel {

    public GamePanel(){

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

        g.drawRect(100, 100, 200, 50);
        g.fillRect(210, 200, 200, 50);
        g.fill3DRect(400, 400, 200, 50, false);
    }
}
