package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.datenbasis.DatenbasisController;

import java.sql.SQLException;

public class EntityUtils {

	public EntityUtils() {

	}

	//Util zum vergleichen der Ergebnisse
	//von aufgaben ergebnisse
	//von WIssensfragen
	//



	private DBErgebnisKommentar getDBKommentar(Aufgabe aufgabe, String userInput) throws SQLException {
		DatenbasisController datenbasisController = new DatenbasisController();
		DBErgebnisTranskript[] dbResult = { null,null};
		if(validInput(userInput)) {
			dbResult = datenbasisController.executeAbfrageUndMusterloesung(aufgabe.getTyp(), aufgabe.getMusterloesung(), userInput, aufgabe.getPruefungsbefehl(), aufgabe.getAufgabenkollektion().getDatenbank());
		}
		return new DBErgebnisKommentar(dbResult[1], dbResult[0], aufgabe, userInput);
	}

	public KommentarAusgabeText getKommentarText(Aufgabe aufgabe, String userInput) {
		KommentarAusgabeText kommentarAusgabeText;
		try {
			kommentarAusgabeText = this.getDBKommentar(aufgabe, userInput).getKommentar();
		} catch (SQLException e) {
			KommentarAusgabeText ausgabeText = new KommentarAusgabeText(ErgebnisKommentarType.ERROR);
			ausgabeText.addArgument(e.getMessage());
			return ausgabeText;
		}
		return kommentarAusgabeText;
	}

	private boolean validInput(String userInput) {
		if(userInput.isBlank()) {
			return false;
		}
		return true;
	}

}
