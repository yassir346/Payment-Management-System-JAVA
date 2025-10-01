package controller;

import models.Agent;
import models.Departement;
import models.TypeAgent;
import service.IAgentService;
import service.IDepartementService;
import service.Ipml.AgentServiceIpml;
import service.Ipml.DepartementServiceIplm;

import java.sql.SQLException;
import java.util.Scanner;

public class DirecteurController {
    private Scanner scanner;
    private IDepartementService departementService;
    private IAgentService agentService;

    public DirecteurController(){
        this.scanner = new Scanner(System.in);
        this.departementService = new DepartementServiceIplm();
        this.agentService = new AgentServiceIpml();
    }

    public void logoDemarrage(){
        System.out.println("BIENVUNUE A PAYFLOW (directeur)");
    }

    public void menu(){
        System.out.println("Entrez un choix :");
        System.out.println("(1) Ajouter responsable.");
        System.out.println("(2) Ajouter departement.");
        System.out.println("(3) Liste des paiements.");
        System.out.println("(4) Calculer paiements");
        System.out.println("(0) Sortir");
    }


    public void demarrer(){
        logoDemarrage();
        menu();
    }

    public void commander(){
        boolean go = true;

        while(go){
            demarrer();
            int choix = scanner.nextInt();

            switch(choix){
                case 1:
                    Agent agent = new Agent();
                    try{
                        ajouterResponsable(agent);
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    Departement departement = new Departement();
                    try {
                        creerDepartement(departement);
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    break;

                case 0:
                    System.out.println("System Out");
                    break;

                default:
                    System.out.println("Choix invalid, Entrez un choix depuis le panneau.");
            }

        }
    }

    public void ajouterResponsable(Agent responsable) throws SQLException{
        System.out.println("Entrez le nom du responsable: ");
        String nom = scanner.next();
        System.out.println("Entrez le prenom du responsable: ");
        String prenom = scanner.next();
        System.out.println("Entrez l'email du responsable: ");
        String email = scanner.next();
        System.out.println("Entrez le mot de passe du responsable: ");
        String motDePasse = scanner.next();
        System.out.println("Entrez le nom du Departement du responsable: ");
        String nomDepartement = scanner.next();

        responsable.setNom(nom);
        responsable.setPrenom(prenom);
        responsable.setEmail(email);
        responsable.setMotDePasse(motDePasse);
        responsable.setTypeAgent(TypeAgent.RESPONSABLE_DEPARTEMENT);

        Departement departement = null;
        try{
            departement = this.departementService.findByName(nomDepartement);
        }catch(SQLException e){
            e.printStackTrace();
        }
        responsable.setDepartement(departement);

        this.agentService.ajouter(responsable);
    }

    public void creerDepartement(Departement departement) throws SQLException {
        System.out.println("Entrez le nom du departement: ");
        String nomDepartement = scanner.next();
        departement.setNom(nomDepartement);

        Departement departement1 = this.departementService.save(departement);

        if(departement1 != null){
            System.out.println("Departement ajouté.");
        }else{
            System.out.println("Departement n'est pas ajouté.");
        }
    }


}
