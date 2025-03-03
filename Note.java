package com.mycompany.projet_de_poo;

import java.util.HashMap;
import java.util.Map;

public class Note {
    private Map<String, Double> notesParMatiere = new HashMap<>();

    public void ajouterNote(String matiere, double note) {
        notesParMatiere.put(matiere, note);
    }

    public double getNote(String matiere) {
        return notesParMatiere.getOrDefault(matiere, -1.0); // -1.0 يعني أن المادة غير موجودة
    }

    public double calculerMoyenne() {
        if (notesParMatiere.isEmpty()) {
            return 0;
        }
        double somme = 0;
        for (double note : notesParMatiere.values()) {
            somme += note;
        }
        return somme / notesParMatiere.size();
    }

    public Map<String, Double> getToutesLesNotes() {
        return notesParMatiere;
    }
}