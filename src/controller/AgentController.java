package controller;

import models.Agent;
import service.Ipml.AgentServiceIpml;

import java.util.Scanner;

public class AgentController {
    Scanner scanner;
    AgentServiceIpml agentService;

    public AgentController(){
        this.scanner = new Scanner(System.in);
        this.agentService = new AgentServiceIpml();
    }

    public void logoDemarrage(){
        System.out.println("+++++++++++++++++++++");
        System.out.println("BIENVUNUE A PAYFLOW (agent)");
        System.out.println("+++++++++++++++++++++");
    }

    public void menu(){
        System.out.println("Entrez un choix :");
        System.out.println("(1) Ma liste de paiements.");
        System.out.println("(2) Calculer paiement.");
        System.out.println("(0) Sortir");
    }

    public void commander(){
        boolean go = true;

        while(go){
            logoDemarrage();
            menu();
            int choix = scanner.nextInt();

            switch (choix){
                case 1:

                    break;

                case 2:
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

    public void ajouterAgent(Agent loggedAgent){

    }


}
