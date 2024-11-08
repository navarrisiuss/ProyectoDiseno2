import java.awt.*;
import javax.swing.*;

public class GameWindow extends JFrame {
    private static final int WINDOW_WIDTH = 1280;
    private static final int WINDOW_HEIGHT = 720;
    private static final String TITLE = "Dino Run";

    public static int getWindowWidth() {
        return WINDOW_WIDTH;
    }

    public static int getWindowHeight() {
        return WINDOW_HEIGHT;
    }

    private final Canvas canvas;

    public GameWindow() {
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setTitle(TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        canvas.setMaximumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        canvas.setMinimumSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        canvas.setFocusable(true);

        add(canvas);
    }

    public Canvas getCanvas() {
        return canvas;
    }
}
