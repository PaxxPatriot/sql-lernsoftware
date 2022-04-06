package de.dhbw.studienarbeit.sqllernsoftware.backend.ErgebnisBewertung;

import java.util.ArrayList;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;

public class ErgebnisBewertungColumns extends ErgebnisBewertung {

	public ErgebnisBewertungColumns() {
		super(ErgebnisKommentarType.C);
		
	}
	@Override
	public boolean pruefeKondition(String nutzerEingabe, String musterEingabe, ArrayList<String> excessRows,
			ArrayList<String> missingRows, boolean matchingColumns) {
		if( matchingColumns) {
			return false;
		}
		return true;
	}
	
}
