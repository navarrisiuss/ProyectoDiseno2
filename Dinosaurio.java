import java.awt.*;

public class Dinosaurio {
    private int DINOSAURIO_X = 100;
    private int DINOSAURIO_Y = 500;
    private int VELOCIDAD_SALTO = 15;
    private int GRAVEDAD = 1;
    private int SALTO = -25;

    public Dinosaurio() {

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
