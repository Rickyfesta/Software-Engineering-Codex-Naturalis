package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;

public class GameBoard {
    @FXML
    private URL location;
    @FXML
    private Pane mainBoardPane;
    @FXML
    private HBox handCardsHBox;
    @FXML
    private Button commonBoardButton;

    private Stage commonBoardStage;

    @FXML
    void initialize() {
        setupCommonBoard();
        assert commonBoardButton != null : "fx:id=\"commonBoardButton\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert handCardsHBox != null : "fx:id=\"handCardsHBox\" was not injected: check your FXML file 'GameBoard.fxml'.";
        assert mainBoardPane != null : "fx:id=\"mainBoardPane\" was not injected: check your FXML file 'GameBoard.fxml'.";

    }
    private void setupCommonBoard() {
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("/GUI/CommonBoard.fxml"));
            Pane commonBoard = loader.load();
            commonBoardStage = new Stage();
            commonBoardStage.setScene(new Scene(commonBoard));
            commonBoardStage.setTitle("Common Board");
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    private void toggleCommonBoard() {
        if (commonBoardStage.isShowing()) {
            commonBoardStage.hide();
        } else {
            commonBoardStage.show();
        }
    }
}
