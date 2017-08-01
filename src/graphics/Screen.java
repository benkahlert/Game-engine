package graphics;

import java.util.Random;

public class Screen {

    // Pixels, tiles, and dimensions
    private int width, height;
    public int[] pixels;
    public int[] tiles = new int[64 * 64];

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
    public void render() {
        for (int i = 0; i < height; i++) {
            if (i < 0 || i >= height) { break; };
            for (int j = 0; j < width; j++) {
                if (j < 0 || j >= width) { break; };
                int tileIndex = (j >> 4) + (i >> 4) * 64;
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
