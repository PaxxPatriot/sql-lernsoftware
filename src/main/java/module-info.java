module de.dhbw.studienarbeit.sqllernsoftware {
    requires javafx.controls;
    requires javafx.fxml;


    opens de.dhbw.studienarbeit.sqllernsoftware to javafx.fxml;
    exports de.dhbw.studienarbeit.sqllernsoftware;
}