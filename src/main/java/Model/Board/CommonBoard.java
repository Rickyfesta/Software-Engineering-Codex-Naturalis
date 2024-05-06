package Model.Board;


import Model.GameManager.GameManager;

import java.util.HashMap;
import java.util.Map;

public class CommonBoard extends GameManager {
    private Map<String, Integer> piecePositions; //Map that tracks the locations of player pieces
    private GameManager gameManager; //Reference to the GameManager to be able to call endGame()

public CommonBoard(GameManager gameManager) {
        this.piecePositions = new HashMap<>();
        this.gameManager = gameManager;
}
    public void addPiece(String playerName) {
        this.piecePositions.put(playerName, 0); // each piece starts at position 0
    }

    public void updateScore(String playerName, int points) {
        int newScore = playersPoints.get(playerName) + points;
        playersPoints.put(playerName, newScore);
        System.out.println(playerName + " now has " + newScore + " points.");

        // Check if a player has reached 20 points and start the final round if necessary
        if (newScore >= 20 && !isFinalRound) {
            isFinalRound = true;
            System.out.println("Start of the final round!");
            gameManager.endGame(); // Calls endGame() from GameManager
        }
    }
}