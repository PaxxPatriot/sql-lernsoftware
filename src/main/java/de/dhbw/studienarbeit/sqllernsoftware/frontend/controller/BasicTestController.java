package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.EntityUtils;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.KommentarAusgabeText;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.frontend.AufgabeUITest;
import de.dhbw.studienarbeit.sqllernsoftware.persistence.AppdataController;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public class BasicTestController {

    AppdataController appdataController;
    EntityUtils entityUtils = new EntityUtils();
    List<AufgabeUITest> aufgabeUITestList = new ArrayList<>();
    BasicDetailpageController basicDetailpageController;
    Alert infoAlert;

    @FXML
    AnchorPane anchorPane;

    @FXML
    ScrollPane scrollPane;

    @FXML
    GridPane testPane;

    public void build() throws FileNotFoundException {
        infoAlert = new Alert(Alert.AlertType.INFORMATION);
        testPane.setPadding(new Insets(10));
        AnchorPane.setTopAnchor(scrollPane, 5.0);
        AnchorPane.setRightAnchor(scrollPane, 5.0);
        AnchorPane.setBottomAnchor(scrollPane, 5.0);
        scrollPane.setFitToWidth(true);


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
            AufgabeUITest aufgabeUITest = new AufgabeUITest(aufgabe, entityUtils, scrollPane);
            testPane.add(aufgabeUITest, 0, row);
            aufgabeUITestList.add(aufgabeUITest);
            row++;
        }

        Button submissionButton = new Button("Prüfung abgeben");
        submissionButton.setPadding(new Insets(5));
        submissionButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
                confirmationAlert.setTitle("Prüfung beenden");
                confirmationAlert.setHeaderText("Sie beenden die Prüfung");
                confirmationAlert.setContentText("Mit Bestätigung wird die Prüfung beendet und ausgewertet. Es können keine weiteren Antworten mehr abgegeben werden.");
                Optional<ButtonType> result = confirmationAlert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    //scoreTest();
                    delay(() -> startScoring());
                } else {
                    confirmationAlert.close();
                }
            }
        });

        testPane.add(submissionButton, 0, row+1);

    }

    public Runnable startScoring() {
        infoAlert.setTitle("Bitte warten");
        infoAlert.setHeaderText("Prüfung wird ausgewertet");
        infoAlert.setContentText("Die von ihnen gegebenen Antworten werden überprüft und das Ergebnis in Kürze ausgegeben. Bitte geduldigen Sie sich kurz.");
        infoAlert.show();
        return null;
    }

    public void scoreTest() throws IOException {
        infoAlert.setTitle("Bitte warten");
        infoAlert.setHeaderText("Prüfung wird ausgewertet");
        infoAlert.setContentText("Die von ihnen gegebenen Antworten werden überprüft und das Ergebnis in Kürze ausgegeben. Bitte geduldigen Sie sich kurz.");
        infoAlert.show();

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
                resultAufgabe.put("aufgabe_titel", entry.getKey().getTitel());
                resultAufgabe.put("aufgabe_text", entry.getKey().getAufgabentext());
                resultAufgabe.put("givenAnswer", entry.getValue());
                resultAufgabe.put("correct", "true");
                resultAufgabe.put("musterloesung", entry.getKey().getMusterloesung());
                results.put(entry.getKey(), resultAufgabe);
                count++;
            } else if (ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.ERROR) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.C) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.F) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.Z) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.L)) {
                resultAufgabe.put("aufgabe_titel", entry.getKey().getTitel());
                resultAufgabe.put("aufgabe_text", entry.getKey().getAufgabentext());
                resultAufgabe.put("givenAnswer", entry.getValue());
                resultAufgabe.put("correct", "false");
                resultAufgabe.put("musterloesung", entry.getKey().getMusterloesung());
                results.put(entry.getKey(), resultAufgabe);
            }
        }

        basicDetailpageController.buildResultPage(results);
        infoAlert.close();
    }

    public void delay(Runnable firstTask) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    firstTask.run();
                } catch (Exception e) {
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> {
            try {
                scoreTest();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        new Thread(sleeper).start();
    }

    public void setBasicDetailpageController(BasicDetailpageController basicDetailpageController) {
        this.basicDetailpageController = basicDetailpageController;
    }

}
