package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;

import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Inhaltstyp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name = "lektionstext")
public class LektionsInhaltText extends LektionsInhalt {
	
	@Column(name = "ueberschrift")
	private String ueberschrift;
	@Column(name = "text")
	private String text;
	

public LektionsInhaltText(Long id, Lektion lektion, int reihenfolge, String ueberschrift,
			String text) {
		super(id, Inhaltstyp.A, lektion, reihenfolge);
		this.ueberschrift = ueberschrift;
		this.text = text;
	}
/*---------------------------------------------------------*/
	public String getText() {
		return text;
	}
	public String getUeberschrift() {
		return ueberschrift;
	}

}
