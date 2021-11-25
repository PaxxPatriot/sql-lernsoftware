package de.dhbw.studienarbeit.sqllernsoftware.objekte;

public abstract class ObjectWithId {

	private String id;
	
	public ObjectWithId(String id) {
		this.id = id;
	}
	public String getId() {
		return id;
	}
}
