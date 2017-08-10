package entity;

import level.Level;

import java.util.Random;

public abstract class Entity {

    // Location and level
    public int x;
    public int y;
    private boolean removed = false;
    protected Level level;
    protected final Random random = new Random();

    // Logic tick for entity
    public void update() {

    }

    // Render entity
    public void render() {

    }

    // Removes object
    public void remove() {
        this.removed = true;
    }

    // Get removed variable
    public boolean isRemoved() {
        return removed;
    }

}
