package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

public class Datenbank extends ObjectWithId {

	String name; //name der Datenbank
	String createSql; //sql befehl um die initialdatenbank zu erzeugen
	
	public Datenbank(long id, String name, String createSql) {
		super(id);
		this.name = name;
		this.createSql = createSql;
	}
/*-------------------------------------------------------------------------*/

	public String getName() {
		return name;
	}

	public String getCreateSql() {
		return createSql;
	}
}
