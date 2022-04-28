package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.LektionsInhalt;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.ObjektMitId;
import de.dhbw.studienarbeit.sqllernsoftware.frontend.ObjectCellFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MasterdetailController {

    private List<ObjektMitId> objektMitIdList;
    private List<ObjektMitId> backUpobjektMitIdList;


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
            Lektion lektion = (Lektion) selectedItem;
            ObservableList<LektionsInhalt> obs = FXCollections.observableList(lektion.getInhalte());

            System.out.println(this.objektMitIdList);
            //ListView listview2 = new ListView(obs);
            //listview2.setCellFactory(new ObjectCellFactory());
            //listview2.setVisible(true);
            //listview2.refresh();
            //masterdetailanchor.getChildren().add(listview2);

            /*
            System.out.println(obs);
            System.out.println(lektion.getBeschreibung());
            System.out.println(lektion.getTitel());
            System.out.println(lektion.getId());*/

            List<Lektion> temp = (List<Lektion>) (List<?>) this.objektMitIdList;
            addAfter(lektion, temp);
            //listView.refresh();

            //basicdetailpageController.setLecturePage(selectedItem);
        } else if (selectedItem instanceof Aufgabenkollektion) {
            basicdetailpageController.setExercisePage(selectedItem);

        } else if (selectedItem instanceof LektionsInhalt) {
            basicdetailpageController.setLecturePage(selectedItem);
        }
    }

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
        this.backUpobjektMitIdList = new ArrayList<>(objektMitIdList);
        System.out.println("Print setObjektMitIdList");
        System.out.println(this.objektMitIdList);
        ObservableList<ObjektMitId> observableList = FXCollections.observableList(this.objektMitIdList);
        listView.setCellFactory(new ObjectCellFactory());
        listView.setItems(observableList);
        listView.refresh();
    }

    public void clearDetailpage() {
        basicdetailpageController.clearDetailpage();
    }

    public void addAfter(Lektion lektion, List<Lektion> lektionList) {

        listView.getItems().retainAll(backUpobjektMitIdList);
        System.out.println(backUpobjektMitIdList);
        Integer index = listView.getItems().indexOf(lektion);
        List<LektionsInhalt> lektionsInhaltList = lektion.getInhalte();

        try {
            if (!listView.getItems().get(index + 1).equals(lektionsInhaltList.get(0))) {
                listView.getItems().addAll(index + 1, lektionsInhaltList);

                listView.refresh();
                System.out.println("Finished execution addAfter");

            } else {
                System.out.println("Already open!");
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Lektion hat keine Inhalte");
        }


    }
}
