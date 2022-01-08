package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Inhaltstyp;

public abstract class LektionsInhalt extends ObjectWithId {

	private Inhaltstyp typ;
	
	public LektionsInhalt(long id, Inhaltstyp typ) {
		super(id);
		this.typ = typ;
	}

}
