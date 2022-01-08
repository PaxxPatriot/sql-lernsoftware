package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Inhaltstyp;

public class LektionsInhaltText extends LektionsInhalt {
	String text;
	
	public LektionsInhaltText(String id) {
		super(id,Inhaltstyp.B);	
	}


/*---------------------------------------------------------*/
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}		
}
