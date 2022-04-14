package de.dhbw.studienarbeit.sqllernsoftware.backend.manager;

import de.dhbw.studienarbeit.sqllernsoftware.backend.ErgebnisBewertung.*;
import de.dhbw.studienarbeit.sqllernsoftware.backend.enums.ErgebnisKommentarType;
import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;

import java.util.ArrayList;

public class DBErgebnisKommentar {

    private DBErgebnisTranskript userResult = null;
    private DBErgebnisTranskript correctResult = null;

    private ArrayList<String> excessRows = new ArrayList<String>();
    private ArrayList<String> missingRows = new ArrayList<String>();

    private Aufgabe aufgabe = null;
    private String userInput = null;
    private int numberArgument = 0;
    private ErgebnisKommentarType comment = null;


    public DBErgebnisKommentar(DBErgebnisTranskript userResult, DBErgebnisTranskript correctResult, Aufgabe aufgabe,
                               String userInput) {
        super();
        this.userResult = userResult;
        this.correctResult = correctResult;
        this.aufgabe = aufgabe;
        this.userInput = userInput;
    }

    public KommentarAusgabeText getKommentar() {
        boolean matchingColumns = false;
        if (userResult != null || correctResult != null) {
            this.calculateExcessRows();
            this.calculateMissingRows();
            matchingColumns = matchingColumnsNumber();
        }

        ErgebnisBewerter ergebnisBewertung = new ErgebnisBewerter(userInput, aufgabe.getMusterloesung(), excessRows, missingRows, matchingColumns);
        //Conditions
        ergebnisBewertung.addBewertung(new ErgebnisBewertungLeer());
        ergebnisBewertung.addBewertung(new ErgebnisBewertungMuster());
        ergebnisBewertung.addBewertung(new ErgebnisBewertungColumns());
        ergebnisBewertung.addBewertung(new ErgebnisBewertungEqual());
        ergebnisBewertung.addBewertung(new ErgebnisBewertungMissing());
        ergebnisBewertung.addBewertung(new ErgebnisBewertungExcess());

        KommentarAusgabeText kommentarAusgabeText = ergebnisBewertung.bewerte();
        this.setComment(kommentarAusgabeText.getKommentarType());
        return kommentarAusgabeText;


    }

    private void setComment(ErgebnisKommentarType r) {
        comment = r;
    }


    public ErgebnisKommentarType getKommentarType() {
        return comment;
    }

    public boolean matchingColumnsNumber() {
        return userResult.getColumnHeads().size() == correctResult.getColumnHeads().size();
    }


    private void calculateExcessRows() {
        excessRows.clear();

        ArrayList<String> userResultRows = userResult.getTranscribeResult();
        ArrayList<String> correctResultRows = correctResult.getTranscribeResult();

        for (String i : userResultRows) {
            if (!(correctResultRows.contains(i))) {
                excessRows.add(i);
            }
        }
    }

    private void calculateMissingRows() {
        missingRows.clear();

        ArrayList<String> userResultRows = userResult.getTranscribeResult();
        ArrayList<String> correctResultRows = correctResult.getTranscribeResult();
        for (String i : correctResultRows) {
            if (!(userResultRows.contains(i))) {
                missingRows.add(i);
            }
        }
    }

    public int getNumberArgument() {
        return numberArgument;
    }

    public int getExcessRowsCount() {
        return excessRows.size();
    }

    public int getMissingRowsCount() {
        return missingRows.size();
    }

    public ArrayList<String> getMissingRows() {
        return missingRows;
    }

    public ArrayList<String> getExcessRows() {
        return excessRows;
    }


}
