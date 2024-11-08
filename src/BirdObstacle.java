import java.awt.Graphics;

public class BirdObstacle extends Obstacle {

    public BirdObstacle(ObstacleBehavior behavior) {
        super(800, 400, 50, 50, behavior, 2); // Velocidad un poco más rápida
    }    

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.bird, x, y, width, height, null);
    }
}
