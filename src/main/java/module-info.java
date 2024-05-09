module IS24.LB09 {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.databind;
    requires com.fasterxml.jackson.core;
    requires javafx.graphics;
    requires java.desktop;

    opens Controller;
    opens Client.GUI;
    exports Controller;
    exports Client.GUI;
}