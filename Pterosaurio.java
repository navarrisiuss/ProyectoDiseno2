import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Pterosaurio {
    public int x = Assets.fondoBosque.getWidth(); 
    public int y = 350; 
    public BufferedImage image; 
    private ObstacleBehavior<Pterosaurio> behavior; 
    private String type = "sky"; 

    public void setBehavior(ObstacleBehavior<Pterosaurio> behavior) {
        this.behavior = behavior;
    }

    public void update() {
        if (behavior != null) {
            behavior.updateBehavior(this);
        }
    }

    public void render(Graphics g) {
        g.drawImage(image, x, y, null);
    }

    public Rectangle getHitbox() {
        return new Rectangle(x, y, image.getWidth(), image.getHeight());
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public Pterosaurio clone() {
        try {
            return (Pterosaurio) super.clone();
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

    public ObstacleBehavior<Pterosaurio> getBehavior() {
        return this.behavior;
    }

    public void setPosition(int i, int y2) {
        throw new UnsupportedOperationException("Unimplemented method 'setPosition'");
    }
}
