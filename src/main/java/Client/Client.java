package Client;

import Client.GUI.ClientGUI;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    public static String username;
    private static ClientHandler clientChat;
    private static final Client clientIn = new Client();


    public String getUsername(){
        return username;
    }
    public static void resetUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose another client username \n");
        Client.username = scanner.nextLine();
    }
    /*
        public Client(){ //Client Setup
            try{
                this.socket = socket;
                this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                this.username = username;
            }catch(IOException e){
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    */
    public void setClient(){ //Client Setup
        final String interfaccia = "cli";
        final String address = "192.168.0.1";
        final String port = "1234";
        try {
            socket = new Socket(address, Integer.parseInt(port));

            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
        }catch (IOException e ) {
            System.out.println("Errore setupClient (metodo setClient)");  //TODO: Change this sysout
            closeEverything(socket, bufferedReader, bufferedWriter); //donno if it's necessary
            System.exit(0);
        }
    }
    public static Client getInstance(){
        return clientIn;
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

    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter){
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
            clientIn.setClient();
        }
        catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }
        System.out.println("Choose if you want to play on cli or gui: ");
        String interfaceClient = scanner.nextLine();
        //TO BE CHANGED
        //client.listenForMessage();
        //client.sendMessage();

        if (interfaceClient.equalsIgnoreCase("CLI")){
            Client.startCLI();
        }
        else if (interfaceClient.equalsIgnoreCase("GUI")) {
            try{
                new Thread(() -> ClientGUI.main(args)).start();
            }catch(Exception e){
                System.out.println("Something went wrong SHIT");
            }

            Client.startGUI();
        }
        else{
            System.out.println("Invalid parameter, you have to write GUI or CLI !");
            System.exit(0);
        }
    }

    private static void startGUI() {
    }

    private static void startCLI() {
        System.out.println("We started!");
        clientChat = new CLIClientMOV(); //to be completed
        //startListen();

    }

}

