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
        int xDistance = 0;
        int yDistance = 0;
        if (input.up) { yDistance -= 1; }
        if (input.right) { xDistance += 1; }
        if (input.down) { yDistance += 1; }
        if (input.left) { xDistance -= 1; }
        if (x != 0 || yDistance != 0) { move(xDistance, yDistance); }
    }

    //Render player
    public void render() {

    }

}
