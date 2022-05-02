package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.HelloApplication;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.LektionsInhalt;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.ObjektMitId;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class BasicDetailpageController {

    @FXML
    private AnchorPane basePane;

    public void setLecturePage(ObjektMitId object) throws IOException {
        LektionsInhalt lektionsInhalt = (LektionsInhalt) object;
        clearDetailpage();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml/basic_lektion.fxml"));
        BasicLektionController basicLektionController = new BasicLektionController();
        basicLektionController.setLektionsInhalt(lektionsInhalt);
        loader.setController(basicLektionController);
        Parent lektionElemente = loader.load();

        basePane.getChildren().add(lektionElemente);
        AnchorPane.setTopAnchor(lektionElemente, .0);
        AnchorPane.setBottomAnchor(lektionElemente, .0);
        AnchorPane.setLeftAnchor(lektionElemente, .0);
        AnchorPane.setRightAnchor(lektionElemente, .0);

        basicLektionController.build();
    }

    public void setExercisePage(ObjektMitId object) throws IOException {
        clearDetailpage();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml/basic_aufgabe.fxml"));
        BasicAufgabenController basicAufgabenController = new BasicAufgabenController();
        basicAufgabenController.setAufgabenkollektion((Aufgabenkollektion) object);
        loader.setController(basicAufgabenController);
        Parent lektionElemente = loader.load();

        basePane.getChildren().add(lektionElemente);
        AnchorPane.setTopAnchor(lektionElemente, .0);
        AnchorPane.setBottomAnchor(lektionElemente, .0);
        AnchorPane.setLeftAnchor(lektionElemente, .0);
        AnchorPane.setRightAnchor(lektionElemente, .0);

        basicAufgabenController.build();
    }

    public void clearDetailpage() {
        this.basePane.getChildren().clear();
    }
}
