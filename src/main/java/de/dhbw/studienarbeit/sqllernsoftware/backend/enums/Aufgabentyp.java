package main.java.de.dhbw.studienarbeit.sqllernsoftware.backend.enums;

public enum Aufgabentyp {
	A("SELECT-Befehl"),
	B("DELETE-Befehl");
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
