package models;

import java.util.ArrayList;

public class Departement {
    private int idDepartement;
    private String nom;
    private Agent responsable;
    private ArrayList<Agent> agents;

    public Departement(int idDepartement, String nom, Agent responsable, ArrayList<Agent> agents) {
        this.idDepartement = idDepartement;
        this.nom = nom;
        this.responsable = responsable;
        this.agents = agents;
    }

    public int getIdDepartement() {
        return idDepartement;
    }

    public void setIdDepartement(int idDepartement) {
        this.idDepartement = idDepartement;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Agent getResponsable() {
        return responsable;
    }

    public void setResponsable(Agent responsable) {
        this.responsable = responsable;
    }

    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public void setAgents(ArrayList<Agent> agents) {
        this.agents = agents;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "idDepartement=" + idDepartement +
                ", nom='" + nom + '\'' +
                ", responsable=" + responsable +
                ", agents=" + agents +
                '}';
    }
}
