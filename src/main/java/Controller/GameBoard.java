package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class GameBoard {
    @FXML
    private Pane mainBoardPane;
    @FXML
    private HBox handCardHBox;
    @FXML
    private Button commonBoardButton;

    private Stage commonBoardStage;

    private void initialize() {
        setupCommonBoard();
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
