package level;

import java.util.Random;

public class RandomLevel extends Level {

    private static final Random random = new Random();

    // Calls Level constructor
    public RandomLevel(int width, int height) {
        super(width, height);
        generateLevel();
    }

    // Generates a level
    private void generateLevel() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                tiles[j + i * width] = random.nextInt(4);
            }
        }
    }

}
