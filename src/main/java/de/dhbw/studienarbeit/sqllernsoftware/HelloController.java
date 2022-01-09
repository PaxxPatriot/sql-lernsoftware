package de.dhbw.studienarbeit.sqllernsoftware;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private Label testText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public void handleNewClick(ActionEvent actionEvent) {
            testText.setText("Test1");
    }
}