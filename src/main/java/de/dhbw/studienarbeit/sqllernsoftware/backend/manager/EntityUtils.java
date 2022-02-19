package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentar;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.datenbasis.DatenbasisController;

import java.sql.ResultSet;

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
		System.out.println(aufgabe.getTyp());
		switch (aufgabe.getTyp()) {
			case S -> {
				ResultSet[] dbResult = DatenbasisController.executeAbfrageUndMusterloesung(aufgabe.getMusterloesung(), userInput, aufgabe.getAufgabenkollektion().getDatenbank());
				return new DBErgebnisKommentar(new DBErgebnisAusgabe(dbResult[1]), new DBErgebnisAusgabe(dbResult[0]), aufgabe, userInput);
			}
			case D -> {
				int[] deleted = DatenbasisController.executeAbfrageUndMusterloesungOnCopyOfDatenbasis(aufgabe.getMusterloesung(), userInput);
				return new DBErgebnisKommentar(new DBErgebnisAusgabe(deleted[1]), new DBErgebnisAusgabe(deleted[0]), aufgabe, userInput);
			}
		}
		return null;
	}
	
	public AusgabeKommentar getAusgabeKommentar(Aufgabe aufgabe, String userInput) {
		return this.getDBKommentar(aufgabe, userInput).getAusgabeKommentar();
	}
}
