import java.util.ArrayList;

public class DinamicoStrategy implements Strategy {
    @Override
    public void execute(double SEGUNDOS_TRANSCURRIDOS, double TIEMPO_ENTRE_OBSTACULOS,
                        int PTEROSAURIOS_SEGUIDOS, Cactus tipoCactus, ArrayList<Cactus> cactusList,
                        Pterosaurio tipoPterosaurio, ArrayList<Pterosaurio> pterosaurioList) {
        if (SEGUNDOS_TRANSCURRIDOS - GameState.getInstance().getULTIMO_OBSTACULO() >= TIEMPO_ENTRE_OBSTACULOS) {
            GameState.getInstance().setULTIMO_OBSTACULO(SEGUNDOS_TRANSCURRIDOS);
            if (Math.random() < 0.5 || PTEROSAURIOS_SEGUIDOS >= 2) {
                Cactus cactus = tipoCactus.clone();
                if (Math.random() < 0.3) {
                    cactus.y = 350;
                }
                cactusList.add(cactus);
                PTEROSAURIOS_SEGUIDOS = 0;
            } else {
                Pterosaurio pterosaurio = tipoPterosaurio.clone();
                if (Math.random() < 0.3) {
                    pterosaurio.y = 580;
                }
                pterosaurioList.add(pterosaurio);
                PTEROSAURIOS_SEGUIDOS++;
            }
        }
    }
}
