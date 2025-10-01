package service;

import models.Agent;
import models.Paiement;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public interface IPaiementService {
    Paiement creerPaiement(Paiement paiement, Agent agent) throws SQLException;
    Paiement modifierPaiement(Paiement paiement) throws SQLException;
    void supprimerPaiement(int id) throws SQLException;
    Paiement getById(int id) throws SQLException;
    List<Paiement> getByAgentId(Agent agent) throws SQLException;
    List<Paiement> paiements() throws SQLException;
    List<Paiement> paiementsParType(String type) throws SQLException;
    List<Paiement> paiementsParMontant(Double montant) throws SQLException;
    List<Paiement> paiementsParDate(Date date) throws SQLException;
}
