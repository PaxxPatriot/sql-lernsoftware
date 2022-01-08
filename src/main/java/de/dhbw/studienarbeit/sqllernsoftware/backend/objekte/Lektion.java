package main.java.de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "lektion")
public class Lektion extends ObjectWithId {
	@Column(name = "titel")
	private String titel;
	@Column(name = "beschreibung")
	private String beschreibung;
	@OneToMany(mappedBy = "lektion")
	private List<LektionsInhalt> inhalte;
	
	
	public Lektion(long id, String titel, String beschreibung) {
		super(id);
		this.titel = titel;
		this.beschreibung = beschreibung;
	}

	public Lektion() {
		super(null);
	}
/*-------------------------------------------------------------------------*/
	public LektionsInhalt getInhalt(int key) {
		return inhalte.get(key);
	}
/*-------------------------------------------------------------------------*/
	
	public String getTitel() {
		return titel;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	
}
