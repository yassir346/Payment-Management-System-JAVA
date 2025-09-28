package service.Ipml;

import DAO.Impl.AgentDaoImpl;
import models.Agent;
import service.IAgentService;

import java.sql.SQLException;

public class AgentServiceIpml implements IAgentService {

    AgentDaoImpl agentDao;

    public AgentServiceIpml(){
        this.agentDao = new AgentDaoImpl();
    }

    @Override
    public void ajouter(Agent agent) {
        if(agent != null){
            try{
                int num = agentDao.save(agent);
                if(num > 0){
                    System.out.println("Agent est ajouté avec succés.");
                }else {
                    System.out.println("Agent n'est pas ajouté.");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            System.out.println("Agent is null");
        }
    }

    @Override
    public void supprimer(Agent agent) {
//        System.out.println(agent.toString());
        if(agent != null){
            try{
                int result = this.agentDao.delete(agent);
                if(result > 0){
                    System.out.println("Agent supprimé.");
                }else{
                    System.out.println("Agent n'est pas supprimé.");
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else {
            System.out.println("Agent is doesn't exist");
        }
    }

    @Override
    public void modifier(Agent agent) {
        try{
            int num = agentDao.update(agent);
            if(num > 0){
                System.out.println("Agent est modifié avec succés.");
            }else{
                System.out.println("Agent n'est pas modifié");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Agent findById(int id) throws SQLException {
        Agent agent = null;
        try{
            agent = agentDao.findById(id);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return agent;
    }

    @Override
    public Agent findByEmail(String email) {
        Agent agent = null;
        try{
            agent = agentDao.findByEmail(email);
        }catch(Exception e){
            e.printStackTrace();
        }

        return agent;
    }

    @Override
    public void calculerPaiementAgent(Agent agent) {

    }
}
