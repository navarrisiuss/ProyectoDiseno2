import java.util.Random;

public class DynamicObstacleBehavior implements ObstacleBehavior {
    private Random random = new Random();

    @Override
    public void update(Obstacle obstacle, int speed) {
        // Cambia la posición aleatoriamente entre piso y cielo
        if (random.nextInt(100) < 5) { // Probabilidad de cambio
            obstacle.setY(random.nextBoolean() ? 300 : 500); // Cambia la altura
        }
        obstacle.setX(obstacle.getX() - speed); // Mueve hacia la izquierda
    }
}
