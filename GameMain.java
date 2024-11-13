import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameMain extends Canvas {
    private Image menuImage; 
    private Rectangle button1Bounds; 
    private Rectangle button2Bounds;
    private Rectangle button3Bounds; 
    private GameWindow gameWindow; 
    private static Image gameIcon = Toolkit.getDefaultToolkit().getImage("resources/dinosaurios/dinosaurioRojo/dinoRojoDefault.png");

    public GameMain(GameWindow gameWindow) {
        this.gameWindow = gameWindow; 

        menuImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("resources/menu.png"));

        button1Bounds = new Rectangle(480, 150, 300, 100);
        button2Bounds = new Rectangle(480, 300, 300, 90);
        button3Bounds = new Rectangle(480, 410, 300, 100);

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
                }
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    onButton1Click(); 
                }
            }
        });

        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawImage(menuImage, 0, 0, getWidth(), getHeight(), this);

        g.setColor(new Color(255, 0, 0, 0)); 
        g.fillRect(button1Bounds.x, button1Bounds.y, button1Bounds.width, button1Bounds.height);
        g.fillRect(button2Bounds.x, button2Bounds.y, button2Bounds.width, button2Bounds.height);
        g.fillRect(button3Bounds.x, button3Bounds.y, button3Bounds.width, button3Bounds.height);
    }

    private void onButton1Click() {
        System.out.println("Botón 1 clicado: Iniciar juego");
        gameWindow.setPanel(new Temas(gameWindow)); 
    }

    private void onButton2Click() {
        System.out.println("Botón 2 clicado: Opciones");
        gameWindow.setPanel(new Modo(gameWindow)); 
    }

    private void onButton3Click() {
        System.out.println("Botón 3 clicado: Salir");
        System.exit(0); 
    }

    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow(); 
        GameMain gameMain = new GameMain(gameWindow);
        gameWindow.setPanel(gameMain); 
        gameWindow.setIconImage(gameIcon);
    }
}
