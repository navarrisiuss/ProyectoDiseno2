public class ForestCactus extends Cactus {
    public ForestCactus() {
        image = Loader.loadImage("resources/tronco.png");
    }

    @Override
    public ForestCactus clone() {
        return new ForestCactus();
    }
}
