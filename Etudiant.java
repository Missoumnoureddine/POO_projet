package com.mycompany.projet_de_poo;

public class Etudiant extends Personne {
private String matricule;
private double bac;
private String typeEtudiant;
private Note note; // إضافة حقل للنقاط

public Etudiant(String nom, String prenom, int age, String sexe, String matricule, double bac) {
super(nom, prenom, age, sexe);
this.matricule = matricule;
this.bac = bac;
if (bac > 14) {
typeEtudiant = "ENS";
} else {
typeEtudiant = "Normal";
}
this.note = new Note(); // تهيئة حقل النقاط
}

public String getMatricule() {
return matricule;
}

public double getBac() {
return bac;
}

public String getTypeEtudiant() {
return typeEtudiant;
}

public Note getNote() {
return note;
}
}