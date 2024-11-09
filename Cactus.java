import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Cactus {
    public int x = Assets.fondoBosque.getWidth();
    public int y = 500 + 64 / 2;
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
    public Cactus clone() {
        try {
            return (Cactus) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}
