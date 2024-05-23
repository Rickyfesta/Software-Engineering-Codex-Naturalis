package Client.GUI;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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
    private Label ErrorLabel;
    @FXML
    private ScrollBar scoreBar;
    @FXML
    private Text scoreValue;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    void playGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/UsernameScene.fxml")));
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
        assert ErrorLabel != null : "fx:id=\"ErrorLabel\" was not injected: check your FXML file 'ChoosePlayers.fxml'.";
        assert scoreBar != null : "fx:id=\"scoreBar\" was not injected: check your FXML file 'ChoosePlayers.fxml'.";
        assert scoreValue != null : "fx:id=\"scoreValue\" was not injected: check your FXML file 'ChoosePlayers.fxml'.";
    }
    @FXML
    private void Enoughplayers() {
        if (!isRequirementMet()) {
            ErrorLabel.setText("You need at least 2 players to start the game.");
        } else {
            ErrorLabel.setText("");
        }
    }

    private boolean isRequirementMet() {

        return false; // Example
    }
}
