package Model.GameManager;

import Client.Client;

import java.util.*;

public class GameManager {
    //private GameState gameState;
    protected Map<String, Integer> playersPoints; //points of the players
    protected List<String> playerNames; //list of players to track the order of the turns
    private int currentPlayerIndex; // index to track the current turn
    protected boolean isFinalRound; // index if the game is in the last lap
    private boolean gameOver; //shows if the game is ended

    public GameManager() {
        this.playersPoints = new HashMap<>();
        this.playerNames = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.isFinalRound = false;
        this.gameOver = false;

    }

    //method to add a player with a unique name
    public void addPlayers() {
        //Scanner scanner = new Scanner(System.in);
        String playerName = Client.username;
        do {
            playerName = Client.username;
            //System.out.print("Inserisci l'username del giocatore: ");
            if (this.playerNames.contains(playerName)) {
                System.out.println("Username already used, choose another one");
                Client.resetUsername();
            }
        } while (this.playerNames.contains(playerName));
        this.playerNames.add(playerName);
        playersPoints.put(playerName, 0);
        System.out.println("Client added!");
    }
    public void startTurn() {
        if (currentPlayerIndex >= playerNames.size()) {
            currentPlayerIndex = 0;  //Rewind index to first player if necessary
        }
        String currentPlayer = playerNames.get(currentPlayerIndex);
        System.out.println("Turn of" + currentPlayer);

    }
    public void endTurn() {
        if (isFinalRound && currentPlayerIndex == playerNames.size() - 1) {
            gameOver = true; // End the game if this is the last player in the final round
            endGame();
        } else {
            currentPlayerIndex++; //Move on to the next player
            startTurn(); // the new turn starts
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
