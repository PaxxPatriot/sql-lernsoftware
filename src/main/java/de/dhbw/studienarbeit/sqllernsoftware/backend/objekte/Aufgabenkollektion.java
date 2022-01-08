package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import java.util.ArrayList;


public class Aufgabenkollektion extends ObjectWithId{

	private String titel;	//name der Kollektion
	private String beschreibung;	//beschreibung der Kollektion
	private Datenbank datenbank; //verwendete Datenbank 

	private ArrayList<Aufgabe> aufgabenliste = new ArrayList<Aufgabe>(); //key = reihenfolge

	public Aufgabenkollektion(String id, String titel, String beschreibung, Datenbank datenbank) {
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
		if(key > aufgabenliste.size()+1) {
			aufgabenliste.add(a);
		}
		else {
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

	public Datenbank getDatenbank() {
		return datenbank;
	}
	
}
