import java.awt.*;
import java.awt.image.BufferedImage;

public class Dinosaurio {
    private int DINOSAURIO_X = 100;
    private int DINOSAURIO_Y = 500;
    private int VELOCIDAD_SALTO = 15;
    private int GRAVEDAD = 1;
    private int SALTO = -20;
    public BufferedImage dinosaurioRunning1;
    public BufferedImage dinosaurioRunning2;
    public BufferedImage dinosaurioRunning3;
    public BufferedImage dinosaurioRunning4;
    public BufferedImage dinosaurioRunning5;
    public BufferedImage dinosaurioRunning6;
    public BufferedImage dinosaurioRunning7;
    public BufferedImage dinosaurioJumping;
    public BufferedImage dinosaurioDying1;
    public BufferedImage dinosaurioDying2;
    public BufferedImage dinosaurioCrouching1;
    public BufferedImage dinosaurioCrouching2;

    public Dinosaurio() {

    }

    public void setRojo() {
        dinosaurioRunning1 = Assets.dinosaurioRojoRunning1;
        dinosaurioRunning2 = Assets.dinosaurioRojoRunning2;
        dinosaurioRunning3 = Assets.dinosaurioRojoRunning3;
        dinosaurioRunning4 = Assets.dinosaurioRojoRunning4;
        dinosaurioRunning5 = Assets.dinosaurioRojoRunning5;
        dinosaurioRunning6 = Assets.dinosaurioRojoRunning6;
        dinosaurioRunning7 = Assets.dinosaurioRojoRunning7;
        dinosaurioJumping = Assets.dinosaurioRojoJumping;
        dinosaurioDying1 = Assets.dinosaurioRojoDying1;
        dinosaurioDying2 = Assets.dinosaurioRojoDying2;
        dinosaurioCrouching1 = Assets.dinosaurioRojoCrouching1;
        dinosaurioCrouching2 = Assets.dinosaurioRojoCrouching2;
    }

    public void setVerde() {

    }

    public void update() {
        VELOCIDAD_SALTO += GRAVEDAD;
        DINOSAURIO_Y += VELOCIDAD_SALTO;

        if (DINOSAURIO_Y > 500) {
            DINOSAURIO_Y = 500;
            VELOCIDAD_SALTO = 0;
        }
    }

    public void saltar() {
        if (DINOSAURIO_Y == 500) {
            VELOCIDAD_SALTO = SALTO;
        }
    }

    public void agacharse() {
        DINOSAURIO_Y += 25;

        if (DINOSAURIO_Y > 500) {
            DINOSAURIO_Y = 500;
            VELOCIDAD_SALTO = 0;
        }
    }

    public void freeze() {
        VELOCIDAD_SALTO = 0;
        GRAVEDAD = 0;
    }

    public int getX() {
        return DINOSAURIO_X;
    }

    public int getY() {
        return DINOSAURIO_Y;
    }

    public Rectangle getHitbox() {
        return new Rectangle(DINOSAURIO_X, DINOSAURIO_Y, Assets.dinosaurioRojoRunning7.getWidth(), Assets.dinosaurioRojoRunning7.getHeight());
    }
}
