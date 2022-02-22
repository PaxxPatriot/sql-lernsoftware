package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BasicAufgabenController {

    private Aufgabenkollektion aufgabenkollektion;

    @FXML
    Label titel;

    @FXML
    Label description;

    public void build() {
        titel.setText(aufgabenkollektion.getTitel());
        description.setText(aufgabenkollektion.getBeschreibung()+"\n");
    }


    public Aufgabenkollektion getAufgabenkollektion() {
        return aufgabenkollektion;
    }

    public void setAufgabenkollektion(Aufgabenkollektion aufgabenkollektion) {
        this.aufgabenkollektion = aufgabenkollektion;
    }
}
