package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.ObjektMitId;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MasterdetailController {

    @FXML
    BasicDetailpageController basicdetailpageController;

    @FXML
    private ListView listView = new ListView();

    @FXML
    private void clickedListElement() throws IOException {
        ObjektMitId selectedItem = (ObjektMitId) listView.getSelectionModel().getSelectedItem();
        System.out.println("selectedItem-Type: "+ selectedItem.getClass());
        if (selectedItem instanceof Lektion) {
            System.out.println("Current ListView is of type Lektion");
            basicdetailpageController.setLecturePage(selectedItem);
        } else if (selectedItem instanceof Aufgabenkollektion) {
            System.out.println("Current ListView is of type Aufgabe");
            basicdetailpageController.setExercisePage(selectedItem);
        }
    }

    private List<ObjektMitId> objektMitIdList;

    public void initialize() {
    }

    public ListView<String> getListView() {
        return listView;
    }

    public void setListView(ListView<String> listView) {
        this.listView = listView;
    }

    public List<ObjektMitId> getObjektMitIdList() {
        return this.objektMitIdList;
    }

    public void setObjektMitIdList(List<ObjektMitId> objektMitIdList) {
        this.objektMitIdList = objektMitIdList;
        ObservableList<ObjektMitId> observableList = FXCollections.observableList(this.objektMitIdList);
        listView.setCellFactory(new ObjectCellFactory());
        listView.setItems(observableList);
        listView.refresh();
    }

    public void clearDetailpage() {
        basicdetailpageController.clearDetailpage();
    }
}
