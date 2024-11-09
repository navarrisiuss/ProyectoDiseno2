import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Pterosaurio {
    public int x = Assets.fondoBosque.getWidth();
    public int y = 300;
    public BufferedImage image;

    public void render(Graphics g) {
        g.drawImage(image, x, y, null);

        // Draw hitbox
        g.setColor(Color.RED);
        g.drawRect(x, y, image.getWidth(), image.getHeight());
    }

    public Rectangle getHitbox() {
        return new Rectangle(x, y, image.getWidth(), image.getHeight());
    }

    @Override
    public Pterosaurio clone() {
        try {
            return (Pterosaurio) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
