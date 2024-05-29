package Server;

import Controller.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    private static ServerSocket serverSocket;
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 4;
    private static AtomicInteger playerCount = new AtomicInteger(0);
    private static ArrayList<String> nicknames = new ArrayList<>();
    private static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();


    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
    // SERVER needs to know the username


    public static ArrayList<String> getNicknames() {
        return nicknames;
    }

    public static void main(String[] args) throws IOException {
        List<Socket> clients = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(60000)) {
            System.out.println("Server is listening on port " + 60000);
            ClientHandler clientHandler;
            while (true) {
                Socket clientSocket = serverSocket.accept();
                //System.out.println("got");
                clientHandler = new ClientHandler(clientSocket, Server::closeServerSocket);
                new Thread(clientHandler).start();
                playerCount.incrementAndGet(); // Increment player count
                System.out.println("Player connected. Total players: " + playerCount.get());
                //System.out.println(getNicknames());
                if (playerCount.get() >= MIN_PLAYERS) {
                    System.out.println("Minimum players reached. Start game?");

                }
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            Server.closeServerSocket();
        }
    }


    //Method to handle the eventual errors. If we get an error we close the serverSocket.
    public static void closeServerSocket() {
        try {
            if (serverSocket != null) { //If we get that this is null, we'd get a nullPointerException if we try to close a already closed server socket (non vogliamo altre eccezioni del cazzo)
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
