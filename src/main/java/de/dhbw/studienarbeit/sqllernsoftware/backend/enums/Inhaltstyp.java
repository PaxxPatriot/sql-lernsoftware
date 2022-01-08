package de.dhbw.studienarbeit.sqllernsoftware.backend.enums;

public enum Inhaltstyp {
	A("TEXT"),
	B("AUFGABE");
//usw
	private String anzeigeName;
		
	Inhaltstyp(String anzeigeName)
	{
		this.anzeigeName = anzeigeName;
	}
	
	public String getAnzeigeName() {
		return anzeigeName;
	}
}
