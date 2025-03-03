package com.mycompany.projet_de_poo;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class Main {
    private static ProfesseurList professeurList = new ProfesseurList();
    private static Etudiant_list diplome = new Etudiant_list();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Enter Notes");
            System.out.println("4. Display");
            System.out.print("Choice: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choix) {
                case 1:
                    menuStudent(scanner);
                    break;
                case 2:
                    menuTeacher(scanner);
                    break;
                case 3:
                    menuEnterNotes(scanner);
                    break;
                case 4:
                    menuDisplay(scanner);
                    break;
                case 5:
                    System.out.println("Exit...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void menuStudent(Scanner scanner) {
        while (true) {
            System.out.println("Student Menu:");
            System.out.println("1. Insert");
            System.out.println("2. Modify");
            System.out.println("3. Delete");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choix) {
                case 1:
                    ajouterEtudiant(scanner);
                    break;
                case 2:
                    modifierEtudiant(scanner);
                    break;
                case 3:
                    supprimerEtudiant(scanner);
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void menuTeacher(Scanner scanner) {
        while (true) {
            System.out.println("Teacher Menu:");
            System.out.println("1. Insert");
            System.out.println("2. Modify");
            System.out.println("3. Delete");
            System.out.println("4. Assign Module");
            System.out.println("5. Exit");
            System.out.print("Choice: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choix) {
                case 1:
                    ajouterEnseignant(scanner);
                    break;
                case 2:
                    modifierEnseignant(scanner);
                    break;
                case 3:
                    supprimerEnseignant(scanner);
                    break;
                case 4:
                    assignerModule(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void menuEnterNotes(Scanner scanner) {
        System.out.print("Enter teacher matricule: ");
        String matricule = scanner.nextLine();
        Enseignant enseignant = professeurList.rechercherEnseignant(matricule);

        if (enseignant == null || enseignant.getModules() == null || enseignant.getModules().isEmpty()) {
            System.out.println("Teacher not found or has no modules!");
            return;
        }

        System.out.println("Available modules:");
        for (Module module : enseignant.getModules()) {
            System.out.println(module.getNom());
        }

        System.out.print("Choose module: ");
        String moduleChoisi = scanner.nextLine();

        boolean moduleExists = false;
        for (Module module : enseignant.getModules()) {
            if (module.getNom().equalsIgnoreCase(moduleChoisi)) {
                moduleExists = true;
                break;
            }
        }

        if (!moduleExists) {
            System.out.println("Module not found!");
            return;
        }

        System.out.print("Enter student matricule: ");
        String studentMatricule = scanner.nextLine();
        Etudiant etudiant = diplome.rechercherEtudiant(studentMatricule);

        if (etudiant == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("Enter note: ");
        double note = scanner.nextDouble();
        scanner.nextLine(); // Clear buffer

        etudiant.getNote().ajouterNote(moduleChoisi, note);
        System.out.println("Note added successfully!");
    }

    private static void menuDisplay(Scanner scanner) {
        while (true) {
            System.out.println("Display Menu:");
            System.out.println("1. Students");
            System.out.println("2. Teachers");
            System.out.println("3. Modules");
            System.out.println("4. Exit");
            System.out.print("Choice: ");
            int choix = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choix) {
                case 1:
                    diplome.afficherTousLesEtudiantsAvecMoyenne();
                    break;
                case 2:
                    professeurList.afficherTousLesEnseignantsAvecModules();
                    break;
                case 3:
                    afficherModules();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void ajouterEtudiant(Scanner scanner) {
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prenom: ");
        String prenom = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Sexe (H/F): ");
        String sexe = scanner.nextLine();
        System.out.print("Matricule: ");
        String matricule = scanner.nextLine();
        System.out.print("Moyenne Bac: ");
        double bac = scanner.nextDouble();
        scanner.nextLine();

        Etudiant etudiant;
        if (bac > 14) {
            etudiant = new Etudiant_ENSK(nom, prenom, age, sexe, matricule, bac);
        } else {
            etudiant = new Etudiant(nom, prenom, age, sexe, matricule, bac);
        }
        diplome.ajouterEtudiant(etudiant);
        System.out.println("Etudiant ajouté avec succès!");
    }

    private static void modifierEtudiant(Scanner scanner) {
        System.out.print("Matricule de l'étudiant à modifier: ");
        String matricule = scanner.nextLine();
        Etudiant etudiant = diplome.rechercherEtudiant(matricule);

        if (etudiant != null) {
            System.out.print("Nouveau Nom: ");
            String nom = scanner.nextLine();
            System.out.print("Nouveau Prenom: ");
            String prenom = scanner.nextLine();
            System.out.print("Nouvel Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nouveau Sexe (H/F): ");
            String sexe = scanner.nextLine();
            System.out.print("Nouvelle Moyenne Bac: ");
            double bac = scanner.nextDouble();
            scanner.nextLine();

            diplome.supprimerEtudiant(matricule);
            Etudiant nouveauEtudiant;
            if (bac > 14) {
                nouveauEtudiant = new Etudiant_ENSK(nom, prenom, age, sexe, matricule, bac);
            } else {
                nouveauEtudiant = new Etudiant(nom, prenom, age, sexe, matricule, bac);
            }
            diplome.ajouterEtudiant(nouveauEtudiant);
            System.out.println("Modification réussie !");
        } else {
            System.out.println("Matricule incorrect!");
        }
    }

    private static void supprimerEtudiant(Scanner scanner) {
        System.out.print("Matricule de l'étudiant à supprimer: ");
        String matricule = scanner.nextLine();
        if (diplome.supprimerEtudiant(matricule)) {
            System.out.println("Suppression réussie!");
        } else {
            System.out.println("Matricule incorrect!");
        }
    }

    private static void ajouterEnseignant(Scanner scanner) {
        System.out.print("Nom: ");
        String nom = scanner.nextLine();
        System.out.print("Prenom: ");
        String prenom = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Sexe (H/F): ");
        String sexe = scanner.nextLine();
        System.out.print("Matricule: ");
        String matricule = scanner.nextLine();
        System.out.print("Matière enseignée: ");
        String matiere = scanner.nextLine();

        Enseignant enseignant = new Enseignant(nom, prenom, age, sexe, matricule, matiere);
        professeurList.ajouterEnseignant(enseignant);
        System.out.println("Enseignant ajouté avec succès!");
    }

    private static void modifierEnseignant(Scanner scanner) {
        System.out.print("Matricule de l'enseignant à modifier: ");
        String matricule = scanner.nextLine();
        Enseignant enseignant = professeurList.rechercherEnseignant(matricule);

        if (enseignant != null) {
            System.out.print("Nouveau Nom: ");
            String nom = scanner.nextLine();
            System.out.print("Nouveau Prenom: ");
            String prenom = scanner.nextLine();
            System.out.print("Nouvel Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nouveau Sexe (H/F): ");
            String sexe = scanner.nextLine();
            System.out.print("Nouvelle Matière enseignée: ");
            String matiere = scanner.nextLine();

            professeurList.supprimerEnseignant(matricule);
            Enseignant nouvelEnseignant = new Enseignant(nom, prenom, age, sexe, matricule, matiere);
            professeurList.ajouterEnseignant(nouvelEnseignant);
            System.out.println("Modification réussie !");
        } else {
            System.out.println("Matricule incorrect!");
        }
    }

    private static void supprimerEnseignant(Scanner scanner) {
        System.out.print("Matricule de l'enseignant à supprimer: ");
        String matricule = scanner.nextLine();
        if (professeurList.supprimerEnseignant(matricule)) {
            System.out.println("Suppression réussie!");
        } else {
            System.out.println("Matricule incorrect!");
        }
    }

    private static void assignerModule(Scanner scanner) {
        System.out.print("Enter teacher matricule: ");
        String matricule = scanner.nextLine();
        Enseignant enseignant = professeurList.rechercherEnseignant(matricule);

        if (enseignant == null) {
            System.out.println("Teacher not found!");
            return;
        }

        List<Module> modules = new ArrayList<>();
        while (true) {
            System.out.print("Enter module name (SE, SI, SM, Algo, Analyse, THL): ");
            String nom = scanner.nextLine();
            double coefficient = getModuleCoefficient(nom);
            if (coefficient == -1) {
                System.out.println("Invalid module name!");
                continue;
            }

            modules.add(new Module(nom, coefficient));
            System.out.print("Add another module? (Y/N): ");
            String response = scanner.nextLine();
            if (!response.equalsIgnoreCase("Y")) {
                break;
            }
        }

        enseignant.setModules(modules);
        System.out.println("Modules assigned successfully!");
    }

    private static double getModuleCoefficient(String nom) {
        switch (nom.toUpperCase()) {
            case "SE":
                return 4.0;
            case "SI":
                return 2.0;
            case "SM":
                return 4.0;
            case "ALGO":
                return 5.0;
            case "ANALYSE":
                return 3.0;
            case "THL":
                return 3.0;
            default:
                return -1.0;
        }
    }

    private static void afficherModules() {
        System.out.println("Modules and Coefficients:");
        System.out.println("SE: 4");
        System.out.println("SI: 2");
        System.out.println("SM: 4");
        System.out.println("Algo: 5");
        System.out.println("Analyse: 3");
        System.out.println("THL: 3");
    }
}