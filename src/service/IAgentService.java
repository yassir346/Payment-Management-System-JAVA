package service;

import models.Agent;

import java.sql.SQLException;

public interface IAgentService {
    void ajouter(Agent agent);
    void supprimer(Agent agent);
    void modifier(Agent agent);
    Agent findById(int id) throws SQLException;
    Agent findByEmail(String email);
    void calculerPaiementAgent(Agent agent);

}
