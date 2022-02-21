package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MasterdetailController {

    @FXML
    private ListView listView = new ListView();

    @FXML
    private void clickedListElement() {
        Object selectedItem = listView.getSelectionModel().getSelectedItem();
    }

    private List<Aufgabenkollektion> exerciseList;
    private List<Lektion> lectureList;

    public void initialize() {


    }

    public ListView<String> getListView() {
        return listView;
    }

    public void setListView(ListView<String> listView) {
        this.listView = listView;
    }

    public List<Aufgabenkollektion> getExerciseList() {
        return exerciseList;
    }

    public void setExerciseList(List<Aufgabenkollektion> exerciseList) {
        this.exerciseList = exerciseList;
        ArrayList<String> titles = new ArrayList<>();
        for (Aufgabenkollektion aufgabenkollektion : exerciseList) {
            titles.add(aufgabenkollektion.getTitel());
        }
        ObservableList<Aufgabenkollektion> observableList = FXCollections.observableList(this.exerciseList);
        listView.setCellFactory(new AufgabenCellFactory());
        listView.setItems(observableList);
        listView.refresh();

    }

    public List<Lektion> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Lektion> lectureList) {
        this.lectureList = lectureList;
        ArrayList<String> titles = new ArrayList<>();
        for (Lektion lektion : lectureList) {
            titles.add(lektion.getTitel());
        }

        ObservableList<Lektion> observableList = FXCollections.observableList(this.lectureList);
        listView.setCellFactory(new LektionCellFactory());
        listView.setItems(observableList);
        listView.refresh();
    }
}
