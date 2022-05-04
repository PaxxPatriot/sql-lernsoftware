package de.dhbw.studienarbeit.sqllernsoftware.frontend.controller;

import de.dhbw.studienarbeit.sqllernsoftware.backend.objekte.Aufgabe;

import javax.persistence.Basic;
import java.util.HashMap;
import java.util.Map;

public class BasicResultController {

    BasicDetailpageController basicDetailpageController;
    HashMap<Aufgabe, HashMap> results;

    public void build() {
        for (Map.Entry<Aufgabe, HashMap> entry : results.entrySet()) {
            System.out.println(entry);
        }
    }

    public void setBasicDetailpageController(BasicDetailpageController basicDetailpageController) {
        this.basicDetailpageController = basicDetailpageController;
    }

    public void setResults(HashMap<Aufgabe, HashMap> results) {
        this.results = results;
    }
}
