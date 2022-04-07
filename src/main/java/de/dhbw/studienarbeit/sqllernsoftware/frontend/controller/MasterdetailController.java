package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.ObjektMitId;
import de.dhbw.studienarbeit.sqllernsoftware.frontend.ObjectCellFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.List;

public class MasterdetailController {

    @FXML
    Pane basicdetailpage;

    @FXML
    BasicDetailpageController basicdetailpageController;

    @FXML
    AnchorPane masterdetailanchor;

    @FXML
    private ListView listView = new ListView();

    @FXML
    private void clickedListElement() throws IOException {
        ObjektMitId selectedItem = (ObjektMitId) listView.getSelectionModel().getSelectedItem();
        if (selectedItem instanceof Lektion) {
            basicdetailpageController.setLecturePage(selectedItem);
        } else if (selectedItem instanceof Aufgabenkollektion) {
            basicdetailpageController.setExercisePage(selectedItem);
        }
    }

    private List<ObjektMitId> objektMitIdList;

    public void initialize() {
        listView.setPrefHeight(1250.0);
        AnchorPane.setTopAnchor(listView, 3.0);
        AnchorPane.setLeftAnchor(listView, 4.0);
        AnchorPane.setBottomAnchor(listView, 5.0);
        AnchorPane.setLeftAnchor(basicdetailpage, 260.0);
        AnchorPane.setTopAnchor(basicdetailpage, 5.0);
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
