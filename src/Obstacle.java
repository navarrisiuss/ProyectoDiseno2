
import java.awt.Graphics;

public abstract class Obstacle {
    protected int x, y; // Coordenadas del obstáculo
    protected int width, height; // Dimensiones del obstáculo
    protected ObstacleBehavior behavior; // Comportamiento del obstáculo
    protected int speed; // Velocidad del obstáculo

    // Constructor que incluye el comportamiento y la velocidad
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
        x -= speed; // Reduce la velocidad disminuyendo el valor de speed
    }
    

    public abstract void render(Graphics g);
}
