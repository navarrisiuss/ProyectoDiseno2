import java.util.ArrayList;

public class TradicionalStrategy implements Strategy {
    @Override
    public void execute(double SEGUNDOS_TRANSCURRIDOS, double TIEMPO_ENTRE_OBSTACULOS,
                        int PTEROSAURIOS_SEGUIDOS, Cactus tipoCactus, ArrayList<Cactus> cactusList,
                        Pterosaurio tipoPterosaurio, ArrayList<Pterosaurio> pterosaurioList) {
        if (SEGUNDOS_TRANSCURRIDOS - GameState.getInstance().getULTIMO_OBSTACULO() >= TIEMPO_ENTRE_OBSTACULOS) {
            GameState.getInstance().setULTIMO_OBSTACULO(SEGUNDOS_TRANSCURRIDOS);
            if (Math.random() < 0.5 || PTEROSAURIOS_SEGUIDOS >= 2) {
                Cactus cactus = tipoCactus.clone();
                cactusList.add(cactus);
            } else {
                Pterosaurio pterosaurio = tipoPterosaurio.clone();
                pterosaurioList.add(pterosaurio);
            }
        }
    }
}
