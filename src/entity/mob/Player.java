package entity.mob;

import input.Keyboard;

public class Player extends Mob {

    // Variables
    private Keyboard input;

    // Default constructor
    public Player(Keyboard input) {
        this.input = input;
    }

    // Create at specific location
    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //Logic tick
    public void update() {
        if (input.up) { y -= 1; }
        if (input.right) { x += 1; }
        if (input.down) { y += 1; }
        if (input.left) { x -= 1; }
    }

    //Render player
    public void render() {

    }

}
