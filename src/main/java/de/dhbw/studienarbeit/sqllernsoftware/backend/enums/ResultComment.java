package de.dhbw.studienarbeit.sqllernsoftware.backend.enums;

public enum ResultComment {
	M("Musterloesung"),
	E("Ergebniss Gleich");
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
