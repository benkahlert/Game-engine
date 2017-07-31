import javax.swing.*;
import java.awt.*;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    // Screen dimensions
    public static int width = 300;
    public static int height = (width / 16) * 9;
    public static int scale = 3;

    // Initialize game
    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        this.setPreferredSize(size);
        frame = new JFrame();
    }

    // Game thread variables
    private Thread gameThread;
    private JFrame frame;
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

    // Create game instance and configure frame
    public static void main(String[] args) {
        Game game = new Game();
        game.frame.setResizable(false);
        game.frame.setTitle("Rain");
        game.frame.add(game);
        game.frame.pack();
        game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        game.frame.setLocationRelativeTo(null);
        game.frame.setVisible(true);
        game.start();
    }

}
