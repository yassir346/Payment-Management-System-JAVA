package models;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Paiement {
    private int idPaiement;
    private TypePaiement typePaiement;
    private double montant;
    private LocalDate date;
    private String motif;
    private boolean conditionValid;
    private Agent agent;
    private int agentId;


    public Paiement(int idPaiement, TypePaiement typePaiement, double montant, LocalDate date, String motif, boolean conditionValid, Agent agent) {
        this.idPaiement = idPaiement;
        this.typePaiement = typePaiement;
        this.montant = montant;
        this.date = date;
        this.motif = motif;
        this.agent = agent;
        this.conditionValid = conditionValid;
    }

    public Paiement(){    }

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public boolean isConditionValid() {
        return conditionValid;
    }

    public void setConditionValid(boolean conditionValid) {
        this.conditionValid = conditionValid;
    }

    public Agent getAgent() {
        return agent;
    }


    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
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
