package level;

import graphics.Screen;
import level.tile.Tile;

public class Level {

    // Dimensions and tiles
    protected int width;
    protected int height;
    protected int[] tiles;

    // Constructor for randomly generating a level
    public Level(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new int[width * height];
        generateLevel();
    }

    // Constructor for creating a level using a file path
    public Level(String path) {
        loadLevel(path);
    }

    // Generates a level randomly
    private void generateLevel() {

    }

    // Loads a level using a file path
    private void loadLevel(String path) {

    }

    // Updates the logic of the level
    public void update() {

    }

    // Renders the level
    public void render(int xScroll, int yScroll, Screen screen) {
        int xStart = xScroll >> 4;
        int xEnd = (xScroll + screen.width) >> 4;
        int yStart = yScroll >> 4;
        int yEnd = (yScroll + screen.height) >> 4;
        Tile tile = getTile(xStart, yStart);

    }

    // Gets tile at location
    public Tile getTile(int x, int y) {
        if (tiles[x + y * width] == 0) { return Tile.grass; }
        return Tile.voidTile;
    }

}
