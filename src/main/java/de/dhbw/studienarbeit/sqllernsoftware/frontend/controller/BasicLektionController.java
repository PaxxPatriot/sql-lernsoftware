package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.LektionsInhalt;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;


public class BasicLektionController {

    private LektionsInhalt lektionsInhalt;

    @FXML
    Label title;

    @FXML
    ScrollPane lecturePane;

    @FXML
    WebView webView;

    public void build() {
        title.setText(lektionsInhalt.getUITitel());
        lecturePane.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(2.0), new Insets(10.0))));
        lecturePane.setPadding(new Insets(5));
        lecturePane.setFitToWidth(true);
        webView.prefWidthProperty().bind(lecturePane.widthProperty());
        webView.prefHeightProperty().bind(lecturePane.heightProperty());
        webView.getEngine().loadContent(lektionsInhalt.getUIBeschreibung());
    }

    public LektionsInhalt getLektionsInhalt() {
        return lektionsInhalt;
    }

    public void setLektionsInhalt(LektionsInhalt lektionsInhalt) {
        this.lektionsInhalt = lektionsInhalt;
    }
}
