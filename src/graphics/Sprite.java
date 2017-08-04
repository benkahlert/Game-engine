package graphics;

public class Sprite {

    // Size and other
    public final int SIZE;
    private int x;
    private int y;
    public int[] pixels;
    private Spritesheet spritesheet;

    // Sprite
    public static Sprite grass = new Sprite(16, 0, 0, Spritesheet.tiles);

    // Instantiate new Sprite object
    Sprite(int size, int x, int y, Spritesheet spritesheet) {
        this.SIZE = size;
        this.x = x;
        this.y = y;
        this.spritesheet = spritesheet;
        this.pixels = new int[SIZE * SIZE];
        loadImage();
    }

    private void loadImage() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                pixels[j + i * SIZE] = spritesheet.pixels[(j + this.x) + (y + this.y) * spritesheet.SIZE];
            }
        }
    }

}
