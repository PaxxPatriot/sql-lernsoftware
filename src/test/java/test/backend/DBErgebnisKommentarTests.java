package test.backend;

import java.util.ArrayList;

import org.easymock.EasyMock;

import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.DBErgebnisTranskript;

public class DBErgebnisKommentarTests {

	
	private DBErgebnisTranskript createMockDBErgebnisTranscript(ArrayList<String> columnHeads, ArrayList<String> rows) {
		DBErgebnisTranskript dbet = EasyMock.createMock(DBErgebnisTranskript.class);
		
		
		return dbet;
	}
}
