package Client.GUI;

import Client.GUI.SceneControllers.StarterSceneController;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;

public class GUIClient extends Application {

    static FXMLLoader loader = new FXMLLoader();
    public static Stage stage;

    public static void launchGui() {
        launch();
    }

    //From waiting scene to Starter Card Choice Scene
    public static void changeToStarterScene() {
        PauseTransition wait = new PauseTransition(Duration.seconds(1));
        wait.setOnFinished((e) ->{
            Platform.runLater(() ->{
                try {
                    Parent root = loader.load(StarterSceneController.class.getResource("/GUI/UsernameScene.fxml")); //scene
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.show();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }) ;
        } );
    }

    @Override
    public void start(Stage MainMenu) {
        try {
            // Load the FXML file
            URL fxmlLocation = getClass().getResource("/GUI/MainMenu.fxml");
            //System.out.println(getClass().getResource("/fxml/MainMenu.fxml"));
            loader = new FXMLLoader(fxmlLocation);
            //System.out.println(loader);
            Parent parent = loader.load();
            Scene scene = new Scene(parent, 1300, 750);
            MainMenu.setScene(scene);
            MainMenu.setResizable(false);
            MainMenu.setTitle("Codex Naturalis");
            stage = MainMenu;
            Image img = new Image ("icon.jpg");
            MainMenu.getIcons().add(img);
            MainMenu.show();
            //PersonalHand.start();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
