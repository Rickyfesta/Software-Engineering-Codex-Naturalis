package Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class UsernameScene {

    @FXML
    private TextField usernameField;

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void submitAction(ActionEvent event) throws IOException {
        //System.out.println(Objects.requireNonNull(getClass().getResource("/GUI/GameBoard.fxml")));
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/GameBoard.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

    }

}
