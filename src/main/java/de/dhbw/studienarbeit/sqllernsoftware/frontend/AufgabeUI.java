package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.EntityUtils;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.KommentarAusgabeText;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import javafx.application.Platform;
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

public class AufgabeUI extends VBox {

    Aufgabe aufgabe;
    static EntityUtils entityUtils;

    public AufgabeUI(Aufgabe aufgabe, EntityUtils entityUtils) throws FileNotFoundException {
        this.aufgabe = aufgabe;
        this.entityUtils = entityUtils;
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
        TextField musterloesungField = new TextField();
        musterloesungField.setEditable(false);
        musterloesungField.setVisible(false);

        GridPane statusButtonPane = new GridPane();
        statusButtonPane.setHgap(5.0);
        Label resultLabel = new Label();
        StatusIcon statusIcon = new StatusIcon(resultLabel);
        statusIcon.setVisible(true);


        StatusButton buttonPruefen = new StatusButton(statusIcon);
        Button buttonMusterloesung = new Button("Musterlösung anzeigen");
        buttonMusterloesung.setVisible(false);

        buttonPruefen.setText("Prüfen");
        buttonPruefen.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                statusIcon.getResultLabel().setText("Antwort wird überprüft. Bitte warten.");
                delay(() -> statusIcon.statusLoading(), aufgabe, inputfield, statusIcon, buttonPruefen, buttonMusterloesung);
                buttonMusterloesung.setVisible(true);
            }
        });

        statusButtonPane.add(buttonPruefen, 0, 0);
        statusButtonPane.add(statusIcon, 1, 0);
        this.getChildren().add(statusButtonPane);
        this.getChildren().add(resultLabel);


        buttonMusterloesung.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (!musterloesungField.isVisible()) {
                    musterloesungField.setText(aufgabe.getMusterloesung());
                    musterloesungField.setVisible(true);
                } else {
                    musterloesungField.setVisible(false);
                }

            }
        });
        this.getChildren().add(buttonMusterloesung);
        this.getChildren().add(musterloesungField);
    }

    public static void delay(Runnable firstTask, Aufgabe aufgabe, TextField inputfield, StatusIcon statusIcon, StatusButton buttonPruefen, Button buttonMusterloesung) {
        Task<Void> sleeper = new Task<Void>() {
            @Override
            protected Void call() throws Exception {
                try {
                    firstTask.run();
                    KommentarAusgabeText ergebnisKommentar = entityUtils.getKommentarText(aufgabe, inputfield.getText());
                    if (ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.M) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.E)) {
                        statusIcon.statusCorrect();
                    } else if (ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.ERROR) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.C) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.F) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.Z) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.L)) {
                        statusIcon.statusWrong();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
                return null;
            }
        };
        sleeper.setOnSucceeded(event -> buttonPruefen.getStatusIcon().getResultLabel().setText(entityUtils.getKommentarText(aufgabe, inputfield.getText()).getOutput()));
        new Thread(sleeper).start();
    }
}
