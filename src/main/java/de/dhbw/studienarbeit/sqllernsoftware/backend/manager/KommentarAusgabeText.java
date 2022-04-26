package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import java.util.ArrayList;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;

public class KommentarAusgabeText {

	private ErgebnisKommentarType kommentar = null;
	private ArrayList<String> args = new ArrayList<String>();
	
	public KommentarAusgabeText(ErgebnisKommentarType kommentar) {
		super();
		this.kommentar = kommentar;
	}
	
	public void addArgument(String argument) {
		args.add(argument);
	}
	public String getOutput() {
		String ausgabe = kommentar.anzeigeText();
		for(String txt: args) {
			ausgabe+= " " + txt;
		}
		return ausgabe;
	}

	public ErgebnisKommentarType getKommentarType() {
		return kommentar;
	}
	
	
	
}
