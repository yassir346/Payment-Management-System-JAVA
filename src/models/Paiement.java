package models;

import java.time.LocalDateTime;

public class Paiement {
    private int idPaiement;
    private TypePaiement typePaiement;
    private double montant;
    private LocalDateTime date;
    private String motif;
    private Agent agent;

    public Paiement(int idPaiement, TypePaiement typePaiement, double montant, LocalDateTime date, String motif, Agent agent) {
        this.idPaiement = idPaiement;
        this.typePaiement = typePaiement;
        this.montant = montant;
        this.date = date;
        this.motif = motif;
        this.agent = agent;
    }

    public int getIdPaiement() {
        return idPaiement;
    }

    public void setIdPaiement(int idPaiement) {
        this.idPaiement = idPaiement;
    }

    public TypePaiement getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(TypePaiement typePaiement) {
        this.typePaiement = typePaiement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "idPaiement=" + idPaiement +
                ", typePaiement=" + typePaiement +
                ", montant=" + montant +
                ", date=" + date +
                ", motif='" + motif + '\'' +
                ", agent=" + agent +
                '}';
    }
}
