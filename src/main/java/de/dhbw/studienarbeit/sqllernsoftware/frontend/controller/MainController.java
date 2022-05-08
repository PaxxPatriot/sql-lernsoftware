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
import java.util.Optional;
import java.util.OptionalInt;

public class MainController {
    private final AppdataController appdataController = new AppdataController();
    private List<Lektion> lectureList;
    private List<Aufgabenkollektion> exercisecollectionList;
    private Boolean inTest;
    private Alert confAlert;

    @FXML
    private Menu lectureMenu, exerciseMenu, testMenu;

    @FXML
    private MasterdetailController masterdetailController;

    @FXML
    public void initialize() throws IOException {
        inTest = false;
        masterdetailController.setMainController(this);
        confAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confAlert.setTitle("Prüfung wird abgebrochen");
        confAlert.setHeaderText("Prüfung wird abgebrochen");
        confAlert.setContentText("Achtung: Die laufende Prüfung wurde noch nicht beendet. " +
                "Wenn Sie bestätigen wird die Prüfung abgebrochen und eine Auswertung kann nicht stattfinden.");


        Label exerciseMenuLabel = new Label("Übungen");
        exerciseMenuLabel.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    if(inTest) {
                        Optional<ButtonType> result = confAlert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            gotoExercise();
                            inTest = false;
                        } else {
                            confAlert.close();
                        }
                    } else {
                        gotoExercise();
                    }
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
                    if(inTest) {
                        Optional<ButtonType> result = confAlert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            gotoLecture();
                            inTest = false;
                        } else {
                            confAlert.close();
                        }
                    } else {
                        gotoLecture();
                    }
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
                    if(inTest) {
                        Optional<ButtonType> result = confAlert.showAndWait();
                        if (result.get() == ButtonType.OK) {
                            gotoTest();
                            inTest = false;
                        } else {
                            confAlert.close();
                        }
                    } else {
                        gotoTest();
                    }
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


    public void setInTest(Boolean inTest) {
        this.inTest = inTest;
    }

}