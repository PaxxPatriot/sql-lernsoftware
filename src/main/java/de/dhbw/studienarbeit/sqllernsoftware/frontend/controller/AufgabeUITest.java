package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.EntityUtils;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.KommentarAusgabeText;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.frontend.StatusButton;
import de.dhbw.studienarbeit.sqllernsoftware.frontend.StatusIcon;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class AufgabeUITest extends VBox{

    Aufgabe aufgabe;
    static EntityUtils entityUtils;
    HashMap<Aufgabe, String> answerMap = new HashMap<>();

    public AufgabeUITest(Aufgabe aufgabe, EntityUtils entityUtils) throws FileNotFoundException {
        this.aufgabe = aufgabe;
        this.entityUtils = entityUtils;
        answerMap.put(aufgabe, "");
        this.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: gray;"
        );
        this.setPadding(new Insets(10));
        this.setSpacing(10);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(.0), new Insets(5.0))));
        Text title = new Text(aufgabe.getTitel());
        this.getChildren().add(title);
        Text exerciseText = new Text(aufgabe.getAufgabentext());
        this.getChildren().add(exerciseText);

        TextField inputfield = new TextField();
        this.getChildren().add(inputfield);


        GridPane statusButtonPane = new GridPane();
        statusButtonPane.setHgap(5.0);
        Label resultLabel = new Label();
        StatusIcon statusIcon = new StatusIcon(resultLabel);
        statusIcon.setVisible(true);


        StatusButton buttonPruefen = new StatusButton(statusIcon);

        buttonPruefen.setText("Antworten");
        buttonPruefen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if (answerMap.containsKey(aufgabe)) {
                    answerMap.put(aufgabe, inputfield.getText());
                    statusIcon.getResultLabel().setText("Antwort wurde erfolgreich aktualisiert.");
                } else {

                    answerMap.put(aufgabe, inputfield.getText());
                    statusIcon.statusCorrect();
                    statusIcon.getResultLabel().setText("Antwort erfolgreich eingetragen.");
                }
            }
        });

        statusButtonPane.add(buttonPruefen, 0, 0);
        statusButtonPane.add(statusIcon, 1, 0);
        this.getChildren().add(statusButtonPane);
        this.getChildren().add(resultLabel);

    }


    public HashMap<Aufgabe, String> getAnswerMap() {
        return answerMap;
    }
}


