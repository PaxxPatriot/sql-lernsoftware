package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.LektionsInhalt;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.ObjektMitId;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class ObjectCellFactory implements Callback<ListView<ObjektMitId>, ListCell<ObjektMitId>> {

    private final Image UNOPENED_LEKTION = new Image(new FileInputStream("src/main/resources/de/dhbw/studienarbeit/sqllernsoftware/icons/right-arrow.png"));
    private final Image OPENED_LEKTION = new Image(new FileInputStream("src/main/resources/de/dhbw/studienarbeit/sqllernsoftware/icons/arrow-down-sign-to-navigate.png"));

    public ObjectCellFactory() throws FileNotFoundException {
    }

    @Override
    public ListCell<ObjektMitId> call(ListView<ObjektMitId> objektMitIdListView) {
        return new ListCell<>(){
            @Override
            public void updateItem(ObjektMitId objektMitId, boolean empty) {
                super.updateItem(objektMitId, empty);
                if (empty || objektMitId == null) {
                    setText(null);
                    setGraphic(null);
                } else {

                    if (objektMitId instanceof LektionsInhalt) {
                        setText("\t"+objektMitId.getUITitel());
                    } else {
                        setText(objektMitId.getUITitel());
                    }

                    if (objektMitId instanceof Lektion) {
                        ImageView imageView = new ImageView(OPENED_LEKTION);
                        imageView.setFitWidth(10);
                        imageView.setFitHeight(10);

                        if (getGraphic() == null) {
                            imageView.setImage(UNOPENED_LEKTION);
                            setGraphic(imageView);

                        } else if (getGraphic().equals(OPENED_LEKTION)){
                            imageView.setImage(UNOPENED_LEKTION);
                            setGraphic(imageView);
                        } else {
                            setGraphic(imageView);
                        }
                    }

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
