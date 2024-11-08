import java.awt.Graphics;

public class Pterosaurio {
    private final int x;
    private int y;
    private final int width;
    private final int height;
    private int velocityY;
    private final int GRAVITY = 1;
    private final int JUMP_STRENGTH = -15;

    public Pterosaurio(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.width = 50;
        this.height = 50;
        this.velocityY = 0;
    }

    public void update() {
        // Actualiza la posición vertical con gravedad
        velocityY += GRAVITY;
        y += velocityY;

        // Limita al suelo para evitar que caiga indefinidamente
        if (y >= 500) { // Altura del suelo
            y = 500;
            velocityY = 0;
        }
    }

    public void jump() {
        if (y == 500) { // Permite saltar solo si está en el suelo
            velocityY = JUMP_STRENGTH;
        }
    }

    public void render(Graphics g) {
        g.drawImage(Assets.pterosaurio, x, y, width, height, null);
    }

    // Getters para colisiones y posición
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
