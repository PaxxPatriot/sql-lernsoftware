package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;


import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.DBErgebnisKommentar;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.EntityUtils;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.KommentarAusgabeText;
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
import javafx.scene.layout.ColumnConstraints;
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
        exercisePane.getColumnConstraints().add(new ColumnConstraints(350));
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
                    KommentarAusgabeText ergebnisKommentar = entityUtils.getKommentarText(aufgabe, inputfield.getText());
                    System.out.println("Button Prüfen was used");
                    System.out.println(ergebnisKommentar);
                    if (ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.M) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.E)) {
                        statusIcon.statusCorrect();
                        System.out.println("Status was set correct");
                    } else if (ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.ERROR) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.C) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.F) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.Z) || ergebnisKommentar.getKommentarType().equals(ErgebnisKommentarType.L)) {
                        statusIcon.statusWrong();
                        System.out.println("Status was set wrong");
                    }
                    buttonPruefen.getStatusIcon().getResultLabel().setText(ergebnisKommentar.getOutput());
                    buttonMusterloesung.setVisible(true);
                }
            });

            statusButtonPane.add(buttonPruefen, 0, 0);
            statusButtonPane.add(statusIcon, 1, 0);
            vbox.getChildren().add(statusButtonPane);
            vbox.getChildren().add(resultLabel);


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
            vbox.getChildren().add(buttonMusterloesung);
            vbox.getChildren().add(musterloesungField);

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
