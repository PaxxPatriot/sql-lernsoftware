package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.ObjektMitId;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import de.dhbw.studienarbeit.sqllernsoftware.persistence.AppdataController;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

import java.io.IOException;
import java.util.List;

public class HelloController {
    private final AppdataController appdataController = new AppdataController();
    private List<Lektion> lectureList;
    private List<Aufgabenkollektion> exercisecollectionList;

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

        Label exerciseMenuLabel = new Label("Übungen");
        exerciseMenuLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    gotoExercise();
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
                try {
                    gotoLecture();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        lectureMenu.setGraphic(lectureMenuLabel);

        masterdetailController.setObjektMitIdList((List<ObjektMitId>) (List<?>) lectureList);

    }

    public void gotoExercise() throws IOException {
        masterdetailController.clearDetailpage();
        masterdetailController.getListView().refresh();
        masterdetailController.setObjektMitIdList((List<ObjektMitId>) (List<?>) exercisecollectionList);

    }

    public void gotoLecture() throws IOException {
        //FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("basic_lektion.fxml"));
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
        masterdetailController.clearDetailpage();
        masterdetailController.getListView().refresh();
        masterdetailController.setObjektMitIdList((List<ObjektMitId>) (List<?>) lectureList);

    }


}