package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ObjektMitId {

	@Id
	private String id;
	
	public ObjektMitId(String id) {
		this.id = id;
	}

	public ObjektMitId() {

	}

	public String getId() {
		return id;
	}
	public String getUITitel() {
		return "null";
	}
	public String getUIBeschreibung() {
		return "null, du null";
	}
}
