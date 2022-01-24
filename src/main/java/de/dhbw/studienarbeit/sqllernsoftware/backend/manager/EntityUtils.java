package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ResultComment;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.datenbasis.DatenbasisController;

import java.sql.ResultSet;

public class EntityUtils {
	
	public EntityUtils() {

		this.dbCntrl = new DatenbasisController();
	}
	
	//Util zum vergleichen der Ergebnisse
	//von aufgaben ergebnisse
	//von WIssensfragen
	//

	public ResultComment getComment(Aufgabe aufgabe, String userInput) {
		ResultSet[] dbResult = dbCntrl.executeAbfrageUndMusterloesung(aufgabe.getMusterloesung(), userInput);
		CommentedResultSet cRS = new CommentedResultSet(new OutputResultSet(dbResult[1]), new OutputResultSet(dbResult[0]), aufgabe, userInput);

		return cRS.getComment();		
	}
	
}
