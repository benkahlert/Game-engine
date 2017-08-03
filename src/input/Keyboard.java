package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    // Keeps track of which keys are pressed
    public boolean up, down, left, right;
    private boolean[] keys = new boolean[120];

    //Update keys array and private booleans
    public void update() {
        up = keys[KeyEvent.VK_UP] || keys[KeyEvent.VK_W];
        right = keys[KeyEvent.VK_RIGHT] || keys[KeyEvent.VK_D];
        down = keys[KeyEvent.VK_DOWN] || keys[KeyEvent.VK_S];
        left = keys[KeyEvent.VK_LEFT] || keys[KeyEvent.VK_A];

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
