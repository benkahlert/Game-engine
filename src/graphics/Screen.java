package graphics;

import level.tile.Tile;

import java.util.Random;

public class Screen {

    // Pixels, tiles, and dimensions
    public int width;
    public int height;
    public final int MAP_SIZE = 16;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int[] pixels;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
    public int xOffset;
    public int yOffset;

    private Random random = new Random();

    // Instantiate screen with given height and width
    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels =  new int[width * height];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = random.nextInt(0xffffff);
        }
    }

    // Renders the screen's pixels
    public void render(int xOffset, int yOffset) {
        for (int i = 0; i < height; i++) {
            int iOffset = i + yOffset;
            if (iOffset < 0 || iOffset >= height) { continue; }
            for (int j = 0; j < width; j++) {
                int jOffset = j + xOffset;
                if (jOffset < 0 || jOffset >= width) { continue; }
                pixels[(jOffset) + (iOffset) * width] = Sprite.grass.pixels[(j & 15) + (i & 15) * Sprite.grass.SIZE];
            }
        }
    }

    // Renders tiles
    public void renderTile(int x, int y, Tile tile) {
        x -= xOffset;
        y -= yOffset;
        for (int i = 0; i < tile.sprite.SIZE; i++) {
            int yAbs = i + y;
            for (int j = 0; j < tile.sprite.SIZE; j++) {
                int xAbs = j + x;
                if (xAbs < 0 || xAbs >= width || yAbs < 0 || yAbs >= height) { break; }
                pixels[xAbs + yAbs * width] = tile.sprite.pixels[x + y * tile.sprite.SIZE];
            }
        }
    }

    // Clears each pixel
    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

    public void setOffsets(int xOffset, int yOffset) {
        this.xOffset = xOffset;
        this.yOffset = yOffset;
    }

}
