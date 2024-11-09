public class GameState {
    private static GameState instance;
    private double currentScore;
    private double maxScore;
    private boolean isGameActive;

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

    public void setCurrentScore(double score) {
        this.currentScore = score;
        if (score > maxScore) {
            maxScore = score;
        }
    }

    public double getMaxScore() {
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
}