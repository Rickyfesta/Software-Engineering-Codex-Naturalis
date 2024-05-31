package Client.GUI.SceneControllers;

import Client.Client;
import Controller.BoardManager;
import Controller.CardPicker;
import Model.Cards.CardJSON;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.*;


public class GameBoard {


    @FXML
    private ImageView CardHand1;

    @FXML
    private ImageView CardHand2;

    @FXML
    private ImageView CardHand3;

    @FXML
    private ImageView CommonObj1;

    @FXML
    private ImageView CommonObj2;

    @FXML
    private ImageView DecksBG;

    @FXML
    private ImageView Down1;

    @FXML
    private ImageView Down10;

    @FXML
    private ImageView Down2;

    @FXML
    private ImageView Down3;

    @FXML
    private ImageView Down4;

    @FXML
    private ImageView Down5;

    @FXML
    private ImageView Down6;

    @FXML
    private ImageView Down7;

    @FXML
    private ImageView Down8;

    @FXML
    private ImageView Down9;

    @FXML
    private ImageView GoldDeck;

    @FXML
    private ImageView GoldDeck1;

    @FXML
    private ImageView GoldDeck2;

    @FXML
    private ImageView Left1;

    @FXML
    private ImageView Left10;

    @FXML
    private ImageView Left1Down1;

    @FXML
    private ImageView Left1Down2;

    @FXML
    private ImageView Left1Down3;

    @FXML
    private ImageView Left1Down4;

    @FXML
    private ImageView Left1Down5;

    @FXML
    private ImageView Left1Up1;


    @FXML
    private ImageView Left1Up2;

    @FXML
    private ImageView Left1Up3;

    @FXML
    private ImageView Left1Up4;

    @FXML
    private ImageView Left1Up5;

    @FXML
    private ImageView Left2;

    @FXML
    private ImageView Left2Down1;

    @FXML
    private ImageView Left2Down2;

    @FXML
    private ImageView Left2Down3;

    @FXML
    private ImageView Left2Down4;

    @FXML
    private ImageView Left2Up1;

    @FXML
    private ImageView Left2Up2;

    @FXML
    private ImageView Left2Up3;

    @FXML
    private ImageView Left2Up4;

    @FXML
    private ImageView Left3;

    @FXML
    private ImageView Left3Down1;

    @FXML
    private ImageView Left3Down2;

    @FXML
    private ImageView Left3Down3;

    @FXML
    private ImageView Left3Up1;

    @FXML
    private ImageView Left3Up2;

    @FXML
    private ImageView Left3Up3;

    @FXML
    private ImageView Left4;

    @FXML
    private ImageView Left4Down1;

    @FXML
    private ImageView Left4Down2;

    @FXML
    private ImageView Left4Up1;

    @FXML
    private ImageView Left4Up2;

    @FXML
    private ImageView Left5;

    @FXML
    private ImageView Left5Down1;

    @FXML
    private ImageView Left5Up1;

    @FXML
    private ImageView Left6;

    @FXML
    private ImageView Left7;

    @FXML
    private ImageView Left8;

    @FXML
    private ImageView Left9;

    @FXML
    private ImageView PersonalObj;

    @FXML
    private ImageView ResDeck;

    @FXML
    private ImageView ResDeck2;

    @FXML
    private ImageView ResDeck3;

    @FXML
    private ImageView Right1;

    @FXML
    private ImageView Right10;

    @FXML
    private ImageView Right1Down1;

    @FXML
    private ImageView Right1Down2;

    @FXML
    private ImageView Right1Down3;

    @FXML
    private ImageView Right1Down4;

    @FXML
    private ImageView Right1Down5;

    @FXML
    private ImageView Right1Up1;


    @FXML
    private ImageView Right1Up2;

    @FXML
    private ImageView Right1Up3;

    @FXML
    private ImageView Right1Up4;

    @FXML
    private ImageView Right1Up5;

