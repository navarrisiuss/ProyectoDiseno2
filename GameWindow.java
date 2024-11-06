import javax.swing.*;

public class GameWindow extends JFrame {
    public GameWindow() {
        setTitle("Mi Juego");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centra la ventana
        setVisible(true);
    }
}