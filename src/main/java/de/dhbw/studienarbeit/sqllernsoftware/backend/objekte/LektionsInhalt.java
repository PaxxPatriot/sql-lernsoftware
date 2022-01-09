package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import javax.persistence.*;
import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Inhaltstyp;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class LektionsInhalt extends ObjectWithId {
	@Column(name = "typ")
	private Inhaltstyp typ;
	@ManyToOne
	@JoinColumn(name = "aufgabenkollektion")
	private Lektion lektion;
	@Column(name = "reihenfolge")
	private int reihenfolge;
	
	public LektionsInhalt(Long id, Inhaltstyp typ, Lektion lektion, int reihenfolge) {
		super(id);
		this.typ = typ;
		this.lektion = lektion;
		this.reihenfolge = reihenfolge;
	}

	public Inhaltstyp getTyp() {
		return typ;
	}

	public Lektion getLektion() {
		return lektion;
	}

	public int getReihenfolge() {
		return reihenfolge;
	}

	
}
