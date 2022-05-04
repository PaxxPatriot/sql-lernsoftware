package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.EntityUtils;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.KommentarAusgabeText;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.frontend.AufgabeUI;
import de.dhbw.studienarbeit.sqllernsoftware.persistence.AppdataController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class BasicTestController {

    AppdataController appdataController;
    EntityUtils entityUtils = new EntityUtils();
    List<AufgabeUITest> aufgabeUITestList = new ArrayList<>();
    BasicDetailpageController basicDetailpageController;

    @FXML
    AnchorPane anchorPane;

    @FXML
    ScrollPane scrollPane;

    @FXML
    GridPane testPane;

    public void build() throws FileNotFoundException {
        testPane.setPadding(new Insets(10));
        AnchorPane.setTopAnchor(scrollPane, 5.0);
        AnchorPane.setRightAnchor(scrollPane, 5.0);
        AnchorPane.setBottomAnchor(scrollPane, 5.0);

        appdataController = new AppdataController();
        List<Aufgabe> aufgabenAllList = new ArrayList<>();
        List<Aufgabenkollektion> aufgabenkollektionList = appdataController.getAllAufgabenkollektion();
        for (Aufgabenkollektion aufgabenkollektion : aufgabenkollektionList) {
            List<Aufgabe> aufgabeList = aufgabenkollektion.getAufgabenliste();
            for (Aufgabe aufgabe : aufgabeList) {
                aufgabenAllList.add(aufgabe);
            }
        }

        Random random = new Random();
        int numberOfElements = 10;
        List<Aufgabe> aufgabenTestList = new ArrayList<>();

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = random.nextInt(aufgabenAllList.size());
            Aufgabe aufgabe = aufgabenAllList.get(randomIndex);
            aufgabenTestList.add(aufgabe);
            aufgabenAllList.remove(randomIndex);
        }

        int row = 0;
        for (Aufgabe aufgabe : aufgabenTestList) {
            AufgabeUITest aufgabeUITest = new AufgabeUITest(aufgabe, entityUtils);
            testPane.add(aufgabeUITest, 0, row);
            aufgabeUITestList.add(aufgabeUITest);
            row++;
        }

        Button submissionButton = new Button("Prüfung abgeben");
        submissionButton.setPadding(new Insets(5));;
        submissionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmationAlert.setTitle("Prüfung beenden");
                confirmationAlert.setHeaderText("Sie beenden die Prüfung");
                confirmationAlert.setContentText("Mit Bestätigung wird die Prüfung beendet und ausgewertet. Es können keine weiteren Antworten mehr abgegeben werden.");
                Optional<ButtonType> result = confirmationAlert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    try {
                        scoreTest();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    confirmationAlert.close();
                }
            }
        });

        testPane.add(submissionButton, 0, row+1);

    }

    public void scoreTest() throws IOException {
        HashMap<Aufgabe, HashMap> results = new HashMap<>();
        HashMap<Aufgabe, String> answerList = new HashMap<>();
        for (AufgabeUITest aufgabeUITest : aufgabeUITestList) {
            Aufgabe aufgabe = aufgabeUITest.getAnswerMap().keySet().iterator().next();
            String answer = aufgabeUITest.getAnswerMap().get(aufgabe);
            answerList.put(aufgabe, answer);
        }

        int count = 0;
        for (Map.Entry<Aufgabe, String> entry : answerList.entrySet()) {
            HashMap<String, String> resultAufgabe = new HashMap<>();
            KommentarAusgabeText ergebnisKommentar = entityUtils.getKommentarText(entry.getKey(), entry.getValue());
            if (ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.M) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.E)) {
                resultAufgabe.put("aufgabe", entry.getKey().getTitel());
                resultAufgabe.put("givenAnswer", entry.getValue());
                resultAufgabe.put("correct", "true");
                resultAufgabe.put("musterloesung", entry.getKey().getMusterloesung());
                results.put(entry.getKey(), resultAufgabe);
                count++;
            } else if (ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.ERROR) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.C) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.F) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.Z) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.L)) {
                resultAufgabe.put("aufgabe", entry.getKey().getTitel());
                resultAufgabe.put("givenAnswer", entry.getValue());
                resultAufgabe.put("correct", "false");
                resultAufgabe.put("musterloesung", entry.getKey().getMusterloesung());
                results.put(entry.getKey(), resultAufgabe);
            }
        }

        basicDetailpageController.buildResultPage(results);

    }

    public void setBasicDetailpageController(BasicDetailpageController basicDetailpageController) {
        this.basicDetailpageController = basicDetailpageController;
    }

}
