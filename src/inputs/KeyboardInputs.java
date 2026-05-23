package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Used for keyboard inputs
public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel; // we want gamePanel because we are moving the drawing

    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
//        System.out.println("A key is pressed");
        switch (e.getKeyChar()){
            case 'w' :
                System.out.println("w is pressed");
                gamePanel.changeYDelta(-5); // up, we have to subtract as Y axis works opposite in computers
                break;
            case 'a' :
                System.out.println("a is pressed");
                gamePanel.changeXDelta(-5); // left
                break;
            case 's' :
                System.out.println("s is pressed");
                gamePanel.changeYDelta(5); // down
                break;
            case 'd' :
                System.out.println("d  is pressed");
                gamePanel.changeXDelta(5); // right
                break;
        }
    }
}
