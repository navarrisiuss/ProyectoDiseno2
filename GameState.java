public class GameState {
    private static GameState instance;
    private int currentScore;
    private int maxScore;
    private boolean isGameActive;
    private int STAGE;
    private int STRATEGY = 0;
    private double ULTIMO_OBSTACULO = 0;

    private GameState() {
        currentScore = 0;
        maxScore = 0;
        isGameActive = false;
    }

    public static synchronized GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public double getCurrentScore() {
        return currentScore;
    }

    public void setCurrentScore(int score) {
        this.currentScore = score;
        if (score > maxScore) {
            maxScore = score;
        }
    }

    public int getMaxScore() {
        return maxScore;
    }

    public boolean isGameActive() {
        return isGameActive;
    }

    public void startGame() {
        isGameActive = true;
        currentScore = 0;
    }

    public void endGame() {
        isGameActive = false;
    }

    public int getSTAGE() {
        return STAGE;
    }

    public void setSTAGE(int STAGE) {
        this.STAGE = STAGE;
    }

    public int getSTRATEGY() {
        return STRATEGY;
    }

    public void setSTRATEGY(int STRATEGY) {
        this.STRATEGY = STRATEGY;
    }

    public double getULTIMO_OBSTACULO() {
        return ULTIMO_OBSTACULO;
    }

    public void setULTIMO_OBSTACULO(double ULTIMO_OBSTACULO) {
        this.ULTIMO_OBSTACULO = ULTIMO_OBSTACULO;
    }
}