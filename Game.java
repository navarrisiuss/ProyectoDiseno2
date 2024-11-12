import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class Game extends Canvas implements Runnable {
    private static GameWindow window;
    private static Image gameIcon = Toolkit.getDefaultToolkit().getImage("resources/dinosaurios/dinosaurioRojo/dinoRojoDefault.png");
    private Thread thread;
    private boolean running = false;
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
    private int STAGE = 0;
    private double TIEMPO_ENTRE_OBSTACULOS = 0.75;
    private double ultimoObstaculo = 0;
    private ArrayList<Cactus> cactusList = new ArrayList<>();
    private ArrayList<Pterosaurio> pterosaurioList = new ArrayList<>();
    private Cactus tipoCactus;
    private Pterosaurio tipoPterosaurio;
    private int PTEROSAURIOS_SEGUIDOS = 0;
    private int CONTADOR_SPRITE = 0;

    public Game() {
        window = new GameWindow();
        window.getCanvas().addKeyListener(keyHandler);
        window.setIconImage(gameIcon);
    }

    private void definirFactory() {
        switch (STAGE) {
            case 0 -> {
                obstacleFactory = new ForestFactory();
                dinosaurio.setRojo();
            }
            case 1 -> {
                obstacleFactory = new DesertFactory();
                dinosaurio.setVerde();
            }
            case 2 -> {
                obstacleFactory = new ForestFactory();
                dinosaurio.setAzul();
            }
            default -> {}
        }
    }

    private void init() {
        Assets.init();
        definirFactory();
        definirCactus();
        definirPterosaurio();
    }

    private void definirCactus() {
        tipoCactus = obstacleFactory.createCactus();
    }

    private void definirPterosaurio() {
        tipoPterosaurio = obstacleFactory.createPterosaurio();
    }

    private void crearObstaculo() {
        if (SEGUNDOS_TRANSCURRIDOS - ultimoObstaculo >= TIEMPO_ENTRE_OBSTACULOS) {
            ultimoObstaculo = SEGUNDOS_TRANSCURRIDOS;
            if (Math.random() < 0.5 || PTEROSAURIOS_SEGUIDOS >= 2) {
                Cactus cactus = tipoCactus.clone();
                cactusList.add(cactus);
                PTEROSAURIOS_SEGUIDOS = 0;
            } else {
                Pterosaurio pterosaurio = tipoPterosaurio.clone();
                pterosaurioList.add(pterosaurio);
            }
        }
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
    }

    private void updateObstacles() {
        try {
            for (Cactus cactus : cactusList) {
                cactus.x -= VELOCIDAD_FONDO;
                if (cactus.x + cactus.image.getWidth() < 0) {
                    cactusList.remove(cactus);
                }
            }
            for (Pterosaurio pterosaurio : pterosaurioList) {
                pterosaurio.x -= VELOCIDAD_FONDO;
                if (pterosaurio.x + pterosaurio.image.getWidth() < 0) {
                    pterosaurioList.remove(pterosaurio);
                }
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
        updateMovement();
        updateObstacles();

        dinosaurio.update();

        if (checkCollision()) {
            gameOver();
        }

        crearObstaculo();

        gameState.setCurrentScore(DISTANCIA_RECORRIDA / 100);
        CONTADOR_SPRITE++;
    }

    private void drawBackground() {
        g.drawImage(Assets.fondoBosque, FONDO_X, 0, this);
        g.drawImage(Assets.fondoBosqueInvertido, FONDO_INVERTIDO_X, 0, this);
        g.drawImage(Assets.fondoBosque, FONDO2_X, 0, this);
    }

    private void drawObstacles() {
        for (Cactus cactus : cactusList) {
            cactus.render(g);
        }
        for (Pterosaurio pterosaurio : pterosaurioList) {
            pterosaurio.render(g);
        }
    }

    private void drawAnimationsDinosaurio() {
        if (keyHandler.down) {
            drawDinosaurioCrouching();
        } else if (dinosaurio.getY() != 500) {
            drawDinosaurioJumping();
        } else {
            drawDinosaurioRunning();
        }
    }

    private void drawShadow() {
        if (dinosaurio.getY() != 500) {
            g.drawImage(Assets.sombra, dinosaurio.getX() - 20, 490, this);
        }
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
        drawBackground();

        drawObstacles();

        drawShadow();

        if (checkCollision()) {
            drawDinosaurioDying();
        } else {
            drawAnimationsDinosaurio();
        }


        // Draw hitbox dinosaurio
        g.setColor(Color.RED);
        g.drawRect(dinosaurio.getX(), dinosaurio.getY(), Assets.dinosaurioRojoRunning7.getWidth(), Assets.dinosaurioRojoRunning7.getHeight());

        g.drawRect(window.getCanvas().getWidth() - 100, 0, 100, 40);
        g.drawString("Score: " + (int) gameState.getCurrentScore(), window.getCanvas().getWidth() - 80, 15);
        g.drawString("Segundos: " + (int) SEGUNDOS_TRANSCURRIDOS, window.getCanvas().getWidth() - 80, 35);

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
                SEGUNDOS_TRANSCURRIDOS += 1.0 / FPS;
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
