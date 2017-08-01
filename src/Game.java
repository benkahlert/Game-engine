import graphics.Screen;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    // Screen dimensions
    public static int width = 320;
    public static int height = (width / 16) * 9;
    public static int scale = 3;

    // Game thread variables
    private Thread gameThread;
    private JFrame frame;
    private boolean running = false;

    //Image & Screen
    private Screen screen;
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private int[] pixels = ((DataBufferInt) (image.getRaster().getDataBuffer())).getData();

    // Initialize game
    public Game() {
        Dimension size = new Dimension(width * scale, height * scale);
        this.setPreferredSize(size);
        screen = new Screen(width, height);
        frame = new JFrame();
    }

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
        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 60.0;
        double delta = 0;
        int frames = 0;
        int updates = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                update();
                updates++;
                delta--;
            }
            render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("Updates: " + updates + ", Frames: " + frames);
                updates = 0;
                frames = 0;
            }
        }
        stop();
    }

    // Logic tick
    public void update() {

    }

    // Graphics tick
    public void render() {
        BufferStrategy bufferStrategy = getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(3);
            return;
        }
        screen.clear();
        screen.render();

        for (int i = 0; i < pixels.length; i++) {
            pixels[i] = screen.pixels[i];
        }

        Graphics graphics = bufferStrategy.getDrawGraphics();

        graphics.drawImage(image, 0, 0, getWidth(), getHeight(), null);

        graphics.dispose();
        bufferStrategy.show();
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
