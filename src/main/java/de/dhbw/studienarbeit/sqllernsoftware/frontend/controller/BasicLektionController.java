package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.LektionsInhalt;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.TextFlow;
import javafx.scene.web.WebView;


public class BasicLektionController {

    private LektionsInhalt lektionsInhalt;

    @FXML
    Label title;

    @FXML
    TextFlow textFlow;

    @FXML
    WebView webView;

    public void build() {
        title.setText(lektionsInhalt.getUITitel());
        webView.getEngine().loadContent(lektionsInhalt.getUIBeschreibung());
    }

    public LektionsInhalt getLektionsInhalt() {
        return lektionsInhalt;
    }

    public void setLektionsInhalt(LektionsInhalt lektionsInhalt) {
        this.lektionsInhalt = lektionsInhalt;
    }
}
