package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.StringJoiner;

public class DBErgebnisTranskript {

	ResultSet result = null;

	ArrayList<String> columnHeads = new ArrayList<String>();
	ArrayList<String> transcribeResult = new ArrayList<String>();

	public DBErgebnisTranskript(ResultSet result) {
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
			ResultSetMetaData metaData = result.getMetaData();
			int columnCount =  metaData.getColumnCount();
			
			for(int i = 1 ; i <= columnCount;i++) {
				columnHeads.add(metaData.getColumnLabel(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void transcribe() {
		try {
			while(result.next()) {
				StringJoiner joiner = new StringJoiner(",");
				
				for(String label: columnHeads) {	
					joiner.add(result.getString(label));
				}
				transcribeResult.add(joiner.toString());
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


