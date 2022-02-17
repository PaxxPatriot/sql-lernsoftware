package de.dhbw.studienarbeit.sqllernsoftware.backend.enums;

public enum Aufgabentyp {
	C("CREATE-Befehl"),
	U("UPDATE-Befehl"),
	S("SELECT-Befehl"),
	D("DELETE-Befehl");
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
