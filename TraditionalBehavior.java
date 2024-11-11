public class TraditionalBehavior<T> implements ObstacleBehavior<T> {
    @Override
    public void updateBehavior(T obstacle) {
        if (obstacle instanceof Cactus) {
            Cactus cactus = (Cactus) obstacle;
            cactus.setPosition(cactus.getX() - Game.VELOCIDAD_FONDO, cactus.getY());
        } else if (obstacle instanceof Pterosaurio) {
            Pterosaurio pterosaurio = (Pterosaurio) obstacle;
            pterosaurio.setPosition(pterosaurio.getX() - Game.VELOCIDAD_FONDO, pterosaurio.getY());
        } else {
            throw new IllegalArgumentException("Unsupported obstacle type");
        }
    }
}
