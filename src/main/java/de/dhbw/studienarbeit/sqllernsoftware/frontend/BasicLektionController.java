package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.ObjektMitId;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

public class BasicLektionController {

    private Lektion lektion;

    @FXML
    Label title;

    @FXML
    TextFlow textFlow;

    public void build() {
        title.setText(lektion.getTitel());
        textFlow.getChildren().add(new Text(lektion.getBeschreibung()));
    }

    public Lektion getLektion() {
        return lektion;
    }

    public void setLektion(Lektion lektion) {
        this.lektion = lektion;
    }
}
