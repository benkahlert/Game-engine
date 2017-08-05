package level.tile;

import graphics.Screen;
import graphics.Sprite;

public class Tile {

    // Coordinates and sprite
    public int x;
    public int y;
    public Sprite sprite;

    // Creates a tile with the given sprite
    Tile(Sprite sprite) {
        this.sprite = sprite;
    }

    // Renders the tile
    public void render(int x, int y, Screen screen) {

    }

    public boolean solid() {
        return false;
    }

}
