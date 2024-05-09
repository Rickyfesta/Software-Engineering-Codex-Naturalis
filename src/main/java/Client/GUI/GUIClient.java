package Client.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.net.URL;

public class GUIClient extends Application {


    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage MainMenu) {
        try {
            // Load the FXML file
            URL fxmlLocation = getClass().getResource("/GUI/MainMenu.fxml");
            //System.out.println(getClass().getResource("/fxml/MainMenu.fxml"));
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            //System.out.println(loader);
            Parent parent = loader.load();
            Scene scene = new Scene(parent, 1300, 750);
            MainMenu.setScene(scene);
            MainMenu.setResizable(false);
            MainMenu.setTitle("Codex Naturalis");
            Image img = new Image ("icon.jpg");
            MainMenu.getIcons().add(img);
            MainMenu.show();


        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
