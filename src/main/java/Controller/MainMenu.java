package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
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

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void playNewGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/ChoosePlayers.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
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
