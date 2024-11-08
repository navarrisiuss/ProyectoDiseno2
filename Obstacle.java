import java.awt.Graphics;

public abstract class Obstacle {
    protected int x;
    protected int y;
    protected int width, height;
    protected ObstacleBehavior behavior;
    protected int speed;


    public Obstacle(int x, int y, int width, int height, ObstacleBehavior behavior, int speed) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.behavior = behavior;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void updatePosition() {
        x -= speed;
    }
    public abstract void render(Graphics g);
}