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
    private static final int PORT = 1234;
    private static final int MAX_PLAYERS = 8;
    private static AtomicInteger playerCount = new AtomicInteger(0);
    // Callback interface


    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket; //Set up serverSocket.
    }

    public static void main(String[] args) throws IOException {
        List<Socket> clients = new ArrayList<>();
        ExecutorService pool = Executors.newCachedThreadPool();
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                //System.out.println("got");
                playerCount.incrementAndGet(); // Increment player count
                System.out.println("Player connected. Total players: " + playerCount.get());

                pool.execute(new ClientHandler(clientSocket, Server::clientDisconnected));

                // Check if minimum players have been reached to start the game
                if (playerCount.get() >= MIN_PLAYERS) {
                    System.out.println("Minimum players reached. Start game?");

                }
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            Server.closeServerSocket();
        }
    }

    public static void clientDisconnected() {
        int currentCount = playerCount.decrementAndGet();
        System.out.println("Player disconnected. Total players: " + currentCount);
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
