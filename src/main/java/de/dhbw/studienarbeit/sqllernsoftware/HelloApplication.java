package de.dhbw.studienarbeit.sqllernsoftware;

import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.EntityUtils;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.persistence.AppdataController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

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
        Aufgabe aufgabe = appdataController.getAufgabenkollektionById(2L).getAufgabe(0);
        EntityUtils entityUtils = new EntityUtils();
        System.out.println(entityUtils.getKommentar(aufgabe, "SELECT * FROM Professoren WHERE 1 = 1").anzeigeText());
        launch();
    }
}