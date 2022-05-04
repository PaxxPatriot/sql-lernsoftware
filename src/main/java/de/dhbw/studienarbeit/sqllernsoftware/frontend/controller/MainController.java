package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.ObjektMitId;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import de.dhbw.studienarbeit.sqllernsoftware.persistence.AppdataController;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.List;

public class MainController {
    private final AppdataController appdataController = new AppdataController();
    private List<Lektion> lectureList;
    private List<Aufgabenkollektion> exercisecollectionList;

    @FXML
    private Menu lectureMenu, exerciseMenu, testMenu;



    @FXML
    private MasterdetailController masterdetailController;

    @FXML
    public void initialize() throws IOException {
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

        Label testMenuLabel = new Label("Prüfung");
        testMenuLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    gotoTest();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
        testMenu.setGraphic(testMenuLabel);

    }

    public void gotoExercise() throws IOException {
        exercisecollectionList = appdataController.getAllAufgabenkollektion();
        masterdetailController.clearDetailpage();
        masterdetailController.getListView().refresh();
        masterdetailController.getListView().setVisible(true);
        masterdetailController.setObjektMitIdList((List<ObjektMitId>) (List<?>) exercisecollectionList);
    }

    public void gotoLecture() throws IOException {
        lectureList = appdataController.getAllLektion();
        masterdetailController.clearDetailpage();
        masterdetailController.getListView().refresh();
        masterdetailController.getListView().setVisible(true);
        masterdetailController.setObjektMitIdList((List<ObjektMitId>) (List<?>) lectureList);
    }

    public void gotoTest() throws IOException {
        masterdetailController.clearDetailpage();
        masterdetailController.getListView().setVisible(false);
        masterdetailController.buildTest();
    }


}