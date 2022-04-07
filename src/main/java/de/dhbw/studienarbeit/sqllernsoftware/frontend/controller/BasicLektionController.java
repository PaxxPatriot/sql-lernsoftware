package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebView;


public class BasicLektionController {

    private Lektion lektion;

    @FXML
    Label title;

    @FXML
    TextFlow textFlow;

    @FXML
    WebView webView;

    public void build() {
        title.setText(lektion.getTitel());
        webView.getEngine().loadContent(lektion.getBeschreibung());
    }

    public Lektion getLektion() {
        return lektion;
    }

    public void setLektion(Lektion lektion) {
        this.lektion = lektion;
    }
}
