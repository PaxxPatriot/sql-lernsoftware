package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.frontend.AufgabeUIResult;
import de.dhbw.studienarbeit.sqllernsoftware.frontend.StatusIcon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class BasicResultController {

    BasicDetailpageController basicDetailpageController;
    HashMap<Aufgabe, HashMap> results;

    @FXML
    AnchorPane anchorPane;

    @FXML
    ScrollPane scrollPane;

    @FXML
    GridPane resultPane;

    public void build() throws FileNotFoundException {
        scrollPane.setVvalue(.0);
        scrollPane.setHvalue(.0);
        scrollPane.setFitToWidth(true);
        resultPane.setPadding(new Insets(5));
        resultPane.prefWidthProperty().bind(scrollPane.widthProperty());

        AnchorPane.setTopAnchor(scrollPane, 5.0);
        AnchorPane.setRightAnchor(scrollPane, 5.0);
        AnchorPane.setBottomAnchor(scrollPane, 5.0);

        int score = 0;
        int row = 1;
        for (Map.Entry<Aufgabe, HashMap> entry : results.entrySet()) {
            AufgabeUIResult aufgabeUIResult = new AufgabeUIResult(entry, scrollPane);
            resultPane.add(aufgabeUIResult, 0, row);
            row++;
            if (entry.getValue().get("correct").equals("true")) {
                score++;
                System.out.println(score);
            }
        }


        StatusIcon statusIcon = new StatusIcon(new Label());
        if (score < 5) {
            statusIcon.statusWrong();
        } else {
            statusIcon.statusCorrect();
        }

        Label scoreLabel = new Label(score+"/10", statusIcon);
        scoreLabel.setFont(new Font(24));
        scoreLabel.setPadding(new Insets(5));
        resultPane.add(scoreLabel, 0, 0);

        Button returnButton = new Button("Prüfungsmodus beenden");
        returnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                basicDetailpageController.clearDetailpage();
                basicDetailpageController.mainController.setInTest(false);
            }
        });

        resultPane.add(returnButton, 0, row);
        System.out.println("Finished building ResultPage");
    }

    public void setBasicDetailpageController(BasicDetailpageController basicDetailpageController) {
        this.basicDetailpageController = basicDetailpageController;
    }

    public void setResults(HashMap<Aufgabe, HashMap> results) {
        this.results = results;
    }


}
