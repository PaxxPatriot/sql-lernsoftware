package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.LektionsInhalt;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.ObjektMitId;
import de.dhbw.studienarbeit.sqllernsoftware.frontend.ObjectCellFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MasterdetailController {

    private List<ObjektMitId> objektMitIdList;
    private List<ObjektMitId> backUpobjektMitIdList;
    private MainController mainController;


    @FXML
    AnchorPane basicdetailpage;

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
            addAfter(lektion);
            listView.refresh();

        } else if (selectedItem instanceof Aufgabenkollektion) {
            basicdetailpageController.buildExercisePage(selectedItem);

        } else if (selectedItem instanceof LektionsInhalt) {
            basicdetailpageController.buildLecturePage(selectedItem);
        }
    }

    public void initialize() {
        listView.setPrefHeight(1250.0);
        AnchorPane.setTopAnchor(listView, 3.0);
        AnchorPane.setLeftAnchor(listView, 4.0);
        AnchorPane.setBottomAnchor(listView, 5.0);
        AnchorPane.setLeftAnchor(basicdetailpage, 260.0);
        AnchorPane.setTopAnchor(basicdetailpage, .0);
        AnchorPane.setBottomAnchor(basicdetailpage, .0);
        AnchorPane.setRightAnchor(basicdetailpage, .0);
    }

    public void buildTest() throws IOException {
        basicdetailpageController.setMainController(mainController);
        Alert confirmationAlert = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationAlert.setTitle("Prüfung starten");
        confirmationAlert.setHeaderText("Prüfung starten");
        confirmationAlert.setContentText("Mit Bestätigung starten sie eine Prüfung. Dabei ist kein Zugriff auf andere Lektionen oder Aufgaben möglich, ohne die Prüfung abzubrechen.");
        Optional<ButtonType> result = confirmationAlert.showAndWait();
        if (result.get() == ButtonType.OK) {
            basicdetailpageController.buildTestPage();
        } else {
            confirmationAlert.close();
        }
    }

    public void setObjektMitIdList(List<ObjektMitId> objektMitIdList) throws FileNotFoundException {
        basicdetailpageController.setMainController(mainController);
        this.objektMitIdList = objektMitIdList;
        this.backUpobjektMitIdList = new ArrayList<>(objektMitIdList);
        ObservableList<ObjektMitId> observableList = FXCollections.observableList(this.objektMitIdList);
        listView.setCellFactory(new ObjectCellFactory());
        listView.setItems(observableList);
        listView.refresh();
    }

    public void clearDetailpage() {
        basicdetailpageController.clearDetailpage();
    }

    public void addAfter(Lektion lektion) {

        listView.getItems().retainAll(backUpobjektMitIdList);
        Integer index = listView.getItems().indexOf(lektion);
        List<LektionsInhalt> lektionsInhaltList = lektion.getInhalte();

        try {
            if (!listView.getItems().get(index + 1).equals(lektionsInhaltList.get(0))) {
                listView.getItems().addAll(index + 1, lektionsInhaltList);
            } else {
                //System.out.println("Already open!");
            }

        } catch (Exception e) {
            //System.out.println(e);
            //System.out.println("Lektion hat keine Inhalte");
        }

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

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
