package Controller;

import Model.Cards.RandomCardFile;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

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
    private AnchorPane commonBoardDecksContainer;

    @FXML
    private ImageView commonBoardIMG;

    @FXML
    private Text commonGoalText;

    @FXML
    private ImageView handBg;

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
    private ImageView yellowPawn;

    private double scaleValue = 1.0;

    @FXML
    void initialize() {

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

        CardHand1.setImage(new Image("/" + RandomCardFile.getRandomGXXFileName()));
        CardHand2.setImage(new Image("/" + RandomCardFile.getRandomXXFileName()));
        CardHand3.setImage(new Image("/" + RandomCardFile.getRandomXXFileName()));
        CommonObj.setImage(new Image("/" + RandomCardFile.getRandomOXXFileName()));
        GoldDeck.setImage(new Image("/" + RandomCardFile.getRandomGXXFileName()));
        PersonalObj.setImage(new Image("/" + RandomCardFile.getRandomOXXFileName()));
        ResDeck.setImage(new Image("/" + RandomCardFile.getRandomXXFileName()));
        StartingCard.setImage(new Image("/" + RandomCardFile.getRandomSXXFileName()));

        //System.out.println(RandomCardFile.getRandomXXFileName());
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
