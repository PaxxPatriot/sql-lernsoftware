package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentar;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;

import java.util.ArrayList;

public class DBErgebnisKommentar {

	private DBErgebnisAusgabe userResult = null;
	private DBErgebnisAusgabe correctResult = null;
	
	private ArrayList<String> excessRows = new ArrayList<String>();
	private ArrayList<String> missingRows = new ArrayList<String>();
	
	private Aufgabe aufgabe = null;
	private String userInput = null;
	private int numberArgument = 0;
	private ErgebnisKommentar comment= null;
	

	
	public DBErgebnisKommentar(DBErgebnisAusgabe userResult, DBErgebnisAusgabe correctResult, Aufgabe aufgabe,
			String userInput) {
		super();
		this.userResult = userResult;
		this.correctResult = correctResult;
		this.aufgabe = aufgabe;
		this.userInput = userInput;
	}

	public AusgabeKommentar getAusgabeKommentar() {
		AusgabeKommentar ausgabe = new AusgabeKommentar(this.getKommentar());
		
		if(numberArgument != 0) {
			ausgabe.addArgument(numberArgument+"");
		}
		return ausgabe;
	}

	public ErgebnisKommentar getKommentar() {
		
		if(aufgabe.getMusterloesung().equalsIgnoreCase(userInput)) {
			return setComment(ErgebnisKommentar.M);
		}
		if(!matchingColumnsNumber()) {
			return setComment(ErgebnisKommentar.C);
		}

		this.calculateExcessRows();
		this.calculateMissingRows();

		if(missingRows.size() == 0 && excessRows.size() == 0) {
			return setComment(ErgebnisKommentar.E);
		}
		if(missingRows.size() > 0) {
			numberArgument = missingRows.size();
			return setComment(ErgebnisKommentar.F);
		}
		if(excessRows.size() > 0) {
			numberArgument = excessRows.size();
			return setComment(ErgebnisKommentar.Z);
		}
		return comment;

	}
	
	private ErgebnisKommentar setComment(ErgebnisKommentar r) {
		comment = r;
		return comment;
	}
	
	
	public boolean matchingColumnsNumber() {
		if (userResult != null) {
			return userResult.getColumnHeads().size() == correctResult.getColumnHeads().size() || (userResult != null);
		}
		return false;
	}	
	
	public int sameRowAmount() {
		if (userResult != null) {
			return userResult.getTranscribeResult().size() - correctResult.getTranscribeResult().size();
		}
		return 0;
	}
	
	private void calculateExcessRows() {
		for(String i: userResult.getTranscribeResult()) {
			if(!(correctResult.getTranscribeResult().contains(i))) {
				excessRows.add(i);
			}
		}
	}
	private void calculateMissingRows() {
		for(String i: correctResult.getTranscribeResult()) {
			if(!(userResult.getTranscribeResult().contains(i))) {
				missingRows.add(i);
			}
		}
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
