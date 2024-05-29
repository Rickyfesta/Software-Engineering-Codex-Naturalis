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

    private static List<Socket> clients = new ArrayList<>();


    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }
    // SERVER needs to know the username


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
                if (playerCount.get() >= MIN_PLAYERS) {
                    System.out.println("Minimum players reached. Start game?");
                }
                Socket clientSocket = serverSocket.accept();
                clients.add(clientSocket);
                clientHandler = new ClientHandler(clientSocket, Server::closeServerSocket);
                new Thread(clientHandler).start();
                //System.out.println(getNicknames());

            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            Server.closeServerSocket();
        }
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
