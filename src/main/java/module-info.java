module de.dhbw.studienarbeit.sqllernsoftware {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
	requires java.xml;
    requires javafx.web;


    opens de.dhbw.studienarbeit.sqllernsoftware to javafx.fxml;
    opens de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;
    opens de.dhbw.studienarbeit.sqllernsoftware.persistence;
    exports de.dhbw.studienarbeit.sqllernsoftware;
    opens de.dhbw.studienarbeit.sqllernsoftware.datenbasis;
    exports de.dhbw.studienarbeit.sqllernsoftware.frontend;
    opens de.dhbw.studienarbeit.sqllernsoftware.frontend;
    exports de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;
    opens de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;
}