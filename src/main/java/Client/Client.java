package Client;

import Client.GUI.GUIClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import static java.lang.System.exit;

public class Client {
    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final PrintWriter bufferedWriter;
    private final String username;


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
        this.bufferedWriter = new PrintWriter((socket.getOutputStream()), true);
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        listenForMessage();
    }
    /**@ requires socket != null;
      @ requires bufferedWriter != null;
      @ requires username != null;
      */

    public void sendMessage(String toSend){
        bufferedWriter.println(toSend);
    }
    /**@ requires socket != null;
      @ requires bufferedReader != null;
      */

    public void listenForMessage(){
        new Thread(() -> {
            String msgFromGroupChat;
                try{
                    msgFromGroupChat = bufferedReader.readLine();
                    if(msgFromGroupChat.equals("Login Failed")){
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }catch (IOException e){
                    closeEverything(socket, bufferedReader, bufferedWriter);
                }
        }).start();
    }
     /**@ requires socket != null || bufferedReader != null || bufferedWriter != null;
      */

    public static void closeEverything(Socket socket, BufferedReader bufferedReader, PrintWriter bufferedWriter){
        try{
                bufferedReader.close();
                bufferedWriter.close();
                socket.close();
                exit(0);
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
        Socket socket = new Socket("localhost", 60000);
        Client client = new Client(socket, username);
        client.sendMessage(username);
        if(socket.isConnected()){
            System.out.println("Connected to server!");
        }
        //System.out.println("Connected to the server");
        System.out.println("Choose if you want to play on cli or gui: ");
        String interfaceClient = scanner.nextLine();
           if (interfaceClient.equalsIgnoreCase("CLI")){
                System.out.println("Connecting to the server...");
                client.connectToServer(true);
                //client.listenForMessage();
                //client.sendMessage();
            }
            else if (interfaceClient.equalsIgnoreCase("GUI")) {
                try{
                    new Thread(() -> GUIClient.main(null));
                }catch(Exception e){
                    System.out.println("Something went wrong SHIT");
                }

                System.out.println("Connecting to the server...");
                client.connectToServer(false);
                //client.listenForMessage();
                //client.sendMessage();

            }
            else{
                System.out.println("Invalid parameter, you have to write GUI or CLI !");
                exit(0);
            }
        }

    private static void connectToServer(boolean cli) {
            if(cli){
                //CLIClient.start();

            }
            else{
                GUIClient.main(null);
            }
    }
}

