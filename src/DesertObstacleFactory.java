public class DesertObstacleFactory implements ObstacleFactory {
    @Override
    public Obstacle createObstacle(String type) {
        if (type.equals("Cactus")) {
            return new CactusObstacle(new TraditionalObstacleBehavior());
        } else if (type.equals("Bird")) {
            return new BirdObstacle(new DynamicObstacleBehavior());
        }
        throw new IllegalArgumentException("Tipo de obstáculo no válido: " + type);
    }
}
