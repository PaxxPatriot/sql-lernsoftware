package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OutputResultSet {

	ResultSet result = null;

	ArrayList<String> columnHeads = new ArrayList<String>();
	ArrayList<String> transcribeResult = new ArrayList<String>();

	public OutputResultSet(ResultSet result) {
		super();
		this.result = result;
		
		this.init();
	}
	private void init() {
		this.getColumns();
		this.transcribe();
	}
	
	
	private void getColumns() {
		try {
			for(int i = 1 ; i <= result.getMetaData().getColumnCount();i++) {
				columnHeads.add(result.getMetaData().getColumnLabel(i));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void transcribe() {
		try {
			while(result.next()) {
				String row  = "";
				
				for(String label: columnHeads) {
					row += result.getString(label) + ";";
				}
				transcribeResult.add(row);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<String> getColumnHeads() {
		return columnHeads;
	}
	public ArrayList<String> getTranscribeResult() {
		return transcribeResult;
	}

	
}


