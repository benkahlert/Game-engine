package graphics;

import java.util.Random;

public class Screen {

    // Pixels, tiles, and dimensions
    private int width, height;
    public final int MAP_SIZE = 8;
    public final int MAP_SIZE_MASK = MAP_SIZE - 1;
    public int[] pixels;
    public int[] tiles = new int[MAP_SIZE * MAP_SIZE];

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
            int iCopy = i + yOffset;
            //if (iCopy < 0 || iCopy >= height) { break; };
            for (int j = 0; j < width; j++) {
                int jCopy = j + xOffset;
                //if (jCopy < 0 || jCopy >= width) { break; };
                int tileIndex = ((jCopy >> 4) & MAP_SIZE_MASK) + ((iCopy >> 4) & MAP_SIZE_MASK) * MAP_SIZE;
                pixels[j + i * width] = tiles[tileIndex];
            }
        }
    }

    // Clears each pixel
    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

}
