public class DesertCactus extends Cactus {
    public DesertCactus() {
        image = Loader.loadImage("resources/munecoNieve.png");
    }

    @Override
    public DesertCactus clone() {
        return new DesertCactus();
    }
}
