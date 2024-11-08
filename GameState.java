public class GameState {
    private static GameState instance;
    private int currentScore;
    private int maxScore;
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

    public int getCurrentScore() {
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
}