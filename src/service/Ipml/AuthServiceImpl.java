package service.Ipml;

import DAO.Impl.AgentDaoImpl;
import models.Agent;
import models.Departement;
import service.IAuthService;
import service.IDepartementService;

import javax.sound.midi.Soundbank;
import java.sql.SQLException;
import java.util.Map;

public class AuthServiceImpl implements IAuthService {

    private AgentDaoImpl agentDao;
    private IDepartementService departementService;

    public AuthServiceImpl(){
        this.agentDao = new AgentDaoImpl();
        this.departementService = new DepartementServiceIplm();
    }
    @Override
    public Agent login(String email, String password) throws SQLException {

        Map<String, Object> map = agentDao.findByEmailAndPassword(email, password);
        Agent agent = (Agent) map.get("agent");
        agent.setDepartement(this.departementService.findById((Integer) map.get("departementId")));

        return agent;
    }
}
