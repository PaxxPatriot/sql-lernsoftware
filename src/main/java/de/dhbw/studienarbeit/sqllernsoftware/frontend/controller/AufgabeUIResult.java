package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.Map;

public class AufgabeUIResult extends VBox {

    Map.Entry<Aufgabe, HashMap> result;
    GridPane gridPane = new GridPane();

    public AufgabeUIResult(Map.Entry<Aufgabe, HashMap> result, ScrollPane scrollPane) {
        this.result = result;
        this.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: gray;"
        );
        this.setPadding(new Insets(10));
        this.setSpacing(10);
        this.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(.0), new Insets(5.0))));
        this.prefWidthProperty().bind(scrollPane.widthProperty());
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setMinWidth(90.0);
        gridPane.getColumnConstraints().add(columnConstraints);

        Label givenAnswerLabel = new Label("Ihre Antwort:");
        Label musterLoesungLabel = new Label("Musterlösung:");


        Text exerciseTitle = new Text((String)result.getValue().get("aufgabe_titel"));
        exerciseTitle.setWrappingWidth(700.0);
        Text exerciseText = new Text((String)result.getValue().get("aufgabe_text"));
        exerciseText.setWrappingWidth(700.0);
        Text givenAnswer = new Text((String)result.getValue().get("givenAnswer"));
        givenAnswer.setWrappingWidth(700.0);
        Text musterLoesung = new Text((String)result.getValue().get("musterloesung"));
        musterLoesung.setWrappingWidth(700.0);


        gridPane.add(givenAnswerLabel, 0,0);
        gridPane.add(givenAnswer, 1, 0);
        gridPane.add(musterLoesungLabel, 0, 1);
        gridPane.add(musterLoesung, 1, 1);

        this.getChildren().add(exerciseTitle);
        this.getChildren().add(exerciseText);
        this.getChildren().add(gridPane);

    }
}
