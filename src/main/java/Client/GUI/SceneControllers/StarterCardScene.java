package Client.GUI.SceneControllers;

import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class StarterCardScene {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView starterCardBack;

    @FXML
    private ImageView starterCardFront;


    static FXMLLoader loader = new FXMLLoader();
    public static Stage stage;


    public static void changeToObjectScreen() {
        PauseTransition wait = new PauseTransition(Duration.seconds(1));
        wait.setOnFinished((e) -> Platform.runLater(() ->{
            try {
                Parent root = loader.load(StarterSceneController.class.getResource("/GUI/PersonalGoalScene.fxml")); //scene
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }));
    }

    @FXML
    void initialize(Stage PersonalGoalScene) {
        //starterCardFront.setImage(new Image());
        //starterCardBack.setImage(new Image());

        starterCardFront.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                try{


                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        starterCardBack.setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.PRIMARY) {
                try{

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        });

        try {
            // Load the FXML file
            URL fxmlLocation = getClass().getResource("/GUI/PersonalGoalScene.fxml");
            loader = new FXMLLoader(fxmlLocation);
            Parent parent = loader.load();
            Scene scene = new Scene(parent, 1300, 750);
            PersonalGoalScene.setScene(scene);
        } catch(Exception e) {
            e.printStackTrace();
        }

        assert starterCardBack != null : "fx:id=\"starterCardBack\" was not injected: check your FXML file 'StarterCardScene.fxml'.";
        assert starterCardFront != null : "fx:id=\"starterCardFront\" was not injected: check your FXML file 'StarterCardScene.fxml'.";

    }
}
