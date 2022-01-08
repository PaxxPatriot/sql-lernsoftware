package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;

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
	private List<Aufgabe> aufgabenliste; // key = reihenfolge

	public Aufgabenkollektion(long id, String titel, String beschreibung, String datenbank) {
		super(id);
		this.titel = titel;
		this.beschreibung = beschreibung;
		this.datenbank = datenbank;
	}

	public Aufgabenkollektion(Long id) {
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
