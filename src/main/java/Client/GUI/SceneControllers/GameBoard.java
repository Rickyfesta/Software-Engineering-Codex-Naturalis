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
    private ImageView Down11;

    @FXML
    private ImageView Down12;

    @FXML
    private ImageView Down13;

    @FXML
    private ImageView Down14;

    @FXML
    private ImageView Down15;

    @FXML
    private ImageView Down16;

    @FXML
    private ImageView Down17;

    @FXML
    private ImageView Down18;

    @FXML
    private ImageView Down19;

    @FXML
    private ImageView Down2;

    @FXML
    private ImageView Down20;

    @FXML
    private ImageView Down21;

    @FXML
    private ImageView Down22;

    @FXML
    private ImageView Down23;

    @FXML
    private ImageView Down24;

    @FXML
    private ImageView Down25;

    @FXML
    private ImageView Down26;

    @FXML
    private ImageView Down27;

    @FXML
    private ImageView Down28;

    @FXML
    private ImageView Down29;

    @FXML
    private ImageView Down3;

    @FXML
    private ImageView Down30;

    @FXML
    private ImageView Down31;

    @FXML
    private ImageView Down32;

    @FXML
    private ImageView Down33;

    @FXML
    private ImageView Down34;

    @FXML
    private ImageView Down35;

    @FXML
    private ImageView Down36;

    @FXML
    private ImageView Down37;

    @FXML
    private ImageView Down38;

    @FXML
    private ImageView Down39;

    @FXML
    private ImageView Down4;

    @FXML
    private ImageView Down40;

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
    private ImageView Left10Down1;

    @FXML
    private ImageView Left10Up1;

    @FXML
    private ImageView Left11;

    @FXML
    private ImageView Left12;

    @FXML
    private ImageView Left13;

    @FXML
    private ImageView Left14;

    @FXML
    private ImageView Left15;

    @FXML
    private ImageView Left16;

    @FXML
    private ImageView Left17;

    @FXML
    private ImageView Left18;

    @FXML
    private ImageView Left19;

    @FXML
    private ImageView Left1Down1;

    @FXML
    private ImageView Left1Down10;

    @FXML
    private ImageView Left1Down2;

    @FXML
    private ImageView Left1Down3;

    @FXML
    private ImageView Left1Down4;

    @FXML
    private ImageView Left1Down5;

    @FXML
    private ImageView Left1Down6;

    @FXML
    private ImageView Left1Down7;

    @FXML
    private ImageView Left1Down8;

    @FXML
    private ImageView Left1Down9;

    @FXML
    private ImageView Left1Up1;

    @FXML
    private ImageView Left1Up10;

    @FXML
    private ImageView Left1Up2;

    @FXML
    private ImageView Left1Up3;

    @FXML
    private ImageView Left1Up4;

    @FXML
    private ImageView Left1Up5;

    @FXML
    private ImageView Left1Up6;

    @FXML
    private ImageView Left1Up7;

    @FXML
    private ImageView Left1Up8;

    @FXML
    private ImageView Left1Up9;

    @FXML
    private ImageView Left2;

    @FXML
    private ImageView Left20;

    @FXML
    private ImageView Left21;

    @FXML
    private ImageView Left22;

    @FXML
    private ImageView Left23;

    @FXML
    private ImageView Left24;

    @FXML
    private ImageView Left25;

    @FXML
    private ImageView Left26;

    @FXML
    private ImageView Left27;

    @FXML
    private ImageView Left28;

    @FXML
    private ImageView Left29;

    @FXML
    private ImageView Left2Down1;

    @FXML
    private ImageView Left2Down2;

    @FXML
    private ImageView Left2Down3;

    @FXML
    private ImageView Left2Down4;

    @FXML
    private ImageView Left2Down5;

    @FXML
    private ImageView Left2Down6;

    @FXML
    private ImageView Left2Down7;

    @FXML
    private ImageView Left2Down8;

    @FXML
    private ImageView Left2Down9;

    @FXML
    private ImageView Left2Up1;

    @FXML
    private ImageView Left2Up2;

    @FXML
    private ImageView Left2Up3;

    @FXML
    private ImageView Left2Up4;

    @FXML
    private ImageView Left2Up5;

    @FXML
    private ImageView Left2Up6;

    @FXML
    private ImageView Left2Up7;

    @FXML
    private ImageView Left2Up8;

    @FXML
    private ImageView Left2Up9;

    @FXML
    private ImageView Left3;

    @FXML
    private ImageView Left30;

    @FXML
    private ImageView Left31;

    @FXML
    private ImageView Left32;

    @FXML
    private ImageView Left33;

    @FXML
    private ImageView Left34;

    @FXML
    private ImageView Left35;

    @FXML
    private ImageView Left36;

    @FXML
    private ImageView Left37;

    @FXML
    private ImageView Left38;

    @FXML
    private ImageView Left39;

    @FXML
    private ImageView Left3Down1;

    @FXML
    private ImageView Left3Down2;

    @FXML
    private ImageView Left3Down3;

    @FXML
    private ImageView Left3Down4;

    @FXML
    private ImageView Left3Down5;

    @FXML
    private ImageView Left3Down6;

    @FXML
    private ImageView Left3Down7;

    @FXML
    private ImageView Left3Down8;

    @FXML
    private ImageView Left3Up1;

    @FXML
    private ImageView Left3Up2;

    @FXML
    private ImageView Left3Up3;

    @FXML
    private ImageView Left3Up4;

    @FXML
    private ImageView Left3Up5;

    @FXML
    private ImageView Left3Up6;

    @FXML
    private ImageView Left3Up7;

    @FXML
    private ImageView Left3Up8;

    @FXML
    private ImageView Left4;

    @FXML
    private ImageView Left40;

    @FXML
    private ImageView Left4Down1;

    @FXML
    private ImageView Left4Down2;

    @FXML
    private ImageView Left4Down3;

    @FXML
    private ImageView Left4Down4;

    @FXML
    private ImageView Left4Down5;

    @FXML
    private ImageView Left4Down6;

    @FXML
    private ImageView Left4Down7;

    @FXML
    private ImageView Left4Up1;

    @FXML
    private ImageView Left4Up2;

    @FXML
    private ImageView Left4Up3;

    @FXML
    private ImageView Left4Up4;

    @FXML
    private ImageView Left4Up5;

    @FXML
    private ImageView Left4Up6;

    @FXML
    private ImageView Left4Up7;

    @FXML
    private ImageView Left5;

    @FXML
    private ImageView Left5Down1;

    @FXML
    private ImageView Left5Down2;

    @FXML
    private ImageView Left5Down3;

    @FXML
    private ImageView Left5Down4;

    @FXML
    private ImageView Left5Down5;

    @FXML
    private ImageView Left5Down6;

    @FXML
    private ImageView Left5Up1;

    @FXML
    private ImageView Left5Up2;

    @FXML
    private ImageView Left5Up3;

    @FXML
    private ImageView Left5Up4;

    @FXML
    private ImageView Left5Up5;

    @FXML
    private ImageView Left5Up6;

    @FXML
    private ImageView Left6;

    @FXML
    private ImageView Left6Down1;

    @FXML
    private ImageView Left6Down2;

    @FXML
    private ImageView Left6Down3;

    @FXML
    private ImageView Left6Down4;

    @FXML
    private ImageView Left6Down5;

    @FXML
    private ImageView Left6Up1;

    @FXML
    private ImageView Left6Up2;

    @FXML
    private ImageView Left6Up3;

    @FXML
    private ImageView Left6Up4;

    @FXML
    private ImageView Left6Up5;

    @FXML
    private ImageView Left7;

    @FXML
    private ImageView Left7Down1;

    @FXML
    private ImageView Left7Down2;

    @FXML
    private ImageView Left7Down3;

    @FXML
    private ImageView Left7Down4;

    @FXML
    private ImageView Left7Up1;

    @FXML
    private ImageView Left7Up2;

    @FXML
    private ImageView Left7Up3;

    @FXML
    private ImageView Left7Up4;

    @FXML
    private ImageView Left8;

    @FXML
    private ImageView Left8Down1;

    @FXML
    private ImageView Left8Down2;

    @FXML
    private ImageView Left8Down3;

    @FXML
    private ImageView Left8Up1;

    @FXML
    private ImageView Left8Up2;

    @FXML
    private ImageView Left8Up3;

    @FXML
    private ImageView Left9;

    @FXML
    private ImageView Left9Down1;

    @FXML
    private ImageView Left9Down2;

    @FXML
    private ImageView Left9Up1;

    @FXML
    private ImageView Left9Up2;

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
    private ImageView Right10Down1;

    @FXML
    private ImageView Right10Up1;

    @FXML
    private ImageView Right11;

    @FXML
    private ImageView Right12;

    @FXML
    private ImageView Right13;

    @FXML
    private ImageView Right14;

    @FXML
    private ImageView Right15;

    @FXML
    private ImageView Right16;

    @FXML
    private ImageView Right17;

    @FXML
    private ImageView Right18;

    @FXML
    private ImageView Right19;

    @FXML
    private ImageView Right1Down1;

    @FXML
    private ImageView Right1Down10;

    @FXML
    private ImageView Right1Down2;

    @FXML
    private ImageView Right1Down3;

    @FXML
    private ImageView Right1Down4;

    @FXML
    private ImageView Right1Down5;

    @FXML
    private ImageView Right1Down6;

    @FXML
    private ImageView Right1Down7;

    @FXML
    private ImageView Right1Down8;

    @FXML
    private ImageView Right1Down9;

    @FXML
    private ImageView Right1Up1;

    @FXML
    private ImageView Right1Up10;

    @FXML
    private ImageView Right1Up2;

    @FXML
    private ImageView Right1Up3;

    @FXML
    private ImageView Right1Up4;

    @FXML
    private ImageView Right1Up5;

    @FXML
    private ImageView Right1Up6;

    @FXML
    private ImageView Right1Up7;

    @FXML
    private ImageView Right1Up8;

    @FXML
    private ImageView Right1Up9;

    @FXML
    private ImageView Right2;

    @FXML
    private ImageView Right20;

    @FXML
    private ImageView Right21;

    @FXML
    private ImageView Right22;

    @FXML
    private ImageView Right23;

    @FXML
    private ImageView Right24;

    @FXML
    private ImageView Right25;

    @FXML
    private ImageView Right26;

    @FXML
    private ImageView Right27;

    @FXML
    private ImageView Right28;

    @FXML
    private ImageView Right29;

    @FXML
    private ImageView Right2Down1;

    @FXML
    private ImageView Right2Down2;

    @FXML
    private ImageView Right2Down3;

    @FXML
    private ImageView Right2Down4;

    @FXML
    private ImageView Right2Down5;

    @FXML
    private ImageView Right2Down6;

    @FXML
    private ImageView Right2Down7;

    @FXML
    private ImageView Right2Down8;

    @FXML
    private ImageView Right2Down9;

    @FXML
    private ImageView Right2Up1;

    @FXML
    private ImageView Right2Up2;

    @FXML
    private ImageView Right2Up3;

    @FXML
    private ImageView Right2Up4;

    @FXML
    private ImageView Right2Up5;

    @FXML
    private ImageView Right2Up6;

    @FXML
    private ImageView Right2Up7;

    @FXML
    private ImageView Right2Up8;

    @FXML
    private ImageView Right2Up9;

    @FXML
    private ImageView Right3;

    @FXML
    private ImageView Right30;

    @FXML
    private ImageView Right31;

    @FXML
    private ImageView Right32;

    @FXML
    private ImageView Right33;

    @FXML
    private ImageView Right34;

    @FXML
    private ImageView Right35;

    @FXML
    private ImageView Right36;

    @FXML
    private ImageView Right37;

    @FXML
    private ImageView Right38;

    @FXML
    private ImageView Right39;

    @FXML
    private ImageView Right3Down1;

    @FXML
    private ImageView Right3Down2;

    @FXML
    private ImageView Right3Down3;

    @FXML
    private ImageView Right3Down4;

    @FXML
    private ImageView Right3Down5;

    @FXML
    private ImageView Right3Down6;

    @FXML
    private ImageView Right3Down7;

    @FXML
    private ImageView Right3Down8;

    @FXML
    private ImageView Right3Up1;

    @FXML
    private ImageView Right3Up2;

    @FXML
    private ImageView Right3Up3;

    @FXML
    private ImageView Right3Up4;

    @FXML
    private ImageView Right3Up5;

    @FXML
    private ImageView Right3Up6;

    @FXML
    private ImageView Right3Up7;

    @FXML
    private ImageView Right3Up8;

    @FXML
    private ImageView Right4;

    @FXML
    private ImageView Right40;

    @FXML
    private ImageView Right4Down1;

    @FXML
    private ImageView Right4Down2;

    @FXML
    private ImageView Right4Down3;

    @FXML
    private ImageView Right4Down4;

    @FXML
    private ImageView Right4Down5;

    @FXML
    private ImageView Right4Down6;

    @FXML
    private ImageView Right4Down7;

    @FXML
    private ImageView Right4Up1;

    @FXML
    private ImageView Right4Up2;

    @FXML
    private ImageView Right4Up3;

    @FXML
    private ImageView Right4Up4;

    @FXML
    private ImageView Right4Up5;

    @FXML
    private ImageView Right4Up6;

    @FXML
    private ImageView Right4Up7;

    @FXML
    private ImageView Right5;

    @FXML
    private ImageView Right5Down1;

    @FXML
    private ImageView Right5Down2;

    @FXML
    private ImageView Right5Down3;

    @FXML
    private ImageView Right5Down4;

    @FXML
    private ImageView Right5Down5;

    @FXML
    private ImageView Right5Down6;

    @FXML
    private ImageView Right5Up1;

    @FXML
    private ImageView Right5Up2;

    @FXML
    private ImageView Right5Up3;

    @FXML
    private ImageView Right5Up4;

    @FXML
    private ImageView Right5Up5;

    @FXML
    private ImageView Right5Up6;

    @FXML
    private ImageView Right6;

    @FXML
    private ImageView Right6Down1;

    @FXML
    private ImageView Right6Down2;

    @FXML
    private ImageView Right6Down3;

    @FXML
    private ImageView Right6Down4;

    @FXML
    private ImageView Right6Down5;

    @FXML
    private ImageView Right6Up1;

    @FXML
    private ImageView Right6Up2;

    @FXML
    private ImageView Right6Up3;

    @FXML
    private ImageView Right6Up4;

    @FXML
    private ImageView Right6Up5;

    @FXML
    private ImageView Right7;

    @FXML
    private ImageView Right7Down1;

    @FXML
    private ImageView Right7Down2;

    @FXML
    private ImageView Right7Down3;

    @FXML
    private ImageView Right7Down4;

    @FXML
    private ImageView Right7Up1;

    @FXML
    private ImageView Right7Up2;

    @FXML
    private ImageView Right7Up3;

    @FXML
    private ImageView Right7Up4;

    @FXML
    private ImageView Right8;

    @FXML
    private ImageView Right8Down1;

    @FXML
    private ImageView Right8Down2;

    @FXML
    private ImageView Right8Down3;

    @FXML
    private ImageView Right8Up1;

    @FXML
    private ImageView Right8Up2;

    @FXML
    private ImageView Right8Up3;

    @FXML
    private ImageView Right9;

    @FXML
    private ImageView Right9Down1;

    @FXML
    private ImageView Right9Down2;

    @FXML
    private ImageView Right9Up1;

    @FXML
    private ImageView Right9Up2;

    @FXML
    private ImageView StartingCard;

    @FXML
    private ImageView Up1;

    @FXML
    private ImageView Up10;

    @FXML
    private ImageView Up11;

    @FXML
    private ImageView Up12;

    @FXML
    private ImageView Up13;

    @FXML
    private ImageView Up14;

    @FXML
    private ImageView Up15;

    @FXML
    private ImageView Up16;

    @FXML
    private ImageView Up17;

    @FXML
    private ImageView Up18;

    @FXML
    private ImageView Up19;

    @FXML
    private ImageView Up2;

    @FXML
    private ImageView Up20;

    @FXML
    private ImageView Up21;

    @FXML
    private ImageView Up22;

    @FXML
    private ImageView Up23;

    @FXML
    private ImageView Up24;

    @FXML
    private ImageView Up25;

    @FXML
    private ImageView Up26;

    @FXML
    private ImageView Up27;

    @FXML
    private ImageView Up28;

    @FXML
    private ImageView Up29;

    @FXML
    private ImageView Up3;

    @FXML
    private ImageView Up30;

    @FXML
    private ImageView Up31;

    @FXML
    private ImageView Up32;

    @FXML
    private ImageView Up33;

    @FXML
    private ImageView Up34;

    @FXML
    private ImageView Up35;

    @FXML
    private ImageView Up36;

    @FXML
    private ImageView Up37;

    @FXML
    private ImageView Up38;

    @FXML
    private ImageView Up39;

    @FXML
    private ImageView Up4;

    @FXML
    private ImageView Up40;

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
                Down1, Down10, Down11, Down12, Down13, Down14, Down15, Down16,
                Down17, Down18, Down19, Down2, Down20, Down21, Down22, Down23, Down24, Down25, Down26, Down27, Down28, Down29, Down3,
                Down30, Down31, Down32, Down33, Down34, Down35, Down36, Down37, Down38, Down39, Down4, Down40, Down5, Down6, Down7,
                Down8, Down9, Left1, Left10, Left10Down1, Left10Up1, Left11, Left12, Left13, Left14,
                Left15, Left16, Left17, Left18, Left19, Left1Down1, Left1Down10, Left1Down2, Left1Down3, Left1Down4, Left1Down5,
                Left1Down6, Left1Down7, Left1Down8, Left1Down9, Left1Up1, Left1Up10, Left1Up2, Left1Up3, Left1Up4, Left1Up5, Left1Up6,
                Left1Up7, Left1Up8, Left1Up9, Left2, Left20, Left21, Left22, Left23, Left24, Left25, Left26, Left27, Left28, Left29,
                Left2Down1, Left2Down2, Left2Down3, Left2Down4, Left2Down5, Left2Down6, Left2Down7, Left2Down8, Left2Down9, Left2Up1,
                Left2Up2, Left2Up3, Left2Up4, Left2Up5, Left2Up6, Left2Up7, Left2Up8, Left2Up9, Left3, Left30, Left31, Left32, Left33,
                Left34, Left35, Left36, Left37, Left38, Left39, Left3Down1, Left3Down2, Left3Down3, Left3Down4, Left3Down5, Left3Down6,
                Left3Down7, Left3Down8, Left3Up1, Left3Up2, Left3Up3, Left3Up4, Left3Up5, Left3Up6, Left3Up7, Left3Up8, Left4, Left40,
                Left4Down1, Left4Down2, Left4Down3, Left4Down4, Left4Down5, Left4Down6, Left4Down7, Left4Up1, Left4Up2, Left4Up3,
                Left4Up4, Left4Up5, Left4Up6, Left4Up7, Left5, Left5Down1, Left5Down2, Left5Down3, Left5Down4, Left5Down5, Left5Down6,
                Left5Up1, Left5Up2, Left5Up3, Left5Up4, Left5Up5, Left5Up6, Left6, Left6Down1, Left6Down2, Left6Down3, Left6Down4,
                Left6Down5, Left6Up1, Left6Up2, Left6Up3, Left6Up4, Left6Up5, Left7, Left7Down1, Left7Down2, Left7Down3, Left7Down4,
                Left7Up1, Left7Up2, Left7Up3, Left7Up4, Left8, Left8Down1, Left8Down2, Left8Down3, Left8Up1, Left8Up2, Left8Up3, Left9,
                Left9Down1, Left9Down2, Left9Up1, Left9Up2, Right1, Right10, Right10Down1,
                Right10Up1, Right11, Right12, Right13, Right14, Right15, Right16, Right17, Right18, Right19, Right1Down1, Right1Down10,
                Right1Down2, Right1Down3, Right1Down4, Right1Down5, Right1Down6, Right1Down7, Right1Down8, Right1Down9, Right1Up1,
                Right1Up10, Right1Up2, Right1Up3, Right1Up4, Right1Up5, Right1Up6, Right1Up7, Right1Up8, Right1Up9, Right2, Right20,
                Right21, Right22, Right23, Right24, Right25, Right26, Right27, Right28, Right29, Right2Down1, Right2Down2, Right2Down3,
                Right2Down4, Right2Down5, Right2Down6, Right2Down7, Right2Down8, Right2Down9, Right2Up1, Right2Up2, Right2Up3,
                Right2Up4, Right2Up5, Right2Up6, Right2Up7, Right2Up8, Right2Up9, Right3, Right30, Right31, Right32, Right33, Right34,
                Right35, Right36, Right37, Right38, Right39, Right3Down1, Right3Down2, Right3Down3, Right3Down4, Right3Down5, Right3Down6,
                Right3Down7, Right3Down8, Right3Up1, Right3Up2, Right3Up3, Right3Up4, Right3Up5, Right3Up6, Right3Up7, Right3Up8, Right4,
                Right40, Right4Down1, Right4Down2, Right4Down3, Right4Down4, Right4Down5, Right4Down6, Right4Down7, Right4Up1, Right4Up2,
                Right4Up3, Right4Up4, Right4Up5, Right4Up6, Right4Up7, Right5, Right5Down1, Right5Down2, Right5Down3, Right5Down4,
                Right5Down5, Right5Down6, Right5Up1, Right5Up2, Right5Up3, Right5Up4, Right5Up5, Right5Up6, Right6, Right6Down1, Right6Down2,
                Right6Down3, Right6Down4, Right6Down5, Right6Up1, Right6Up2, Right6Up3, Right6Up4, Right6Up5, Right7, Right7Down1,
                Right7Down2, Right7Down3, Right7Down4, Right7Up1, Right7Up2, Right7Up3, Right7Up4, Right8, Right8Down1, Right8Down2,
                Right8Down3, Right8Up1, Right8Up2, Right8Up3, Right9, Right9Down1, Right9Down2, Right9Up1, Right9Up2,
                Up1, Up10, Up11, Up12, Up13, Up14, Up15, Up16, Up17, Up18, Up19, Up2, Up20, Up21, Up22, Up23, Up24, Up25, Up26, Up27,
                Up28, Up29, Up3, Up30, Up31, Up32, Up33, Up34, Up35, Up36, Up37, Up38, Up39, Up4, Up40, Up5, Up6, Up7, Up8, Up9
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

        ArrayList<CardJSON> goldDeck = Client.getVirtualModel().getGoldDeck();
        for(int i = 0; i<goldDeck.size(); i++){
            System.out.println(goldDeck.getClass());
            //String sos = goldDeck.get(i).getID();
        }
        /*
        CardJSON gold1 = goldDeck.get(rand.nextInt(40));
        CardJSON gold2 = goldDeck.get(rand.nextInt(40));
        CardJSON gold3 = goldDeck.get(rand.nextInt(40));

        String GoldId1 = gold1.getID();
        String GoldId2 = gold2.getID();
        String GoldId3 = gold3.getID();

        URL GoldURL1 = getClass().getResource("/Images/" + GoldId1 + "front.jpg");
        URL GoldURL2 = getClass().getResource("/Images/" + GoldId2 + "front.jpg");
        URL GoldURL3 = getClass().getResource("/Images/" + GoldId3 + "front.jpg");
        GoldDeck.setImage(new Image(GoldURL1.toString()));
        GoldDeck1.setImage(new Image(GoldURL2.toString()));
        GoldDeck2.setImage(new Image(GoldURL3.toString()));


/*
        String ResId1 = Client.getVirtualModel().getCardR().getID();
        String ResId2 = Client.getVirtualModel().getCardR().getID();
        String ResId3 = Client.getVirtualModel().getCardR().getID();
        URL ResURL1 = getClass().getResource("/Images/" + ResId1 + "front.jpg");
        URL ResURL2 = getClass().getResource("/Images/" + ResId2 + "front.jpg");
        URL ResURL3 = getClass().getResource("/Images/" + ResId3 + "front.jpg");
        ResDeck.setImage(new Image("/Images/" + ResURL1 + "front.jpg"));
        ResDeck2.setImage(new Image("/Images/" + ResURL2 + "front.jpg"));
        ResDeck3.setImage(new Image("/Images/" + ResURL3 + "front.jpg"));
 */

        rec = client.checkForMSG();
        if(Client.isTurn()){
            //Here i make draggable all the cards inside my hand to make them placeable
            cardsController.makeDraggable(CardHand1, personalBoardScroll, 508, 650, copy, personalBoardContainer, Starturl.toString(), imageViewList, ResourcesList);
            cardsController.makeDraggable(CardHand2, personalBoardScroll, 801, 650, copy, personalBoardContainer, Starturl.toString(), imageViewList, ResourcesList);
            cardsController.makeDraggable(CardHand3, personalBoardScroll, 1064, 650, copy, personalBoardContainer, Starturl.toString(), imageViewList, ResourcesList);
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



        assert CardHand1 != null : "fx:id=\"CardHand1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert CardHand2 != null : "fx:id=\"CardHand2\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert CardHand3 != null : "fx:id=\"CardHand3\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert CommonObj1 != null : "fx:id=\"CommonObj\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert CommonObj2 != null : "fx:id=\"CommonObj\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert Down1 != null : "fx:id=\"Down1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert GoldDeck != null : "fx:id=\"GoldDeck\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert GoldDeck1 != null : "fx:id=\"GoldDeck1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert GoldDeck2 != null : "fx:id=\"GoldDeck2\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert Left1 != null : "fx:id=\"Left1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert PersonalObj != null : "fx:id=\"PersonalObj\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert ResDeck != null : "fx:id=\"ResDeck\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert ResDeck2 != null : "fx:id=\"ResDeck2\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert ResDeck3 != null : "fx:id=\"ResDeck2\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert Right1 != null : "fx:id=\"Right1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert StartingCard != null : "fx:id=\"StartingCard\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert Up1 != null : "fx:id=\"Up1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert allContainer != null : "fx:id=\"allContainer\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert commonBoardDecksContainer != null : "fx:id=\"commonBoardDecksContainer\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert commonGoalText != null : "fx:id=\"commonGoalText\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert handBg != null : "fx:id=\"handBg\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert handContainer != null : "fx:id=\"handContainer\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert objbackground != null : "fx:id=\"objbackground\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert personalBoardContainer != null : "fx:id=\"personalBoardContainer\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert personalBoardScroll != null : "fx:id=\"personalBoardScroll\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert personalGoalText != null : "fx:id=\"personalGoalText\" was not injected: check your FXML file 'GameBoard.fxml'.";

    }
}
