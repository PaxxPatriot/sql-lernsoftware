package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class commentedResultSet {

	OutputResultSet userResult = null;
	OutputResultSet correctResult = null;
	
	
	public commentedResultSet(ResultSet userResult, ResultSet correctResult) {
		super();
		this.userResult = new OutputResultSet(userResult);
		this.correctResult = new OutputResultSet(correctResult);
		
	}
	public boolean matchingColumns() {
			return false;
	}
	
	public int getExcessEntries() {
		int ret = 0;
		
		
		
		return ret;
	}
	
	
}
