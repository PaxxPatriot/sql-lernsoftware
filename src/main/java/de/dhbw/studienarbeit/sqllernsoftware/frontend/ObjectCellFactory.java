package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.ObjektMitId;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;


public class ObjectCellFactory implements Callback<ListView<ObjektMitId>, ListCell<ObjektMitId>> {
    @Override
    public ListCell<ObjektMitId> call(ListView<ObjektMitId> objektMitIdListView) {
        return new ListCell<>(){
            @Override
            public void updateItem(ObjektMitId objektMitId, boolean empty) {
                super.updateItem(objektMitId, empty);
                if (empty || objektMitId == null) {
                    setText(null);
                } else {
                    setText(objektMitId.toString());
                }

                setOnMouseClicked((MouseEvent event) -> {
                        if (isEmpty()) {
                            event.consume();
                        }
                });
            }
        };

    }
}
