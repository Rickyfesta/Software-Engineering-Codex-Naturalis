package Client.GUI;

import Controller.MainMenu;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIClient extends Application {



    @Override
    public void start(Stage MainMenu) {
        try {
            // Load the FXML file
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("src/main/resources/GUI/MainMenu.fxml")); // Update the path as needed
            Parent root = loader.load();

            // Set the scene and stage
            Scene scene = new Scene(root);
            MainMenu.setScene(scene);
            MainMenu.setTitle("Main Menu");
            MainMenu.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void start() {

        MainMenu.initialize();
    }
}
