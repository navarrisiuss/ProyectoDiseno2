public class ForestFactory implements ObstacleFactory {
    @Override
    public Cactus createCactus() {
        return new ForestCactus();
    }

    @Override
    public Pterosaurio createPterosaurio() {
        return new ForestPterosaurio();
    }
}
