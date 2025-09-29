package controller;

import DAO.IAgentDao;
import models.Agent;
import models.Departement;
import models.TypeAgent;
import service.IAgentService;
import service.IDepartementService;
import service.Ipml.AgentServiceIpml;
import service.Ipml.DepartementServiceIplm;

import java.sql.SQLException;
import java.util.Scanner;

public class ResponsableController {
    private Scanner scanner;
    private IAgentService agentService;
    private IDepartementService departementService;

    public ResponsableController(){
        this.agentService = new AgentServiceIpml();
        this.departementService = new DepartementServiceIplm();
        this.scanner = new Scanner(System.in);
    }

    public void logoDemarrage(){
        System.out.println("+++++++++++++++++++++");
        System.out.println("BIENVUNUE A PAYFLOW");
        System.out.println("+++++++++++++++++++++");
    }

    public void menu(){
        System.out.println("Entrez un choix :");
        System.out.println("(1) Ajouter agent.");
        System.out.println("(1) Modifier agent.");
    }

    public void commander(){
        boolean go = true;

        while(go){
            logoDemarrage();
            menu();
            int choix = scanner.nextInt();

            switch (choix){
                case 1:
                    Agent agent = new Agent();
                    try{
                        ajouterAgent(agent);
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try{
                        modifierAgent();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
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

    public void ajouterAgent(Agent agent) throws SQLException {

        System.out.println("Entrez le nom de l'agent: ");
        String nom = scanner.next();
        System.out.println("Entrez le prenom de l'agent: ");
        String prenom = scanner.next();
        System.out.println("Entrez l'email de l'agent: ");
        String email = scanner.next();
        System.out.println("Entrez le mot de passe de l'agent: ");
        String motDePasse = scanner.next();
        System.out.println("Entrez le nom du Departement de l'agent: ");
        String nomDepartement = scanner.next();

        System.out.println("Choisissez le type de l'agent: ");
        System.out.println("(1) OUVRIER");
        System.out.println("(2) STAGIAIRE");
        int choixType = scanner.nextInt();

        agent.setNom(nom);
        agent.setPrenom(prenom);
        agent.setEmail(email);
        agent.setMotDePasse(motDePasse);
        switch(choixType){
            case 1:
                agent.setTypeAgent(TypeAgent.OUVRIER);
                break;

            case 2:
                agent.setTypeAgent(TypeAgent.STAGIAIRE);
                break;

            default:
                System.out.println("Entrez un nombre correspondant aux choix disponibles");
        }

        Departement departement = null;
        try{
            departement = this.departementService.findByName(nomDepartement);
        }catch(SQLException e){
            e.printStackTrace();
        }
        agent.setDepartement(departement);

        this.agentService.ajouter(agent);
    }

    public void modifierAgent() throws  SQLException{
        System.out.println("Entrez l'email de l'agent que vous voulez modifier: ");
        String email = scanner.next();
        Agent agent = this.agentService.findByEmail(email);

        System.out.println("Entrez le nouveau nom de l'agent: ");
        String nom = scanner.next();
        System.out.println("Entrez le nouveau prenom de l'agent: ");
        String prenom = scanner.next();
        System.out.println("Entrez le nouveau email de l'agent: ");
        String email1 = scanner.next();
        System.out.println("Entrez le nouveau mot de passe de l'agent: ");
        String motDePasse = scanner.next();
        System.out.println("Entrez le nouveau nom du Departement de l'agent: ");
        String nomDepartement = scanner.next();

        System.out.println("Choisissez le type de l'agent: ");
        System.out.println("(1) OUVRIER");
        System.out.println("(2) STAGIAIRE");
        int choixType = scanner.nextInt();

        switch(choixType){
            case 1:
                agent.setTypeAgent(TypeAgent.OUVRIER);
                break;

            case 2:
                agent.setTypeAgent(TypeAgent.STAGIAIRE);
                break;

            default:
                System.out.println("Entrez un nombre correspondant aux choix disponibles");
        }

        agent.setNom(nom);
        agent.setPrenom(prenom);
        agent.setEmail(email1);
        agent.setMotDePasse(motDePasse);

        this.agentService.modifier(agent);
    }





}
