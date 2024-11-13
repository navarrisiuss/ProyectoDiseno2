public class SnowPterosaurio extends Pterosaurio {
    public SnowPterosaurio() {
        image = Loader.loadImage("resources/birdForest/birdForest1.png");
    }

    @Override
    public SnowPterosaurio clone() {
        return new SnowPterosaurio();
    }
}
