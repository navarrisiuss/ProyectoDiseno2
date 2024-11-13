import java.awt.*;
import javax.swing.*;

public class GameWindow extends JFrame {
    private static final int ANCHO = 1280;
    private static final int ALTO = 720;
    private static final String TITULO = "DinoPessi";

    public GameWindow() {
        setSize(ANCHO, ALTO);
        setTitle(TITULO);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setPanel(Canvas panel) {
        getContentPane().removeAll(); 
        add(panel); 
        revalidate();
        repaint();

        panel.requestFocusInWindow();

        if (panel instanceof Game) {
            ((Game) panel).start(); 
        }
    }
}
