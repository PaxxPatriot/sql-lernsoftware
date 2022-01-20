package de.dhbw.studienarbeit.sqllernsoftware.datenbasis;

import java.sql.*;
import java.util.logging.Logger;

public class DatenbasisController {
    private static final Logger logger = Logger.getLogger("de.dhbw.studienarbeit.sqllernsoftware.datenbasis.DatenbasisController");
    private static Connection connection = null;

    public static void connect(String datenbankPfad) {
        try {
            connection = DriverManager.getConnection(String.format("jdbc:sqlite:%s", datenbankPfad));
            logger.info("Connection to SQLite has been established.");
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
    }

    public static ResultSet[] executeAbfrageUndMusterloesung(String query, String loesung, String datenbankPfad) {
        ResultSet[] abfrageUndLoesung = new ResultSet[2];
        try {
            Connection verbindung = DriverManager.getConnection(String.format("jdbc:sqlite:%s", datenbankPfad));
            Statement stmtQuery = verbindung.createStatement();
            Statement stmtLoesung = verbindung.createStatement();
            abfrageUndLoesung[0] = stmtQuery.executeQuery(query);
            abfrageUndLoesung[1] = stmtLoesung.executeQuery(loesung);
            return abfrageUndLoesung;
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
        return null;
    }
}
