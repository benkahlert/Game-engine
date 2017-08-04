package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    // Keeps track of which keys are pressed
    public boolean up, down, left, right;
    private boolean[] keys = new boolean[120];

    //Update keys array and private booleans
    public void update() {
        up = keys[KeyEvent.VK_UP];
        right = keys[KeyEvent.VK_RIGHT];
        down = keys[KeyEvent.VK_DOWN];
        left = keys[KeyEvent.VK_LEFT];

        for (int i = 0; i < keys.length; i++) {

        }
    }

    public void keyTyped(KeyEvent e) {

    }

    // Key initially pressed
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    // Key released
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }
}
