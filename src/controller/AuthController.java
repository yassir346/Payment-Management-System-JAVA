package controller;

import DAO.IAgentDao;
import models.Agent;
import models.Departement;
import service.IAgentService;
import service.IAuthService;
import service.IDepartementService;
import service.Ipml.AgentServiceIpml;
import service.Ipml.AuthServiceImpl;
import service.Ipml.DepartementServiceIplm;

import java.sql.SQLException;
import java.util.Scanner;

public class AuthController {
    private IAuthService authService;
    private IAgentService agentService;
    private IDepartementService departementService;
    private AgentController agentController;
    private ResponsableController responsableController;
    private DirecteurController directeurController;
    private Scanner scanner;

    public AuthController(){
        this.scanner = new Scanner(System.in);
        this.authService = new AuthServiceImpl();
        this.departementService = new DepartementServiceIplm();
        this.agentService = new AgentServiceIpml();
        this.responsableController = new ResponsableController();
    }

    public Agent entreeAgent() throws SQLException {
        System.out.println("=====SE CONNECTER=====");

        System.out.print("Entrez votre email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Entrez votre mot de passe: ");
        String password = scanner.nextLine().trim();

        Agent agent = authService.login(email, password);

        return agent;
    }

    public Agent seConnecter() throws SQLException{
//        Agent directeur = this.agentService.findByEmail("directeur@dir.ma");
//        Departement departement = this.departementService.findByName("CEO");

//        if(departement == null && directeur == null){
//            donneeInitiales();
//        }

        Agent agent = entreeAgent();

        if(agent != null){
            return agent;
        }else{
            System.out.println("Utilisateur introuvable.");
        }
        while (true) {
            System.out.print("Pour recommencez appuyez (1). pour quitter appuyez (0): ");
            String choix = scanner.nextLine().trim();

            if (choix.equals("1")) {
                agent = entreeAgent();
                if (agent != null) {
                    return agent;
                }
                System.out.println("Utilisateur introuvable.");
            } else if (choix.equals("0")) {
                return null;
            } else {
                System.out.println("Pour recommencez appuyez (1). pour quitter appuyez (0): ");
            }
        }
    }
}
