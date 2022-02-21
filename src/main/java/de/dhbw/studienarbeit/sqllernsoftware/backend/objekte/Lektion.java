package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Inhaltstyp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "lektion")
public class Lektion extends ObjektMitId {
	@Column(name = "titel")
	private String titel;
	@Column(name = "beschreibung")
	private String beschreibung;
	@OneToMany(mappedBy = "lektion")
	private List<LektionsInhalt> inhalte;
	
	
	public Lektion(String id, String titel, String beschreibung) {
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
	public List<LektionsInhalt> getInhalte(){
		return inhalte;	
	}
	public List<LektionsInhalt> getInhaltePerType(Inhaltstyp i){
		List<LektionsInhalt> tmp = null;
		for(LektionsInhalt inhalt: inhalte) {
			if(inhalt.getTyp() == i) {
				tmp.add(inhalt);
			}		
		}
		return tmp;	
	}
	
}
