package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Aufgabentyp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "aufgabenkollektion")
public class Aufgabenkollektion extends ObjektMitId {
	@Column(name = "titel")
	private String titel; // name der Kollektion
	@Column(name = "beschreibung")
	private String beschreibung; // beschreibung der Kollektion
	@Column(name = "datenbank")
	private String datenbank; // verwendete Datenbank
	@OneToMany(mappedBy = "aufgabenkollektionId")
	private List<Aufgabe> aufgabenliste; // key = reihenfolge

	public Aufgabenkollektion(String id, String titel, String beschreibung, String datenbank) {
		super(id);
		this.titel = titel;
		this.beschreibung = beschreibung;
		this.datenbank = datenbank;
	}

	public Aufgabenkollektion(String id) {
		super(id);
	}

	public Aufgabenkollektion() {
		super(null);
	}

	/*--------------------------------------------------------------------------------------------------*/

	public Aufgabe getAufgabe(int key) {
		return aufgabenliste.get(key);
	}

	public void addAufgabe(Aufgabe a, int key) {
		if (key > aufgabenliste.size() + 1) {
			aufgabenliste.add(a);
		} else {
			aufgabenliste.add(key, a);
		}
	}

	public void deleteAufgabe(int key) {
		aufgabenliste.remove(key);
	}
	/*--------------------------------------------------------------------------------------------------*/

	public List<Aufgabe> getAufgabenliste() {
		return aufgabenliste;
	}
	public List<Aufgabe> getAufgabenPerType(Aufgabentyp a){
		List<Aufgabe> tmp = null;
		for(Aufgabe aufgabe: aufgabenliste) {
			if(aufgabe.getTyp() == a) {
				tmp.add(aufgabe);
			}		
		}
		return tmp;	
	}
	public String getTitel() {
		return titel;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public String getDatenbank() {
		return datenbank;
	}
	@Override
	public String getUITitel() {
		return titel;
	}
	@Override
	public String getUIBeschreibung() {
		return beschreibung;
	}
}
