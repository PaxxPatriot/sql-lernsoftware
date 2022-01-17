package de.dhbw.studienarbeit.sqllernsoftware.backend.enums;

public enum ResultComment {
	M("Musterloesung"),
	E("Ergebniss Gleich"),
	Z("Im Erbgebniss befinden sich überschüssige Einträge:"),
	F("Im Ergebniss fehlen Einträge"),
	C("Die Anzahl der Selektierten Spalten stimmen nicht überein");
//usw
	private String anzeigeText;
		
	ResultComment(String anzeigeText)
	{
		this.anzeigeText = anzeigeText;
	}
	
	public String anzeigeText() {
		return anzeigeText;
	}
}
