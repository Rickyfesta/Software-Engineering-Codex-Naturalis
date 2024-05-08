package Client;

import Client.CLI.CLIClient;
import Client.GUI.GUIClient;
import Controller.ClientHandler;
import javafx.application.Application;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static Socket socket;
    public static BufferedReader bufferedReader;
    public static BufferedWriter bufferedWriter;
    public static String username;
    private static ClientHandler clientChat;

    static boolean cli;
    public String getUsername(){
        return username;
    }
    public static void resetUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose another client username \n");
        Client.username = scanner.nextLine();
    }

     /*   public Client(Socket socket, String username){ //Client Setup
            try{
                Client.socket = socket;
                this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Client.username = username;
            }catch(IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    */
    public Client(Socket socket, String username){
        Client.socket = socket;
        Client.username = username;
    }

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
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your username for the group chat: ");
        String username = scanner.nextLine();
        try{
            Client client = new Client(socket, username);
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Choose if you want to play on cli or gui: ");
        String interfaceClient = scanner.nextLine();
           if (interfaceClient.equalsIgnoreCase("CLI")){
                System.out.println("Connecting to the server...");
                Client.connectToServer(true);
            }
            else if (interfaceClient.equalsIgnoreCase("GUI")) {
                try{
                    new Thread(() -> Application.launch(GUIClient.class)).start();
                }catch(Exception e){
                    System.out.println("Something went wrong SHIT");
                }

                System.out.println("Connecting to the server...");
                Client.connectToServer(false);

            }
            else{
                System.out.println("Invalid parameter, you have to write GUI or CLI !");
                System.exit(0);
            }
        }


    private static void connectToServer(boolean cli) {
       // System.out.println("hey");
        try (Socket socket = new Socket("localhost", 1234)) {
            System.out.println("Connected to the server");
            Client.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            Client.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            if(cli){
                CLIClient.start();
            }
            else{
                GUIClient.main(null);
            }
        } catch (UnknownHostException e) {
            System.out.println("Server not found");
        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }


}

