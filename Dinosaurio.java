import java.awt.*;

public class Dinosaurio {
    private int DINOSAURIO_X = 100;
    private int DINOSAURIO_Y = 500;
    private int VELOCIDAD_SALTO = 10;
    private int GRAVEDAD = 1;
    private int SALTO = -20;

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

    public void render(Graphics g) {
        g.drawImage(Assets.dinosaurio, DINOSAURIO_X, DINOSAURIO_Y, null);

        // Draw hitbox
        g.setColor(Color.RED);
        g.drawRect(DINOSAURIO_X, DINOSAURIO_Y, Assets.dinosaurio.getWidth(), Assets.dinosaurio.getHeight());
    }
}
