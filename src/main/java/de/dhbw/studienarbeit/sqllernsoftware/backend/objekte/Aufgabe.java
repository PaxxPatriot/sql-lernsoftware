package de.dhbw.studienarbeit.sqllernsoftware.backend.objekte;


import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.Aufgabentyp;

import javax.persistence.*;

@Entity
@Table(name = "aufgabe")
public class Aufgabe extends ObjektMitId {
	@Column(name = "titel")
	private String titel; // titel der Aufgabe der angezeigt wird
	@Column(name = "aufgabentext")
	private String aufgabentext; // textkoerper der AUfgabe
	@Column(name = "musterloesung")
	private String musterloesung; // sqlbefehl der das gewünschte ergebnis zurück liefert
	@Column(name = "pruefungsbefehl")
	private String pruefungsbefehl; // sql befehl um vorgenommene Aenderungen in der Datenbank zu testen
	@Enumerated(EnumType.STRING)
	@Column(name = "typ")
	private Aufgabentyp typ; // art der aufgabe, auch wichtig für prüfung der antwort
	@Column(name = "schwierigkeit")
	private int schwierigkeit; // einfach ne Zahl von 1-10
	@Column(name = "reihenfolge")
	private int reihenfolge;
	@ManyToOne
	@JoinColumn(name = "aufgabenkollektion_id")
	private Aufgabenkollektion aufgabenkollektionId;

	public Aufgabe(String id, String titel, String aufgabentext, String musterloesung, String pruefungsbefehl,
				   Aufgabentyp typ, int schwierigkeit, int reihenfolge, Aufgabenkollektion aufgabenkollektionId) {
		super(id);
		this.titel = titel;
		this.aufgabentext = aufgabentext;
		this.musterloesung = musterloesung;
		this.pruefungsbefehl = pruefungsbefehl;
		this.typ = typ;
		this.schwierigkeit = schwierigkeit;
		this.reihenfolge = reihenfolge;
		this.aufgabenkollektionId = aufgabenkollektionId;
	}

	public Aufgabe() {
		super(null);
	}

	/*---------------------------------------------------------------------------------------------------*/

	public String getTitel() {
		return titel;
	}

	public String getAufgabentext() {
		return aufgabentext;
	}

	public String getMusterloesung() {
		return musterloesung;
	}

	public String getPruefungsbefehl() {
		return pruefungsbefehl;
	}

	public Aufgabentyp getTyp() {
		return typ;
	}

	public int getSchwierigkeit() {
		return schwierigkeit;
	}

	public int getReihenfolge() {
		return reihenfolge;
	}

	public Aufgabenkollektion getAufgabenkollektion() {
		return aufgabenkollektionId;
	}
	@Override
	public String getUIString() {
		return aufgabentext;
	}
	
}
