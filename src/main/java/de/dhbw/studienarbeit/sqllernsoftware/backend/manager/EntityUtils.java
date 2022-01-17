package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ClassType;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;
import de.dhbw.studienarbeit.sqllernsoftware.persistence.DatenbasisController;

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
		ResultSet[] dbResult = dbCntrl.executeAbfrageUndMusterloesung(a.getMusterloesung(), userInput);
		CommentedResultSet cRS = new CommentedResultSet(new OutputResultSet(dbResult[1]), new OutputResultSet(dbResult[0]), a, userInput);
		return cRS.getComment();		
	}
	
}
