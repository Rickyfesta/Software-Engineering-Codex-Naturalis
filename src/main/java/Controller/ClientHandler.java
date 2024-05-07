package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

//handles the connections between clients and server

public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public static void makeTurn(String currentPlayer) {
    }

    @Override
    public void run() {
        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ) {
            // Sending initial options to the client
            Client.CLI.MenuOption.getTitle();

            // Listening for client response
            String line;
            while ((line = in.readLine()) != null) {
                if (line.equalsIgnoreCase("Start Game")) {
                    startNewGame(out, in);
                } else if (line.equalsIgnoreCase("Quit")) {
                    out.println("Connection closing...");
                    break;
                } else {
                    out.println("Invalid option. Please type 'Start Game' or 'Quit'.");
                }
            }
        } catch (IOException e) {
            System.out.println("Error handling client: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("Could not close a socket");
            }
        }
    }

    private void startNewGame(PrintWriter out, BufferedReader in) {
    }
}
