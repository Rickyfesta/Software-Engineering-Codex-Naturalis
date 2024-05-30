module IS24.LB09 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires javafx.graphics;
    requires java.desktop;

    opens Controller;
    opens Model.Cards to com.fasterxml.jackson.databind;
    opens Client.GUI;
    opens Client.CLI;
    exports Controller;
    exports Client.GUI;
    exports Client.CLI;

    exports Model.Cards to com.fasterxml.jackson.databind;
    exports Server;
    opens Server;
    exports Client.GUI.SceneControllers;
    opens Client.GUI.SceneControllers;
}