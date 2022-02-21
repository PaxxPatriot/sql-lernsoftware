package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import de.dhbw.studienarbeit.sqllernsoftware.persistence.AppdataController;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.List;

public class HelloController {
    private final AppdataController appdataController = new AppdataController();
    private List<Lektion> lectureList;
    private List<Aufgabenkollektion> exercisecollectionList;

    @FXML
    private VBox root;


    @FXML
    private Menu lectureMenu;


    @FXML
    private Menu exerciseMenu;

    @FXML
    private MasterdetailController masterdetailController;


    @FXML
    public void initialize() throws IOException {
        lectureList = appdataController.getAllLektion();
        exercisecollectionList = appdataController.getAllAufgabenkollektion();

        lectureMenu.setOnAction(e -> {
            try {
                gotoLecture(e);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Label exerciseMenuLabel = new Label("Übungen");
        exerciseMenuLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Object aufgabe = exercisecollectionList;
                ActionEvent e = new ActionEvent(aufgabe, null);
                try {
                    gotoExercise(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        exerciseMenu.setGraphic(exerciseMenuLabel);

        Label lectureMenuLabel = new Label("Lektionen");
        lectureMenuLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                Object lektion = lectureList;
                ActionEvent e = new ActionEvent(lektion, null);
                try {
                    gotoLecture(e);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        lectureMenu.setGraphic(lectureMenuLabel);

    }

    public void gotoExercise(ActionEvent event) throws IOException {
        //FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("basic_aufgabe.fxml"));
        //BasicAufgabeController exerciseController = new BasicAufgabeController();


        //loader.setController(exerciseController);
        //Parent AufgabenManager = loader.load();

        /*List<Node> nodesToDelete = new ArrayList<>();
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

        root.getChildren().add(AufgabenManager); */
        masterdetailController.setExerciseList(exercisecollectionList);

    }

    public void gotoLecture(ActionEvent event) throws IOException {
        //FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("basic_lecture.fxml"));
        //BasicLectureController lectureController = new BasicLectureController();

        //loader.setController(lectureController);
        //Parent LektionenManager = loader.load();

        /*List<Node> nodesToDelete = new ArrayList<>();
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

        root.getChildren().add(LektionenManager); */
        masterdetailController.setLectureList(lectureList);

    }


}