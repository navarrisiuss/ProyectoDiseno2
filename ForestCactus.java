public class ForestCactus extends Cactus {
    public ForestCactus() {
        image = Loader.loadImage("resources/cactus.png");
    }

    @Override
    public ForestCactus clone() {
        return new ForestCactus();
    }
}
