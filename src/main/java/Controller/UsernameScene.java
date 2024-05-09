package Controller;


import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class UsernameScene {

    @FXML
    private TextField usernameField;

    @FXML
    private void handleSubmitButtonAction() {
        String username = usernameField.getText();
        System.out.println("Username entered: " + username);
        // Add further action, like transitioning to another scene or validating the username
    }

}
