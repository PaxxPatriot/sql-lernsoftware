open module de.dhbw.studienarbeit.sqllernsoftware {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
	requires java.xml;
    requires javafx.web;



    exports de.dhbw.studienarbeit.sqllernsoftware;
    exports de.dhbw.studienarbeit.sqllernsoftware.backend.enums;
    exports de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

}