package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.EntityUtils;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.frontend.AufgabeUI;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.*;
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
        description.setText(aufgabenkollektion.getBeschreibung()+"\n");

        AnchorPane.setTopAnchor(scrollPane, 5.0);
        AnchorPane.setRightAnchor(scrollPane, 5.0);
        AnchorPane.setBottomAnchor(scrollPane, 5.0);

        Integer row = 2;

        for (Aufgabe aufgabe : aufgabenkollektion.getAufgabenliste()) {
            AufgabeUI aufgabeUI = new AufgabeUI(aufgabe, entityUtils);
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
