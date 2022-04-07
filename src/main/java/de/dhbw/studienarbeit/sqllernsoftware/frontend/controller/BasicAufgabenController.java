package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentar;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.EntityUtils;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.frontend.StatusButton;
import de.dhbw.studienarbeit.sqllernsoftware.frontend.StatusIcon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;


public class BasicAufgabenController {

    private Aufgabenkollektion aufgabenkollektion;

    EntityUtils entityUtils = new EntityUtils();

    @FXML
    GridPane exercisePane;

    @FXML
    Label title;

    @FXML
    Label description;

    public void build() throws FileNotFoundException {
        title.setText(aufgabenkollektion.getTitel());
        description.setText(aufgabenkollektion.getBeschreibung()+"\n");

        Integer row = 2;

        for (Aufgabe aufgabe : aufgabenkollektion.getAufgabenliste()) {
            VBox vbox = new VBox();
            vbox.setPadding(new Insets(10));
            vbox.setSpacing(10);
            Text title = new Text(aufgabe.getTitel());
            vbox.getChildren().add(title);

            Text exerciseText = new Text(aufgabe.getAufgabentext());
            vbox.getChildren().add(exerciseText);

            TextField inputfield = new TextField();
            vbox.getChildren().add(inputfield);
            TextField revealField = new TextField();
            revealField.setVisible(false);

            GridPane statusButtonPane = new GridPane();
            Label resultLabel = new Label();
            StatusIcon statusIcon = new StatusIcon(resultLabel);

            StatusButton button = new StatusButton(statusIcon);
            button.setText("Prüfen");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    ErgebnisKommentar ergebnisKommentar = entityUtils.getKommentar(aufgabe, inputfield.getText());

                    if (ergebnisKommentar.equals(ErgebnisKommentar.M) || ergebnisKommentar.equals(ErgebnisKommentar.E)) {
                        statusIcon.statusCorrect();
                    } else if (ergebnisKommentar.equals(ErgebnisKommentar.ERROR) || ergebnisKommentar.equals(ErgebnisKommentar.C) || ergebnisKommentar.equals(ErgebnisKommentar.F) || ergebnisKommentar.equals(ErgebnisKommentar.Z)) {
                        statusIcon.statusWrong();
                    }
                    button.getStatusIcon().getResultLabel().setText(ergebnisKommentar.anzeigeText());
                }
            });
            statusButtonPane.add(button, 0, 0);
            statusButtonPane.add(statusIcon, 1, 0);
            vbox.getChildren().add(statusButtonPane);
            vbox.getChildren().add(resultLabel);


            Button buttonReveal = new Button("Anzeigen");
            buttonReveal.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    revealField.setText(aufgabe.getMusterloesung());
                    revealField.setVisible(true);
                }
            });
            vbox.getChildren().add(buttonReveal);
            vbox.getChildren().add(revealField);

            exercisePane.add(vbox, 0, row);
            row++;
        }
    }


    public Aufgabenkollektion getAufgabenkollektion() {
        return aufgabenkollektion;
    }

    public void setAufgabenkollektion(Aufgabenkollektion aufgabenkollektion) {
        this.aufgabenkollektion = aufgabenkollektion;
    }
}
