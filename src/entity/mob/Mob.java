package entity.mob;

import entity.Entity;
import graphics.Sprite;

public abstract class Mob extends Entity {

    // Sprite and direction variables
    protected Sprite sprite;
    protected int direction = 0;
    protected boolean moving = false;

    // Move mob
    public void move() {

    }

    // Update tick for mob
    public void update() {

    }

    // Returns if mob is colliding
    private boolean collision() {
        return false;
    }

}
