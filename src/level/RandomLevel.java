package level;

import java.util.Random;

public class RandomLevel extends Level {

    private final Random random = new Random();

    RandomLevel(int width, int height) {
        super(width, height);
    }

    private void generateLevel() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[j + i * width] = random.nextInt(tiles.length);
            }
        }
    }

}
