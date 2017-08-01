package graphics;

import java.awt.*;

public class Screen {

    private int width, height;
    public int[] pixels;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
        pixels =  new int[width * height];
    }

    public void render() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                pixels[j + i * width] = 0xff00ff;
            }
        }
    }

    public void clear() {
        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = 0;
        }
    }

}
