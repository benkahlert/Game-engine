package graphics;

public class Screen {

    // Pixels and dimensions
    private int width, height;
    public int[] pixels;

    // Instantiate screen with given height and width
    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels =  new int[width * height];
    }

    // Renders the screen's pixels
    public void render() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[j + i * width] = 0xff00ff;
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
