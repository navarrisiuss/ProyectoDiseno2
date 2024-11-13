public class DesertFactory implements ObstacleFactory{

    @Override
    public Cactus createCactus() {
        return new DesertCactus();
    }

    @Override
    public Pterosaurio createPterosaurio() {
        return new DesertPterosaurio();
    }
}
