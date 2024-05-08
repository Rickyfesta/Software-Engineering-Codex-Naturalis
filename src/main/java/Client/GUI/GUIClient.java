package Client.GUI;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
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
            URL fxmlLocation = getClass().getResource("/fxml/MainMenu.fxml");
            //System.out.println(getClass().getResource("/fxml/MainMenu.fxml"));
            FXMLLoader loader = new FXMLLoader(fxmlLocation);
            //System.out.println(loader);
            Scene scene = new Scene(loader.load());
            MainMenu.setScene(scene);
            MainMenu.setTitle("Main Menu");
            MainMenu.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }


}
