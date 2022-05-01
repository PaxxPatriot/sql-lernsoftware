package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Inhaltstyp;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class LektionsInhalt extends ObjektMitId {
	@Enumerated(EnumType.STRING)
	@Column(name = "typ")
	private Inhaltstyp typ;
	@ManyToOne
	@JoinColumn(name = "aufgabenkollektion")
	private Lektion lektion;
	@Column(name = "reihenfolge")
	private int reihenfolge;

	protected LektionsInhalt() {
	}

	public LektionsInhalt(String id, Inhaltstyp typ, Lektion lektion, int reihenfolge) {
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
