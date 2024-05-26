package Model.GameManager;
/*
import Client.CLI.CLICardJSON;
import Client.CLI.CLIMapper;
import Client.CLI.CLIPlayableCard;
import Client.CLI.RandomCLICardPicker;
import Client.Client;
import Controller.ClientHandler;
import Model.Board.PersonalBoard.PersonalBoard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameManager {
    protected Map<String, Integer> playersPoints;
    protected List<String> playerNames;
    private int currentPlayerIndex;
    protected boolean isFinalRound;
    private boolean gameOver;
    private List<CLICardJSON> availableCards;
    private Map<String, CLIPlayableCard> playerHands;
    private Map<String, PersonalBoard> personalBoards;

    public GameManager() {
        this.playersPoints = new HashMap<>();
        this.playerNames = new ArrayList<>();
        this.currentPlayerIndex = 0;
        this.isFinalRound = false;
        this.gameOver = false;
        this.availableCards = new ArrayList<>();
        this.playerHands = new HashMap<>();
        this.personalBoards = new HashMap<>();
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void addPlayers() {
        String playerName;
        do {
            playerName = Client.username;
            if (this.playerNames.contains(playerName)) {
                System.out.println("Username already used, choose another one");
                Client.resetUsername();
            }
        } while (this.playerNames.contains(playerName));
        this.playerNames.add(playerName);
        playersPoints.put(playerName, 0);
        playerHands.put(playerName, new CLIPlayableCard());
        personalBoards.put(playerName, new PersonalBoard());
        System.out.println("Player added!");
    }
    public void updateScore(String playerName, int points) {
        int newScore = playersPoints.get(playerName) + points;
        playersPoints.put(playerName, newScore);
        System.out.println(playerName + " now has " + newScore + " points.");
        // Check if a player has reached 20 points and start the final round if necessary
        if (newScore >= 20 && !isFinalRound) {
            isFinalRound = true;
            System.out.println("Start of the final round!");
            //gameManager.endGame(); // Calls endGame() from GameManager
        }
    }
    public String getCurrentPlayer() {
        if (currentPlayerIndex >= playerNames.size()) {
            currentPlayerIndex = 0;
        }
        return playerNames.get(currentPlayerIndex);
    }

    public void startTurn() {
        String currentPlayer = getCurrentPlayer();
        System.out.println("Turn of " + currentPlayer);
        ClientHandler.makeTurn(currentPlayer);
    }

    public void endTurn() {
        if (isFinalRound && currentPlayerIndex == playerNames.size() - 1) {
            gameOver = true;
            endGame();
        } else {
            currentPlayerIndex++;
            if (currentPlayerIndex >= playerNames.size()) {
                currentPlayerIndex = 0;
            }
            startTurn();
        }
    }

    public int getPlayerPoints(String playerName) {
        return playersPoints.getOrDefault(playerName, 0);
    }

    public void displayPlayerHand(String playerName) {
        CLIPlayableCard hand = playerHands.get(playerName);
        hand.showCards();
    }

    public CLICardJSON getPlayerCard(String playerName, int cardIndex) {
        CLIPlayableCard hand = playerHands.get(playerName);
        return hand.getCard(cardIndex);
    }

    public boolean placeCard(String playerName, CLICardJSON card, String position) {
        String[] pos = position.split(",");
        int x = Integer.parseInt(pos[0].trim());
        int y = Integer.parseInt(pos[1].trim());
        PersonalBoard board = personalBoards.get(playerName);
        if (board.placeCard(x, y, card.getDESCRIPTION())) {
            return true;
        } else {
            return false;
        }
    }

    public CLICardJSON drawCard(int cardIndex) {
        return availableCards.get(cardIndex);
    }

    public void addCardToPlayerHand(String playerName, CLICardJSON card) {
        CLIPlayableCard hand = playerHands.get(playerName);
        hand.setHandCard(hand.cardList.size() + 1, card); // Adjust according to your hand logic
    }

    public void refreshAvailableCards() {
        availableCards.clear();
        for (int i = 0; i < 4; i++) {
            availableCards.add(new CLIMapper().getCard("/CLI/" + RandomCLICardPicker.getRandomCLIXXFileName()));
        }
    }

    public void calculateFinalScores() {
        for (String playerName : playerNames) {
            int score = getPlayerPoints(playerName);
            playersPoints.put(playerName, score);
        }
    }

    public void showLeaderBoard() {
        System.out.println("Players leaderboard:");
        for (Map.Entry<String, Integer> entry : playersPoints.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " Points");
        }
    }

    public void endGame() {
        this.gameOver = true;
        System.out.println("Game Over. Winner: " + pointsLeader());
        showLeaderBoard();
    }

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

    public void displayAvailableCards() {
        System.out.println("Available Cards:");
        for (int i = 0; i < availableCards.size(); i++) {
            System.out.println(i + ": " + availableCards.get(i));
        }
    }
}

 */
