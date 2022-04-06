package de.dhbw.studienarbeit.sqllernsoftware.backend.ErgebnisBewertung;

import java.util.ArrayList;
import java.util.Optional;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;

public class ErgebnisBewertungMissing extends ErgebnisBewertung {
	
	public ErgebnisBewertungMissing() {
		super(ErgebnisKommentarType.F);	
	}
	
	@Override
	public boolean pruefeKondition(String nutzerEingabe, String musterEingabe, ArrayList<String> excessRows,
			ArrayList<String> missingRows, boolean matchingColumns) {
		if(missingRows.size() > 0) {
			this.setNumberArg(missingRows.size());
			return true;
		}
		return false;
	}
}
