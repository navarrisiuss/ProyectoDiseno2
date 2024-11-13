public class ForestPterosaurio extends Pterosaurio {
    public ForestPterosaurio() {
        image = Loader.loadImage("resources/birdForest/birdForest1.png");
    }

    @Override
    public ForestPterosaurio clone() {
        return new ForestPterosaurio();
    }
}
