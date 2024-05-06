package Server;

import Client.Client;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static ServerSocket serverSocket;
    private static final int MIN_PLAYERS = 2;
    private static final int MAX_PLAYERS = 8;
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket; //Set up serverSocket.
    }
    public static void startServer() {
        List<Socket> clients = new ArrayList<>();
        try (ServerSocket serverSocket = new ServerSocket(1234);) {
            System.out.println("Server is running");

            while (clients.size() < MAX_PLAYERS) {
                Socket socket = serverSocket.accept(); // Accept a new client
                System.out.println("New client connected: " + Client.username);
                clients.add(socket);

                // Start the game if the minimum number of players have connected
                if (clients.size() == MIN_PLAYERS) {
                    System.out.println("Minimum players reached. Start a game?");
                    // wait to see what the client say.
                }
            }
        } catch (IOException e) {
            System.out.println("Server exception: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //Method to handle the eventual errors. If we get an error we close the serverSocket.
    public void closeServerSocket(){
        try{
            if(serverSocket != null){ //If we get that this is null, we'd get a nullPointerException if we try to close a already closed server socket (non vogliamo altre eccezioni del cazzo)
                serverSocket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
