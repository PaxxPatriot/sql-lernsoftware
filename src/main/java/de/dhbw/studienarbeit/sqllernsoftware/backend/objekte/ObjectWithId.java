package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;
@Embedabble
public abstract class ObjectWithId {

	private long id;
	
	public ObjectWithId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
}
