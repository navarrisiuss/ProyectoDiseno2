import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    private static GameWindow window;
    private Thread thread;
    private boolean running = false;
    private BufferStrategy bs;
    private Graphics g;
    private final int FPS = 60;
    private double delta = 0;
    private int FONDO_X = 0;
    private int FONDO_INVERTIDO_X = 0;
    private int FONDO2_X = 0;
    private int VELOCIDAD_FONDO = 2;
    private int DISTANCIA_RECORRIDA = 0;
    private KeyHandler keyHandler = new KeyHandler();
    private Dinosaurio dinosaurio = new Dinosaurio();
    private GameState gameState = GameState.getInstance();

    public Game() {
        window = new GameWindow();
        window.getCanvas().addKeyListener(keyHandler);
    }

    private void init() {
        Assets.init();
    }

    private void update() {
        DISTANCIA_RECORRIDA += VELOCIDAD_FONDO;
        FONDO_X -= VELOCIDAD_FONDO;
        FONDO_INVERTIDO_X = FONDO_X + Assets.fondoBosque.getWidth();
        FONDO2_X = FONDO_INVERTIDO_X + Assets.fondoBosqueInvertido.getWidth();

        // Carrusel infinito de fondos
        if (FONDO2_X <= 0) {
            FONDO_X = 0;
            FONDO_INVERTIDO_X = FONDO_X + Assets.fondoBosque.getWidth();
            FONDO2_X = FONDO_INVERTIDO_X + Assets.fondoBosqueInvertido.getWidth();
        }

        dinosaurio.update();

        if (keyHandler.up) {
            dinosaurio.saltar();
        }
        if (keyHandler.down) {

        }

        gameState.setCurrentScore((gameState.getCurrentScore() + VELOCIDAD_FONDO));
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
        dinosaurio.render(g);
        g.drawRect(window.getCanvas().getWidth() - 100, 0, 100, 40);
        g.drawString("Score: " + gameState.getCurrentScore() / 10, window.getCanvas().getWidth() - 80, 25);

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
            double targetTime = (double) 1000000000 / FPS;
            delta += (now - lastTime) / targetTime;
            lastTime = now;

            if (delta >= 1) {
                draw();
                update();
                delta--;
            }

            if (timer >= 1000000000) {
                int AVERAGE_FPS = frames;
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
