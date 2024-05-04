package Model.GameManager;
import java.util.HashMap;
import java.util.Map;

public class PointsManager {
    private Map<String, Integer> PlayerPoints;

    public PointsManager() {
        PlayerPoints = new HashMap<>();
    }

    // Add points to players
    public void addPoints(String playerName, int PointsAdded) {
        PlayerPoints.put(playerName, PlayerPoints.getOrDefault(playerName, 0) + PointsAdded);
    }

    // get points from players
    public int getPlayersPoints(String playerName) {
        return PlayerPoints.getOrDefault(playerName, 0);
    }

    // Get all players points
    public Map<String, Integer> getPlayersPoints() {
        return PlayerPoints;
    }

    public static void main(String[] args) {
        PointsManager pointManager = new PointsManager();

        // Aggiungi punti ai giocatori
        pointManager.addPoints("Giocatore1", 10);
        pointManager.addPoints("Giocatore2", 20);
        pointManager.addPoints("Giocatore1", 5);

        // Stampare i punti dei giocatori
        System.out.println("Punti di Giocatore1: " + pointManager.getPlayersPoints("Giocatore1"));
        System.out.println("Punti di Giocatore2: " + pointManager.getPlayersPoints("Giocatore2"));


    }
}

