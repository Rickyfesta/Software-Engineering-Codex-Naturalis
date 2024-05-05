package Model.GameManager;

import java.util.*;

public class GameManager {
    private Map<String, Integer> playersPoints;
    private Set<String> playerName;

    public GameManager() {
        playersPoints = new HashMap<>();
        playerName = new HashSet<>();
    }

    // Metodo per aggiungere un giocatore con un nome unico
    public void addPlayers() {
        Scanner scanner = new Scanner(System.in);
        String playerName;

        do {
            System.out.print("Inserisci l'username del giocatore: ");
            playerName = scanner.nextLine().trim();

            if (this.playerName.contains(playerName)) {
                System.out.println("Username già utilizzato. Si prega di sceglierne un altro.");
            }
        } while (this.playerName.contains(playerName));

        this.playerName.add(playerName);
        playersPoints.put(playerName, 0);
        System.out.println("Giocatore aggiunto con successo!");
    }

    // Metodo per aggiungere punti a un giocatore
    public void addPoints(String playerName, int pointsAdded) {
        playersPoints.put(playerName, playersPoints.getOrDefault(playerName, 0) + pointsAdded);
    }

    // Metodo per trovare il leader in punti
    public String pointsLeader() {
        int maxPoints = Integer.MIN_VALUE;
        String leader = null;
        for (Map.Entry<String, Integer> entry : playersPoints.entrySet()) {
            if (entry.getValue() > maxPoints) {
                maxPoints = entry.getValue();
                leader = entry.getKey();
            }
        }
        return leader;
    }

    // Metodo per mostrare la classifica dei giocatori
    public void showLeaderBoard() {
        System.out.println("Classifica dei giocatori:");
        for (Map.Entry<String, Integer> entry : playersPoints.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " punti");
        }
    }

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();

        // Aggiungere giocatori e punti
        gameManager.addPlayers();
        gameManager.addPlayers();
        gameManager.addPoints("Giocatore1", 20);
        gameManager.addPoints("Giocatore2", 15);

        // Mostrare la classifica dei giocatori
        gameManager.showLeaderBoard();

        // Trovare il leader in punti
        String leader = gameManager.pointsLeader();
        System.out.println("Il leader in punti è: " + leader);
    }
}
