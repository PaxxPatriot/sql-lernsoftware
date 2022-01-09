package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import javax.persistence.*;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Inhaltstyp;

@Entity
@Table(name = "wissenfrage")
public class LektionsInhaltAufgabe extends LektionsInhalt {
	
	@Column(name = "frage")
	private String frage;
	@Column(name = "antwort")
	private String antwort;
	
	public LektionsInhaltAufgabe(Long id, Lektion lektion, int reihenfolge, String frage,
			String antwort) {
		super(id, Inhaltstyp.B, lektion, reihenfolge);
		this.frage = frage;
		this.antwort = antwort;
	}

	public String getFrage() {
		return frage;
	}

	public String getAntwort() {
		return antwort;
	}


/*----------------------------------------------------------------------*/
	
	
}
