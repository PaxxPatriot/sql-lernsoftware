package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.HelloApplication;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.ObjektMitId;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class BasicDetailpageController {

    @FXML
    private Pane basePane;

    public void setLecturePage(ObjektMitId object) throws IOException {
        clearDetailpage();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("basic_lektion.fxml"));
        BasicLektionController basicLektionController = new BasicLektionController();
        basicLektionController.setLektion((Lektion) object);
        loader.setController(basicLektionController);
        Parent lektionElemente = loader.load();

        basePane.getChildren().add(lektionElemente);
        basicLektionController.build();
        System.out.println("Successfully loaded Lektion-Detailpage!");
    }

    public void setExercisePage(ObjektMitId object) throws IOException {
        clearDetailpage();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("basic_aufgabe.fxml"));
        BasicAufgabenController basicAufgabenController = new BasicAufgabenController();
        basicAufgabenController.setAufgabenkollektion((Aufgabenkollektion) object);
        loader.setController(basicAufgabenController);
        Parent lektionElemente = loader.load();

        basePane.getChildren().add(lektionElemente);
        basicAufgabenController.build();
        System.out.println("Successfully loaded Aufgaben-Detailpage!");
    }

    public void clearDetailpage() {
        this.basePane.getChildren().clear();
    }
}
