package Server;

import Model.Cards.CardJSON;
import Model.Cards.PlayerHand;
import Model.Cards.RandomCardFile;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class ServerController {
    private CardJSON cg1;
    private CardJSON cg2;
    String path1;

    String path2;

    private ArrayList<CardJSON> resourceDeck = new ArrayList<>();
    private ArrayList<CardJSON> goldDeck = new ArrayList<>();

    private ArrayList<CardJSON> personalGoalDeck = new ArrayList<>();
    private ArrayList<CardJSON> startingChoices = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();
    private ArrayList<PlayerHand> hands = new ArrayList<>();
    private ArrayList<CardJSON> chosenStarter = new ArrayList<>();
    private ArrayList<CardJSON> chosenGoal = new ArrayList<>();


    public void initializeGame() throws IOException {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        generateCommonGoals();
        generateResourcesDeck();
        generateGoldDeck();
        generateStartingCard();
        generatePersonalGoals();
        assignCard();
        //Have to send everything to the players

    }

    public void startGame() throws IOException {

        ClientHandler.broadcastMessage("Game is starting!");
        ClientHandler.broadcastMessage(cg1.getID());
        ClientHandler.broadcastMessage(cg2.getID());
        ClientHandler.broadcastMessage(mapper.writeValueAsString(resourceDeck));
        ClientHandler.broadcastMessage(mapper.writeValueAsString(goldDeck));
        for(int i = 0; i<Server.getPlayerCount().get(); i++){
            ClientHandler clientHandler = Server.getClientHandlers().get(i);
            clientHandler.sendMessageToClient(startingChoices.get(i).getID());
            clientHandler.sendMessageToClient(personalGoalDeck.get(2*i).getID());
            clientHandler.sendMessageToClient(personalGoalDeck.get(2*i+1).getID());
            clientHandler.sendMessageToClient(mapper.writeValueAsString(hands.get(i)));
        }
        ClientHandler.broadcastMessage("Start");

        for(int i = 0; i < Server.getNumPlayers(); i++){
            //if "front" receive --> continue;
            //else change to back with the same ID
            String rec = Server.getClientHandlers().get(i).checkForMSG();
            if(rec.equals("front")){
                chosenStarter.add(startingChoices.get(i));
            }
            else if(rec.equals("back")){
                String id = this.startingChoices.get(i).getID();
                CardJSON card = mapper.readValue(new File("src/main/resources/json/" + id + "back.json"), CardJSON.class);
                chosenStarter.add(card);
            }

            System.out.println("choice " + i);
        }
        //Choosing personal goal
        for(int i = 0; i < Server.getNumPlayers(); i++){
            String rec = Server.getClientHandlers().get(i).checkForMSG();
            if(rec.equals("first")){
                chosenGoal.add(personalGoalDeck.get(2*i));
            }
            else if(rec.equals("second")){
                chosenGoal.add(personalGoalDeck.get(2*i +1));
            }
            System.out.println("choice " + i);
        }


    }
//to create two separate hands
    private void assignCard() {
        for(int i =0; i<Server.getPlayerCount().get(); i++){
            Random rand = new Random();
            hands.add(new PlayerHand());
            hands.get(i).setCardOne(resourceDeck.get(rand.nextInt(resourceDeck.size())));
            resourceDeck.remove(hands.get(i).getCardOne());
            hands.get(i).setCardTwo(resourceDeck.get(rand.nextInt(resourceDeck.size())));
            resourceDeck.remove(hands.get(i).getCardTwo());
            hands.get(i).setCardThree(goldDeck.get(rand.nextInt(goldDeck.size())));
            goldDeck.remove(hands.get(i).getCardThree());

        }
    }

    private void generatePersonalGoals() throws IOException {
        ArrayList<String> generatedPaths = new ArrayList<>();
        for(int i = 0; i <2*Server.getPlayerCount().get(); i++){
            String pathX = RandomCardFile.getRandomOXXFileName().replace("jpg","json");
            if(pathX.equals(path1) || pathX.equals(path2)){
                i--;
            }
            else if(generatedPaths.contains(pathX)){
                i--;
            }
            else{
                generatedPaths.add(pathX);
                personalGoalDeck.add(mapper.readValue(new File("src/main/resources/json/" + pathX), CardJSON.class));
            }
        }
    }

    private void generateStartingCard() throws IOException {
        ArrayList<Integer> generatedNumbers = new ArrayList<>();
        for(int i = 0; i<Server.getPlayerCount().get(); i++){
            Random rand = new Random();
            int n = rand.nextInt(6)+1;
            if(generatedNumbers.contains(n)){
                i--;
            }else {
                generatedNumbers.add(n);
            }
        }
        for(int i = 0; i< generatedNumbers.size(); i++){
            startingChoices.add(mapper.readValue(new File("src/main/resources/json/S0"+generatedNumbers.get(i)+"front.json"), CardJSON.class));
        }
    }

    private void generateGoldDeck() throws IOException {
        goldDeck.add(mapper.readValue(new File("src/main/resources/json/G01front.json"), CardJSON.class));
        goldDeck.add(mapper.readValue(new File("src/main/resources/json/G02front.json"), CardJSON.class));
        goldDeck.add(mapper.readValue(new File("src/main/resources/json/G03front.json"), CardJSON.class));
        goldDeck.add(mapper.readValue(new File("src/main/resources/json/G04front.json"), CardJSON.class));
        goldDeck.add(mapper.readValue(new File("src/main/resources/json/G05front.json"), CardJSON.class));
        goldDeck.add(mapper.readValue(new File("src/main/resources/json/G06front.json"), CardJSON.class));
        goldDeck.add(mapper.readValue(new File("src/main/resources/json/G07front.json"), CardJSON.class));
        goldDeck.add(mapper.readValue(new File("src/main/resources/json/G08front.json"), CardJSON.class));
        goldDeck.add(mapper.readValue(new File("src/main/resources/json/G09front.json"), CardJSON.class));
        for (int i = 10; i<41; i++){
            goldDeck.add(mapper.readValue(new File("src/main/resources/json/G"+ i +"front.json"), CardJSON.class));
        }
    }

    private void generateResourcesDeck() throws IOException {
        resourceDeck.add(mapper.readValue(new File("src/main/resources/json/01front.json"), CardJSON.class));
        resourceDeck.add(mapper.readValue(new File("src/main/resources/json/02front.json"), CardJSON.class));
        resourceDeck.add(mapper.readValue(new File("src/main/resources/json/03front.json"), CardJSON.class));
        resourceDeck.add(mapper.readValue(new File("src/main/resources/json/04front.json"), CardJSON.class));
        resourceDeck.add(mapper.readValue(new File("src/main/resources/json/05front.json"), CardJSON.class));
        resourceDeck.add(mapper.readValue(new File("src/main/resources/json/06front.json"), CardJSON.class));
        resourceDeck.add(mapper.readValue(new File("src/main/resources/json/07front.json"), CardJSON.class));
        resourceDeck.add(mapper.readValue(new File("src/main/resources/json/08front.json"), CardJSON.class));
        resourceDeck.add(mapper.readValue(new File("src/main/resources/json/09front.json"), CardJSON.class));
        for (int i = 10; i<41; i++){
            resourceDeck.add(mapper.readValue(new File("src/main/resources/json/"+ i +"front.json"), CardJSON.class));
        }
    }

    private void generateCommonGoals() throws IOException {
        path1 =  RandomCardFile.getRandomOXXFileName().replace("jpg","json");
        cg1 = mapper.readValue(new File("src/main/resources/json/" + path1), CardJSON.class);
        path2 =  RandomCardFile.getRandomOXXFileName().replace("jpg","json");
        cg2 = mapper.readValue(new File("src/main/resources/json/" + path2), CardJSON.class);

    }

    public void turn() {
        for(int i = 0; i < Server.getNumPlayers(); i++){
            System.out.println("Player number " + i);

        }
    }
}
