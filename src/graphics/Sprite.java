package graphics;

public class Sprite {

    // Size and other
    public final int SIZE;
    private int x;
    private int y;
    public int[] pixels;
    private Spritesheet spritesheet;

    // Sprites
    public static Sprite grass = new Sprite(16, 0, 0, Spritesheet.tiles);
    public static Sprite voidSprite = new Sprite(16, 0xffaaaa);

    // Instantiate new Sprite object
    Sprite(int size, int x, int y, Spritesheet spritesheet) {
        this.SIZE = size;
        this.x = x;
        this.y = y;
        this.spritesheet = spritesheet;
        this.pixels = new int[SIZE * SIZE];
        loadImage();
    }

    // Instantiate void sprite
    public Sprite(int size, int color) {
        this.SIZE = size;
        this.pixels = new int[SIZE * SIZE];
        setColor(color);
    }

    // Sets color of a sprite
    private void setColor(int color) {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = color;
        }
    }

    // Load the image's pixels
    private void loadImage() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                pixels[j + i * SIZE] = spritesheet.pixels[(j + this.x) + (i + this.y) * spritesheet.SIZE];
            }
        }
    }

}
