package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Inhaltstyp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "wissenfrage")
public class LektionsInhaltAufgabe extends LektionsInhalt {
	
	@Column(name = "frage")
	private String frage;
	@Column(name = "antwort")
	private String antwort;

	public LektionsInhaltAufgabe() {
	}

	public LektionsInhaltAufgabe(String id, Lektion lektion, int reihenfolge, String frage,
								 String antwort) {
		super(id, Inhaltstyp.B, lektion, reihenfolge);
		this.frage = frage;
		this.antwort = antwort;
	}

	@Override
	public String getUITitel() {
		return this.frage;
	}

	public String getFrage() {
		return frage;
	}

	public String getAntwort() {
		return antwort;
	}


/*----------------------------------------------------------------------*/
	
	
}
