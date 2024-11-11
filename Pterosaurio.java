import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Pterosaurio {
    public int x = Assets.fondoBosque.getWidth(); // Posición inicial en X
    public int y = 300; // Posición inicial en Y
    public BufferedImage image; // Imagen asociada al pterosaurio
    private ObstacleBehavior<Pterosaurio> behavior; // Comportamiento del pterosaurio
    private String type = "sky"; // Tipo de obstáculo ("ground" o "sky")

    // Asigna el comportamiento (Strategy)
    public void setBehavior(ObstacleBehavior<Pterosaurio> behavior) {
        this.behavior = behavior;
    }

    // Actualiza el estado del pterosaurio según su comportamiento
    public void update() {
        if (behavior != null) {
            behavior.updateBehavior(this);
        }
    }

    // Renderiza el pterosaurio en la pantalla
    public void render(Graphics g) {
        g.drawImage(image, x, y, null);

        // Dibuja la hitbox para depuración
        g.setColor(Color.RED);
        g.drawRect(x, y, image.getWidth(), image.getHeight());
    }

    // Obtiene la hitbox del pterosaurio como un rectángulo
    public Rectangle getHitbox() {
        return new Rectangle(x, y, image.getWidth(), image.getHeight());
    }

    // Asigna el tipo del pterosaurio ("ground" o "sky")
    public void setType(String type) {
        this.type = type;
    }

    // Obtiene el tipo del pterosaurio
    public String getType() {
        return type;
    }

    // Implementa el método clone para duplicar el objeto
    @Override
    public Pterosaurio clone() {
        try {
            Pterosaurio cloned = (Pterosaurio) super.clone();
            cloned.image = new BufferedImage(
                this.image.getWidth(),
                this.image.getHeight(),
                this.image.getType()
            );
            Graphics g = cloned.image.getGraphics();
            g.drawImage(this.image, 0, 0, null);
            g.dispose();
            return cloned;
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
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

    public ObstacleBehavior<Pterosaurio> getBehavior() {
        return this.behavior;
    }

    public void setPosition(int i, int y2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setPosition'");
    }
}
