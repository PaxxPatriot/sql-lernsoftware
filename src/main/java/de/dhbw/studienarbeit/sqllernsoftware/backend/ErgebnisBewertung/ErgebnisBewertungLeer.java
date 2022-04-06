package de.dhbw.studienarbeit.sqllernsoftware.backend.ErgebnisBewertung;

import java.util.ArrayList;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;

public class ErgebnisBewertungLeer extends ErgebnisBewertung {

	public ErgebnisBewertungLeer() {
		super(ErgebnisKommentarType.L);
		
	}
	@Override
	public boolean pruefeKondition(String nutzerEingabe, String musterEingabe, ArrayList<String> excessRows,
			ArrayList<String> missingRows, boolean matchingColumns) {
		if( nutzerEingabe.isBlank()) {
			return true;
		}
		return false;
	}
	
}
