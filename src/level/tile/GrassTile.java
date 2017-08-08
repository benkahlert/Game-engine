package level.tile;

import graphics.Screen;
import graphics.Sprite;

public class GrassTile extends Tile {

    // Instantiate GrassTile
    public GrassTile(Sprite sprite) {
        super(sprite);
    }

    // Actually render the tile
    public void render(int x, int y, Screen screen) {
        screen.renderTile(x << 4, y << 4, this);
    }

}