    @FXML
    private ImageView Right2;

    @FXML
    private ImageView Right2Down1;

    @FXML
    private ImageView Right2Down2;

    @FXML
    private ImageView Right2Down3;

    @FXML
    private ImageView Right2Down4;

    @FXML
    private ImageView Right2Up1;

    @FXML
    private ImageView Right2Up2;

    @FXML
    private ImageView Right2Up3;

    @FXML
    private ImageView Right2Up4;

    @FXML
    private ImageView Right3;

    @FXML
    private ImageView Right3Down1;

    @FXML
    private ImageView Right3Down2;

    @FXML
    private ImageView Right3Down3;

    @FXML
    private ImageView Right3Up1;

    @FXML
    private ImageView Right3Up2;

    @FXML
    private ImageView Right3Up3;

    @FXML
    private ImageView Right4;


    @FXML
    private ImageView Right4Down1;

    @FXML
    private ImageView Right4Down2;

    @FXML
    private ImageView Right4Up1;

    @FXML
    private ImageView Right4Up2;


    @FXML
    private ImageView Right5;

    @FXML
    private ImageView Right5Down1;

    @FXML
    private ImageView Right5Up1;

    @FXML
    private ImageView Right6;

    @FXML
    private ImageView Right7;

    @FXML
    private ImageView Right8;

    @FXML
    private ImageView Right9;

    @FXML
    private ImageView StartingCard;

    @FXML
    private ImageView Up1;

    @FXML
    private ImageView Up2;

    @FXML
    private ImageView Up3;

    @FXML
    private ImageView Up4;

    @FXML
    private ImageView Up5;

    @FXML
    private ImageView Up6;

    @FXML
    private ImageView Up7;

    @FXML
    private ImageView Up8;

    @FXML
    private ImageView Up9;

    @FXML
    private Text ampNumber;

    @FXML
    private ImageView ampRes;

    @FXML
    private Text animalNumber;

    @FXML
    private ImageView animalRes;

    @FXML
    private ImageView backgroundBoard;

    @FXML
    private AnchorPane commonBoardDecksContainer;

    @FXML
    private Text commonGoalText;

    @FXML
    private ImageView copy;

    @FXML
    private Text featherNumber;

    @FXML
    private ImageView featherRes;

    @FXML
    private ImageView handBg;

    @FXML
    private Text insectNumber;

    @FXML
    private ImageView insectRes;

    @FXML
    private Text mushroomNumber;

    @FXML
    private ImageView mushroomRes;

    @FXML
    private Text myPoints;

    @FXML
    private ImageView objbackground;

    @FXML
    private AnchorPane personalBoardContainer;

    @FXML
    private ScrollPane personalBoardScroll;

    @FXML
    private Text personalGoalText;

    @FXML
    private Text plantNumber;

    @FXML
    private ImageView plantRes;

    @FXML
    private Text scrollNumber;

    @FXML
    private ImageView scrollRes;

    @FXML
    private Button showBtn;
    @FXML
    private Pane allContainer;
    @FXML
    private AnchorPane handContainer;
    public static List<ImageView> DecksList;
    public static List<ImageView> imageViewList;
    public static List<Text> ResourcesList;

    public static List<Text> MyPoints;

    private boolean clicked = false;

    String rec;
    Client client;


    @FXML
    public void selectHandCard1(MouseEvent event){
        if(!clicked) {
            clicked = true;
            Client.sendMessage("first");

        }
    }

    @FXML
    public void selectHandCard2(MouseEvent event){
        if(!clicked) {
            clicked = true;
            Client.sendMessage("second");

        }
    }

    @FXML
    public void selectHandCard3(MouseEvent event){
        if(!clicked) {
            clicked = true;
            Client.sendMessage("third");

        }
    }

    static FXMLLoader loader = new FXMLLoader();
    public static Stage stage;

