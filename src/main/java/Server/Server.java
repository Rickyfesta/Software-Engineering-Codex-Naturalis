package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Server {
    private static ServerSocket serverSocket;
    private static int NUM_PLAYERS = 4;
    private static AtomicInteger playerCount = new AtomicInteger(0);
    private static ArrayList<String> nicknames = new ArrayList<>();
    private static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();

    private static List<Socket> clients = new ArrayList<>();

    public static int getNumPlayers() {
        return NUM_PLAYERS;
    }

    public static void setNumPlayers(int numPlayers) {
        NUM_PLAYERS = numPlayers;
    }

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
    // SERVER needs to know the username


    public static List<Socket> getClients() {
        return clients;
    }

    public static ArrayList<ClientHandler> getClientHandlers() {
        return clientHandlers;
    }

    public static ArrayList<String> getNicknames() {
        return nicknames;
    }

    public static AtomicInteger getPlayerCount() {
        return playerCount;
    }

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(60000)) {
            System.out.println("Server is listening on port " + 60000);
            ClientHandler clientHandler;
            while (true) {
                if (clients.size() >= NUM_PLAYERS) {
                    System.out.println("Game is about to start.");
                    break;
                }
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                clientHandler = new ClientHandler(clientSocket, Server::closeServerSocket);
                System.out.println("A new client has just connected");
                clientHandlers.add(clientHandler);
                new Thread(clientHandler).start();
                //System.out.println(getNicknames());
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            Server.closeServerSocket();
        }

        ServerController serverController = new ServerController();
        serverController.initializeGame();
        serverController.startGame();
        serverController.turn();

    }


    //Method to handle the eventual errors. If we get an error we close the serverSocket.
    public static void closeServerSocket() throws IOException {
        for(Socket s : clients){
            if(!s.isConnected()){
                s.close();
                System.out.println("Cunte decremented: " + playerCount.decrementAndGet());
            }
        }
    }
}
