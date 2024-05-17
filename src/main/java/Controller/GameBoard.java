package Controller;

import Client.GUI.DraggableMaker;
import Client.GUI.FlippableMaker;
import Model.Cards.CardJSON;
import Model.Cards.RandomCardFile;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class GameBoard {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView CardHand1;

    @FXML
    private ImageView CardHand2;

    @FXML
    private ImageView CardHand3;

    @FXML
    private ImageView CommonObj;

    @FXML
    private ImageView Down1;

    @FXML
    private ImageView GoldDeck;

    @FXML
    private ImageView Left1;

    @FXML
    private ImageView PersonalObj;

    @FXML
    private ImageView ResDeck;

    @FXML
    private ImageView Right1;

    @FXML
    private ImageView StartingCard;

    @FXML
    private ImageView Up1;

    @FXML
    private HBox commonBoardDecksContainer;

    @FXML
    private ImageView commonBoardIMG;

    @FXML
    private Text commonGoalText;

    @FXML
    private ImageView handBg;
    @FXML
    private Pane allContainer;
    @FXML
    private AnchorPane handContainer;

    @FXML
    private ImageView objbackground;

    @FXML
    private AnchorPane personalBoardContainer;

    @FXML
    private ScrollPane personalBoardScroll;

    @FXML
    private Text personalGoalText;

    @FXML
    private Button showBtn;


    private double scaleValue = 1.0;

    public static String url1 = RandomCardFile.getRandomGXXFileName() ;

    public static String url2 = RandomCardFile.getRandomXXFileName();

    public static String url3 = RandomCardFile.getRandomXXFileName();

    public static boolean isFlipped;

    public static String StartUrl = RandomCardFile.getRandomSXXFileName();

    DraggableMaker draggableMaker = new DraggableMaker();
    FlippableMaker flippableMaker = new FlippableMaker();

    public static void dropCard(String isCornerPlayable) {
        switch(isCornerPlayable){
            case "top":
                //have to set is placeable false for left 1
            case "left":

            case "right":

            case "bottom":
        }
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
            commonBoardIMG.setVisible(true);
            ResDeck.setVisible(true);
            GoldDeck.setVisible(true);
            commonBoardIMG.setFitWidth(220);
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
            commonBoardIMG.setVisible(false);
            ResDeck.setVisible(false);
            GoldDeck.setVisible(false);
            commonBoardIMG.setFitWidth(0);
            ResDeck.setFitWidth(0);
            GoldDeck.setFitWidth(0);
            personalBoardScroll.setPrefWidth(1400);
            personalBoardContainer.setPrefWidth(4000);
            personalBoardScroll.pannableProperty();
        commonBoardDecksContainer.setPrefWidth(0.0d);
        //System.out.println("Left" + commonBoardDecksContainer.getPrefWidth());
    }
    @FXML
    void initialize() {

        //TODO VISUALIZE RESOURCES THAT I HAVE
        //To optimize useless operations
        commonBoardDecksContainer.setPrefWidth(0.0d);
        commonBoardIMG.setVisible(false);
        ResDeck.setVisible(false);
        GoldDeck.setVisible(false);
        // Handle scroll events on the ScrollPane
        personalBoardScroll.addEventFilter(ScrollEvent.SCROLL, event -> {
            if (event.isControlDown()) {
                double deltaY = event.getDeltaY();
                final double zoomFactor = 1.4; // Consider adjusting this value
                final double minScale = 0.5; // Adjust minimum scale as needed
                final double maxScale = 2.0; // Maximum scale

                if (deltaY < 0) {
                    scaleValue /= zoomFactor;
                } else {
                    scaleValue *= zoomFactor;
                }

                // Limit the zoom level
                scaleValue = Math.min(maxScale, Math.max(minScale, scaleValue));

                // Apply the scale transformation to the content
                personalBoardScroll.getContent().setScaleX(scaleValue);
                personalBoardScroll.getContent().setScaleY(scaleValue);

                event.consume();
            }
        });

        // Set CommonBoard into the placeholder
        //System.out.println("/cards/cardsimg/" + RandomCardFile.getRandomGXXFileName());
        //System.out.println(CardHand1);
        CardHand1.setImage(new Image("/" + url1));
        CardHand2.setImage(new Image("/" + url2));
        CardHand3.setImage(new Image("/" + url3));
        //System.out.println(Down1);
        //Left1.setImage(new Image("/" + url3));
        //System.out.println(url1);
        draggableMaker.makeDraggable(CardHand1, personalBoardScroll, 508, 650, Left1);
        draggableMaker.makeDraggable(CardHand2, personalBoardScroll, 801, 650, Left1);
        draggableMaker.makeDraggable(CardHand3, personalBoardScroll, 1064, 650, Left1);


        CardHand1.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                try{
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    CardJSON card = objectMapper.readValue(new File("src/main/resources/json/" + url1.replace("jpg", "json")), CardJSON.class);
                    //System.out.println(card.getID());
                    //System.out.println(card.getCOLOUR());
                    String cardColor = card.getCOLOUR();
                    String cardType = card.getCARDTYPE();
                    //System.out.println(cardType);
                    flippableMaker.flipCard(CardHand1, cardColor, cardType, url1);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        });

        CardHand2.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                try{
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    CardJSON card = objectMapper.readValue(new File("src/main/resources/json/" + url2.replace("jpg", "json")), CardJSON.class);
                    String cardColor = card.getCOLOUR();
                    String cardType = card.getCARDTYPE();
                    flippableMaker.flipCard(CardHand2, cardColor, cardType, url2);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        CardHand3.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                try{
                    ObjectMapper objectMapper = new ObjectMapper();
                    objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
                    CardJSON card = objectMapper.readValue(new File("src/main/resources/json/" + url3.replace("jpg", "json")), CardJSON.class);
                    String cardColor = card.getCOLOUR();
                    String cardType = card.getCARDTYPE();
                    flippableMaker.flipCard(CardHand3, cardColor, cardType, url3);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


        CommonObj.setImage(new Image("/" + RandomCardFile.getRandomOXXFileName()));
        GoldDeck.setImage(new Image("/" + RandomCardFile.getRandomGXXFileName()));
        PersonalObj.setImage(new Image("/" + RandomCardFile.getRandomOXXFileName()));
        ResDeck.setImage(new Image("/" + RandomCardFile.getRandomXXFileName()));
        StartingCard.setImage(new Image("/" + StartUrl));


        assert CardHand1 != null : "fx:id=\"CardHand1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert CardHand2 != null : "fx:id=\"CardHand2\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert CardHand3 != null : "fx:id=\"CardHand3\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert CommonObj != null : "fx:id=\"CommonObj\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert Down1 != null : "fx:id=\"Down1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert GoldDeck != null : "fx:id=\"GoldDeck\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert Left1 != null : "fx:id=\"Left1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert PersonalObj != null : "fx:id=\"PersonalObj\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert ResDeck != null : "fx:id=\"ResDeck\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert Right1 != null : "fx:id=\"Right1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert StartingCard != null : "fx:id=\"StartingCard\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert Up1 != null : "fx:id=\"Up1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert allContainer != null : "fx:id=\"allContainer\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert commonBoardDecksContainer != null : "fx:id=\"commonBoardDecksContainer\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert commonBoardIMG != null : "fx:id=\"commonBoardIMG\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert commonGoalText != null : "fx:id=\"commonGoalText\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert handBg != null : "fx:id=\"handBg\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert handContainer != null : "fx:id=\"handContainer\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert objbackground != null : "fx:id=\"objbackground\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert personalBoardContainer != null : "fx:id=\"personalBoardContainer\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert personalBoardScroll != null : "fx:id=\"personalBoardScroll\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert personalGoalText != null : "fx:id=\"personalGoalText\" was not injected: check your FXML file 'GameBoard.fxml'.";

    }
}
