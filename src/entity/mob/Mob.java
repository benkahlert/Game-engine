package entity.mob;

import entity.Entity;
import graphics.Sprite;

public abstract class Mob extends Entity {

    // Sprite and direction variables
    protected Sprite sprite;
    protected int direction = 0;
    protected boolean moving = false;

    // Move mob
    public void move(int xChange, int yChange) {
        if (xChange > 0) { direction = 1; }
        if (xChange < 0) { direction = 3; }

        if (!collision()) {
            x += xChange;
            y += yChange;
        }
    }

    // Update tick for mob
    public void update() {

    }

    // Render mob
    public void render() {

    }

    // Returns if mob is colliding
    private boolean collision() {
        return false;
    }

}
