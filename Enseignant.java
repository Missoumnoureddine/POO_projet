package com.mycompany.projet_de_poo;

import java.util.List;
import java.util.ArrayList;

public class Enseignant extends Personne {
private String matricule;
private String matiere;
private List<Module> modules; 

public Enseignant(String nom, String prenom, int age, String sexe, String matricule, String matiere) {
super(nom, prenom, age, sexe);
this.matricule = matricule;
this.matiere = matiere;
this.modules = new ArrayList<>();
}

public String getMatricule() {
return matricule;
}

public String getMatiere() {
return matiere;
}

public List<Module> getModules() {
return modules;
}

public void setModules(List<Module> modules) {
this.modules = modules;
}

public void addModule(Module module) {
this.modules.add(module);
}
}
