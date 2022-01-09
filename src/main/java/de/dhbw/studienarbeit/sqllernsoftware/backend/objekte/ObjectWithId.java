package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;
 
import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class ObjectWithId {

	@Id
	private Long id;
	
	public ObjectWithId(Long id) {
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	public String getUIString() {
		return "null";
	}
}
