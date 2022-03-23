package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.EntityUtils;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.hibernate.tool.schema.Action;

public class BasicAufgabenController {

    private Aufgabenkollektion aufgabenkollektion;

    EntityUtils entityUtils = new EntityUtils();

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
            VBox vbox = new VBox();
            vbox.setPadding(new Insets(10));
            vbox.setSpacing(10);
            Text title = new Text(aufgabe.getTitel());
            vbox.getChildren().add(title);

            Text exerciseText = new Text(aufgabe.getAufgabentext());
            vbox.getChildren().add(exerciseText);

            TextField textField = new TextField();
            vbox.getChildren().add(textField);
            TextField revealField = new TextField();
            revealField.setVisible(false);

            Button button = new Button("Prüfen");
            button.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent e) {
                    entityUtils.getKommentar(aufgabe, textField.getText());
                }
            }
            );
            vbox.getChildren().add(button);

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
