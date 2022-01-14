package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ResultComment;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;

public class commentedResultSet {

	private OutputResultSet userResult = null;
	private OutputResultSet correctResult = null;
	
	private ArrayList<String> missingRows = new ArrayList<String>();
	private ArrayList<String> excessRows = new ArrayList<String>();
	
	private Aufgabe aufgabe = null;
	private String userInput = null;
	
	private ResultComment comment= null;
	

	
	public commentedResultSet(OutputResultSet userResult, OutputResultSet correctResult, Aufgabe aufgabe,
			String userInput) {
		super();
		this.userResult = userResult;
		this.correctResult = correctResult;
		this.aufgabe = aufgabe;
		this.userInput = userInput;
	}



	public ResultComment getComment() {
		
		if(aufgabe.getMusterloesung().equalsIgnoreCase(userInput)) {
			return setComment(ResultComment.M);
		}
		
		return comment;

	}
	
	private ResultComment setComment(ResultComment r) {
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
		for(String i: correctResult.getTranscribeResult()) {
			if(!(userResult.getTranscribeResult().contains(i))) {
				excessRows.add(i);
			}
		}
	}
	private void missingExcessRows() {
		for(String i: userResult.getTranscribeResult()) {
			if(!(correctResult.getTranscribeResult().contains(i))) {
				excessRows.add(i);
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
