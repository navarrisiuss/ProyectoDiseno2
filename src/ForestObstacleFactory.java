public class ForestObstacleFactory implements ObstacleFactory {
    @Override
    public Obstacle createObstacle(String type) {
        switch (type) {
            case "Tree" -> {
                return new CactusObstacle(new TraditionalObstacleBehavior());
            }
            case "Bird" -> {
                return new BirdObstacle(new DynamicObstacleBehavior());
            }
            default -> throw new IllegalArgumentException("Tipo de obstáculo desconocido: " + type);
        }
    }
}
