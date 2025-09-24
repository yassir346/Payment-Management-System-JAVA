package DAO.Impl;

import DAO.IAgentDao;
import models.Agent;

import java.sql.SQLException;
import java.util.List;

public class AgentDaoImpl implements IAgentDao {

    @Override
    public int save(Agent ) throws SQLException {

        return 0;
    }

    @Override
    public void delete(Agent agent) throws SQLException {

    }

    @Override
    public List<Agent> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public void update(Agent agent) throws SQLException {

    }

    @Override
    public Agent findById() throws SQLException {
        return null;
    }

    @Override
    public Agent findByEmailAndPassword() throws SQLException {
        return null;
    }
}
