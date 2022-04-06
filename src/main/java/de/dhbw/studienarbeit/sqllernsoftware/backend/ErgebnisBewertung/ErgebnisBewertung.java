package de.dhbw.studienarbeit.sqllernsoftware.backend.ErgebnisBewertung;

import java.util.ArrayList;
import java.util.Optional;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;

public abstract class ErgebnisBewertung {

	private Optional<Integer> numberArg = Optional.empty(); 
	
	private ErgebnisKommentarType kommentar = null;
	
	public ErgebnisBewertung(ErgebnisKommentarType kommentar){
		this.kommentar = kommentar;	
	}
	
	public boolean pruefeKondition(String nutzerEingabe, String musterEingabe, ArrayList<String> excessRows,
			ArrayList<String> missingRows, boolean matchingColumns) {
				return true;
	}
	
	public ErgebnisKommentarType getKommentar() {
		return kommentar;
	}
	public Optional<Integer> getNumberArg(){
		return numberArg;
	}
	protected void setNumberArg(int arg) {
		 numberArg = Optional.of(arg);
	}
}
