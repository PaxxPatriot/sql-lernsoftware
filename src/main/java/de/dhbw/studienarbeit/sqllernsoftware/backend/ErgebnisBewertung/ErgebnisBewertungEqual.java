package de.dhbw.studienarbeit.sqllernsoftware.backend.ErgebnisBewertung;

import java.util.ArrayList;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;

public class ErgebnisBewertungEqual extends ErgebnisBewertung {

	public ErgebnisBewertungEqual() {
		super(ErgebnisKommentarType.E);	
	}
	
	@Override
	public boolean pruefeKondition(String nutzerEingabe, String musterEingabe, ArrayList<String> excessRows,
			ArrayList<String> missingRows, boolean matchingColumns) {
		if(missingRows.size() == 0 && excessRows.size() == 0) {
			return true;
		}
		return false;
	}

}
