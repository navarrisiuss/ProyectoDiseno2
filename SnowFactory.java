public class SnowFactory implements ObstacleFactory {
    private String behaviorType;

    public SnowFactory() {
        this.behaviorType = "traditional"; // Comportamiento predeterminado
    }

    public SnowFactory(String behaviorType) {
        this.behaviorType = behaviorType;
    }

    private <T> ObstacleBehavior<T> getBehavior(Class<T> clazz) {
        if ("traditional".equalsIgnoreCase(behaviorType)) {
            return new TraditionalBehavior<>();
        } else if ("dynamic".equalsIgnoreCase(behaviorType)) {
            return new DynamicBehavior<>();
        } else {
            throw new IllegalArgumentException("Invalid behavior type");
        }
    }

    @Override
    public Cactus createCactus() {
        Cactus cactus = new SnowCactus();
        cactus.setBehavior(getBehavior(Cactus.class));
        return cactus;
    }

    @Override
    public Pterosaurio createPterosaurio() {
        Pterosaurio pterosaurio = new SnowPterosaurio();
        pterosaurio.setBehavior(getBehavior(Pterosaurio.class));
        return pterosaurio;
    }
}
