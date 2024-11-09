public class ForestPterosaurio extends Pterosaurio {
    public ForestPterosaurio() {
        image = Loader.loadImage("resources/bird.png");
    }

    @Override
    public ForestPterosaurio clone() {
        return new ForestPterosaurio();
    }
}
