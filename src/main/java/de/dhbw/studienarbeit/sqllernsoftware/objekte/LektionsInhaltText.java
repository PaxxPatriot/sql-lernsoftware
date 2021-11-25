package de.dhbw.studienarbeit.sqllernsoftware.objekte;

import de.dhbw.studienarbeit.sqllernsoftware.enums.Inhaltstyp;

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
