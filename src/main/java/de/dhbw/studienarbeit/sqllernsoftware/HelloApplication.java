package de.dhbw.studienarbeit.sqllernsoftware;

import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.EntityUtils;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
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
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        AppdataController appdataController = new AppdataController();
        List<Aufgabenkollektion> aufgabenkollektion = appdataController.getAllAufgabenkollektion();
        System.out.println(aufgabenkollektion.get(0).getId());
        Aufgabe aufgabe = aufgabenkollektion.get(0).getAufgabe(1);
        System.out.println(aufgabe.getAufgabentext());
        EntityUtils entityUtils = new EntityUtils();
        System.out.println(entityUtils.getKommentarText(aufgabe, "DELETE FROM Professoren WHERE id = 5588;").getOutput());
        launch();
    }
}