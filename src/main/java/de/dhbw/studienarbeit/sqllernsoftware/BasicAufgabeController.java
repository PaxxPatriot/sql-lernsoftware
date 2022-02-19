package de.dhbw.studienarbeit.sqllernsoftware;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class BasicAufgabeController {

    private Aufgabenkollektion exerciseCollection;

    @FXML
    private Label exerciseTitel;

    @FXML
    private Label exerciseDescription;


    public void initialize() throws IOException {
        //exerciseTitel.setText(exerciseCollection.getTitel());
        //exerciseDescription.setText(exerciseCollection.getBeschreibung());

    }

    public void setExerciseCollection(Aufgabenkollektion collection) {
        this.exerciseCollection = collection;
        System.out.println("Successfully set collection!");
    }

    public Aufgabenkollektion getExerciseCollection() {
        return this.exerciseCollection;
    }
}
