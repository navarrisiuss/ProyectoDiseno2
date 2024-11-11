import java.util.Random;

public class DynamicBehavior<T> implements ObstacleBehavior<T> {
    private Random random = new Random();

    @Override
    public void updateBehavior(T obstacle) {
        if (obstacle instanceof Cactus cactus) {
            cactus.setType(random.nextBoolean() ? "ground" : "sky");
            cactus.setPosition(cactus.getX() - Game.VELOCIDAD_FONDO, cactus.getY());
        } else if (!(obstacle instanceof Pterosaurio pterosaurio)) {
            throw new IllegalArgumentException("Unsupported obstacle type");
        } else {
            pterosaurio.setType(random.nextBoolean() ? "ground" : "sky");
            pterosaurio.setPosition(pterosaurio.getX() - Game.VELOCIDAD_FONDO, pterosaurio.getY());
        }
    }
}
