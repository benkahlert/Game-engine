public class Game implements Runnable {

    // Screen dimensions
    public static int width = 300;
    public static int height = (width / 16) * 9;
    public static int scale = 3;

    // Game thread variables
    private Thread gameThread;
    private boolean running = false;

    // Start game thread
    public synchronized void start() {
        this.running = true;
        this.gameThread = new Thread(this, "Display");
        this.gameThread.start();
    }

    // Stop game thread
    public synchronized void stop() {
        this.running = false;
        try {
            this.gameThread.join();
        } catch (InterruptedException exception) {
            exception.printStackTrace();
        }
    }

    // Run method from Runnable interface for threads
    public void run() {
        while (running) {

        }
    }

}
