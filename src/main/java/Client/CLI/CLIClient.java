package Client.CLI;

import Client.Client;

import java.util.List;
import java.util.Scanner;



public class CLIClient {
    private List<MenuOption> playerTurnMenu, opponentTurnMenu;

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(MenuOption.getTitle());
        System.out.println(MenuOption.getStart());
        System.out.println(MenuOption.getQuit());
        String choice = scanner.nextLine();
        if(choice.equalsIgnoreCase("Start") || choice.equalsIgnoreCase("Start Game")){
            //Start a game
        }
        else if(choice.equalsIgnoreCase("quit")){
            System.out.println("CLosing the game...");
            Client.closeEverything(Client.socket, Client.bufferedReader, Client.bufferedWriter);
        }
    }
}
