package DAO.Impl;

import DAO.IAgentDao;
import config.DB;
import models.Agent;
import models.TypeAgent;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AgentDaoImpl implements IAgentDao{
    static Connection connection;

    static {
        try {
            connection = DB.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Agent agent) throws SQLException {

        String sql = "INSERT INTO agents(nom, prenom, email, password, typeagent, departement_id) VALUES(?,?,?,?,?::typeagent,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, agent.getNom());
        preparedStatement.setString(2, agent.getPrenom());
        preparedStatement.setString(3, agent.getEmail());
        preparedStatement.setString(4, agent.getMotDePasse());
        preparedStatement.setString(5, String.valueOf(agent.getTypeAgent()));
        preparedStatement.setInt(6, agent.getDepartement().getIdDepartement());

        int num = preparedStatement.executeUpdate();

        return num;
    }

    @Override
    public int delete(Agent agent) throws SQLException {
        String sql = "DELETE FROM agents WHERE idagent = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, agent.getIdAgent());
        return preparedStatement.executeUpdate();
    }
//
    @Override
    public List<Agent> getAll() throws SQLException {

        String sql = "SELECT * FROM agents";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Agent> agents = new ArrayList<>();
        while(resultSet.next()){
            Agent agent = new Agent();
            agent.setIdAgent(resultSet.getInt("idagent"));
            agent.setNom(resultSet.getString("nom"));
            agent.setPrenom(resultSet.getString("prenom"));
            agent.setEmail(resultSet.getString("password"));
            agent.setEmail(resultSet.getString("typeagent"));

            agents.add(agent);

        }
        return agents;
    }
//
    @Override
    public int update(Agent agent) throws SQLException {
        String sql = "UPDATE agents SET nom=?, prenom=?, email=?, password = ? WHERE idagent = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, agent.getNom());
        preparedStatement.setString(2, agent.getPrenom());
        preparedStatement.setString(3, agent.getEmail());
        preparedStatement.setString(4, agent.getMotDePasse());
        preparedStatement.setInt(5, agent.getIdAgent());
        return preparedStatement.executeUpdate();
    }
//
    @Override
    public Agent findById(int id) throws SQLException {
        String sql = "SELECT * FROM agents WHERE idagent = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        Agent agent = new Agent();
        Boolean check = false;

        while(resultSet.next()){
            check = true;
            agent.setIdAgent(resultSet.getInt("idagent"));
            agent.setNom(resultSet.getString("nom"));
            agent.setPrenom(resultSet.getString("prenom"));
            agent.setEmail(resultSet.getString("email"));
            agent.setMotDePasse(resultSet.getString("password"));
            agent.setTypeAgent(TypeAgent.valueOf(resultSet.getString("typeagent")));
        }
        if(check){
            return agent;
        }else {
            return null;
        }
    }
//
    @Override
    public Agent findByEmail(String email) throws SQLException {
        String sql = "SELECT * FROM agents WHERE email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);

        ResultSet resultSet = preparedStatement.executeQuery();

        Agent agent = new Agent();

        while (resultSet.next()){
            agent.setIdAgent(resultSet.getInt("idagent"));
            agent.setNom(resultSet.getString("nom"));
            agent.setPrenom(resultSet.getString("prenom"));
            agent.setEmail(resultSet.getString("email"));
            agent.setMotDePasse(resultSet.getString("password"));
            agent.setTypeAgent(TypeAgent.valueOf(resultSet.getString("typeagent")));
        }
        return agent;
    }

    @Override
    public Map<String, Object> findByEmailAndPassword(String email, String password) throws SQLException{
        String sql = "SELECT * FROM agents WHERE email = ? AND password = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, email);
        preparedStatement.setString(2, password);

        ResultSet resultSet = preparedStatement.executeQuery();
        Agent agent = new Agent();
        int departementId = 0;
        while(resultSet.next()){
            agent.setIdAgent(resultSet.getInt("idagent"));
            agent.setNom(resultSet.getString("nom"));
            agent.setPrenom(resultSet.getString("prenom"));
            agent.setEmail(resultSet.getString("email"));
            agent.setMotDePasse(resultSet.getString("password"));
            agent.setTypeAgent(TypeAgent.valueOf(resultSet.getString("typeagent")));
            departementId = resultSet.getInt("departement_id");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("agent", agent);
        map.put("departementId", departementId);

        return map;
    }
}
