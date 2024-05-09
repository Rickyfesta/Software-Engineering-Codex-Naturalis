package Controller;

import Model.Cards.RandomCardFile;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
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
    private Button commonBoardButton;
    @FXML
    private StackPane commonBoardContainer;

    @FXML
    private ImageView CardHand1;

    @FXML
    private ImageView CardHand2;

    @FXML
    private ImageView CardHand3;

    @FXML
    void initialize() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI/CommonBoard.fxml"));
        Pane commonBoard = null;
        try {
            commonBoard = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Set CommonBoard into the placeholder
        commonBoardContainer.getChildren().add(commonBoard);
        //System.out.println("/Cards/cardsimg/" + RandomCardFile.getRandomGXXFileName());
        CardHand1.setImage(new Image("cards/carding/" + RandomCardFile.getRandomGXXFileName()));
        CardHand2.setImage(new Image("cards/carding/" + RandomCardFile.getRandomXXFileName()));
        CardHand3.setImage(new Image("cards/carding/" + RandomCardFile.getRandomXXFileName()));
        //System.out.println(RandomCardFile.getRandomXXFileName());
        assert commonBoardButton != null : "fx:id=\"commonBoardButton\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert handCardsHBox != null : "fx:id=\"handCardsHBox\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert mainBoardPane != null : "fx:id=\"mainBoardPane\" was not injected: check your FXML file 'GameBoard.fxml'.";

    }


}
