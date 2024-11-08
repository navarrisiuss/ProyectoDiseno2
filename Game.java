import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    private static GameWindow window;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    private final int FPS = 60;
    private double targetTime = 1000000000/ FPS;
    private double delta = 0;
    private int AVERAGE_FPS = FPS;
    private int FONDO_X = 0;
    private int FONDO_INVERTIDO_X = 0;
    private int FONDO2_X = 0;
    private int FONDO_INVERTIDO2_X = 0;

    public Game() {
        window = new GameWindow();
    }

    private void init() {
        Assets.init();
    }

    private void update() {
        FONDO_X--;
        FONDO_INVERTIDO_X = FONDO_X + Assets.fondoBosque.getWidth();
        FONDO2_X = FONDO_INVERTIDO_X + Assets.fondoBosqueInvertido.getWidth();
        FONDO_INVERTIDO2_X = FONDO2_X + Assets.fondoBosque.getWidth();

        // Carrusel infinito de fondos
        if (FONDO2_X <= 0) {
            FONDO_X = 0;
            FONDO_INVERTIDO_X = FONDO_X + Assets.fondoBosque.getWidth();
            FONDO2_X = FONDO_INVERTIDO_X + Assets.fondoBosqueInvertido.getWidth();
            FONDO_INVERTIDO2_X = FONDO2_X + Assets.fondoBosque.getWidth();
        }

    }

    private void draw() {
        bs = window.getCanvas().getBufferStrategy();
        if (bs == null) {
            window.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        // Clear screen
        g.clearRect(0, 0, window.getCanvas().getWidth(), window.getCanvas().getHeight());
        // Draw here ----------------------------------------------------------------------------------

        g.drawImage(Assets.fondoBosque, FONDO_X, 0, this);
        g.drawImage(Assets.fondoBosqueInvertido, FONDO_INVERTIDO_X, 0, this);
        g.drawImage(Assets.fondoBosque, FONDO2_X, 0, this);


        // End drawing ---------------------------------------------------------------------------------
        g.dispose();
        bs.show();
    }

    private void start() {
        running = true;

        thread = new Thread(this);
        thread.start();
    }

    private void stop() {
        try {
            running = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long now = 0;
        long lastTime = System.nanoTime();
        int frames = 0;
        long timer = 0;

        init();

        while (running) {
            now = System.nanoTime();
            delta += (now - lastTime) / targetTime;
            lastTime = now;

            if (delta >= 1) {
                draw();
                update();
                delta--;
            }

            if (timer >= 1000000000) {
                AVERAGE_FPS = frames;
                frames = 0;
                timer = 0;
            }

        }
        stop();
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
