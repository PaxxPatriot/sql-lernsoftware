package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StatusButton extends Button {

    StatusIcon statusIcon;

    public StatusButton(StatusIcon statusIcon) {
        super();
        this.statusIcon = statusIcon;
    }

    public StatusIcon getStatusIcon() {
        return statusIcon;
    }

    public void setStatusIcon(StatusIcon statusIcon) {
        this.statusIcon = statusIcon;
    }
}
