package level.tile;

import graphics.Screen;
import graphics.Sprite;

public class VoidTile extends Tile {

    // Instantiate void tile
    public VoidTile(Sprite sprite) {
        super(sprite);
    }

    // Renders the tile
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x, y, this);
    }

}
