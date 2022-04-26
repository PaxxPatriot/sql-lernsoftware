package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StatusIcon extends ImageView {

    Image wrong, correct, waiting;
    Label resultLabel;
    ProgressIndicator progressIndicator;

    public StatusIcon(Label resultLabel) throws FileNotFoundException {
        wrong = new Image(new FileInputStream("src/main/resources/de/dhbw/studienarbeit/sqllernsoftware/icons/icons8-stornieren-48.png"));
        correct = new Image(new FileInputStream("src/main/resources/de/dhbw/studienarbeit/sqllernsoftware/icons/icons8-häkchen-48.png"));
        this.setFitHeight(18);
        this.setFitWidth(18);
        this.resultLabel = resultLabel;
        progressIndicator = new ProgressIndicator();

    }

    public void statusWrong() {
        this.setImage(wrong);
    }

    public void statusCorrect() {
        this.setImage(correct);
    }

    public void statusWorking() {
        this.setImage(waiting);
    }

    public Image getWrong() {
        return wrong;
    }

    public void setWrong(Image wrong) {
        this.wrong = wrong;
    }

    public Image getCorrect() {
        return correct;
    }

    public void setCorrect(Image correct) {
        this.correct = correct;
    }

    public Image getWaiting() {
        return waiting;
    }

    public void setWaiting(Image waiting) {
        this.waiting = waiting;
    }

    public Label getResultLabel() {
        return resultLabel;
    }

    public void setResultLabel(Label resultLabel) {
        this.resultLabel = resultLabel;
    }
}
