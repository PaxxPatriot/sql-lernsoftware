package de.dhbw.studienarbeit.sqllernsoftware.backend.ErgebnisBewertung;

import java.util.ArrayList;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;

public class ErgebnisBewertungMuster extends ErgebnisBewertung {

	public ErgebnisBewertungMuster() {
		super(ErgebnisKommentarType.M);	
	}
	
	@Override
	public boolean pruefeKondition(String nutzerEingabe, String musterEingabe, ArrayList<String> excessRows,
			ArrayList<String> missingRows, boolean matchingColumns) {
		if( nutzerEingabe.equalsIgnoreCase(musterEingabe)) {
			return true;
		}
		return false;
	}

}
