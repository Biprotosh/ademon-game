package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

// Used for keyboard inputs
public class KeyboardInputs implements KeyListener {
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
                break;
            case 'a' :
                System.out.println("a is pressed");
                break;
            case 's' :
                System.out.println("s is pressed");
                break;
            case 'd' :
                System.out.println("d  is pressed");
                break;
        }
    }
}
