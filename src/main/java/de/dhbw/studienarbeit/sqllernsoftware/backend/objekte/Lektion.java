package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import java.util.ArrayList;

public class Lektion extends ObjectWithId {

	private String titel;
	private String beschreibung;
	
	private ArrayList<LektionsInhalt> inhalte = new ArrayList<LektionsInhalt>();
	
	
	public Lektion(String id, String titel, String beschreibung) {
		super(id);
		this.titel = titel;
		this.beschreibung = beschreibung;
	}
/*-------------------------------------------------------------------------*/
	public LektionsInhalt getInhalt(int key) {
		return inhalte.get(key);
	}
	
	public void addInhalt(LektionsInhalt i, int key) {
		if(key > inhalte.size()+1) {
			inhalte.add(i);
		}
		else {
			inhalte.add(key, i);
		}		
	}
	public void deleteInhalt(int key) {
		inhalte.remove(key);
	}
/*-------------------------------------------------------------------------*/
	
	public String getTitel() {
		return titel;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	
}
