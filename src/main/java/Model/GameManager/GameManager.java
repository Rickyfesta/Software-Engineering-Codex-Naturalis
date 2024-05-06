package Model.GameManager;

import java.util.*;

public class GameManager {
    private Map<String, Integer> playersPoints; //points of the players
    private List<String> playerName; //list of players to track the order of the turns
    private int currentPlayerIndex; // index to track the current turn
    private boolean isFinalRound; // index if the game is in the last lap
    private boolean gameOver; //shows if the game is ended

    public GameManager() {
        this.playersPoints = new HashMap<>();
        this.playerName = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.isFinalRound = false;
        this.gameOver = false;

    }

    //method to add a player with a unique name
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
    public void startTurn() {
        if (currentPlayerIndex >= playerName.size()) {
            currentPlayerIndex = 0;  //Rewind index to first player if necessary
        }
        String currentPlayer = playerName.get(currentPlayerIndex);
        System.out.println("È il turno di " + currentPlayer);

    }
    public void endTurn() {
        if (isFinalRound && currentPlayerIndex == playerName.size() - 1) {
            gameOver = true; // End the game if this is the last player in the final round
            endGame();
        } else {
            currentPlayerIndex++; //Move on to the next player
            startTurn(); // the new turn starts
        }
    }
    public void updateScore(String playerName, int points) {
        int newScore = playersPoints.get(playerName) + points;
        playersPoints.put(playerName, newScore);
        System.out.println(playerName + " ora ha " + newScore + " punti.");

        // Check if a player has reached 20 points and start the final round if necessary
        if (newScore >= 20 && !isFinalRound) {
            isFinalRound = true;
            System.out.println("Inizio del giro finale!");
        }
    }


    // method to find the leader in points
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

    public void endGame() {
        // game ends
        this.gameOver = true;
        System.out.println("Game Over. Winner: " + pointsLeader());
        showLeaderBoard();
    }

    // Method for showing player rankings
    public void showLeaderBoard() {
        System.out.println("Classifica dei giocatori:");
        for (Map.Entry<String, Integer> entry : playersPoints.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " punti");
        }
    }


}
