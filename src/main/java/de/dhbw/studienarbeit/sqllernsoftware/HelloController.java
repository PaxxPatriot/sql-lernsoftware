package de.dhbw.studienarbeit.sqllernsoftware;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
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
import java.util.ArrayList;
import java.util.List;

public class HelloController {
    private final AppdataController appdataController = new AppdataController();
    private List<Lektion> lectures;
    private List<Aufgabenkollektion> exercisecollectionList;

    @FXML
    private VBox root;


    @FXML
    private Menu lectureMenu;


    @FXML
    private Menu exerciseMenu;


    @FXML
    public void initialize() throws IOException {
        lectures = appdataController.getAllLektion();
        exercisecollectionList = appdataController.getAllAufgabenkollektion();
        for (Lektion lektion : lectures) {
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

        for (Aufgabenkollektion kollektion : exercisecollectionList) {
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
        //Scene AufgabenManagerScene = new Scene(AufgabenManager, 1280, 700);
        BasicAufgabeController exerciseController = new BasicAufgabeController();
        MenuItem menuItem = (MenuItem) event.getSource();
        for (Aufgabenkollektion collection : exercisecollectionList) {
            if (collection.getTitel().equals(menuItem.getText())) {
                exerciseController.setExerciseCollection(collection);
            }
        }
        loader.setController(exerciseController);
        Parent AufgabenManager = loader.load();

        List<Node> nodesToDelete = new ArrayList<>();
        for (Object o : root.getChildren()) {
            Node node = (Node) o;
            System.out.println(node.getId());
            if (!node.getId().equals("menuBar")) {
                nodesToDelete.add(node);
            }
        }
        for (Node node : nodesToDelete) {
            root.getChildren().remove(node);
        }

        root.getChildren().add(AufgabenManager);
        //exerciseController.loadPage();

        //Stage window = (Stage) menuBar.getScene().getWindow();
        //window.setScene(AufgabenManagerScene);
        //window.show();
    }

    public void gotoLecture(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("basic_lecture.fxml"));
        BasicLectureController lectureController = new BasicLectureController();
        MenuItem menuItem = (MenuItem) event.getSource();
        for (Lektion lecture : lectures) {
            if (lecture.getTitel().equals(menuItem.getText())) {
                lectureController.setLecture(lecture);
            }
        }

        loader.setController(lectureController);
        Parent LektionenManager = loader.load();

        List<Node> nodesToDelete = new ArrayList<>();
        for (Object o : root.getChildren()) {
            Node node = (Node) o;
            System.out.println(node.getId());
            if (!node.getId().equals("menuBar")) {
                nodesToDelete.add(node);
            }
        }
        for (Node node : nodesToDelete) {
            root.getChildren().remove(node);
        }

        root.getChildren().add(LektionenManager);
        //Stage window = (Stage) root.getScene().getWindow();
        //window.setScene(LektionenManagerScene);
        //window.show();
    }


}