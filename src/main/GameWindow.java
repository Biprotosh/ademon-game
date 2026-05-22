package main;

import javax.swing.*;

// Creation of game window where graphics are rendered
public class GameWindow{

    private JFrame jframe; // JFrame object

    public GameWindow(){
        jframe = new JFrame(); // initializing jframe

        jframe.setSize(750, 600); // window is 400x400 size
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // we have to tell jframe explicitly to close the window when close button in pressed
        jframe.setVisible(true); // used to see the window. (setVisible is false by default)
    }
}
