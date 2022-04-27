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
    private ObservableList<?> tempList;

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

            addAfter(lektion, (List<Lektion>) (List<?>) this.objektMitIdList);
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
        List<Lektion> lektionObservableList1 = new ArrayList<>();
        List<Lektion> lektionObservableList2 = new ArrayList<>();
        Boolean firstList = true;

        System.out.println(lektionList);
        listView.getItems().removeAll(lektionList);
        System.out.println("Cleared list");
        List<LektionsInhalt> lektionsInhaltList = lektion.getInhalte();
        for (Lektion lektion1 : lektionList) {
            if (firstList) {
                System.out.println("For Execution works");
                if (lektion1.equals(lektion)) {
                    lektionObservableList1.add(lektion1);
                    System.out.println("Added Inhalte!");
                    firstList = false;
                } else {
                    lektionObservableList1.add(lektion1);
                }
                System.out.println(listView.getItems());
            }
            lektionObservableList2.add(lektion1);
        }
        listView.getItems().addAll(FXCollections.observableList(lektionObservableList1));
        listView.getItems().addAll(FXCollections.observableList(lektionsInhaltList));
        listView.getItems().addAll(FXCollections.observableList(lektionObservableList2));
        tempList = listView.getItems();
        listView.refresh();
        System.out.println("Finished execution addAfter");
    }
}
