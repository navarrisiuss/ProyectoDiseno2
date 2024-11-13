import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameOver extends Canvas {
    private GameWindow gameWindow;

    public Image image = Toolkit.getDefaultToolkit().getImage(getClass().getResource("resources/fondoGameover.png"));
    private Rectangle button1Bounds;

    public GameOver(GameWindow gameWindow) {
        this.gameWindow = gameWindow;

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point clickPoint = e.getPoint();

                if (button1Bounds.contains(clickPoint)) {
                    onButton1Click();
                }
            }
        });
    }

    private void onButton1Click() {
        System.out.println("Botón 1 clicado: Back");
        GameState.getInstance().setSTAGE(0);
    }
}
