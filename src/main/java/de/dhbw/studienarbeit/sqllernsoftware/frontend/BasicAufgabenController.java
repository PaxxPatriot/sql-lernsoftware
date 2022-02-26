package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class BasicAufgabenController {

    private Aufgabenkollektion aufgabenkollektion;

    @FXML
    GridPane exercisePane;

    @FXML
    Label title;

    @FXML
    Label description;

    public void build() {
        title.setText(aufgabenkollektion.getTitel());
        description.setText(aufgabenkollektion.getBeschreibung()+"\n");

        Integer row = 2;

        for (Aufgabe aufgabe : aufgabenkollektion.getAufgabenliste()) {
            System.out.println(aufgabe.getTitel());
            VBox vbox = new VBox();
            vbox.setPadding(new Insets(10));
            vbox.setSpacing(10);
            Text title = new Text(aufgabe.getTitel());
            vbox.getChildren().add(title);

            Text exerciseText = new Text(aufgabe.getAufgabentext());
            vbox.getChildren().add(exerciseText);

            TextField textField = new TextField();
            vbox.getChildren().add(textField);

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
