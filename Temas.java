import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Temas extends Canvas {
    private GameWindow gameWindow; 
    private Image temasImage;
    private Rectangle button1Bounds; 
    private Rectangle button2Bounds; 
    private Rectangle button3Bounds; 
    private Rectangle button4Bounds; 

    public Temas(GameWindow gameWindow) {
        this.gameWindow = gameWindow; 

        temasImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("resources/temas.png"));

        button1Bounds = new Rectangle(220, 150, 245, 370);
        button2Bounds = new Rectangle(510, 150, 245, 370);
        button3Bounds = new Rectangle(800, 150, 245, 370);
        button4Bounds = new Rectangle(550, 550, 170, 80);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Point clickPoint = e.getPoint();

                if (button1Bounds.contains(clickPoint)) {
                    onButton1Click();
                } else if (button2Bounds.contains(clickPoint)) {
                    onButton2Click();
                } else if (button3Bounds.contains(clickPoint)) {
                    onButton3Click();
                } else if (button4Bounds.contains(clickPoint)) {
                    onButton4Click();
                }
            }
        });

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(temasImage, 0, 0, getWidth(), getHeight(), this);

        g.setColor(new Color(255, 0, 0, 0)); // Rojo transparente
        g.fillRect(button1Bounds.x, button1Bounds.y, button1Bounds.width, button1Bounds.height);
        g.fillRect(button2Bounds.x, button2Bounds.y, button2Bounds.width, button2Bounds.height);
        g.fillRect(button3Bounds.x, button3Bounds.y, button3Bounds.width, button3Bounds.height);
        g.fillRect(button4Bounds.x, button4Bounds.y, button4Bounds.width, button4Bounds.height);
    }

    private void onButton1Click() {
        System.out.println("Botón 1 clicado: tema Forest");
        GameState.getInstance().setSTAGE(0);
        gameWindow.setPanel(new Game(gameWindow)); 
    }

    private void onButton2Click() {
        System.out.println("Botón 2 clicado: tema Desert");
        GameState.getInstance().setSTAGE(1);
        gameWindow.setPanel(new Game(gameWindow)); 
    }

    private void onButton3Click() {
        System.out.println("Botón 3 clicado: tema Snow");
        GameState.getInstance().setSTAGE(2);
        gameWindow.setPanel(new Game(gameWindow)); 
    }

    private void onButton4Click() {
        System.out.println("Botón 4 clicado: Salir");
        gameWindow.setPanel(new GameMain(gameWindow));
    }
}
