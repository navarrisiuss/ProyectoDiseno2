import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage fondoBosque;
    public static BufferedImage fondoBosqueInvertido;
    public static BufferedImage dinosaurio;
    public static void init() {
        fondoBosque = Loader.loadImage("resources/fondoBosque.png");
        fondoBosqueInvertido = Loader.loadImage("resources/fondoBosqueInvertido.png");
        dinosaurio = Loader.loadImage("resources/dinosaurio.png");
    }
}
