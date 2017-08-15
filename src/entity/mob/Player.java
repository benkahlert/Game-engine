package entity.mob;

import graphics.Screen;
import graphics.Sprite;
import input.Keyboard;

public class Player extends Mob {

    // Variables
    private Keyboard input;
    private Sprite sprite;

    // Default constructor
    public Player(Keyboard input) {
        this.input = input;
        this.sprite = Sprite.playerRight;
    }

    // Create at specific location
    public Player(Keyboard input, int x, int y) {
        this.input = input;
        this.x = x;
        this.y = y;
        this.sprite = Sprite.playerRight;
    }

    // Logic tick
    public void update() {
        int xDistance = 0;
        int yDistance = 0;
        if (input.up) { yDistance -= 1; }
        if (input.right) { xDistance += 1; }
        if (input.down) { yDistance += 1; }
        if (input.left) { xDistance -= 1; }
        if (xDistance != 0 || yDistance != 0) { move(xDistance, yDistance); }
    }

    // Render player
    public void render(Screen screen) {
        if (direction == 1) { this.sprite = Sprite.playerRight; }
        if (direction == 3) { this.sprite = Sprite.playerLeft; }
        screen.renderPlayer(x, y, sprite);
    }

}
