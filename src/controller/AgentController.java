package controller;

import models.Agent;
import models.Paiement;
import service.Ipml.AgentServiceIpml;
import service.Ipml.PaiementServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class AgentController {
    Scanner scanner;
    AgentServiceIpml agentService;
    PaiementServiceImpl paiementService;

    public AgentController(){
        this.scanner = new Scanner(System.in);
        this.agentService = new AgentServiceIpml();
        this.paiementService = new PaiementServiceImpl();
    }

    public void logoDemarrage(){
        System.out.println("+++++++++++++++++++++");
        System.out.println("BIENVUNUE A PAYFLOW (agent)");
        System.out.println("+++++++++++++++++++++");
    }

    public void menu(){
        System.out.println("Entrez un choix :");
        System.out.println("(1) Afficher mes informations.");
        System.out.println("(2) Ma liste de paiements.");
        System.out.println("(3) Calculer paiement.");
        System.out.println("(0) Sortir");
    }

    public void commander(Agent loggedAgent){
        boolean go = true;

        while(go){
            logoDemarrage();
            menu();
            int choix = scanner.nextInt();

            switch (choix){
                case 1:
                    afficherInformations(loggedAgent);
                    break;

                case 2:
                    listePaiements(loggedAgent);
                    break;

                case 3:
                    break;

                case 4:
                    break;

                default:
                    System.out.println("Choix invalid, Entrez un choix depuis le panneau.");
            }
        }
    }

    public void afficherInformations(Agent loggedAgent){
        System.out.println("++++Mes Informations++++");
        System.out.println("Nom Complet: " + loggedAgent.getNom() + " " + loggedAgent.getPrenom());
        System.out.println("Email: " + loggedAgent.getEmail());
        System.out.println("Mot de passe: " + loggedAgent.getMotDePasse());
        System.out.println("type Agent: " + loggedAgent.getTypeAgent());
        System.out.println("Departement: " + loggedAgent.getDepartement().getNom() + "\n");
        System.out.println("=======================================================");
    }

    public void listePaiements(Agent loggedAgent){
        try {
            this.paiementService.getByAgentId(loggedAgent);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
