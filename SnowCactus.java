public class SnowCactus extends Cactus {
    public SnowCactus() {
        image = Loader.loadImage("resources/cactus.png");
    }

    @Override
    public SnowCactus clone() {
        return new SnowCactus();
    }
}
