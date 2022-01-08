package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Aufgabentyp;

public class Aufgabe extends ObjectWithId{

	private String titel; //titel der Aufgabe der angezeigt wird
	private String aufgabentext; //textkoerper der AUfgabe
	private String musterloesung; //sqlbefehl der das gewünschte ergebnis zurück liefert
	private String pruefungsbefehl; //sql befehl um vorgenommene Aenderungen in der Datenbank zu testen
	private Aufgabentyp typ; // art der aufgabe, auch wichtig für prüfung der antwort
	private int Schwierigkeit; //einfahc ne Zahl von 1-10


	public Aufgabe(String id, String titel, String aufgabentext, String musterloesung, String pruefungsbefehl,
			Aufgabentyp typ, int schwierigkeit) {
		super(id);
		this.titel = titel;
		this.aufgabentext = aufgabentext;
		this.musterloesung = musterloesung;
		this.pruefungsbefehl = pruefungsbefehl;
		this.typ = typ;
		Schwierigkeit = schwierigkeit;
	}
	
/*---------------------------------------------------------------------------------------------------*/
	
	public String getTitel() {
		return titel;
	}
	public String getAufgabentext() {
		return aufgabentext;
	}
	public String getMusterloesung() {
		return musterloesung;
	}
	public String getPruefungsbefehl() {
		return pruefungsbefehl;
	}
	public Aufgabentyp getTyp() {
		return typ;
	}
	public int getSchwierigkeit() {
		return Schwierigkeit;
	}	
}
