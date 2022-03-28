import static org.junit.jupiter.api.Assertions.assertEquals;

import org.easymock.EasyMock;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Aufgabentyp;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabenkollektion;
import org.junit.jupiter.api.Test;

public class AufgabenTests {
	@Test
	public void testErstellungUndWerteRückgabeWerte() {
		// Werte
		String id = "231";
		String titel = "Exampletitel";
		String aufgabentext = "exampletext";
		String musterloesung = "exampleloesung";
		String pruefungsbefehl = "examplepruefungsbefehl";
		Aufgabentyp typ = Aufgabentyp.C;
		int schwierigkeit = 23;
		int reihenfolge = 1;
		Aufgabenkollektion aufgabenkollektionId = EasyMock.createMock(Aufgabenkollektion.class);
		// Konstruktor

		Aufgabe aufgabe = new Aufgabe(id, titel, aufgabentext, musterloesung, pruefungsbefehl, typ, schwierigkeit,
				reihenfolge, aufgabenkollektionId);
		assertEqualsAllAufgabenWerte(aufgabe, id, titel, aufgabentext, musterloesung, pruefungsbefehl, typ,
				schwierigkeit, reihenfolge, aufgabenkollektionId);
	}

	private void assertEqualsAllAufgabenWerte(Aufgabe aufgabe, String id, String titel, String aufgabentext,
			String musterloesung, String pruefungsbefehl, Aufgabentyp typ, int schwierigkeit, int reihenfolge,
			Aufgabenkollektion aufgabenkollektionId) {
		assertEquals(aufgabe.getId(), id);
		assertEquals(aufgabe.getTitel(), titel);
		assertEquals(aufgabe.getAufgabentext(), aufgabentext);
		assertEquals(aufgabe.getMusterloesung(), musterloesung);
		assertEquals(aufgabe.getPruefungsbefehl(), pruefungsbefehl);
		assertEquals(aufgabe.getTyp(), typ);
		assertEquals(aufgabe.getSchwierigkeit(), schwierigkeit);
		assertEquals(aufgabe.getReihenfolge(), reihenfolge);
		assertEquals(aufgabe.getAufgabenkollektion(), aufgabenkollektionId);
		assertEquals(aufgabe.getUITitel(),titel);
		assertEquals(aufgabe.getUIBeschreibung(),aufgabentext);
	}
}
