package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.StringJoiner;

import org.easymock.EasyMock;
import org.junit.jupiter.api.Test;

import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.DBErgebnisTranskript;

public class DBTranscriptTests {
	@Test
	void testDBErgebnisTranskriptCreation() throws SQLException {
		String[][] values1 = { {"Some","again","wow"}, {"Example","trouble",""},{ "Writing","",""} };
		String[] columnHeads = { "1","2","3" };
		ResultSet mockResultSet = createMockResultSet(values1,columnHeads);

		DBErgebnisTranskript dbet = new DBErgebnisTranskript(mockResultSet);

		// check the column heads
		assertColumnHeadForDBTranscript(dbet, columnHeads);

		// check Values
		assertValuesForDBTranscript(dbet, values1,columnHeads);
	}
	public ResultSet createMockResultSet(String[][] values,String[] columnHeads) throws SQLException {
		ResultSet mockResultSet = EasyMock.createMock(ResultSet.class); // 1
		ResultSetMetaData mockResultSetMetaData = EasyMock.createMock(ResultSetMetaData.class);
		EasyMock.expect(mockResultSet.getMetaData()).andReturn(mockResultSetMetaData);
		EasyMock.expect(mockResultSetMetaData.getColumnCount()).andReturn(columnHeads.length);
		for(int i = 0; i < columnHeads.length;i++) {
			EasyMock.expect(mockResultSetMetaData.getColumnLabel(i+1)).andReturn(columnHeads[i]);
		}

		for (int i = 0; i < values.length; i++) {
			EasyMock.expect(mockResultSet.next()).andReturn(true);
			for(int j = 0; j < columnHeads.length; j++) {
				EasyMock.expect(mockResultSet.getString(columnHeads[j])).andReturn(values[i][j]);
			}	
		}
		EasyMock.expect(mockResultSet.next()).andReturn(false);

		EasyMock.replay(mockResultSet);

		EasyMock.replay(mockResultSetMetaData);
		return mockResultSet;
	}

	public void assertColumnHeadForDBTranscript(DBErgebnisTranskript dbet, String[] columnHeads) {
		assertEquals(dbet.getColumnHeads().size(), columnHeads.length);

		for (int i = 0; i < columnHeads.length; i++) {
			assertEquals(dbet.getColumnHeads().get(i), columnHeads[i]);
		}
	}

	public void assertValuesForDBTranscript(DBErgebnisTranskript dbet, String[][] values,String[] columnHeads) {
		assertEquals(dbet.getTranscribeResult().size(), values.length);

		for (int i = 0; i < values.length; i++) {
			StringJoiner joiner = new StringJoiner(",");
			for(int j = 0; j < columnHeads.length; j++) {
				joiner.add(values[i][j]);
			}
			assertEquals(dbet.getTranscribeResult().get(i), joiner.toString());
		}
	}
	
}
