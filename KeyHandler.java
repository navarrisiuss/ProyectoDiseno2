import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean up;
    public boolean down;
    public boolean any;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_KP_UP || code == KeyEvent.VK_W || code == KeyEvent.VK_SPACE) {
            up = true;
        }
        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_KP_DOWN || code == KeyEvent.VK_S) {
            down = true;
        }

        // Cualquier tecla presionada
        any = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_UP || code == KeyEvent.VK_KP_UP || code == KeyEvent.VK_W || code == KeyEvent.VK_SPACE) {
            up = false;
        }
        if (code == KeyEvent.VK_DOWN || code == KeyEvent.VK_KP_DOWN || code == KeyEvent.VK_S) {
            down = false;
        }

        // Cualquier tecla liberada
        any = false;
    }
}