    public AnchorPane getAnchorPane() {
        return personalBoardContainer;
    }
    @FXML
    public void showBoardandCards(MouseEvent event) {
        if ((event.getButton() == MouseButton.PRIMARY || event.getButton() == MouseButton.SECONDARY)  && commonBoardDecksContainer.getPrefWidth() == 0){ // Only expand if it's collapsed
            commonBoardDecksContainer.setPrefWidth(800.0d);
            //System.out.println("Creating action for right click");
            commonBoardDecksContainer.translateXProperty().set(-1 * 800.0d);
            var keyValue = new KeyValue(commonBoardDecksContainer.translateXProperty(), 0, Interpolator.EASE_IN);
            var keyFrame = new KeyFrame(Duration.millis(900), keyValue);
            showBtn.translateXProperty().set(-1 * 800.0d);
            var keyValueBtn = new KeyValue(showBtn.translateXProperty(), 0, Interpolator.EASE_IN);
            var keyFrameBtn = new KeyFrame(Duration.millis(900), keyValueBtn);
            var timeline = new Timeline(keyFrameBtn, keyFrame);
            timeline.play();
            commonBoardDecksContainer.setLayoutX(0);
            showBtn.setLayoutX(655);
            showBtn.setText("<");
            ResDeck.setVisible(true);
            GoldDeck.setVisible(true);
            ResDeck.setFitWidth(215);
            GoldDeck.setFitWidth(215);
            //System.out.println("Right" + commonBoardDecksContainer.getPrefWidth());
        } else if((event.getButton() == MouseButton.PRIMARY || event.getButton() == MouseButton.SECONDARY)  && commonBoardDecksContainer.getPrefWidth() == 800){
            dismissTop();
        }
    }
    private void dismissTop() {
        //System.out.println("Left click detected");
         // Only collapse if it's expanded
            //System.out.println("Creating action for left click");
            commonBoardDecksContainer.translateXProperty().set(0.0d);
            var keyValue = new KeyValue(commonBoardDecksContainer.translateXProperty(), -650, Interpolator.EASE_IN);
            var keyFrame = new KeyFrame(Duration.millis(900), keyValue);
            var timeline = new Timeline(keyFrame);
            timeline.play();
            commonBoardDecksContainer.setLayoutX(-1 * 650);
            showBtn.setLayoutX(0);
            showBtn.setText(">");
            ResDeck.setVisible(false);
            GoldDeck.setVisible(false);
            ResDeck.setFitWidth(0);
            GoldDeck.setFitWidth(0);
            personalBoardScroll.setPrefWidth(1400);
            personalBoardContainer.setPrefWidth(4000);
            personalBoardScroll.pannableProperty();
        commonBoardDecksContainer.setPrefWidth(0.0d);
        //System.out.println("Left" + commonBoardDecksContainer.getPrefWidth());
    }
    @FXML
    void initialize() throws IOException {

        CardsController cardsController = new CardsController(this);
        CardPicker cardPicker = new CardPicker(this);

        MyPoints = Collections.singletonList(
                myPoints
        );

        ResourcesList = Arrays.asList(
                mushroomNumber, animalNumber, insectNumber, plantNumber,
                ampNumber, featherNumber, scrollNumber
        );

        DecksList = Arrays.asList(
                ResDeck, ResDeck2, ResDeck3, GoldDeck, GoldDeck1, GoldDeck2
        );

        imageViewList = Arrays.asList(
                StartingCard,
                Down1, Down10, Down2, Down3,
                Down4,  Down5, Down6, Down7,
                Down8, Down9, Left1, Left10,  Left1Down1,  Left1Down2, Left1Down3, Left1Down4, Left1Down5,
                   Left1Up1,  Left1Up2, Left1Up3, Left1Up4, Left1Up5,
                  Left2,
                Left2Down1, Left2Down2, Left2Down3, Left2Down4,   Left2Up1,
                Left2Up2, Left2Up3, Left2Up4,   Left3,  Left3Down1, Left3Down2, Left3Down3,
                  Left3Up1, Left3Up2, Left3Up3,   Left4,
                Left4Down1, Left4Down2,   Left4Up1, Left4Up2,
                   Left5, Left5Down1,
                Left5Up1,     Left6,
                     Left7,
                Left8,    Left9,
                   Right1, Right10, Right1Down1,
                   Right1, Right10, Right1Down1,
                Right1Down2, Right1Down3, Right1Down4, Right1Down5,  Right1Up1,
                Right1Up2, Right1Up3, Right1Up4, Right1Up5,   Right2,
                Right2Down1, Right2Down2, Right2Down3,
                Right2Down4,   Right2Up1, Right2Up2, Right2Up3,
                Right2Up4,  Right3, Right3Down1, Right3Down2, Right3Down3,
                  Right3Up1, Right3Up2, Right3Up3,  Right4,
                 Right4Down1, Right4Down2,  Right4Up1, Right4Up2,
                  Right5, Right5Down1,
                  Right5Up1,   Right6,
                    Right7,
                Right8,    Right9,
                Up1,  Up2,  Up3,  Up4, Up5, Up6, Up7, Up8, Up9
        );

        //TODO optimize useless operations
        commonBoardDecksContainer.setPrefWidth(0.0d);
        ResDeck.setVisible(false);
        GoldDeck.setVisible(false);
        ObjectMapper boardMapper = new ObjectMapper();
        boardMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        //deserialize all the cards

        //initialize the personal board
        //BoardManager.initializeBoard(startingCard, ResourcesList);

/*
        CardJSON Card1 = boardMapper.readValue(new File("src/main/resources/json/" + url1.replace("jpg", "json")), CardJSON.class);
        CardJSON Card2 = boardMapper.readValue(new File("src/main/resources/json/" + url2.replace("jpg", "json")), CardJSON.class);
        CardJSON Card3 = boardMapper.readValue(new File("src/main/resources/json/" + url3.replace("jpg", "json")), CardJSON.class);
 */

        String id1 = Client.getVirtualModel().getPersonalGoal().getID();
        String id2 = Client.getVirtualModel().getCg1().getID();
        String id3 = Client.getVirtualModel().getCg2().getID();

        URL url1 = getClass().getResource("/Images/" + id1 + "front.jpg");
        URL url2 = getClass().getResource("/Images/" + id2 + "front.jpg");
        URL url3 = getClass().getResource("/Images/" + id3 + "front.jpg");
        PersonalObj.setImage(new Image(url1.toString()));
        CommonObj1.setImage(new Image(url2.toString()));
        CommonObj2.setImage(new Image(url3.toString()));


        String CardHand1s = Client.getVirtualModel().getHand().getCardOne().getID().replaceFirst("0", "");
        String CardHand2s = Client.getVirtualModel().getHand().getCardTwo().getID().replaceFirst("0", "");
        String CardHand3s = Client.getVirtualModel().getHand().getCardThree().getID();

        URL HandUrl1 = getClass().getResource("/Images/" + CardHand1s + "front.jpg");
        URL HandUrl2 = getClass().getResource("/Images/" + CardHand2s + "front.jpg");
        URL HandUrl3 = getClass().getResource("/Images/" + CardHand3s + "front.jpg");
        CardHand3.setImage(new Image(HandUrl1.toString()));
        CardHand2.setImage(new Image(HandUrl2.toString()));
        CardHand1.setImage(new Image(HandUrl3.toString()));

        String Start = Client.getVirtualModel().getChosenStarter().getID();

        URL Starturl = getClass().getResource("/Images/"+ Start + ".jpg");
        StartingCard.setImage(new Image(Starturl.toString()));

        BoardManager.initializeBoard(Client.getVirtualModel().getChosenStarter(), ResourcesList);
        //ResourcesCounter.updateResources(Client.getVirtualModel().getChosenStarter(), MyPoints);
        Random rand = new Random();

        System.out.println("AAAA" + Client.getVirtualModel().getGoldDeck().getClass());
        ArrayList<CardJSON> goldDeck = Client.getVirtualModel().getGoldDeck();
        System.out.println("GOLD SIZE: " + goldDeck.size());
        System.out.println("GOLD DECK: " + goldDeck);

        for(int i = 0; i<goldDeck.size(); i++){
            System.out.println("CARD " + i + " " + goldDeck.get(i));
            System.out.println("CARD " + i + " " + (goldDeck.get(i) instanceof CardJSON));
            //String sos = goldDeck.get(i).getID();
        }

        Random random = new Random();
        CardJSON gold1 = Client.getVirtualModel().getGoldDeck().get(random.nextInt(Client.getVirtualModel().getGoldDeck().size()-1));
        CardJSON gold2 = Client.getVirtualModel().getGoldDeck().get(random.nextInt(Client.getVirtualModel().getGoldDeck().size()-1));
        CardJSON gold3 = Client.getVirtualModel().getGoldDeck().get(random.nextInt(Client.getVirtualModel().getGoldDeck().size()-1));

        String GoldId1 = gold1.getID();
        String GoldId2 = gold2.getID();
        String GoldId3 = gold3.getID();

        URL GoldURL1 = getClass().getResource("/Images/" + GoldId1 + "front.jpg");
        URL GoldURL2 = getClass().getResource("/Images/" + GoldId2 + "front.jpg");
        URL GoldURL3 = getClass().getResource("/Images/" + GoldId3 + "front.jpg");
        GoldDeck.setImage(new Image(GoldURL1.toString()));
        GoldDeck1.setImage(new Image(GoldURL2.toString()));
        GoldDeck2.setImage(new Image(GoldURL3.toString()));



        CardJSON Res1 = Client.getVirtualModel().getResourceDeck().get(random.nextInt(Client.getVirtualModel().getGoldDeck().size()-1));
        CardJSON Res2 = Client.getVirtualModel().getResourceDeck().get(random.nextInt(Client.getVirtualModel().getGoldDeck().size()-1));
        CardJSON Res3 = Client.getVirtualModel().getResourceDeck().get(random.nextInt(Client.getVirtualModel().getGoldDeck().size()-1));

        String ResId1 = Res1.getID().replaceFirst("0", "");
        String ResId2 = Res2.getID().replaceFirst("0", "");
        String ResId3 = Res3.getID().replaceFirst("0", "");
        System.out.println(Res1.getID());
        URL ResURL1 = getClass().getResource("/Images/" + ResId1 + "front.jpg");
        URL ResURL2 = getClass().getResource("/Images/" + ResId2 + "front.jpg");
        URL ResURL3 = getClass().getResource("/Images/" + ResId3 + "front.jpg");
        ResDeck.setImage(new Image(ResURL1.toString()));
        ResDeck2.setImage(new Image(ResURL2.toString()));
        ResDeck3.setImage(new Image(ResURL3.toString()));

        //rec = Client.getInstance().checkForMSG();
        while(!Client.isTurn()){
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        if(Client.isTurn()){
            //Here i make draggable all the cards inside my hand to make them placeable
            cardsController.makeDraggable(CardHand1, personalBoardScroll, 508, 650, copy, personalBoardContainer, Starturl.toString(), imageViewList, ResourcesList, "first");
            cardsController.makeDraggable(CardHand2, personalBoardScroll, 801, 650, copy, personalBoardContainer, Starturl.toString(), imageViewList, ResourcesList, "second");
            cardsController.makeDraggable(CardHand3, personalBoardScroll, 1064, 650, copy, personalBoardContainer, Starturl.toString(), imageViewList, ResourcesList, "third");
            cardPicker.makePickable(ResDeck, DecksList);
            cardPicker.makePickable(ResDeck2, DecksList);
            cardPicker.makePickable(ResDeck3, DecksList);
            cardPicker.makePickable(GoldDeck, DecksList);
            cardPicker.makePickable(GoldDeck1, DecksList);
            cardPicker.makePickable(GoldDeck2, DecksList);
            if(Integer.parseInt(MyPoints.get(0).getText()) >= 20){
                Client.sendMessage("win");
                Parent root;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/WinnerScene.fxml")));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            }
        }






        //StartingCard.setImage(new Image("/" + StartUrl));

        //Make the cards pickable from deck



        assert CardHand1 != null : "fx:id=\"CardHand1\" was not injected: check your FXML file 'Game.fxml'.";
        assert CardHand2 != null : "fx:id=\"CardHand2\" was not injected: check your FXML file 'Game.fxml'.";
        assert CardHand3 != null : "fx:id=\"CardHand3\" was not injected: check your FXML file 'Game.fxml'.";
        assert CommonObj1 != null : "fx:id=\"CommonObj\" was not injected: check your FXML file 'Game.fxml'.";
        assert CommonObj2 != null : "fx:id=\"CommonObj\" was not injected: check your FXML file 'Game.fxml'.";
        assert Down1 != null : "fx:id=\"Down1\" was not injected: check your FXML file 'Game.fxml'.";
        assert GoldDeck != null : "fx:id=\"GoldDeck\" was not injected: check your FXML file 'Game.fxml'.";
        assert GoldDeck1 != null : "fx:id=\"GoldDeck1\" was not injected: check your FXML file 'Game.fxml'.";
        assert GoldDeck2 != null : "fx:id=\"GoldDeck2\" was not injected: check your FXML file 'Game.fxml'.";
        assert Left1 != null : "fx:id=\"Left1\" was not injected: check your FXML file 'Game.fxml'.";
        assert PersonalObj != null : "fx:id=\"PersonalObj\" was not injected: check your FXML file 'Game.fxml'.";
        assert ResDeck != null : "fx:id=\"ResDeck\" was not injected: check your FXML file 'Game.fxml'.";
        assert ResDeck2 != null : "fx:id=\"ResDeck2\" was not injected: check your FXML file 'Game.fxml'.";
        assert ResDeck3 != null : "fx:id=\"ResDeck2\" was not injected: check your FXML file 'Game.fxml'.";
        assert Right1 != null : "fx:id=\"Right1\" was not injected: check your FXML file 'Game.fxml'.";
        assert StartingCard != null : "fx:id=\"StartingCard\" was not injected: check your FXML file 'Game.fxml'.";
        assert Up1 != null : "fx:id=\"Up1\" was not injected: check your FXML file 'Game.fxml'.";
        assert allContainer != null : "fx:id=\"allContainer\" was not injected: check your FXML file 'Game.fxml'.";
        assert commonBoardDecksContainer != null : "fx:id=\"commonBoardDecksContainer\" was not injected: check your FXML file 'Game.fxml'.";
        assert commonGoalText != null : "fx:id=\"commonGoalText\" was not injected: check your FXML file 'Game.fxml'.";
        assert handBg != null : "fx:id=\"handBg\" was not injected: check your FXML file 'Game.fxml'.";
        assert handContainer != null : "fx:id=\"handContainer\" was not injected: check your FXML file 'Game.fxml'.";
        assert objbackground != null : "fx:id=\"objbackground\" was not injected: check your FXML file 'Game.fxml'.";
        assert personalBoardContainer != null : "fx:id=\"personalBoardContainer\" was not injected: check your FXML file 'Game.fxml'.";
        assert personalBoardScroll != null : "fx:id=\"personalBoardScroll\" was not injected: check your FXML file 'Game.fxml'.";
        assert personalGoalText != null : "fx:id=\"personalGoalText\" was not injected: check your FXML file 'Game.fxml'.";

    }
}
