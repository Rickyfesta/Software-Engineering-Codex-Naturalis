package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ChoosePlayers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ScrollBar scoreBar;

    @FXML
    private Text scoreValue;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void playGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/Game.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        scoreBar.setOnMouseClicked(event -> {
            double value = scoreBar.getValue();
            scoreValue.setText(String.format("%.0f", value));

        });
        assert scoreBar != null : "fx:id=\"scoreBar\" was not injected: check your FXML file 'ChoosePlayers.fxml'.";
        assert scoreValue != null : "fx:id=\"scoreValue\" was not injected: check your FXML file 'ChoosePlayers.fxml'.";

    }
}
