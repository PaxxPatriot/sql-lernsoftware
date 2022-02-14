package de.dhbw.studienarbeit.sqllernsoftware;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import de.dhbw.studienarbeit.sqllernsoftware.persistence.AppdataController;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.tool.schema.Action;

import java.io.IOException;
import java.util.List;

public class HelloController {
    private final AppdataController appdataController = new AppdataController();

    @FXML
    private Parent menuBar;


    @FXML
    private VBox root;

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
    public void initialize() throws IOException {
        List<Lektion> lektionen = appdataController.getAllLektion();
        List<Aufgabenkollektion> aufgabenkollektionen = appdataController.getAllAufgabenkollektion();
        for (Lektion lektion : lektionen) {
            MenuItem menuItem = new MenuItem(""+lektion.getTitel());
            menuItem.setOnAction(e -> {
                try {
                    gotoLecture(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            lectureMenu.getItems().add(menuItem);
        }

        for (Aufgabenkollektion kollektion : aufgabenkollektionen) {
            MenuItem menuItem = new MenuItem(kollektion.getTitel());
            menuItem.setOnAction(e -> {
                try {
                    gotoExercise(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
            exerciseMenu.getItems().add(menuItem);
        }

    }

    public void gotoExercise(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("basic_aufgabe.fxml"));
        Parent AufgabenManager = loader.load();
        Scene AufgabenManagerScene = new Scene(AufgabenManager, 1280, 700);

        root.getChildren().add(AufgabenManager);

        //Stage window = (Stage) menuBar.getScene().getWindow();
        //window.setScene(AufgabenManagerScene);
        //window.show();
    }

    public void gotoLecture(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("basic_lecture.fxml"));
        Parent LektionenManager = loader.load();
        Scene LektionenManagerScene = new Scene(LektionenManager, 1280, 700);

        //Stage window = (Stage) root.getScene().getWindow();
        //window.setScene(LektionenManagerScene);
        //window.show();
    }


}