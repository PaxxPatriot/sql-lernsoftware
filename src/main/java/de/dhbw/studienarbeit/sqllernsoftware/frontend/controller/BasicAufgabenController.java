package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.EntityUtils;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.frontend.AufgabeUI;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.io.FileNotFoundException;



public class BasicAufgabenController {

    private Aufgabenkollektion aufgabenkollektion;

    EntityUtils entityUtils = new EntityUtils();

    @FXML
    AnchorPane anchorPane;

    @FXML
    ScrollPane scrollPane;

    @FXML
    GridPane exercisePane;

    @FXML
    Label title;

    @FXML
    Label description;

    public void build() throws FileNotFoundException {
        title.setText(aufgabenkollektion.getTitel());
        title.setFont(new Font(24.0));
        title.setPadding(new Insets(5));
        description.setText(aufgabenkollektion.getBeschreibung()+"\n");
        description.setPadding(new Insets(5));
        scrollPane.setFitToWidth(true);

        AnchorPane.setTopAnchor(scrollPane, 5.0);
        AnchorPane.setRightAnchor(scrollPane, 5.0);
        AnchorPane.setBottomAnchor(scrollPane, 5.0);

        Integer row = 2;

        for (Aufgabe aufgabe : aufgabenkollektion.getAufgabenliste()) {
            AufgabeUI aufgabeUI = new AufgabeUI(aufgabe, entityUtils, scrollPane);
            exercisePane.add(aufgabeUI, 0, row);
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
