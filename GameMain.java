import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameMain extends Canvas {
    private Image menuImage; // Imagen del menú principal
    private Rectangle button1Bounds; // Área del botón "Iniciar"
    private Rectangle button2Bounds; // Área del botón "Opciones"
    private Rectangle button3Bounds; // Área del botón "Salir"
    private GameWindow gameWindow; // Referencia al GameWindow
    private static Image gameIcon = Toolkit.getDefaultToolkit().getImage("resources/dinosaurios/dinosaurioRojo/dinoRojoDefault.png");

    public GameMain(GameWindow gameWindow) {
        this.gameWindow = gameWindow; // Guarda la referencia del GameWindow

        // Carga la imagen del menú
        menuImage = Toolkit.getDefaultToolkit().getImage(getClass().getResource("resources/menu.png"));

        // Define las áreas de los botones
        button1Bounds = new Rectangle(480, 150, 300, 100);
        button2Bounds = new Rectangle(480, 300, 300, 90);
        button3Bounds = new Rectangle(480, 410, 300, 100);

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

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    onButton1Click(); // Iniciar juego con la tecla espacio
                }
            }
        });

        // Solicitar foco para capturar eventos del teclado
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Renderiza la imagen del menú
        g.drawImage(menuImage, 0, 0, getWidth(), getHeight(), this);

        // (Opcional) Dibuja las áreas de los botones para depuración
        g.setColor(new Color(255, 0, 0, 50)); // Rojo transparente
        g.fillRect(button1Bounds.x, button1Bounds.y, button1Bounds.width, button1Bounds.height);
        g.fillRect(button2Bounds.x, button2Bounds.y, button2Bounds.width, button2Bounds.height);
        g.fillRect(button3Bounds.x, button3Bounds.y, button3Bounds.width, button3Bounds.height);
    }

    // Métodos para manejar clics en los botones
    private void onButton1Click() {
        System.out.println("Botón 1 clicado: Iniciar juego");
        gameWindow.setPanel(new Game(gameWindow)); // Cambia al panel del juego
    }

    private void onButton2Click() {
        System.out.println("Botón 2 clicado: Opciones");
        gameWindow.setPanel(new Temas(gameWindow)); // Cambia al panel de opciones
    }

    private void onButton3Click() {
        System.out.println("Botón 3 clicado: Salir");
        System.exit(0); // Salir del programa
    }

    // Método principal para iniciar el programa
    public static void main(String[] args) {
        GameWindow gameWindow = new GameWindow(); // Crear instancia de GameWindow
        GameMain gameMain = new GameMain(gameWindow);
        gameWindow.setPanel(gameMain); // Muestra el menú principal
        gameWindow.setIconImage(gameIcon);
    }
}
