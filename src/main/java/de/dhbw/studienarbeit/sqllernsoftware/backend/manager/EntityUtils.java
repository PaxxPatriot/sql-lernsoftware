package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentar;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.datenbasis.DatenbasisController;

public class EntityUtils {
	
	public EntityUtils() {

	}
	
	//Util zum vergleichen der Ergebnisse
	//von aufgaben ergebnisse
	//von WIssensfragen
	//

	public ErgebnisKommentar getKommentar(Aufgabe aufgabe, String userInput) {
		ErgebnisKommentar kommentar = this.getDBKommentar(aufgabe, userInput).getKommentar();
		if (kommentar == null) {
			return ErgebnisKommentar.ERROR;
		}
		return kommentar;
	}
	
	private DBErgebnisKommentar getDBKommentar(Aufgabe aufgabe, String userInput) {
		DBErgebnisAusgabe[] dbResult = DatenbasisController.executeAbfrageUndMusterloesung(aufgabe.getTyp(), aufgabe.getMusterloesung(), userInput, aufgabe.getPruefungsbefehl(), aufgabe.getAufgabenkollektion().getDatenbank());
		return new DBErgebnisKommentar(dbResult[1], dbResult[0], aufgabe, userInput);
	}

	public AusgabeKommentar getAusgabeKommentar(Aufgabe aufgabe, String userInput) {
		return this.getDBKommentar(aufgabe, userInput).getAusgabeKommentar();
	}
}
