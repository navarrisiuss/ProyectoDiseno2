import java.awt.Point;

public class Obstacle {
    private ObstacleBehavior behavior;
    private String type; // Tipo del obstáculo: "ground" o "sky"
    private Point position; // Posición del obstáculo
    private int speed; // Velocidad de movimiento

    public Obstacle(ObstacleBehavior behavior) {
        this.behavior = behavior;
    }

    public void setBehavior(ObstacleBehavior behavior) {
        this.behavior = behavior;
    }

    public void update() {
        behavior.updateBehavior(this);
    }

    // Getters y Setters para posición, tipo y velocidad
    public Point getPosition() {
        return position;
    }

    public void setPosition(int x, int y) {
        this.position = new Point(x, y);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
