import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Cactus {
    public int x = Assets.fondoBosque.getWidth(); // Posición inicial en X
    public int y = 580; // Posición inicial en Y
    public static BufferedImage image; // Imagen asociada al cactus
    private ObstacleBehavior<Cactus> behavior; // Comportamiento del cactus
    private String type = "ground"; // Tipo de obstáculo ("ground" o "sky")

    // Asigna el comportamiento (Strategy)
    public void setBehavior(ObstacleBehavior<Cactus> behavior) {
        this.behavior = behavior;
    }

    // Actualiza el estado del cactus según su comportamiento
    public void update() {
        if (behavior != null) {
            behavior.updateBehavior(this);
        }
    }

    // Renderiza el cactus en la pantalla
    public void render(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    // Obtiene la hitbox del cactus como un rectángulo
    public Rectangle getHitbox() {
        return new Rectangle(x, y, image.getWidth(), image.getHeight());
    }

    // Asigna el tipo del cactus ("ground" o "sky")
    public void setType(String type) {
        this.type = type;
    }

    // Obtiene el tipo del cactus
    public String getType() {
        return type;
    }

    // Implementa el método clone para duplicar el objeto
    @Override
    public Cactus clone() {
        try {
            return (Cactus) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }


    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public BufferedImage getImage() {
        return this.image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;
    }

    public ObstacleBehavior<Cactus> getBehavior() {
        return this.behavior;
    }

    public void setPosition(int i, int y2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPosition'");
    }
}
