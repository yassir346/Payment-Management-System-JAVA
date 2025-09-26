package models;

import java.util.ArrayList;

public class Agent extends Personne{
    private int idAgent;
    private TypeAgent typeAgent;
    private Departement departement;
    private ArrayList<Paiement> paiements;

    public Agent(String nom, String prenom, String email, String motDePasse, int idAgent, TypeAgent typeAgent, Departement departement, ArrayList<Paiement> paiements) {
        super(nom, prenom, email, motDePasse);
        this.idAgent = idAgent;
        this.typeAgent = typeAgent;
        this.departement = departement;
        this.paiements = paiements;
    }

    public Agent(){}

    public int getIdAgent() {
        return idAgent;
    }

    public void setIdAgent(int idAgent) {
        this.idAgent = idAgent;
    }

    public TypeAgent getTypeAgent() {
        return typeAgent;
    }

    public void setTypeAgent(TypeAgent typeAgent) {
        this.typeAgent = typeAgent;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public ArrayList<Paiement> getPaiements() {
        return paiements;
    }

    public void setPaiements(ArrayList<Paiement> paiements) {
        this.paiements = paiements;
    }

    @Override
    public String toString() {
        return "Agent{" +
                "idAgent=" + idAgent +
                ", typeAgent=" + typeAgent +
                ", departement=" + departement +
                ", paiements=" + paiements +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", motDePasse='" + motDePasse + '\'' +
                '}';
    }
}
