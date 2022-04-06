package de.dhbw.studienarbeit.sqllernsoftware.backend.ErgebnisBewertung;

import java.util.ArrayList;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;
import de.dhbw.studienarbeit.sqllernsoftware.backend.manager.KommentarAusgabeText;

public class ErgebnisBewerter {

	ArrayList<ErgebnisBewertung> list = new ArrayList<ErgebnisBewertung>();
	
	private String nutzerEingabe = "";
	private String musterEingabe = "";
	private ArrayList<String> excessRows = null;
	private ArrayList<String> missingRows = null;
	private boolean matchingColumns = false;
	
	public ErgebnisBewerter(String nutzerEingabe, String musterEingabe, ArrayList<String> excessRows,
			ArrayList<String> missingRows, boolean matchingColumns) {
		super();
		this.nutzerEingabe = nutzerEingabe;
		this.musterEingabe = musterEingabe;
		this.excessRows = excessRows;
		this.missingRows = missingRows;
		this.matchingColumns = matchingColumns;
	}
	
	public void addBewertung(ErgebnisBewertung eb) {
		list.add(eb);
	}
	public KommentarAusgabeText bewerte() {
		ErgebnisBewertung ergebnisBewertung = new ErgebnisBewertungError();
		
		for(ErgebnisBewertung eb: list) {
			ergebnisBewertung = eb;
		
			if(eb.pruefeKondition(nutzerEingabe, musterEingabe, excessRows, missingRows, matchingColumns)) {
				break;
			}
		}
		
		KommentarAusgabeText ausgabe = new KommentarAusgabeText(ergebnisBewertung.getKommentar());
		
		if(ergebnisBewertung.getNumberArg().isPresent()) {
			ausgabe.addArgument(ergebnisBewertung.getNumberArg().get()+"");
		}
		return ausgabe;
		
	}
	

	
	
	
}
