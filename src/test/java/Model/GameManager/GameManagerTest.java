package Model.GameManager;

import Client.Client;
import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GameManagerTest extends TestCase {
    private GameManager gameManager;
    private Client client;

    @BeforeEach
    public void setUp() {
        gameManager = new GameManager();
    }
    @Test
    public void testConstructorInitialization() {
        assertNotNull(gameManager.playersPoints);
        assertNotNull(gameManager.playerNames);
        assertEquals(0, gameManager.getCurrentPlayerIndex());
        assertFalse(gameManager.isFinalRound);
        assertFalse(gameManager.getGameOver());
    }

    @Test
    public void testAddPlayers() {
        client.setUsername("Player1");
        gameManager.addPlayers();
        assertTrue(gameManager.playerNames.contains("Player1"));
        assertEquals(0, gameManager.playersPoints.get("Player1"));
    }

    @Test
    public void testStartTurn() {

        gameManager.startTurn();
        assertEquals("Player1", gameManager.playerNames.get(gameManager.currentPlayerIndex));

        gameManager.endTurn();
        assertEquals("Player2", gameManager.playerNames.get(gameManager.currentPlayerIndex));
    }

    @Test
    public void testTurnWrapAround() {
        Client.setUsername("Player1");
        gameManager.addPlayers();
        Client.setUsername("Player2");
        gameManager.addPlayers();

        gameManager.startTurn(); // Player1
        gameManager.endTurn(); // Player2
        gameManager.endTurn(); // Should wrap to Player1

        assertEquals(0, gameManager.currentPlayerIndex);
    }

    @Test
    public void testPointsLeader() {
        Client.setUsername("Player1");
        gameManager.addPlayers();
        gameManager.playersPoints.put("Player1", 10);

        Client.setUsername("Player2");
        gameManager.addPlayers();
        gameManager.playersPoints.put("Player2", 20);

        assertEquals("Player2", gameManager.pointsLeader());
    }

    @Test
    public void testEndGame() {
        Client.setUsername("Player1");
        gameManager.addPlayers();
        gameManager.playersPoints.put("Player1", 10);

        gameManager.endGame();
        assertTrue(gameManager.gameOver);
    }
}


}