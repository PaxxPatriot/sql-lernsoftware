package de.dhbw.studienarbeit.sqllernsoftware.datenbasis;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Logger;

public class DatenbasisController {
    private static final Logger logger = Logger.getLogger("de.dhbw.studienarbeit.sqllernsoftware.datenbasis.DatenbasisController");

    private static ResultSet executeQueryOnDatabase(String query, String datenbankPfad) throws SQLException {
        try (Connection conn = DriverManager.getConnection(datenbankPfad)) {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery(query);
        }
    }

    private static int executeUpdateOnDatabase(String query, String datenbankPfad) throws SQLException {
        try (Connection conn = DriverManager.getConnection(datenbankPfad)) {
            Statement stmt = conn.createStatement();
            return stmt.executeUpdate(query);
        }
    }

    public static ResultSet[] executeAbfrageUndMusterloesung(String query, String loesung, String datenbankPfad) {
        ResultSet[] abfrageUndLoesung = new ResultSet[2];
        String url = String.format("jdbc:sqlite:%s", datenbankPfad);
        try {
            abfrageUndLoesung[0] = executeQueryOnDatabase(query, url);
            abfrageUndLoesung[1] = executeQueryOnDatabase(loesung, url);
            return abfrageUndLoesung;
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
        return null;
    }

    public static int[] executeAbfrageUndMusterloesungOnCopyOfDatenbasis(String query, String loesung) {
        int[] abfrageUndLoesung = new int[2];

        String url_user = copyDatenbasis();
        String url_muster = copyDatenbasis();
        try {
            abfrageUndLoesung[0] = executeUpdateOnDatabase(query, url_user);
            abfrageUndLoesung[1] = executeUpdateOnDatabase(loesung, url_muster);
            return abfrageUndLoesung;
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
        finally {
            // Delete temporary copies of Datenbasis
            new File(url_user.substring(12)).delete();
            new File(url_muster.substring(12)).delete();
        }
        return null;
    }

    public static String copyDatenbasis() {
        String url = createNewDb();
        try (Connection conn = DriverManager.getConnection(url)) {
            importSQL(conn, new File("data/hochschule-schema.sql"));
            importSQL(conn, new File("data/hochschule-daten.sql"));
            return url;
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
        return "";
    }

    private static String createNewDb() {

        String uuid = UUID.randomUUID().toString();
        String url = String.format("jdbc:sqlite:data/hochschule-%s.db", uuid);

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                return url;
            }
        } catch (SQLException e) {
            logger.warning(e.getMessage());
        }
        return "";
    }

    public static void importSQL(Connection conn, File in) {
        try {
            Scanner s = new Scanner(in);
            s.useDelimiter("(;(\r)?\n)|(--\n)");
            try (Statement st = conn.createStatement()) {
                while (s.hasNext()) {
                    String line = s.next();
                    if (line.startsWith("/*!") && line.endsWith("*/")) {
                        int i = line.indexOf(' ');
                        line = line.substring(i + 1, line.length() - " */".length());
                    }

                    if (line.trim().length() > 0) {
                        st.execute(line);
                    }
                }
            }
        } catch (SQLException | FileNotFoundException e) {
            logger.warning(e.getMessage());
        }
    }
}
