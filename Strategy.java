import java.util.ArrayList;

public interface Strategy {
    void execute(double SEGUNDOS_TRANSCURRIDOS, double TIEMPO_ENTRE_OBSTACULOS,
                 int PTEROSAURIOS_SEGUIDOS, Cactus tipoCactus, ArrayList<Cactus> cactusList,
                 Pterosaurio tipoPterosaurio, ArrayList<Pterosaurio> pterosaurioList);
}
