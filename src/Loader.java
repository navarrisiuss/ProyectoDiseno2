import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class Loader {
    public static BufferedImage loadImage(String path) {
        try {
            InputStream is = Loader.class.getClassLoader().getResourceAsStream("resources/" + path);
            if (is == null) {
                throw new IllegalArgumentException("Recurso no encontrado: " + path);
            }
            return ImageIO.read(is);
        } catch (IOException | IllegalArgumentException e) {
            System.exit(1);
        }
        return null;
    }
}
