package Client;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
//implements runnable so that the instances will be executed by a separate thread
public class ClientHandler implements Runnable{

    //Static arraylist of every ClientHandler we instanceate
    // Whenever a client sends a message we loop this arraylist and send a message to each of the clients in there.
    //Broadcast insomma
    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket; //Socket from the server class
    private BufferedReader bufferedReader; //Used to read data sent from the client
    private BufferedWriter bufferedWriter; //Send data to all clients.

    private String clientUsername;

    public ClientHandler(Socket socket){
        try{
            this.socket = socket; //Socket of this class equal to the socket passed.
            //Set up the buffered Writer
            //Byte stream and character stream.
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = bufferedReader.readLine(); //When a client press enter it sends the string stream and we'll read that up until the new line command.
            clientHandlers.add(this); //Add the client to the array list.
            broadcastMessage("SERVER: " + clientUsername + " has entered the chat.");
        } catch (IOException e ){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }
    @Override
    public void run() {
        String messageFromClient;

        while(socket.isConnected()){
            try{
                messageFromClient = bufferedReader.readLine(); //Blocking operation. Need a separate thread to not block everything.
                broadcastMessage(clientUsername + ": " + messageFromClient);
            } catch (IOException e ){
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }
    public void broadcastMessage(String messageToSend){
        for(ClientHandler clientHandler : clientHandlers){
            try{
                if(!clientHandler.clientUsername.equals(clientUsername)){
                    clientHandler.bufferedWriter.write(messageToSend);
                    clientHandler.bufferedWriter.newLine();
                    clientHandler.bufferedWriter.flush();
                }
            }catch(IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    public void removeClientHandler(){
        clientHandlers.remove(this);
        broadcastMessage( "SERVER: " + clientUsername + " has left the chat.");
    }
    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        removeClientHandler();
        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedReader.close();
            }
            if(socket != null){
                socket.close();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
