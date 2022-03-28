package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;

import java.util.ArrayList;

public class DBErgebnisKommentar {

	private DBErgebnisTranskript userResult = null;
	private DBErgebnisTranskript correctResult = null;
	
	private ArrayList<String> excessRows = new ArrayList<String>();
	private ArrayList<String> missingRows = new ArrayList<String>();
	
	private Aufgabe aufgabe = null;
	private String userInput = null;
	private int numberArgument = 0;
	private ErgebnisKommentarType comment= null;
	

	
	public DBErgebnisKommentar(DBErgebnisTranskript userResult, DBErgebnisTranskript correctResult, Aufgabe aufgabe,
			String userInput) {
		super();
		this.userResult = userResult;
		this.correctResult = correctResult;
		this.aufgabe = aufgabe;
		this.userInput = userInput;
	}

	public KommentarAusgabeText getAusgabeKommentar() {
		KommentarAusgabeText ausgabe = new KommentarAusgabeText(this.getKommentar());
		
		if(numberArgument != 0) {
			ausgabe.addArgument(numberArgument+"");
		}
		return ausgabe;
	}

	public ErgebnisKommentarType getKommentar() {
		
		if(aufgabe.getMusterloesung().equalsIgnoreCase(userInput)) {
			return setComment(ErgebnisKommentarType.M);
		}
		if(!matchingColumnsNumber()) {
			return setComment(ErgebnisKommentarType.C);
		}

		this.calculateExcessRows();
		this.calculateMissingRows();

		if(missingRows.size() == 0 && excessRows.size() == 0) {
			return setComment(ErgebnisKommentarType.E);
		}
		if(missingRows.size() > 0) {
			numberArgument = missingRows.size();
			return setComment(ErgebnisKommentarType.F);
		}
		if(excessRows.size() > 0) {
			numberArgument = excessRows.size();
			return setComment(ErgebnisKommentarType.Z);
		}
		return comment;

	}
	
	private ErgebnisKommentarType setComment(ErgebnisKommentarType r) {
		comment = r;
		return comment;
	}
	
	
	public boolean matchingColumnsNumber() {
		return userResult.getColumnHeads().size() == correctResult.getColumnHeads().size();
	}	
	
	public int sameRowAmount() {
		return userResult.getTranscribeResult().size() - correctResult.getTranscribeResult().size();
	}
	
	private void calculateExcessRows() {
		excessRows.clear();
		
		ArrayList<String>userResultRows = userResult.getTranscribeResult();
		ArrayList<String>correctResultRows = correctResult.getTranscribeResult();

		for(String i: userResultRows) {
			if(!(correctResultRows.contains(i))) {
				excessRows.add(i);
			}
		}
	}
	private void calculateMissingRows() {
		missingRows.clear();
		
		ArrayList<String>userResultRows = userResult.getTranscribeResult();
		ArrayList<String>correctResultRows = correctResult.getTranscribeResult();
		for(String i: correctResultRows) {
			if(!(userResultRows.contains(i))) {
				missingRows.add(i);
			}
		}
	}
	public int getNumberArgument() {
		return numberArgument;
	}
	public int getExcessRowsCount() {
		return excessRows.size();
	}
	public int getMissingRowsCount() {
		return missingRows.size();
	}
	public ArrayList<String> getMissingRows() {
		return missingRows;
	}
	public ArrayList<String> getExcessRows() {
		return excessRows;
	}

	
}
