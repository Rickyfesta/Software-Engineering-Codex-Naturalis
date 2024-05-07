package Server;

import Controller.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    private static ServerSocket serverSocket;
    private static final int MIN_PLAYERS = 2;
    private static final int PORT = 12345;
    private static final int MAX_PLAYERS = 8;
    private static AtomicInteger playerCount = new AtomicInteger(0);

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket; //Set up serverSocket.
    }

    public static void startServer() throws IOException {
        List<Socket> clients = new ArrayList<>();
        ExecutorService pool = Executors.newCachedThreadPool();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                playerCount.incrementAndGet(); // Increment player count
                System.out.println("Player connected. Total players: " + playerCount.get());

                pool.execute(new ClientHandler(clientSocket));

                // Check if minimum players have been reached to start the game
                if (playerCount.get() >= MIN_PLAYERS) {
                    System.out.println("Minimum players reached. Start game?");

                }
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
        }
    }
    //Method to handle the eventual errors. If we get an error we close the serverSocket.
    public void closeServerSocket () {
        try {
            if (serverSocket != null) { //If we get that this is null, we'd get a nullPointerException if we try to close a already closed server socket (non vogliamo altre eccezioni del cazzo)
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
