import java.awt.image.BufferedImage;

public class Assets {
    public static BufferedImage fondoBosque;
    public static BufferedImage fondoDesierto;
    public static BufferedImage cactus;
    public static BufferedImage bird;
    public static BufferedImage pterosaurio;

    public static void init() {
        fondoBosque = Loader.loadImage("fondoBosque.png");
        cactus = Loader.loadImage("cactus.png");
        bird = Loader.loadImage("bird.png");
        pterosaurio = Loader.loadImage("pterosaurio.png");

        // Mensajes de validación para identificar problemas
        if (fondoBosque == null) System.out.println("Error al cargar fondoBosque");
        if (cactus == null) System.out.println("Error al cargar cactus");
        if (bird == null) System.out.println("Error al cargar bird");
        if (pterosaurio == null) System.out.println("Error al cargar pterosaurio");
    }
}
