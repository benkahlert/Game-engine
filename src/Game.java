public class Game {

    public static int width = 300;
    public static int height = (width / 16) * 9;
    public static int scale = 3;

    private Thread gameThread;

    public synchronized void start() {
        gameThread = new Thread();
    }

}
