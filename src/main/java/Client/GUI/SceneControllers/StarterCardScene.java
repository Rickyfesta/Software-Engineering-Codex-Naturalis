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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class StarterCardScene implements Initializable {
    @FXML
    private ImageView starterCardBack;

    @FXML
    private ImageView starterCardFront;

    @FXML
    private Text id;


    static FXMLLoader loader = new FXMLLoader();
    public static Stage stage;


    private static boolean clicked = false;

    @FXML
    public void selectStarterFront(Event event){
        if(!clicked){
            clicked = true;
            Client.getVirtualModel().setChosenStarter(Client.getVirtualModel().getStarterFront());
            Client.sendMessage("front");
                stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                Parent root;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/PersonalGoalScene.fxml")));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

        }
    }

    @FXML
    public void selectStarterBack(Event event){
        if(!clicked){
            clicked = true;
            Client.getVirtualModel().setChosenStarter(Client.getVirtualModel().getStarterBack());
            Client.sendMessage("back");

               stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
               Parent root;
                try {
                    root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/GUI/PersonalGoalScene.fxml")));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String id = Client.getVirtualModel().getStarterFront().getID();
        if(id.contains("front")){
            URL imageURL = getClass().getResource("/Images/" + id + ".jpg");
            starterCardFront.setImage(new Image(imageURL.toString()));
            imageURL = getClass().getResource("/Images/" + id.replace("front", "back") + ".jpg");
            starterCardBack.setImage(new Image(imageURL.toString()));
        } else if (id.contains("back")) {
            URL imageURL = getClass().getResource("/Images/" + id.replace("back", "front") + ".jpg");
            starterCardFront.setImage(new Image(imageURL.toString()));
            imageURL = getClass().getResource("/Images/" + id + ".jpg");
            starterCardBack.setImage(new Image(imageURL.toString()));
        }
    }
}
