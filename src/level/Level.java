package level;

import graphics.Screen;

public class Level {

    private int width;
    private int height;
    private int[] tiles;

    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new int[width * height];
        generateLevel();
    }

    public Level(String path) {
        loadLevel(path);
    }

    private void generateLevel() {

    }

    private void loadLevel(String path) {

    }

    public void update() {

    }

    public void render(int xScroll, int yScroll, Screen screen) {

    }

}
