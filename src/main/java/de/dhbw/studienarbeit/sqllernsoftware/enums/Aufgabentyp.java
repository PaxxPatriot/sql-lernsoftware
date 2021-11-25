package de.dhbw.studienarbeit.sqllernsoftware.enums;

public enum Aufgabentyp {
	A("SELECT-Befehl"),
	B("DELETE-Befel");
//usw
	private String anzeigeName;
		
	Aufgabentyp(String anzeigeName)
	{
		this.anzeigeName = anzeigeName;
	}
	
	public String getAnzeigeName() {
		return anzeigeName;
	}
}
