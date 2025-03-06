package com.mycompany.projet_de_poo;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Etudiant_list {
private List<Etudiant> etudiantsList;

public Etudiant_list() {
etudiantsList = new ArrayList<>();
}

public void ajouterEtudiant(Etudiant etudiant) {
etudiantsList.add(etudiant);
}

public boolean supprimerEtudiant(String matricule) {
for (Etudiant etudiant : etudiantsList) {
if (etudiant.getMatricule().equals(matricule)) {
etudiantsList.remove(etudiant);
return true;
}
}
return false;
}

public Etudiant rechercherEtudiant(String matricule) {
for (Etudiant etudiant : etudiantsList) {
if (etudiant.getMatricule().equals(matricule)) {
return etudiant;
}
}
return null;
}

public void afficherTousLesEtudiants() {
for (Etudiant etudiant : etudiantsList) {
System.out.println("Nom: " + etudiant.getNom());
System.out.println("Prenom: " + etudiant.getPrenom());
System.out.println("Age: " + etudiant.getAge());
System.out.println("Sexe: " + etudiant.getSexe());
System.out.println("Major? " + etudiant.getIsMajor());
System.out.println("Matricule: " + etudiant.getMatricule());
System.out.println("Type Etudiant: " + etudiant.getTypeEtudiant());
if (etudiant instanceof Etudiant_ENSK) {
System.out.println("Specialite: " + ((Etudiant_ENSK) etudiant).getSpecialite());
}
System.out.println("-----------------------------");
}
}


public void afficherTousLesEtudiantsAvecMoyenne() {
if (etudiantsList.isEmpty()) {
System.out.println("Aucun étudiant enregistré.");
return;
}

for (Etudiant etudiant : etudiantsList) {
System.out.println("Nom: " + etudiant.getNom());
System.out.println("Prenom: " + etudiant.getPrenom());
System.out.println("Matricule: " + etudiant.getMatricule());

Note note = etudiant.getNote();
Map<String, Double> notesParMatiere = note.getToutesLesNotes();

if (notesParMatiere.isEmpty()) {
System.out.println("Moyenne: Pas encore calculée.");
} else {
double moyenne = note.calculerMoyenne();
System.out.println("Moyenne: " + moyenne);
}

System.out.println("-----------------------------");
}
}
} 
