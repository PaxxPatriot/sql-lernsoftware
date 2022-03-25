package test.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.StringJoiner;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Aufgabentyp;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.DBErgebnisKommentar;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.DBErgebnisTranskript;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.EntityUtils;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import de.dhbw.studienarbeit.sqllernsoftware.datenbasis.Datenbasis;
import de.dhbw.studienarbeit.sqllernsoftware.datenbasis.DatenbasisController;
import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

public class EntityUtilsTests {
	@Test
	void testGetDBKommentar() {
		Datenbasis datenbasisController = EasyMock.createMock(Datenbasis.class);
		Aufgabenkollektion aufgabenkollektion = new Aufgabenkollektion("f6f6b4e8-37e2-4fbe-9756-5f3aaadeba1b",
				"Aufgabenkollektion 1", "Beschreibung", "data/hochschule.db");
		Aufgabe aufgabe = new Aufgabe("d1cf65ca-426b-4a97-930d-660017389806", "Aufgabe Test", "Aufgabentext",
				"SELECT * FROM Professoren;", "", Aufgabentyp.S, 0, 0, aufgabenkollektion);
		String userInput = "SELECT * FROM Professoren;";
		DBErgebnisTranskript dbErgebnisTranskriptMuster = EasyMock.createMock(DBErgebnisTranskript.class);
		DBErgebnisTranskript dbErgebnisTranskriptUser = EasyMock.createMock(DBErgebnisTranskript.class);
		DBErgebnisTranskript[] dbErgebnisTranskripts = new DBErgebnisTranskript[2];
		dbErgebnisTranskripts[0] = dbErgebnisTranskriptMuster;
		dbErgebnisTranskripts[1] = dbErgebnisTranskriptUser;
		EasyMock.expect(
				datenbasisController.executeAbfrageUndMusterloesung(aufgabe.getTyp(), aufgabe.getMusterloesung(),
						userInput, aufgabe.getPruefungsbefehl(), aufgabe.getAufgabenkollektion().getDatenbank()))
				.andReturn(dbErgebnisTranskripts);
		EasyMock.replay(datenbasisController);

		DBErgebnisTranskript[] dbResult = datenbasisController.executeAbfrageUndMusterloesung(aufgabe.getTyp(),
				aufgabe.getMusterloesung(), userInput, aufgabe.getPruefungsbefehl(),
				aufgabe.getAufgabenkollektion().getDatenbank());
		new DBErgebnisKommentar(dbResult[1], dbResult[0], aufgabe, userInput);

		EasyMock.verify(datenbasisController);
	}

	@Test
	void testDBErgebnisTranskriptCreation() throws SQLException {
		String[][] values1 = { {"Some","again","wow"}, {"Example","trouble",""},{ "Writing","",""} };
		String[] columnHeads = { "1","2","3" };
		ResultSet mockResultSet = createMockResultSet(values1,columnHeads);

		DBErgebnisTranskript dbet = new DBErgebnisTranskript(mockResultSet);

		// check the column heads
		assertColumnHeadForDBTranscript(dbet, columnHeads);

		// check Values
		assertValuesForDBTranscript(dbet, values1,columnHeads);
	}

	public ResultSet createMockResultSet(String[][] values,String[] columnHeads) throws SQLException {
		ResultSet mockResultSet = EasyMock.createMock(ResultSet.class); // 1
		ResultSetMetaData mockResultSetMetaData = EasyMock.createMock(ResultSetMetaData.class);
		EasyMock.expect(mockResultSet.getMetaData()).andReturn(mockResultSetMetaData);
		EasyMock.expect(mockResultSetMetaData.getColumnCount()).andReturn(columnHeads.length);
		for(int i = 0; i < columnHeads.length;i++) {
			EasyMock.expect(mockResultSetMetaData.getColumnLabel(i+1)).andReturn(columnHeads[i]);
		}

		for (int i = 0; i < values.length; i++) {
			EasyMock.expect(mockResultSet.next()).andReturn(true);
			for(int j = 0; j < columnHeads.length; j++) {
				EasyMock.expect(mockResultSet.getString(columnHeads[j])).andReturn(values[i][j]);
			}	
		}
		EasyMock.expect(mockResultSet.next()).andReturn(false);

		EasyMock.replay(mockResultSet);

		EasyMock.replay(mockResultSetMetaData);
		return mockResultSet;
	}

	public void assertColumnHeadForDBTranscript(DBErgebnisTranskript dbet, String[] columnHeads) {
		assertEquals(dbet.getColumnHeads().size(), columnHeads.length);

		for (int i = 0; i < columnHeads.length; i++) {
			assertEquals(dbet.getColumnHeads().get(i), columnHeads[i]);
		}
	}

	public void assertValuesForDBTranscript(DBErgebnisTranskript dbet, String[][] values,String[] columnHeads) {
		assertEquals(dbet.getTranscribeResult().size(), values.length);

		for (int i = 0; i < values.length; i++) {
			StringJoiner joiner = new StringJoiner(",");
			for(int j = 0; j < columnHeads.length; j++) {
				joiner.add(values[i][j]);
			}
			assertEquals(dbet.getTranscribeResult().get(i), joiner.toString());
		}
	}
}
