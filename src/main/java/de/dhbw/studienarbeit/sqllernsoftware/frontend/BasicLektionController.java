package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.ObjektMitId;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BasicLektionController {

    private Lektion lektion;

    @FXML
    Label titel;

    @FXML
    Label description;

    public void build() {
        titel.setText(lektion.getTitel());
        description.setText(lektion.getBeschreibung()+"\n");
    }

    public Lektion getLektion() {
        return lektion;
    }

    public void setLektion(Lektion lektion) {
        this.lektion = lektion;
    }
}
