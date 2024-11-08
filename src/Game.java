
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {

    private Thread thread;
    private boolean running = false;
    private final List<Obstacle> obstacles; // Lista de obstáculos en pantalla
    private final ObstacleFactory factory; // Fábrica para crear obstáculos
    private final GameState gameState; // Estado del juego
    private Pterosaurio player; // Personaje controlado por el jugador
    private Random random; // Generador de números aleatorios
    private int backgroundX = 0; // Posición del fondo para desplazamiento

    public Game() {
        // Configuración de la ventana
        JFrame frame = new JFrame("Dino Run");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        // Inicializar elementos del juego
        this.obstacles = new ArrayList<>();
        this.random = new Random();
        this.factory = new DesertObstacleFactory(); // Cambia según la temática
        this.player = new Pterosaurio(100, 500); // Inicializa el personaje
        this.gameState = GameState.getInstance(); // Usa el Singleton de GameState
        gameState.startGame(); // Inicia el estado del juego

        addKeyListener(this); // Escucha eventos de teclado
        setFocusable(true);
    }

    @Override
    public void run() {
        final int TARGET_FPS = 144; // Tasa de fotogramas deseada
        final long FRAME_TIME = 1000000000 / TARGET_FPS; // Tiempo por fotograma en nanosegundos

        Assets.init(); // Cargar recursos del juego
        createBufferStrategy(3); // Triple buffering para suavidad
        BufferStrategy bs = getBufferStrategy();

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        int frames = 0;

        while (running) {
            long now = System.nanoTime();
            long elapsedTime = now - lastTime;

            if (elapsedTime >= FRAME_TIME) {
                update(); // Actualiza lógica del juego
                render(bs); // Renderiza el juego
                lastTime = now; // Reinicia el temporizador
                frames++;
            }

            // Opcional: Mostrar FPS en consola para depuración
            if (System.currentTimeMillis() - timer > 1000) {
                System.out.println("FPS: " + frames);
                frames = 0;
                timer += 1000;
            }
        }
    }


    private void update() {
        if (!gameState.isGameActive()) {
            return;
        }

        // Movimiento del fondo
        backgroundX -= 1; // Reduce la velocidad del fondo
        if (backgroundX <= -getWidth()) {
            backgroundX = 0;
        }

        // Actualizar el jugador
        player.update();

        // Generar nuevos obstáculos
        if (random.nextInt(100) < 5) {
            String[] types = {"Cactus", "Bird"};
            String type = types[random.nextInt(types.length)];
            obstacles.add(factory.createObstacle(type));
        }

        // Actualizar posición de los obstáculos
        for (int i = 0; i < obstacles.size(); i++) {
            Obstacle obstacle = obstacles.get(i);
            obstacle.updatePosition();

            // Eliminar obstáculos fuera de pantalla
            if (obstacle.getX() + obstacle.getWidth() < 0) {
                obstacles.remove(i);
                i--;
            }
        }

        // Incrementar el puntaje
        gameState.setCurrentScore(gameState.getCurrentScore() + 1);
    }

    private void render(BufferStrategy bs) {
        do {
            try {
                Graphics g = bs.getDrawGraphics();

                // Dibujar fondo desplazado con la imagen fondoBosque
                g.drawImage(Assets.fondoBosque, backgroundX, 0, getWidth(), getHeight(), null);
                g.drawImage(Assets.fondoBosque, backgroundX + getWidth(), 0, getWidth(), getHeight(), null);

                // Dibujar obstáculos
                for (Obstacle obstacle : obstacles) {
                    obstacle.render(g);
                }

                // Dibujar jugador
                player.render(g);

                // Mostrar puntaje
                g.setColor(Color.BLACK);
                g.setFont(new Font("Arial", Font.BOLD, 20));
                g.drawString("Puntaje: " + gameState.getCurrentScore(), 10, 30);
                g.drawString("Máximo: " + gameState.getMaxScore(), 10, 60);

                g.dispose();
                bs.show();
            } catch (Exception e) {
            }
        } while (bs.contentsLost());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            player.jump(); // Saltar cuando se presiona espacio
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}
