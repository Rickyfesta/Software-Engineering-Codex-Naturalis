package Client.GUI.SceneControllers;

import Client.Client;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class PersonalGoalScene implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;



    @FXML
    private ImageView personalGoal1;

    @FXML
    private ImageView personalGoal2;
    static FXMLLoader loader = new FXMLLoader();
    public static Stage stage;
    private static boolean clicked = false;

    @FXML
    public void selectFirstGoal(Event event){
        if(!clicked){
            clicked = true;
            Client.getVirtualModel().setPersonalGoal(Client.getVirtualModel().getPg1());
            Client.sendMessage("first");

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root;
            try {
                root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/Game.fxml")));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
    }

    @FXML
    public void selectSecondGoal(Event event){
        if(!clicked){
            clicked = true;
            Client.getVirtualModel().setPersonalGoal(Client.getVirtualModel().getPg2());
            Client.sendMessage("second");

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Parent root = null;
            try {
                root = FXMLLoader.load(GameBoard.class.getResource("/GUI/Starte.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String id = Client.getVirtualModel().getPg1().getID();
        URL imageURL = getClass().getResource("/Images/" + id + "front.jpg");
        personalGoal1.setImage(new Image(imageURL.toString()));
        id = Client.getVirtualModel().getPg2().getID();
        imageURL = getClass().getResource("/Images/" + id + "front.jpg");
        personalGoal2.setImage(new Image(imageURL.toString()));
    }
}
