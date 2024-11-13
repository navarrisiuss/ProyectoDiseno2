import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Game extends Canvas implements Runnable {
    private static GameWindow window;
    private Thread thread;
    private boolean running = false;
    private static BufferedImage fondo;
    private static BufferedImage fondoInvertido;
    private static BufferedImage fondo2;
    private BufferStrategy bs;
    private Graphics g;
    private final int FPS = 60;
    private double delta = 0;
    private int FONDO_X = 0;
    private int FONDO_INVERTIDO_X = 0;
    private int FONDO2_X = 0;
    static int VELOCIDAD_FONDO = 8;
    private int DISTANCIA_RECORRIDA = 0;
    private KeyHandler keyHandler = new KeyHandler();
    private Dinosaurio dinosaurio = new Dinosaurio();
    private GameState gameState = GameState.getInstance();
    private double SEGUNDOS_TRANSCURRIDOS = 0;
    private boolean cambioVelocidad = false;
    private boolean cambioObstaculo = false;
    private ObstacleFactory obstacleFactory;
    private double TIEMPO_ENTRE_OBSTACULOS = 0.75;
    private ArrayList<Cactus> cactusList = new ArrayList<>();
    private ArrayList<Pterosaurio> pterosaurioList = new ArrayList<>();
    private Cactus tipoCactus;
    private Pterosaurio tipoPterosaurio;
    private int PTEROSAURIOS_SEGUIDOS = 0;
    private int CONTADOR_SPRITE = 0;
    private GameWindow gameWindow;
    private int CORRECTOR_X_PTEROSAURIO = 1;
    private Strategy strategy;

    public Game(GameWindow gameWindow) {
        this.gameWindow = gameWindow;
        setBackground(Color.BLACK);
        addKeyListener(keyHandler);
    }

    private void definirFactory() {
        switch (GameState.getInstance().getSTAGE()) {
            case 0 -> {
                obstacleFactory = new ForestFactory();
                fondo = Assets.fondoBosque;
                fondoInvertido = Assets.fondoBosqueInvertido;
                fondo2 = Assets.fondoBosque;
                dinosaurio.setAzul();
            }
            case 1 -> {
                obstacleFactory = new DesertFactory();
                fondo = Assets.fondoDesierto;
                fondoInvertido = Assets.fondoDesiertoInvertido;
                fondo2 = Assets.fondoDesierto;
                dinosaurio.setRojo();
            }
            case 2 -> {
                obstacleFactory = new SnowFactory();
                fondo = Assets.fondoNieve;
                fondoInvertido = Assets.fondoNieveInvertido;
                fondo2 = Assets.fondoNieve;
                dinosaurio.setVerde();
            }
            default -> {
            }
        }
    }

    private void init() {
        Assets.init();
        definirFactory();
        definirCactus();
        definirPterosaurio();
        definirStrategy();
    }

    private void definirStrategy() {
        switch (GameState.getInstance().getSTRATEGY()) {
            case 0 -> strategy = new TradicionalStrategy();
            case 1 -> strategy = new DinamicoStrategy();
            default -> {
            }
        }
    }

    private void definirCactus() {
        tipoCactus = obstacleFactory.createCactus();
    }

    private void definirPterosaurio() {
        tipoPterosaurio = obstacleFactory.createPterosaurio();
    }

    private void crearObstaculo() {
        strategy.execute(SEGUNDOS_TRANSCURRIDOS, TIEMPO_ENTRE_OBSTACULOS,
                PTEROSAURIOS_SEGUIDOS, tipoCactus, cactusList, tipoPterosaurio, pterosaurioList);
    }

    private boolean checkCollision() {
        for (Cactus cactus : cactusList) {
            if (dinosaurio.getHitbox().intersects(cactus.getHitbox())) {
                return true;
            }
        }
        for (Pterosaurio pterosaurio : pterosaurioList) {
            if (dinosaurio.getHitbox().intersects(pterosaurio.getHitbox())) {
                return true;
            }
        }
        return false;
    }

    private void gameOver() {
        reset();
    }

    private void reset() {
        SEGUNDOS_TRANSCURRIDOS = 0;
        DISTANCIA_RECORRIDA = 0;
        VELOCIDAD_FONDO = 0;
        gameState.setCurrentScore(0);
        dinosaurio.freeze();
        CORRECTOR_X_PTEROSAURIO = 0;
    }

    private void updateObstacles() {
        try {
            if (cactusList.size() > 15) {
                for (int i = 0; i < 5; i++) {
                    cactusList.remove(cactusList.get(i));
                }
            }
            if (pterosaurioList.size() > 15) {
                for (int i = 0; i < 5; i++) {
                    pterosaurioList.remove(pterosaurioList.get(i));
                }
            }
            for (Cactus cactus : cactusList) {
                cactus.x -= VELOCIDAD_FONDO;
            }
            for (Pterosaurio pterosaurio : pterosaurioList) {
                pterosaurio.x -= (VELOCIDAD_FONDO + CORRECTOR_X_PTEROSAURIO);
            }
        } catch (Exception e) {
            // Nada
        }
    }

    private void updateVelocidad() {
        if ((int) SEGUNDOS_TRANSCURRIDOS % 10 == 0 && (int) SEGUNDOS_TRANSCURRIDOS != 0 && !cambioVelocidad) {
            cambioVelocidad = true;
            VELOCIDAD_FONDO += 1;
        }
        if ((int) SEGUNDOS_TRANSCURRIDOS % 10 != 0) {
            cambioVelocidad = false;
        }
    }

    private void updateBackground() {
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
    }

    private void updateMovement() {
        if (keyHandler.up) {
            dinosaurio.saltar();
        }
        if (keyHandler.down) {
            dinosaurio.agacharse();
        }
    }

    private void update() {
        updateVelocidad();
        updateBackground();

        dinosaurio.update();

        if (checkCollision()) {
            gameOver();
        } else {
            updateMovement();
        }

        updateObstacles();
        crearObstaculo();

        gameState.setCurrentScore(DISTANCIA_RECORRIDA / 100);
        CONTADOR_SPRITE++;
    }

    private void drawBackground() {
        g.drawImage(fondo, FONDO_X, 0, this);
        g.drawImage(fondoInvertido, FONDO_INVERTIDO_X, 0, this);
        g.drawImage(fondo2, FONDO2_X, 0, this);
    }

    private void drawObstacles() {
        for (Cactus cactus : cactusList) {
            cactus.render(g);
        }
        drawBirdForest();
    }

    private void drawAnimationsDinosaurio() {
        if (keyHandler.down) {
            drawDinosaurioCrouching();
        } else if (dinosaurio.getY() != dinosaurio.ALTURA_SUELO) {
            drawDinosaurioJumping();
        } else {
            drawDinosaurioRunning();
        }
    }

    private void drawShadow() {
        g.drawImage(Assets.sombra, dinosaurio.getX() - 20, dinosaurio.ALTURA_SUELO - 10, this);
    }

    private void drawDinosaurioRunning() {
        if (CONTADOR_SPRITE < 10) {
            g.drawImage(dinosaurio.dinosaurioRunning1, dinosaurio.getX(), dinosaurio.getY(), this);
        } else if (CONTADOR_SPRITE < 20) {
            g.drawImage(dinosaurio.dinosaurioRunning2, dinosaurio.getX(), dinosaurio.getY(), this);
        } else if (CONTADOR_SPRITE < 30) {
            g.drawImage(dinosaurio.dinosaurioRunning3, dinosaurio.getX(), dinosaurio.getY(), this);
        } else if (CONTADOR_SPRITE < 40) {
            g.drawImage(dinosaurio.dinosaurioRunning4, dinosaurio.getX(), dinosaurio.getY(), this);
        } else if (CONTADOR_SPRITE < 50) {
            g.drawImage(dinosaurio.dinosaurioRunning5, dinosaurio.getX(), dinosaurio.getY(), this);
        } else if (CONTADOR_SPRITE < 60) {
            g.drawImage(dinosaurio.dinosaurioRunning6, dinosaurio.getX(), dinosaurio.getY(), this);
        } else {
            g.drawImage(dinosaurio.dinosaurioRunning7, dinosaurio.getX(), dinosaurio.getY(), this);
            CONTADOR_SPRITE = 0;
        }
    }

    private void drawDinosaurioJumping() {
        if (CONTADOR_SPRITE < 10) {
            g.drawImage(dinosaurio.dinosaurioJumping, dinosaurio.getX(), dinosaurio.getY(), this);
        } else {
            g.drawImage(dinosaurio.dinosaurioJumping, dinosaurio.getX(), dinosaurio.getY(), this);
            CONTADOR_SPRITE = 0;
        }
    }

    private void drawDinosaurioCrouching() {
        if (CONTADOR_SPRITE < 10) {
            g.drawImage(dinosaurio.dinosaurioCrouching1, dinosaurio.getX(), dinosaurio.getY(), this);
        } else if (CONTADOR_SPRITE < 20) {
            g.drawImage(dinosaurio.dinosaurioCrouching2, dinosaurio.getX(), dinosaurio.getY(), this);
        } else {
            g.drawImage(dinosaurio.dinosaurioCrouching1, dinosaurio.getX(), dinosaurio.getY(), this);
            CONTADOR_SPRITE = 0;
        }
    }

    private void drawDinosaurioDying() {
        if (CONTADOR_SPRITE < 50) {
            g.drawImage(dinosaurio.dinosaurioDying1, dinosaurio.getX(), dinosaurio.getY(), this);
        } else if (CONTADOR_SPRITE < 70) {
            g.drawImage(dinosaurio.dinosaurioDying2, dinosaurio.getX(), dinosaurio.getY(), this);
        } else {
            g.drawImage(dinosaurio.dinosaurioDying1, dinosaurio.getX(), dinosaurio.getY(), this);
            CONTADOR_SPRITE = 0;
        }
    }

    private void drawBirdForest() {
        for (Pterosaurio bird : pterosaurioList) {
            if (CONTADOR_SPRITE < 10) {
                g.drawImage(Assets.birdForest1, bird.x, bird.y, this);
            } else if (CONTADOR_SPRITE < 20) {
                g.drawImage(Assets.birdForest2, bird.x, bird.y, this);
            } else if (CONTADOR_SPRITE < 30) {
                g.drawImage(Assets.birdForest3, bird.x, bird.y, this);
            } else if (CONTADOR_SPRITE < 40) {
                g.drawImage(Assets.birdForest4, bird.x, bird.y, this);
            } else if (CONTADOR_SPRITE < 50) {
                g.drawImage(Assets.birdForest5, bird.x, bird.y, this);
            } else if (CONTADOR_SPRITE < 60) {
                g.drawImage(Assets.birdForest6, bird.x, bird.y, this);
            } else if (CONTADOR_SPRITE < 70) {
                g.drawImage(Assets.birdForest7, bird.x, bird.y, this);
            } else {
                g.drawImage(Assets.birdForest8, bird.x, bird.y, this);
                CONTADOR_SPRITE = 0;
            }
        }
    }

    private void draw() {
        bs = getBufferStrategy();

        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics();
        // Clear screen
        g.clearRect(0, 0, getWidth(), getHeight());
        // Draw here ----------------------------------------------------------------------------------
        drawBackground();

        drawShadow();

        if (checkCollision()) {
            drawDinosaurioDying();
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("GAME OVER", getWidth() / 2 - 150, getHeight() / 2);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g.drawString("Presiona cualquier tecla para volver al menú", getWidth() / 2 - 200, getHeight() / 2 + 50);
            if (keyHandler.any) {
                returnToMenu();
            }
        } else {
            drawAnimationsDinosaurio();
        }

        drawObstacles();

        g.drawRect(getWidth() - 200, 0, 200, 60);
        g.drawString("Score: " + (int) gameState.getCurrentScore(), getWidth() - 180, 15);
        g.drawString("Highscore: " + (int) gameState.getMaxScore(), getWidth() - 180, 35);
        g.drawString("Segundos: " + (int) SEGUNDOS_TRANSCURRIDOS, getWidth() - 180, 55);

        // End drawing ---------------------------------------------------------------------------------
        g.dispose();
        bs.show();
    }

    void start() {
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
                SEGUNDOS_TRANSCURRIDOS += 1.0 / FPS;
                update();
                draw();
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

    public void returnToMenu() {
        gameWindow.setPanel(new GameMain(gameWindow)); // Cambia al menú principal
    }
}
