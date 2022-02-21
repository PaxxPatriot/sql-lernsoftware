package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;


public class LektionCellFactory implements Callback<ListView<Lektion>, ListCell<Lektion>> {
    @Override
    public ListCell<Lektion> call(ListView<Lektion> lektionListView) {
        return new ListCell<>(){
            @Override
            public void updateItem(Lektion lecture, boolean empty) {
                super.updateItem(lecture, empty);
                if (empty || lecture == null) {
                    setText(null);
                } else {
                    setText(lecture.getTitel());
                }
            }
        };
    }
}
