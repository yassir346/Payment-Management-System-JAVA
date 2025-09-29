import DAO.Impl.AgentDaoImpl;
import DAO.Impl.DepartementDaoImpl;
import config.DB;
import controller.AgentController;
import controller.DirecteurController;
import controller.ResponsableController;
import models.Agent;
import models.Departement;
import models.TypeAgent;
import service.Ipml.AgentServiceIpml;

import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {



//        Agent agt4 = new Agent("new", "new", "new", "new", 13, TypeAgent.STAGIAIRE, dpt, null);
//        Agent agt2 = new Agent("ahmed", "foulan", "email2", "password3", 1, TypeAgent.STAGIAIRE, dpt, null);
//        Agent agt3 = new Agent("kamal", "foul", "email3", "password4", 1, TypeAgent.RESPONSABLE_DEPARTEMENT, dpt, null);
//        Agent agt1 = agentService.findById(13);
//        System.out.println(agt1);


        ResponsableController resCont = new ResponsableController();
        resCont.ajouterAgent(new Agent());



    }

}