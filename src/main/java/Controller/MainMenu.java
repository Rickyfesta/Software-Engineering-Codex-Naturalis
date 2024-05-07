package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class MainMenu {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private static Button newGameBtn;

    @FXML
    private static Button quitBtn;

    @FXML
    private static Button reconnectBtn;

    @FXML
    void playNewGame(ActionEvent event) {

    }

    @FXML
    void quitGame(ActionEvent event) {

    }

    @FXML
    void reconnect(ActionEvent event) {

    }

    @FXML
    public static void initialize() {
        assert newGameBtn != null : "fx:id=\"newGameBtn\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert quitBtn != null : "fx:id=\"quitBtn\" was not injected: check your FXML file 'MainMenu.fxml'.";
        assert reconnectBtn != null : "fx:id=\"reconnectBtn\" was not injected: check your FXML file 'MainMenu.fxml'.";

    }

}
