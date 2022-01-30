package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ObjektMitId {

	@Id
	private Long id;
	
	public ObjektMitId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public String getUIString() {
		return "null";
	}
}
