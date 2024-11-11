import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage fondoBosque;
    public static BufferedImage fondoBosqueInvertido;
    public static BufferedImage dinosaurio;
    public static BufferedImage dinosaurioRojoRunning1;
    public static BufferedImage dinosaurioRojoRunning2;
    public static BufferedImage dinosaurioRojoRunning3;
    public static BufferedImage dinosaurioRojoRunning4;
    public static BufferedImage dinosaurioRojoRunning5;
    public static BufferedImage dinosaurioRojoRunning6;
    public static BufferedImage dinosaurioRojoRunning7;
    public static BufferedImage dinosaurioRojoJumping1;
    public static BufferedImage dinosaurioRojoJumping2;
    public static BufferedImage dinosaurioRojoDying1;
    public static BufferedImage dinosaurioRojoDying2;
    public static BufferedImage dinosaurioRojoCrouching1;
    public static BufferedImage dinosaurioRojoCrouching2;

    public static BufferedImage cactus;
    public static BufferedImage bird;


    public static void init() {
        fondoBosque = Loader.loadImage("resources/fondoBosque.png");
        fondoBosqueInvertido = Loader.loadImage("resources/fondoBosqueInvertido.png");
        dinosaurioRojoRunning1 = Loader.loadImage("resources/dinosaurios/dinoRojoRunning1.png");
        dinosaurioRojoRunning2 = Loader.loadImage("resources/dinosaurios/dinoRojoRunning2.png");
        dinosaurioRojoRunning3 = Loader.loadImage("resources/dinosaurios/dinoRojoRunning3.png");
        dinosaurioRojoRunning4 = Loader.loadImage("resources/dinosaurios/dinoRojoRunning4.png");
        dinosaurioRojoRunning5 = Loader.loadImage("resources/dinosaurios/dinoRojoRunning5.png");
        dinosaurioRojoRunning6 = Loader.loadImage("resources/dinosaurios/dinoRojoRunning6.png");
        dinosaurioRojoRunning7 = Loader.loadImage("resources/dinosaurios/dinoRojoRunning7.png");
        dinosaurioRojoJumping1 = Loader.loadImage("resources/dinosaurios/dinoRojoJumping1.png");
        dinosaurioRojoJumping2 = Loader.loadImage("resources/dinosaurios/dinoRojoJumping2.png");
        dinosaurioRojoDying1 = Loader.loadImage("resources/dinosaurios/dinoRojoDying1.png");
        dinosaurioRojoDying2 = Loader.loadImage("resources/dinosaurios/dinoRojoDying2.png");
        dinosaurioRojoCrouching1 = Loader.loadImage("resources/dinosaurios/dinoRojoCrouching1.png");
        dinosaurioRojoCrouching2 = Loader.loadImage("resources/dinosaurios/dinoRojoCrouching2.png");
    }
}
