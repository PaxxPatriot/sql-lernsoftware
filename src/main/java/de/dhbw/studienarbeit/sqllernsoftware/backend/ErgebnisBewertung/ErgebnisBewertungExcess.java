package de.dhbw.studienarbeit.sqllernsoftware.backend.ErgebnisBewertung;

import java.util.ArrayList;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;

public class ErgebnisBewertungExcess extends ErgebnisBewertung {

	public ErgebnisBewertungExcess() {
		super(ErgebnisKommentarType.Z);	
	}
	
	@Override
	public boolean pruefeKondition(String nutzerEingabe, String musterEingabe, ArrayList<String> excessRows,
			ArrayList<String> missingRows, boolean matchingColumns) {
		if(excessRows.size() > 0) {
			this.setNumberArg(excessRows.size());
			return true;
		}
		return false;
	}

}
