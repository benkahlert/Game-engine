package graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Spritesheet {

    // URL and dimensions
    private String path;
    public final int SIZE;
    public int[] pixels;

    // Spritesheets
    public static Spritesheet tiles = new Spritesheet("/textures/tiles.png", 256);
    public static Spritesheet player = new Spritesheet("/textures/player.png", 256);

    // Instantiate Spritesheet
    public Spritesheet(String path, int size) {
        this.path = path;
        this.SIZE = size;
        this.pixels = new int[SIZE * SIZE];
        loadImage();
    }

    // Load image into pixels array
    public void loadImage() {
        try {
            BufferedImage image = ImageIO.read(Spritesheet.class.getResource(path));
            int width = image.getWidth();
            int height = image.getHeight();
            image.getRGB(0, 0, width, height, pixels, 0, width);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
