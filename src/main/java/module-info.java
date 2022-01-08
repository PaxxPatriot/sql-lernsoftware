module de.dhbw.studienarbeit.sqllernsoftware {
    requires javafx.controls;
    requires javafx.fxml;
	requires java.xml;
	requires org.hibernate.orm.core;
	requires java.persistence;


    opens de.dhbw.studienarbeit.sqllernsoftware to javafx.fxml;
    exports de.dhbw.studienarbeit.sqllernsoftware;
}