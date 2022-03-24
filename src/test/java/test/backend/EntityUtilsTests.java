package test.backend;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        Aufgabenkollektion aufgabenkollektion = new Aufgabenkollektion("f6f6b4e8-37e2-4fbe-9756-5f3aaadeba1b", "Aufgabenkollektion 1", "Beschreibung", "data/hochschule.db");
        Aufgabe aufgabe = new Aufgabe("d1cf65ca-426b-4a97-930d-660017389806", "Aufgabe Test", "Aufgabentext", "SELECT * FROM Professoren;", "", Aufgabentyp.S, 0, 0, aufgabenkollektion);
        String userInput = "SELECT * FROM Professoren;";
        DBErgebnisTranskript dbErgebnisTranskriptMuster = EasyMock.createMock(DBErgebnisTranskript.class);
        DBErgebnisTranskript dbErgebnisTranskriptUser = EasyMock.createMock(DBErgebnisTranskript.class);
        DBErgebnisTranskript[] dbErgebnisTranskripts = new DBErgebnisTranskript[2];
        dbErgebnisTranskripts[0] = dbErgebnisTranskriptMuster;
        dbErgebnisTranskripts[1] = dbErgebnisTranskriptUser;
        EasyMock.expect(datenbasisController.executeAbfrageUndMusterloesung(aufgabe.getTyp(), aufgabe.getMusterloesung(), userInput, aufgabe.getPruefungsbefehl(), aufgabe.getAufgabenkollektion().getDatenbank())).andReturn(dbErgebnisTranskripts);
        EasyMock.replay(datenbasisController);

        DBErgebnisTranskript[] dbResult = datenbasisController.executeAbfrageUndMusterloesung(aufgabe.getTyp(), aufgabe.getMusterloesung(), userInput, aufgabe.getPruefungsbefehl(), aufgabe.getAufgabenkollektion().getDatenbank());
        new DBErgebnisKommentar(dbResult[1], dbResult[0], aufgabe, userInput);

        EasyMock.verify(datenbasisController);
    }
    
    void testDBErgebnisTranskriptCreation() throws SQLException {
    	String[] values1 = {"Some", "Example", "Writing"};
    	
    	 ResultSet mockResultSet = createMockResultSet(values1);
    	 
    	
         
    }
    
    public ResultSet createMockResultSet(String[] values) throws SQLException {
    	 ResultSet mockResultSet = EasyMock.createMock(ResultSet.class);  // 1
    	 EasyMock.expect(mockResultSet.getMetaData().getColumnCount()).andReturn(1);
    	 EasyMock.expect(mockResultSet.getMetaData().getColumnLabel(0)).andReturn("0");
    	 for(int i = 0; i < values.length;i++) {
    		   EasyMock.expect(mockResultSet.next()).andReturn(true);
    		   EasyMock.expect(mockResultSet.getString("0")).andReturn(values[i]);
    	 }      
         EasyMock.expect(mockResultSet.next()).andReturn(false); 
         EasyMock.replay(mockResultSet);
    	 return mockResultSet;
    }
}
