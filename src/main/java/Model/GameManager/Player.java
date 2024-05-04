package Model.GameManager;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private Set<String> playerName;

    public Player() {
        playerName = new HashSet<>();
    }

    // Add player
    public void addPlayers() {
        Scanner scanner = new Scanner(System.in);
        String playerName;

        do {
            System.out.print("Username: ");
            playerName = scanner.nextLine().trim();

            if (this.playerName.contains(playerName)) {
                System.out.println("Username già utilizzato. Si prega di sceglierne un altro.");
            }
        } while (this.playerName.contains(playerName));

        this.playerName.add(playerName);
        System.out.println("Giocatore aggiunto con successo!");
    }

    public static void main(String[] args) {
        Player playerManager = new Player();

        // Aggiungere giocatori
        playerManager.addPlayers();
        playerManager.addPlayers();
        playerManager.addPlayers();
    }
}

