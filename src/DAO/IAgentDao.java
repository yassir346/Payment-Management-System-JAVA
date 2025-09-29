package DAO;

import models.Agent;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IAgentDao {
    int save(Agent agent) throws SQLException;
    int delete(Agent agent) throws SQLException;
    List<Agent> getAll() throws SQLException;
    int update(Agent agent) throws SQLException;
    Agent findById(int id) throws SQLException;
    Agent findByEmail(String email) throws SQLException;
    Map<String, Object> findByEmailAndPassword(String email, String password) throws SQLException;
}
