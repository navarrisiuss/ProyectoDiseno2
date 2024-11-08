import java.awt.Graphics;

public class CactusObstacle extends Obstacle {

    public CactusObstacle(ObstacleBehavior behavior) {
        super(800, 500, 50, 50, behavior, 1); // Velocidad más lenta
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.cactus, x, y, width, height, null);
    }
}
