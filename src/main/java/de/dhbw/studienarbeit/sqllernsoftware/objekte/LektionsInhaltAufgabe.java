package de.dhbw.studienarbeit.sqllernsoftware.objekte;

import de.dhbw.studienarbeit.sqllernsoftware.enums.Inhaltstyp;

public class LektionsInhaltAufgabe extends LektionsInhalt {

	private Aufgabenkollektion aufgabenkollektion;
	
	public LektionsInhaltAufgabe(String id) {
		super(id,Inhaltstyp.B);	
	}

/*----------------------------------------------------------------------*/
	
	public Aufgabenkollektion getAufgabenkollektion() {
		return aufgabenkollektion;
	}
}
