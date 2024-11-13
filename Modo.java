import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Modo extends Canvas {
    private GameWindow gameWindow; // Referencia al GameWindow
    private Image modoImage; // Imagen del menú principal
    private Rectangle button1Bounds; // Área del botón "Forest"
    private Rectangle button2Bounds; // Área del botón "Desert"
    private Rectangle button3Bounds; // Área del botón "Snow"

    public Modo(GameWindow gameWindow) {
        this.gameWindow = gameWindow; // Guarda la referencia del GameWindow

        modoImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("resources/modo.png"));

        // Define las áreas de los botones
        button1Bounds = new Rectangle(220, 150, 245, 370);
        button2Bounds = new Rectangle(510, 150, 245, 370);
        button3Bounds = new Rectangle(550, 550, 170, 80);

        // Agrega un MouseListener para manejar los clics
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point clickPoint = e.getPoint();

                // Verifica qué botón fue clicado
                if (button1Bounds.contains(clickPoint)) {
                    onButton1Click();
                } else if (button2Bounds.contains(clickPoint)) {
                    onButton2Click();
                } else if (button3Bounds.contains(clickPoint)) {
                    onButton3Click();
                }
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Renderiza la imagen del menú
        g.drawImage(modoImage, 0, 0, getWidth(), getHeight(), this);

        // (Opcional) Dibuja las áreas de los botones para depuración
        g.setColor(new Color(255, 0, 0, 50)); // Rojo transparente
        g.fillRect(button1Bounds.x, button1Bounds.y, button1Bounds.width, button1Bounds.height);
        g.fillRect(button2Bounds.x, button2Bounds.y, button2Bounds.width, button2Bounds.height);
        g.fillRect(button3Bounds.x, button3Bounds.y, button3Bounds.width, button3Bounds.height);
    }

    // Métodos para manejar clics en los botones
    private void onButton1Click() {
        System.out.println("Botón 1 clicado: tema Forest");
        GameState.getInstance().setSTAGE(0);
    }

    private void onButton2Click() {
        System.out.println("Botón 2 clicado: tema Desert");
        GameState.getInstance().setSTAGE(1);
    }

    private void onButton3Click() {
        System.out.println("Botón 3 clicado: tema Snow");
        gameWindow.setPanel(new GameMain(gameWindow));
    }
}
