package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import java.util.ArrayList;
import javax.persistence.*;

@Entity
@Table(name = "lektion")
public class Lektion extends ObjectWithId {
	@Column(name = "titel")
	private String titel;
	@Column(name = "bechreibung")
	private String beschreibung;
	@OneToMany(mappedBy = "lektion")
	private ArrayList<LektionsInhalt> inhalte = new ArrayList<LektionsInhalt>();
	
	
	public Lektion(long id, String titel, String beschreibung) {
		super(id);
		this.titel = titel;
		this.beschreibung = beschreibung;
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
