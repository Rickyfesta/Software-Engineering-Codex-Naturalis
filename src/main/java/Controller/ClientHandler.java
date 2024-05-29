package Controller;

import Server.Server;

import java.io.*;
import java.net.Socket;

//handles the connections between clients and server

public class ClientHandler implements Runnable {
    private ClientDisconnectListener listener;

    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final PrintWriter bufferedWriter;

    public interface ClientDisconnectListener {
        void onClientDisconnect();
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
    }

    public static void closeEverything(Socket socket, BufferedReader bufferedReader, PrintWriter bufferedWriter){
        try{
            bufferedReader.close();
            bufferedWriter.close();
            socket.close();

        } catch(IOException e){
            e.printStackTrace();
        }
    }


    @Override
    public void run() {
        try{
            while(!login()){
                //System.out.println("Login failed");
                closeEverything(socket, bufferedReader, bufferedWriter);
                return;
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public boolean login() throws IOException{
        try {
            String received = bufferedReader.readLine();
            for(String nick : Server.getNicknames()){
                if(nick.equals(received)){
                    //System.out.println("cannot use this nickname");
                    sendMessageToClient("Login Failed");
                    return false;
                }
            }
            Server.getNicknames().add(received);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        sendMessageToClient("Connected!");
        return true;
    }

    private void sendMessageToClient(String s) {
        bufferedWriter.println(s);
    }

}


