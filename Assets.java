import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage fondoBosque;
    public static BufferedImage fondoBosqueInvertido;
    public static BufferedImage fondoDesierto;
    public static BufferedImage fondoDesiertoInvertido;
    public static BufferedImage dinosaurio;
    public static BufferedImage dinosaurioRojoRunning1;
    public static BufferedImage dinosaurioRojoRunning2;
    public static BufferedImage dinosaurioRojoRunning3;
    public static BufferedImage dinosaurioRojoRunning4;
    public static BufferedImage dinosaurioRojoRunning5;
    public static BufferedImage dinosaurioRojoRunning6;
    public static BufferedImage dinosaurioRojoRunning7;
    public static BufferedImage dinosaurioRojoJumping;
    public static BufferedImage dinosaurioRojoDying1;
    public static BufferedImage dinosaurioRojoDying2;
    public static BufferedImage dinosaurioRojoCrouching1;
    public static BufferedImage dinosaurioRojoCrouching2;
    public static BufferedImage dinosaurioVerdeRunning1;
    public static BufferedImage dinosaurioVerdeRunning2;
    public static BufferedImage dinosaurioVerdeRunning3;
    public static BufferedImage dinosaurioVerdeRunning4;
    public static BufferedImage dinosaurioVerdeRunning5;
    public static BufferedImage dinosaurioVerdeRunning6;
    public static BufferedImage dinosaurioVerdeRunning7;
    public static BufferedImage dinosaurioVerdeJumping;
    public static BufferedImage dinosaurioVerdeDying1;
    public static BufferedImage dinosaurioVerdeDying2;
    public static BufferedImage dinosaurioVerdeCrouching1;
    public static BufferedImage dinosaurioVerdeCrouching2;
    public static BufferedImage dinosaurioAzulRunning1;
    public static BufferedImage dinosaurioAzulRunning2;
    public static BufferedImage dinosaurioAzulRunning3;
    public static BufferedImage dinosaurioAzulRunning4;
    public static BufferedImage dinosaurioAzulRunning5;
    public static BufferedImage dinosaurioAzulRunning6;
    public static BufferedImage dinosaurioAzulRunning7;
    public static BufferedImage dinosaurioAzulJumping;
    public static BufferedImage dinosaurioAzulDying1;
    public static BufferedImage dinosaurioAzulDying2;
    public static BufferedImage dinosaurioAzulCrouching1;
    public static BufferedImage dinosaurioAzulCrouching2;

    public static BufferedImage sombra;

    public static BufferedImage cactus;
    public static BufferedImage bird;
    public static BufferedImage speed1;
    public static BufferedImage speed2;


    public static void init() {
        fondoBosque = Loader.loadImage("resources/fondoBosque.png");
        fondoBosqueInvertido = Loader.loadImage("resources/fondoBosqueInvertido.png");
        fondoDesierto = Loader.loadImage("resources/fondoDesierto.png");
        fondoDesiertoInvertido = Loader.loadImage("resources/fondoDesiertoInvertido.png");
        dinosaurioRojoRunning1 = Loader.loadImage("resources/dinosaurios/dinosaurioRojo/dinoRojoRunning1.png");
        dinosaurioRojoRunning2 = Loader.loadImage("resources/dinosaurios/dinosaurioRojo/dinoRojoRunning2.png");
        dinosaurioRojoRunning3 = Loader.loadImage("resources/dinosaurios/dinosaurioRojo/dinoRojoRunning3.png");
        dinosaurioRojoRunning4 = Loader.loadImage("resources/dinosaurios/dinosaurioRojo/dinoRojoRunning4.png");
        dinosaurioRojoRunning5 = Loader.loadImage("resources/dinosaurios/dinosaurioRojo/dinoRojoRunning5.png");
        dinosaurioRojoRunning6 = Loader.loadImage("resources/dinosaurios/dinosaurioRojo/dinoRojoRunning6.png");
        dinosaurioRojoRunning7 = Loader.loadImage("resources/dinosaurios/dinosaurioRojo/dinoRojoRunning7.png");
        dinosaurioRojoJumping = Loader.loadImage("resources/dinosaurios/dinosaurioRojo/dinoRojoJumping.png");
        dinosaurioRojoDying1 = Loader.loadImage("resources/dinosaurios/dinosaurioRojo/dinoRojoDying1.png");
        dinosaurioRojoDying2 = Loader.loadImage("resources/dinosaurios/dinosaurioRojo/dinoRojoDying2.png");
        dinosaurioRojoCrouching1 = Loader.loadImage("resources/dinosaurios/dinosaurioRojo/dinoRojoCrouching1.png");
        dinosaurioRojoCrouching2 = Loader.loadImage("resources/dinosaurios/dinosaurioRojo/dinoRojoCrouching2.png");
        dinosaurioVerdeRunning1 = Loader.loadImage("resources/dinosaurios/dinosaurioVerde/dinoVerdeRunning1.png");
        dinosaurioVerdeRunning2 = Loader.loadImage("resources/dinosaurios/dinosaurioVerde/dinoVerdeRunning2.png");
        dinosaurioVerdeRunning3 = Loader.loadImage("resources/dinosaurios/dinosaurioVerde/dinoVerdeRunning3.png");
        dinosaurioVerdeRunning4 = Loader.loadImage("resources/dinosaurios/dinosaurioVerde/dinoVerdeRunning4.png");
        dinosaurioVerdeRunning5 = Loader.loadImage("resources/dinosaurios/dinosaurioVerde/dinoVerdeRunning5.png");
        dinosaurioVerdeRunning6 = Loader.loadImage("resources/dinosaurios/dinosaurioVerde/dinoVerdeRunning6.png");
        dinosaurioVerdeRunning7 = Loader.loadImage("resources/dinosaurios/dinosaurioVerde/dinoVerdeRunning7.png");
        dinosaurioVerdeJumping = Loader.loadImage("resources/dinosaurios/dinosaurioVerde/dinoVerdeJumping.png");
        dinosaurioVerdeDying1 = Loader.loadImage("resources/dinosaurios/dinosaurioVerde/dinoVerdeDying1.png");
        dinosaurioVerdeDying2 = Loader.loadImage("resources/dinosaurios/dinosaurioVerde/dinoVerdeDying2.png");
        dinosaurioVerdeCrouching1 = Loader.loadImage("resources/dinosaurios/dinosaurioVerde/dinoVerdeCrouching1.png");
        dinosaurioVerdeCrouching2 = Loader.loadImage("resources/dinosaurios/dinosaurioVerde/dinoVerdeCrouching2.png");
        dinosaurioAzulRunning1 = Loader.loadImage("resources/dinosaurios/dinosaurioAzul/dinoAzulRunning1.png");
        dinosaurioAzulRunning2 = Loader.loadImage("resources/dinosaurios/dinosaurioAzul/dinoAzulRunning2.png");
        dinosaurioAzulRunning3 = Loader.loadImage("resources/dinosaurios/dinosaurioAzul/dinoAzulRunning3.png");
        dinosaurioAzulRunning4 = Loader.loadImage("resources/dinosaurios/dinosaurioAzul/dinoAzulRunning4.png");
        dinosaurioAzulRunning5 = Loader.loadImage("resources/dinosaurios/dinosaurioAzul/dinoAzulRunning5.png");
        dinosaurioAzulRunning6 = Loader.loadImage("resources/dinosaurios/dinosaurioAzul/dinoAzulRunning6.png");
        dinosaurioAzulRunning7 = Loader.loadImage("resources/dinosaurios/dinosaurioAzul/dinoAzulRunning7.png");
        dinosaurioAzulJumping = Loader.loadImage("resources/dinosaurios/dinosaurioAzul/dinoAzulJumping.png");
        dinosaurioAzulDying1 = Loader.loadImage("resources/dinosaurios/dinosaurioAzul/dinoAzulDying1.png");
        dinosaurioAzulDying2 = Loader.loadImage("resources/dinosaurios/dinosaurioAzul/dinoAzulDying2.png");
        dinosaurioAzulCrouching1 = Loader.loadImage("resources/dinosaurios/dinosaurioAzul/dinoAzulCrouching1.png");
        dinosaurioAzulCrouching2 = Loader.loadImage("resources/dinosaurios/dinosaurioAzul/dinoAzulCrouching2.png");
        cactus = Loader.loadImage("resources/cactus.png");
        sombra = Loader.loadImage("resources/sombra.png");
    }
}
