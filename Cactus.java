import java.awt.Graphics;

public class Cactus extends Obstacle {
    public Cactus(int x, int y, int width, int height, ObstacleBehavior behavior, int speed) {
        super(x, y, width, height, behavior, speed);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.cactus, x, y, width, height, null);
    }
}