package controller;

import DAO.IAgentDao;
import models.*;
import service.IAgentService;
import service.IDepartementService;
import service.IPaiementService;
import service.Ipml.AgentServiceIpml;
import service.Ipml.DepartementServiceIplm;
import service.Ipml.PaiementServiceImpl;

import java.sql.SQLException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResponsableController {
    private Scanner scanner;
    private IAgentService agentService;
    private IDepartementService departementService;
    private IPaiementService paiementService;

    public ResponsableController(){
        this.agentService = new AgentServiceIpml();
        this.departementService = new DepartementServiceIplm();
        this.paiementService = new PaiementServiceImpl();
        this.scanner = new Scanner(System.in);
    }

    public void logoDemarrage(){
        System.out.println("+++++++++++++++++++++");
        System.out.println("BIENVUNUE A PAYFLOW (responsable)");
        System.out.println("+++++++++++++++++++++");
    }

    public void menu(){
        System.out.println("Entrez un choix :");
        System.out.println("(1) Affecter Paiement à un agent.");
        System.out.println("(2) Afficher les paiements d'un agent.");
        System.out.println("(3) Afficher tous les paiements.");
        System.out.println("(4) Ajouter agent.");
        System.out.println("(5) Modifier agent.");
        System.out.println("(6) Supprimer agent.");
    }

    public void commander(){
        boolean go = true;

        while(go){
            logoDemarrage();
            menu();
            int choix = scanner.nextInt();

            switch (choix){
                case 1:
                    try{
                        affecterPaiement();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    try {
                        paiementsDunAgent();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 3:
                    try {
                        afficherTousPaiements();
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case 4:
                    try{
                        modifierAgent();
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;

                case 5:
                    Agent agent = new Agent();
                    try{
                        ajouterAgent(agent);
                    }catch(SQLException e){
                        e.printStackTrace();
                    }
                    break;

                case 6:
                    supprimerAgent();
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

    public void supprimerAgent(){
        System.out.println("Entrez l'email de l'agent à supprimer: ");
        String email = scanner.next();
        Agent agent = agentService.findByEmail(email);
        this.agentService.supprimer(agent);
        System.out.println("Agent est supprimé.");
    }

    public void affecterPaiement() throws SQLException {
        Paiement paiement = new Paiement();

        System.out.println("Entrez l'email de l'agent ");
        String email = scanner.next();
        Agent agent = agentService.findByEmail(email);

        if(agent != null){
            System.out.println("Agent trouvé. Entrez le paiement que vous voulez affectez à lui.");
        }else{
            System.out.println("agent n'est pas trouvé. Veuillez entrer un agent valide");
        }

        int choixTypeAgent;

            System.out.println("Entrez le type de Paiement. ");
            System.out.println("(1). SALAIRE. ");
            System.out.println("(2). PRIME.");
            System.out.println("(3). BONUS.");
            System.out.println("(4). INDEMNITE.");

            choixTypeAgent = scanner.nextInt();
            switch(choixTypeAgent){
                case 1:
                    paiement.setTypePaiement(TypePaiement.SALAIRE);
                    break;
                case 2:
                    paiement.setTypePaiement(TypePaiement.PRIME);
                    break;
                case 3:
                    paiement.setTypePaiement(TypePaiement.BONUS);
                    break;
                case 4:
                    paiement.setTypePaiement(TypePaiement.INDEMNITE);
                    break;
                default:
                    System.out.println("Entrez un nombre qui correspond à la liste des types des paiements");
                    break;
            }

        System.out.println("Entrez le montant de paiement");
        double montant = scanner.nextDouble();
        paiement.setMontant(montant);
        paiement.setDate(LocalDate.now());
        paiement.setConditionValid(true);
        paiement.setAgentId(agent.getIdAgent());

        paiementService.creerPaiement(paiement, agent);

        System.out.println("paiement créé");
    }

    public void paiementsDunAgent() throws SQLException {
        System.out.println("Entrez l'email de l'agent ");
        String email = scanner.next();
        Agent agent = agentService.findByEmail(email);

        List<Paiement> paiements;
        paiements = paiementService.getByAgentId(agent);


        for(Paiement p : paiements){
            System.out.println(p);
        }
    }

    public void afficherTousPaiements() throws SQLException {
        List<Paiement> paiements;
        paiements = paiementService.paiements();
        for(Paiement p : paiements){
            System.out.println(p);
        }
    }
}
