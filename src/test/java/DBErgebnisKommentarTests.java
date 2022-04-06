import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.DBErgebnisKommentar;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.DBErgebnisTranskript;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.KommentarAusgabeText;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;

public class DBErgebnisKommentarTests {

	@Test
	public void testDBErgebnisKommentarTypeM() {
		String userInput = "muster";
		Aufgabe aufgabe = createMockAufgabe(userInput);
		ArrayList<String> columnHeads1 = new ArrayList<String>(Arrays.asList("These", "Are" , "Rows"));
		ArrayList<String> rows1 = new ArrayList<String>(Arrays.asList("These", "Are" , "Rows"));
		
		DBErgebnisTranskript et1 = createMockDBErgebnisTranscript(columnHeads1, rows1);
		DBErgebnisTranskript et2 = createMockDBErgebnisTranscript(columnHeads1, rows1);

		DBErgebnisKommentar kommentar = new DBErgebnisKommentar(et1, et2, aufgabe, userInput);
		KommentarAusgabeText kommentarAusgabe = kommentar.getKommentar();
		assertEquals(kommentarAusgabe.getKommentarType(), ErgebnisKommentarType.L);
		assertEquals(kommentarAusgabe.getOutput(),ErgebnisKommentarType.L.anzeigeText());
	}
	@Test
	public void testDBErgebnisKommentarTypeC(){
		String userInput = "muster";
		Aufgabe aufgabe = createMockAufgabe(userInput+"change");
		
		ArrayList<String> columnHeads1 = new ArrayList<String>(Arrays.asList("These", "Are" , "Rows"));
		ArrayList<String> columnHeads2 = new ArrayList<String>(Arrays.asList( "Are" , "Rows"));

		ArrayList<String> rows1 = new ArrayList<String>(Arrays.asList("These", "Are" , "Rows"));
		
		DBErgebnisTranskript et1 = createMockDBErgebnisTranscript(columnHeads1, rows1);
		DBErgebnisTranskript et2 = createMockDBErgebnisTranscript(columnHeads2, rows1);

		DBErgebnisKommentar kommentar = new DBErgebnisKommentar(et1, et2, aufgabe, userInput);
		KommentarAusgabeText kommentarAusgabe = kommentar.getKommentar();
		assertEquals(kommentarAusgabe.getKommentarType(), ErgebnisKommentarType.L);
		assertEquals(kommentarAusgabe.getOutput(),ErgebnisKommentarType.L.anzeigeText());
	
	}
	@Test
	public void testDBErgebnisKommentarTypeL(){
		String userInput = "";
		Aufgabe aufgabe = createMockAufgabe(userInput);
		ArrayList<String> columnHeads1 = new ArrayList<String>(Arrays.asList("These", "Are" , "Rows"));
		ArrayList<String> rows1 = new ArrayList<String>(Arrays.asList("These", "Are" , "Rows"));
		
		DBErgebnisTranskript et1 = createMockDBErgebnisTranscript(columnHeads1, rows1);
		DBErgebnisTranskript et2 = createMockDBErgebnisTranscript(columnHeads1, rows1);

		DBErgebnisKommentar kommentar = new DBErgebnisKommentar(et1, et2, aufgabe, userInput);
		KommentarAusgabeText kommentarAusgabe = kommentar.getKommentar();
		assertEquals(kommentarAusgabe.getKommentarType(), ErgebnisKommentarType.L);
		assertEquals(kommentarAusgabe.getOutput(),ErgebnisKommentarType.L.anzeigeText());
	}
	@Test
	public void testDBErgebnisKommentarTypeE(){
		String userInput = "muster";
		Aufgabe aufgabe = createMockAufgabe(userInput+"change");
		ArrayList<String> columnHeads1 = new ArrayList<String>(Arrays.asList("These", "Are" , "Rows"));
		ArrayList<String> rows1 = new ArrayList<String>(Arrays.asList("These", "Are" , "Rows"));
		
		DBErgebnisTranskript et1 = createMockDBErgebnisTranscript(columnHeads1, rows1);
		DBErgebnisTranskript et2 = createMockDBErgebnisTranscript(columnHeads1, rows1);

		DBErgebnisKommentar kommentar = new DBErgebnisKommentar(et1, et2, aufgabe, userInput);
		KommentarAusgabeText kommentarAusgabe = kommentar.getKommentar();
		assertEquals(kommentarAusgabe.getKommentarType(), ErgebnisKommentarType.E);
		assertEquals(kommentarAusgabe.getOutput(),ErgebnisKommentarType.E.anzeigeText());
	}
	@Test
	public void testDBErgebnisKommentarTypeF(){
		String userInput = "muster";
		Aufgabe aufgabe = createMockAufgabe(userInput+"change");
		ArrayList<String> columnHeads1 = new ArrayList<String>(Arrays.asList("These", "Are" , "Rows"));
		ArrayList<String> rows1 = new ArrayList<String>(Arrays.asList("t1", "t2" , "t3"));
		ArrayList<String> rows2 = new ArrayList<String>(Arrays.asList("t1"));

		
		DBErgebnisTranskript nutzerResult = createMockDBErgebnisTranscript(columnHeads1, rows2);
		DBErgebnisTranskript correctResult = createMockDBErgebnisTranscript(columnHeads1, rows1);

		DBErgebnisKommentar kommentar = new DBErgebnisKommentar(nutzerResult, correctResult, aufgabe, userInput);
		KommentarAusgabeText kommentarAusgabe = kommentar.getKommentar();
		assertEquals(kommentarAusgabe.getKommentarType(), ErgebnisKommentarType.F);
		assertEquals(kommentarAusgabe.getOutput(),ErgebnisKommentarType.F.anzeigeText() + " " + (rows1.size()-rows2.size()));
	}
	@Test
	public void testDBErgebnisKommentarTypeZ(){
		String userInput = "muster";
		Aufgabe aufgabe = createMockAufgabe(userInput+"change");
		ArrayList<String> columnHeads1 = new ArrayList<String>(Arrays.asList("These", "Are" , "Rows"));
		ArrayList<String> rows1 = new ArrayList<String>(Arrays.asList("t1", "t2" , "t3"));
		ArrayList<String> rows2 = new ArrayList<String>(Arrays.asList("t1"));

		
		DBErgebnisTranskript nutzerResult = createMockDBErgebnisTranscript(columnHeads1, rows1);
		DBErgebnisTranskript correctResult = createMockDBErgebnisTranscript(columnHeads1, rows2);

		DBErgebnisKommentar kommentar = new DBErgebnisKommentar(nutzerResult, correctResult, aufgabe, userInput);
		KommentarAusgabeText kommentarAusgabe = kommentar.getKommentar();
		assertEquals(kommentarAusgabe.getKommentarType(), ErgebnisKommentarType.Z);
		assertEquals(kommentarAusgabe.getOutput(),ErgebnisKommentarType.Z.anzeigeText() + " " + (rows1.size()-rows2.size()));
	
	}

	
	private DBErgebnisTranskript createMockDBErgebnisTranscript(ArrayList<String> columnHeads, ArrayList<String> rows) {
		DBErgebnisTranskript dbet = EasyMock.createMock(DBErgebnisTranskript.class);
		EasyMock.expect(dbet.getColumnHeads()).andReturn(columnHeads);
		EasyMock.expectLastCall().times(0,2);
		EasyMock.expect(dbet.getTranscribeResult()).andReturn(rows);
		EasyMock.expectLastCall().times(0,4);
		EasyMock.replay(dbet);
		return dbet;
	}
	private Aufgabe createMockAufgabe(String musterloesung) {
		Aufgabe aufgabe = EasyMock.createMock(Aufgabe.class);
		
		EasyMock.expect(aufgabe.getMusterloesung()).andReturn(musterloesung);
		EasyMock.expectLastCall().times(0, 3);
		EasyMock.replay(aufgabe);
		return aufgabe;
	}
}
