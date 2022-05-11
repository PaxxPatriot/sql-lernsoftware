package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.HelloApplication;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.HashMap;

public class BasicDetailpageController {

    MainController mainController;

    @FXML
    private AnchorPane basePane;

    public void buildLecturePage(ObjektMitId object) throws IOException {

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

    public void buildExercisePage(ObjektMitId object) throws IOException {
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

    public void buildTestPage() throws IOException {
        mainController.setInTest(true);
        clearDetailpage();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml/basic_test.fxml"));
        BasicTestController basicTestController = new BasicTestController();
        basicTestController.setBasicDetailpageController(this);
        loader.setController(basicTestController);
        Parent lektionElemente = loader.load();

        basePane.getChildren().add(lektionElemente);
        AnchorPane.setTopAnchor(lektionElemente, .0);
        AnchorPane.setLeftAnchor(lektionElemente, .0);
        AnchorPane.setRightAnchor(lektionElemente, .0);
        AnchorPane.setBottomAnchor(lektionElemente, .0);

        basicTestController.build();
    }

    public void buildResultPage(HashMap<Aufgabe, HashMap> results) throws IOException {
        clearDetailpage();
        FXMLLoader loader = new FXMLLoader(HelloApplication.class.getResource("fxml/basic_result.fxml"));
        BasicResultController basicResultController = new BasicResultController();
        basicResultController.setBasicDetailpageController(this);
        basicResultController.setResults(results);
        loader.setController(basicResultController);
        Parent lektionElemente = loader.load();

        basePane.getChildren().add(lektionElemente);
        AnchorPane.setTopAnchor(lektionElemente, .0);
        AnchorPane.setLeftAnchor(lektionElemente, .0);
        AnchorPane.setRightAnchor(lektionElemente, .0);
        AnchorPane.setBottomAnchor(lektionElemente, .0);

        basicResultController.build();
    }

    public void clearDetailpage() {
        this.basePane.getChildren().clear();
    }

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
    }
}
