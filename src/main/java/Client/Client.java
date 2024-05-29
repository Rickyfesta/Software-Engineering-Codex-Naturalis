package Client;

import Client.CLI.CLIClient;
import Client.GUI.GUIClient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static Socket socket;
    public static BufferedReader bufferedReader;
    public static BufferedWriter bufferedWriter;
    public static String username;

    /**@ ensures username != null;
      */
    public static void resetUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose another client username \n");
        Client.username = scanner.nextLine();
    }
    /**@ requires socket != null;
      @ requires username != null;
      @ ensures this.socket == socket;
      @ ensures this.username == username;
      @ ensures this.bufferedWriter != null;
      @ ensures this.bufferedReader != null;
      */
    public Client(Socket socket, String username) throws IOException {
        this.socket = socket;
        this.username = username;
        this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }
    /**@ requires socket != null;
      @ requires bufferedWriter != null;
      @ requires username != null;
      */

    public void sendMessage(){
        try{
            bufferedWriter.write(username);
            bufferedWriter.newLine();
            bufferedWriter.flush();

            Scanner scanner = new Scanner(System.in);
            while(socket.isConnected()){
                String messageToSend = scanner.nextLine();
                bufferedWriter.write(messageToSend);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch(IOException e){
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }
    /**@ requires socket != null;
      @ requires bufferedReader != null;
      */

    public void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromGroupChat;

                while(socket.isConnected()){
                    try{
                        msgFromGroupChat = bufferedReader.readLine();
                        System.out.println(msgFromGroupChat);
                    }catch (IOException e){
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }
     /**@ requires socket != null || bufferedReader != null || bufferedWriter != null;
      */

    public static void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
        try{
            if(bufferedReader != null){
                bufferedReader.close();
            }
            if(bufferedWriter != null){
                bufferedWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        } catch(IOException e){
            e.printStackTrace();
        }
    }
    /**@ requires args != null;
     */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username for the group chat: ");
        String username = scanner.nextLine();
        Socket socket = new Socket("localhost", 1234);
        Client client = new Client(socket, username);
        System.out.println("Connected to the server");
        System.out.println("Choose if you want to play on cli or gui: ");
        String interfaceClient = scanner.nextLine();
           if (interfaceClient.equalsIgnoreCase("CLI")){
                System.out.println("Connecting to the server...");
                client.connectToServer(true);
                client.listenForMessage();
                client.sendMessage();
            }
            else if (interfaceClient.equalsIgnoreCase("GUI")) {
                try{
                    new Thread(() -> GUIClient.main(null));
                }catch(Exception e){
                    System.out.println("Something went wrong SHIT");
                }

                System.out.println("Connecting to the server...");
                client.connectToServer(false);
                client.listenForMessage();
                client.sendMessage();

            }
            else{
                System.out.println("Invalid parameter, you have to write GUI or CLI !");
                System.exit(0);
            }
        }
        /**@ requires cli == true || cli == false;
      */


    private static void connectToServer(boolean cli) {
            if(cli){
                CLIClient.start();

            }
            else{
                GUIClient.main(null);
            }
    }
}

