public class TraditionalObstacleBehavior implements ObstacleBehavior {
    @Override
    public void update(Obstacle obstacle, int speed) {
        obstacle.setX(obstacle.getX() - speed); // Mueve el obstáculo hacia la izquierda
    }
}
