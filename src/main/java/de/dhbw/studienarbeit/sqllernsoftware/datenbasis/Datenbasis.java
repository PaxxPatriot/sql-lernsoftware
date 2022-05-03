package de.dhbw.studienarbeit.sqllernsoftware.datenbasis;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Aufgabentyp;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.DBErgebnisTranskript;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

public interface Datenbasis {
    DBErgebnisTranskript[] executeAbfrageUndMusterloesung(Aufgabentyp aufgabentyp, String userQuery, String loesungQuery, String pruefungsQuery, String datenbankPfad) throws SQLException;

    String copyDatenbasis();

    void importSQL(Connection conn, File in);
}
