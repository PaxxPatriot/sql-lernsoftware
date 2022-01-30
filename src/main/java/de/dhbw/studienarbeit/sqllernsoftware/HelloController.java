package de.dhbw.studienarbeit.sqllernsoftware;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import de.dhbw.studienarbeit.sqllernsoftware.persistence.AppdataController;
import javafx.scene.control.MenuItem;

import java.util.List;

public class HelloController {
    private final AppdataController appdataController = new AppdataController();

    @FXML
    private Label welcomeText;

    @FXML
    private Menu lectureMenu;

    @FXML
    private Menu exerciseMenu;

    @FXML
    private Menu testMenu;


    @FXML
    private Label testText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public void initialize() {
        List<Lektion> lektionen = appdataController.getAllLektion();
        List<Aufgabenkollektion> aufgabenkollektionen = appdataController.getAllAufgabenkollektion();
        for (Lektion lektion : lektionen) {
            MenuItem menuItem = new MenuItem(""+lektion.getTitel());
            lectureMenu.getItems().add(menuItem);
        }

        for (Aufgabenkollektion kollektion : aufgabenkollektionen) {
            MenuItem menuItem = new MenuItem(kollektion.getTitel());
            exerciseMenu.getItems().add(menuItem);
        }

    }


}