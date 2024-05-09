package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

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
    void initialize() {
        assert commonBoardButton != null : "fx:id=\"commonBoardButton\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert handCardsHBox != null : "fx:id=\"handCardsHBox\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert mainBoardPane != null : "fx:id=\"mainBoardPane\" was not injected: check your FXML file 'GameBoard.fxml'.";

    }

    public void loadCommonBoard(javafx.event.ActionEvent actionEvent) {
        try {
            // Load CommonBoard
            FXMLLoader loader = new FXMLLoader(getClass().getResource("CommonBoard.fxml"));
            StackPane commonBoard = loader.load();

            // Set CommonBoard into the placeholder
            commonBoardContainer.getChildren().add(commonBoard);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
