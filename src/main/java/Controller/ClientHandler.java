package Controller;

import Server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

//handles the connections between clients and server

public class ClientHandler implements Runnable {
    private ClientDisconnectListener listener;

    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final PrintWriter bufferedWriter;
    private ArrayList<String> messages = new ArrayList<>();

    public interface ClientDisconnectListener {
        void onClientDisconnect() throws IOException;
    }
    /**@ requires socket != null;
      @ requires listener != null;
      @ ensures this.socket == socket;
      @ ensures this.listener == listener;
      */

    public ClientHandler(Socket socket, ClientDisconnectListener listener) throws IOException {
        this.socket = socket;
        this.listener = listener;
        this.bufferedWriter = new PrintWriter((socket.getOutputStream()), true);
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        listenForMessage();
    }


    @Override
    public void run() {
        try{
            while(!login()){
                closeEverything(socket, bufferedReader, bufferedWriter);
                return;
            }
            System.out.println("Player connected. Total players: " + Server.getPlayerCount());
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public void closeEverything(Socket socket, BufferedReader bufferedReader, PrintWriter bufferedWriter){
        try{
            bufferedReader.close();
            bufferedWriter.close();
            socket.close();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public void listenForMessage(){
        new Thread(() -> {
            String msgFromGroupChat;
            while(socket.isConnected()){
                try{
                    msgFromGroupChat = bufferedReader.readLine();
                    messages.add(msgFromGroupChat);
                }catch (IOException e){
                    closeEverything(socket, bufferedReader, bufferedWriter);
                }
            }
        }).start();
    }

    public boolean login() throws IOException{
        String received = checkForMSG();

        for(String nick : Server.getNicknames()){
            if(nick.equals(received)){
                //System.out.println("cannot use this nickname");
                sendMessageToClient("Login Failed");
                return false;
            }
        }
        Server.getNicknames().add(received);
        sendMessageToClient("Connected!");
        Server.getPlayerCount().incrementAndGet();
        return true;
    }

    public String checkForMSG(){
        while(messages.isEmpty()){
            //TODO thread sleep
        }
        String result = messages.get(0);
        messages.remove(0);
        return result;
    }

    private void sendMessageToClient(String s) {
        bufferedWriter.println(s);
    }

}


