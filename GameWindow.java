import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {
    private static final int ANCHO = 1280;
    private static final int ALTO = 720;
    private static final String TITULO = "DinoPessi";
    private Canvas canvas;


    public GameWindow() {
        setSize(ANCHO, ALTO);
        setTitle(TITULO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(ANCHO, ALTO));
        canvas.setMaximumSize(new Dimension(ANCHO, ALTO));
        canvas.setMinimumSize(new Dimension(ANCHO, ALTO));
        canvas.setFocusable(true);

        add(canvas);
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
