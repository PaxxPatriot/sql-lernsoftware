package de.dhbw.studienarbeit.sqllernsoftware.backend.enums;

public enum Inhaltstyp {
	A("Text"),
	B("Wissensfrage");
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
