package Controller;

import Model.Cards.RandomCardFile;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class GameBoard {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private Pane mainBoardPane;
    @FXML
    private HBox handCardsHBox;
    @FXML
    private ImageView CardHand1;

    @FXML
    private ImageView CardHand2;

    @FXML
    private ImageView CardHand3;
    @FXML
    private ImageView CommonObj;

    @FXML
    private ImageView GoldDeck;

    @FXML
    private ImageView PersonalObj;

    @FXML
    private ImageView ResDeck;

    @FXML
    private ImageView StartingCard;

    @FXML
    void initialize() {
        // Set CommonBoard into the placeholder
        //System.out.println("/Cards/cardsimg/" + RandomCardFile.getRandomGXXFileName());
        CardHand1.setImage(new Image("cards/carding/" + RandomCardFile.getRandomGXXFileName()));
        CardHand2.setImage(new Image("cards/carding/" + RandomCardFile.getRandomXXFileName()));
        CardHand3.setImage(new Image("cards/carding/" + RandomCardFile.getRandomXXFileName()));
        CommonObj.setImage(new Image("cards/carding/" + RandomCardFile.getRandomOXXFileName()));
        GoldDeck.setImage(new Image("cards/carding/" + RandomCardFile.getRandomGXXFileName()));
        PersonalObj.setImage(new Image("cards/carding/" + RandomCardFile.getRandomOXXFileName()));
        ResDeck.setImage(new Image("cards/carding/" + RandomCardFile.getRandomXXFileName()));
        StartingCard.setImage(new Image("cards/carding/" + RandomCardFile.getRandomSXXFileName()));

        //System.out.println(RandomCardFile.getRandomXXFileName());
        assert CardHand1 != null : "fx:id=\"CardHand1\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert CardHand2 != null : "fx:id=\"CardHand2\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert CardHand3 != null : "fx:id=\"CardHand3\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert CommonObj != null : "fx:id=\"CommonObj\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert GoldDeck != null : "fx:id=\"GoldDeck\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert PersonalObj != null : "fx:id=\"PersonalObj\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert ResDeck != null : "fx:id=\"ResDeck\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert StartingCard != null : "fx:id=\"StartingCard\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert mainBoardPane != null : "fx:id=\"mainBoardPane\" was not injected: check your FXML file 'GameBoard.fxml'.";

    }


}
