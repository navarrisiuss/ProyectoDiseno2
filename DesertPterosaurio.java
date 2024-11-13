public class DesertPterosaurio extends Pterosaurio {
    public DesertPterosaurio() {
        image = Loader.loadImage("resources/birdForest/birdForest1.png");
    }

    @Override
    public DesertPterosaurio clone() {
        return new DesertPterosaurio();
    }
}
