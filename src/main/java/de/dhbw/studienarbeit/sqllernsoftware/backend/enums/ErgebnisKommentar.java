package de.dhbw.studienarbeit.sqllernsoftware.backend.enums;

public enum ErgebnisKommentar {
	M("Musterlösung!!!"),
	E("Ergebnis ist gleich."),
	Z("Im Erbgebnis befinden sich überschüssige Einträge:"),
	F("Im Ergebnis fehlen Einträge:"),
	C("Die Anzahl der selektierten Spalten stimmt nicht überein.");
//usw
	private String anzeigeText;
		
	ErgebnisKommentar(String anzeigeText)
	{
		this.anzeigeText = anzeigeText;
	}
	
	public String anzeigeText() {
		return anzeigeText;
	}
}
