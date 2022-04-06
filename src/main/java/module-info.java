module de.dhbw.studienarbeit.sqllernsoftware {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
	requires java.xml;


    opens de.dhbw.studienarbeit.sqllernsoftware to javafx.fxml;
    opens de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;
    opens de.dhbw.studienarbeit.sqllernsoftware.persistence;
    opens test;
    exports de.dhbw.studienarbeit.sqllernsoftware;
    exports de.dhbw.studienarbeit.sqllernsoftware.backend.enums;
    exports de.dhbw.studienarbeit.sqllernsoftware.backend.manager;
    opens de.dhbw.studienarbeit.sqllernsoftware.backend.manager;
    opens de.dhbw.studienarbeit.sqllernsoftware.datenbasis;
}