package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentar;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.datenbasis.DatenbasisController;

import java.sql.ResultSet;

public class EntityUtils {
	
	DatenbasisController dbCntrl = new DatenbasisController();
	
	public EntityUtils() {

	}
	
	//Util zum vergleichen der Ergebnisse
	//von aufgaben ergebnisse
	//von WIssensfragen
	//

	public ErgebnisKommentar getKommentar(Aufgabe aufgabe, String userInput) {
		return this.getDBKommentar(aufgabe, userInput).getKommentar();
	}
	
	private DBErgebnisKommentar getDBKommentar(Aufgabe aufgabe, String userInput) {
		ResultSet[] dbResult = dbCntrl.executeAbfrageUndMusterloesung(aufgabe.getMusterloesung(), userInput,aufgabe.getAufgabenkollektion().getDatenbank());
		DBErgebnisKommentar dbErgebnisKommentar = new DBErgebnisKommentar(new DBErgebnisAusgabe(dbResult[1]), new DBErgebnisAusgabe(dbResult[0]), aufgabe, userInput);
		return dbErgebnisKommentar;
	}
	
	public AusgabeKommentar getAusgabeKommentar(Aufgabe aufgabe, String userInput) {
		return this.getDBKommentar(aufgabe, userInput).getAusgabeKommentar();
	}
}
