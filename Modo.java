import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Modo extends Canvas {
    private GameWindow gameWindow; 
    private Image modoImage; 
    private Rectangle button1Bounds; 
    private Rectangle button2Bounds; 
    private Rectangle button3Bounds; 

    public Modo(GameWindow gameWindow) {
        this.gameWindow = gameWindow; 

        modoImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("resources/modo.png"));

        button1Bounds = new Rectangle(360, 450, 150, 80);
        button2Bounds = new Rectangle(720, 450, 150, 80);
        button3Bounds = new Rectangle(550, 550, 170, 80);

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

        g.drawImage(modoImage, 0, 0, getWidth(), getHeight(), this);

        g.setColor(new Color(255, 0, 0, 0)); // Rojo transparente
        g.fillRect(button1Bounds.x, button1Bounds.y, button1Bounds.width, button1Bounds.height);
        g.fillRect(button2Bounds.x, button2Bounds.y, button2Bounds.width, button2Bounds.height);
        g.fillRect(button3Bounds.x, button3Bounds.y, button3Bounds.width, button3Bounds.height);
    }

    private void onButton1Click() {
        System.out.println("Botón 1 clicado: modo tradicional");
        GameState.getInstance().setSTRATEGY(0);
    }

    private void onButton2Click() {
        System.out.println("Botón 2 clicado: modo dinamico");
        GameState.getInstance().setSTRATEGY(1);
    }

    private void onButton3Click() {
        System.out.println("Botón 3 clicado: tema Snow");
        gameWindow.setPanel(new GameMain(gameWindow));
    }
}
