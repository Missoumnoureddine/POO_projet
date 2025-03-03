package com.mycompany.projet_de_poo;

public class Module {
private String nom;
private double coefficient;

public Module(String nom, double coefficient) {
this.nom = nom;
this.coefficient = coefficient;
}

public String getNom() {
return nom;
}

public double getCoefficient() {
return coefficient;
}
}