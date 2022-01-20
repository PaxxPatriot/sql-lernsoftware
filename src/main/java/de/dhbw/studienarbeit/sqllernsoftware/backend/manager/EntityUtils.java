package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ResultComment;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.datenbasis.DatenbasisController;

import java.sql.ResultSet;

public class EntityUtils {

	DatenbasisController dbCntrl = null;
	
	public EntityUtils(DatenbasisController dbCntrl) {
		this.dbCntrl = dbCntrl;
	}
	
	//Util zum vergleichen der Ergebnisse
	//von aufgaben ergebnisse
	//von WIssensfragen
	//
	public ResultComment getComment(Aufgabe a, String userInput) {
		ResultSet[] dbResult = DatenbasisController.executeAbfrageUndMusterloesung(a.getMusterloesung(), userInput);
		CommentedResultSet cRS = new CommentedResultSet(new OutputResultSet(dbResult[1]), new OutputResultSet(dbResult[0]), a, userInput);
		return cRS.getComment();		
	}
	
}
