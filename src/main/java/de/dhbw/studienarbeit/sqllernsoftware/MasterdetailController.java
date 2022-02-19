package de.dhbw.studienarbeit.sqllernsoftware;

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
    private ListView<String> listView = new ListView<>();

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
        ObservableList<String> observableList = FXCollections.observableList(titles);
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

        ObservableList<String> observableList = FXCollections.observableList(titles);
        listView.setItems(observableList);
        listView.refresh();
    }
}
