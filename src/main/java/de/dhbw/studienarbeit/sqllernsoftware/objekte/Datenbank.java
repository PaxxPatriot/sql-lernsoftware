package de.dhbw.studienarbeit.sqllernsoftware.objekte;

public class Datenbank extends ObjectWithId {

	String name; //name der Datenbank
	String createSql; //sql befehl um die initialdatenbank zu erzeugen
	
	public Datenbank(String id, String name, String createSql) {
		super(id);
		this.name = name;
		this.createSql = createSql;
	}
	
	
}
