package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //Server class will be responsible to listen to clients wishing to connect.
    //It spawns new thread foreach client.
    private ServerSocket serverSocket;
    //The serversocket is the socket of the server:
    // it's literally listening for new clients trying to communicate with the server.
    // It also will create a socket to communicate with them:
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket; //Set up serverSocket.
    }
    //method for keeping server running:
    public void startServer(){

        try{ //For avoiding any exception (errori in java)
            while(!serverSocket.isClosed()){ //To make the server run un tempo indefinito
                Socket socket = serverSocket.accept(); //Blocking method, meaning the server doesn't go forward but stops here waiting for any client to connect.
                System.out.println("A new client has connected."); //Here a client has connected
               // ClientHandler clientHandler = new ClientHandler(); //Each object of this class will communicate with the client.
                // It implements runnable to be executed by a separated thread.
                //To spawn a new thread we have to call the thread method and pass the class that will implement runnable (diventa un fratello dei thread)
               // Thread thread = new Thread(clientHandler);
               // thread.start(); //After creating the thread for the client, it must be started.
            }
        }catch(IOException e){

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

    //Instead of writing try catch exception we just write throws IOException cuz we lazy
    public static void main(String[] args) throws IOException{
        //Our server will get the clients listening on this port:
        ServerSocket serverSocket = new ServerSocket(1234);
        //Create the server
        Server server = new Server(serverSocket);
        //Run the server
        server.startServer();
    }
}
