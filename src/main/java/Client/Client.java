package Client;

import Client.GUI.GUIClient;
import Client.GUI.VirtualModel;
import Model.Cards.CardJSON;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.System.exit;

public class Client {
    private static Socket socket;
    private static BufferedReader bufferedReader;
    private static PrintWriter bufferedWriter;
    private final String username;
    private final ArrayList<String> messages = new ArrayList<>();
    private static VirtualModel virtualModel = new VirtualModel();
    private static ObjectMapper mapper = new ObjectMapper();

    public static VirtualModel getVirtualModel() {
        return virtualModel;
    }

    public static void setVirtualModel(VirtualModel virtualModel) {
        Client.virtualModel = virtualModel;
    }

    /**@ requires socket != null;
      @ requires username != null;
      @ ensures this.socket == socket;
      @ ensures this.username == username;
      @ ensures this.bufferedWriter != null;
      @ ensures this.bufferedReader != null;
      */
    public Client(Socket socket, String username) throws IOException {
        Client.socket = socket;
        this.username = username;
        Client.bufferedWriter = new PrintWriter((socket.getOutputStream()), true);
        Client.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.listenForMessage();
    }
    /**@ requires socket != null;
      @ requires bufferedWriter != null;
      @ requires username != null;
      */

    public static void sendMessage(String toSend){
        bufferedWriter.println(toSend);
    }
    /**@ requires socket != null;
      @ requires bufferedReader != null;
      */

    public void listenForMessage(){
        Thread t = new Thread(() -> {
            String msgFromGroupChat;
                try{
                    while(socket.isConnected()){
                        msgFromGroupChat = bufferedReader.readLine();
                        //if(msgFromGroupChat.equals("Start")){
                          //  GUIClient.changeToStarterScene();
                            //continue;
                        //}
                        messages.add(msgFromGroupChat);
                        Thread.sleep(250);
                    }
                }catch (IOException e){
                    closeEverything(socket, bufferedReader, bufferedWriter);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
        });
        t.start();
    }
     /**@ requires socket != null || bufferedReader != null || bufferedWriter != null;
      */
    public String checkForMSG(){
        while(messages.isEmpty()){
            //TODO thread sleep
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        String result = messages.get(0);
        messages.remove(0);
        //System.out.println("MESSAGE: " + result);
        //System.out.println("LEFT: " + messages);
        return result;
    }


    public void closeEverything(Socket socket, BufferedReader bufferedReader, PrintWriter bufferedWriter){
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

        if(client.checkForMSG().equals("Login Failed")){
            System.out.println("Connection failed");
            return;
        }
        System.out.println("Connected to Server!");
        //System.out.println("Connected to the server");

        String rec = client.checkForMSG();
        if(rec.equals("Enter player number:")){
            int number = 0;
            while(number > 4 || number <2 ){
                try{
                    System.out.println("Enter player number: ");
                    number = Integer.parseInt(scanner.nextLine());
                }catch(IllegalArgumentException e){
                    System.out.println("Error");
                    client.closeEverything(socket, client.bufferedReader, client.bufferedWriter);
                    return;
                }
            }
            client.sendMessage(String.valueOf(number));
            rec = client.checkForMSG(); //To skip "Game is starting!"
        }

        if(rec.equals("Game is starting!"))
            System.out.println(rec);


        //Here game initialization
        //2 Common Goals
        rec = client.checkForMSG();
        System.out.println(rec);
        Client.virtualModel.setCg1(mapper.readValue(new File("src/main/resources/json/" + rec +"front.json"), CardJSON.class));
        rec = client.checkForMSG();
        System.out.println(rec);
        Client.virtualModel.setCg2(mapper.readValue(new File("src/main/resources/json/" + rec +"front.json"), CardJSON.class));

        //Get resources deck
        rec = client.checkForMSG();
        Client.virtualModel.setResourceDeck(mapper.readValue(rec, ArrayList.class));
        System.out.println(client.virtualModel.getResourceDeck().size());

        //Get gold deck
        rec = client.checkForMSG();
        Client.virtualModel.setGoldDeck(mapper.readValue(rec, ArrayList.class));
        System.out.println(client.virtualModel.getGoldDeck().size());

        //Get starter card
        rec = client.checkForMSG();
        Client.virtualModel.setStarterFront(mapper.readValue(new File("src/main/resources/json/"+ rec +"front.json"), CardJSON.class));
        System.out.println(client.virtualModel.getStarterFront().getID());

        //Starting Back
        Client.virtualModel.setStarterBack(mapper.readValue(new File("src/main/resources/json/"+ rec +"back.json"), CardJSON.class));
        System.out.println(client.virtualModel.getStarterBack().getID());

        //2 Personal goals
        rec = client.checkForMSG();
        Client.virtualModel.setPg1(mapper.readValue(new File("src/main/resources/json/"+ rec +"front.json"), CardJSON.class));
        System.out.println(client.virtualModel.getPg1().getID());
        rec = client.checkForMSG();
        Client.virtualModel.setPg2(mapper.readValue(new File("src/main/resources/json/"+ rec +"front.json"), CardJSON.class));
        System.out.println(client.virtualModel.getPg2().getID());

        //Launching GUI
        GUIClient.launchGui();
        //Server sends a broadcast so that the scene changes





        }

}

