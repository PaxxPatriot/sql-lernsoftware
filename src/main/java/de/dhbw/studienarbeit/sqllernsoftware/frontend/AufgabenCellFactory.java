package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

public class AufgabenCellFactory implements Callback<ListView<Aufgabenkollektion>, ListCell<Aufgabenkollektion>> {

    @Override
    public ListCell<Aufgabenkollektion> call(ListView<Aufgabenkollektion> aufgabenkollektionListView) {
        return new ListCell<>() {
            @Override
            public void updateItem(Aufgabenkollektion aufgabenkollektion, boolean empty) {
                super.updateItem(aufgabenkollektion, empty);
                if (empty || aufgabenkollektion == null) {
                    setText(null);
                } else {
                    setText(aufgabenkollektion.getTitel());
                }
            }
        };
    }
}
