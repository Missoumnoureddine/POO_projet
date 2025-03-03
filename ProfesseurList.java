package com.mycompany.projet_de_poo;

import java.util.ArrayList;
import java.util.List;

public class ProfesseurList {
private List<Enseignant> enseignantsList = new ArrayList<>();

public void ajouterEnseignant(Enseignant enseignant) {
enseignantsList.add(enseignant);
}

public boolean supprimerEnseignant(String matricule) {
for (Enseignant enseignant : enseignantsList) {
if (enseignant.getMatricule().equals(matricule)) {
enseignantsList.remove(enseignant);
return true;
}
}
return false;
}

public Enseignant rechercherEnseignant(String matricule) {
for (Enseignant enseignant : enseignantsList) {
if (enseignant.getMatricule().equals(matricule)) {
return enseignant;
}
}
return null;
}

public void afficherTousLesEnseignants() {
if (enseignantsList.isEmpty()) {
System.out.println("Aucun enseignant enregistré.");
return;
}

for (Enseignant enseignant : enseignantsList) {
System.out.println("Nom: " + enseignant.getNom());
System.out.println("Prenom: " + enseignant.getPrenom());
System.out.println("Age: " + enseignant.getAge());
System.out.println("Sexe: " + enseignant.getSexe());
System.out.println("Matricule: " + enseignant.getMatricule());
System.out.println("Matière: " + enseignant.getMatiere());
System.out.println("-----------------------------");
}
}

// New Method: Display teachers with their assigned modules
public void afficherTousLesEnseignantsAvecModules() {
if (enseignantsList.isEmpty()) {
System.out.println("Aucun enseignant enregistré.");
return;
}

for (Enseignant enseignant : enseignantsList) {
System.out.println("Nom: " + enseignant.getNom());
System.out.println("Prenom: " + enseignant.getPrenom());
System.out.println("Matricule: " + enseignant.getMatricule());

List<Module> modules = enseignant.getModules();
if (modules == null || modules.isEmpty()) {
System.out.println("Modules: Aucun module assigné.");
} else {
System.out.println("Modules:");
for (Module module : modules) {
System.out.println("- " + module.getNom() + " (Coefficient: " + module.getCoefficient() + ")");
}
}

System.out.println("-----------------------------");
}
}
}