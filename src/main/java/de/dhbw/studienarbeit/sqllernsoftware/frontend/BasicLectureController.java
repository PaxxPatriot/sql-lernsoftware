package de.dhbw.studienarbeit.sqllernsoftware.frontend;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Lektion;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class BasicLectureController {

    private Lektion lecture;

    @FXML
    private Label lectureTitel;

    @FXML
    private Label lectureDescription;

    public void setLecture(Lektion lecture) {
        this.lecture = lecture;
        System.out.println("Successfully set lecture!");
    }

    public Lektion getLecture() {
        return this.lecture;
    }

    public void initialize() throws IOException {
        lectureTitel.setText(lecture.getTitel());
        lectureDescription.setText(lecture.getBeschreibung());
    }
}
