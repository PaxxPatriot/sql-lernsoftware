package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "aufgabenkollektion")
public class Aufgabenkollektion extends ObjectWithId {
	@Column(name = "titel")
	private String titel; // name der Kollektion
	@Column(name = "beschreibung")
	private String beschreibung; // beschreibung der Kollektion
	@Column(name = "datenbank")
	private String datenbank; // verwendete Datenbank
	@OneToMany(mappedBy = "aufgabenkollektion")
	private ArrayList<Aufgabe> aufgabenliste = new ArrayList<Aufgabe>(); // key = reihenfolge

	public Aufgabenkollektion(long id, String titel, String beschreibung, String datenbank) {
		super(id);
		this.titel = titel;
		this.beschreibung = beschreibung;
		this.datenbank = datenbank;
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

	public ArrayList<Aufgabe> getAufgabenliste() {
		return aufgabenliste;
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

}
