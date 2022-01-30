package de.dhbw.studienarbeit.sqllernsoftware;

import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.EntityUtils;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.datenbasis.DatenbasisController;
import de.dhbw.studienarbeit.sqllernsoftware.persistence.AppdataController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("mockup.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("SQL-Lernsoftware");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        DatenbasisController.connect("data/hochschule.db");
        AppdataController appdataController = new AppdataController();
        Aufgabe aufgabe = appdataController.getAufgabenkollektionById(2L).getAufgabe(0);
        EntityUtils entityUtils = new EntityUtils();
        System.out.println(entityUtils.getKommentar(aufgabe, "SELECT * FROM Professoren WHERE 1 = 1").anzeigeText());
        launch();
    }
}