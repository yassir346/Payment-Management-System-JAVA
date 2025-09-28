import DAO.Impl.AgentDaoImpl;
import DAO.Impl.DepartementDaoImpl;
import config.DB;
import models.Agent;
import models.Departement;
import models.TypeAgent;
import service.Ipml.AgentServiceIpml;

import java.sql.SQLException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws SQLException {
//        try(var connection = DB.connect()){
//            System.out.println("Connected to the PostgreSQL database.");
//        }catch (SQLException e){
//            System.err.println(e.getMessage());
//        }

        //--------------------------------------------------------------------------------

        Departement dpt = new Departement(1, "RH");

        AgentDaoImpl test = new AgentDaoImpl();
        AgentServiceIpml  agentService = new AgentServiceIpml();
        DepartementDaoImpl saveDptTest = new DepartementDaoImpl();

        Agent agt4 = new Agent("new", "new", "new", "new", 13, TypeAgent.STAGIAIRE, dpt, null);
//        Agent agt2 = new Agent("ahmed", "foulan", "email2", "password3", 1, TypeAgent.STAGIAIRE, dpt, null);
//        Agent agt3 = new Agent("kamal", "foul", "email3", "password4", 1, TypeAgent.RESPONSABLE_DEPARTEMENT, dpt, null);
        Agent agt1 = agentService.findById(13);
        System.out.println(agt1);

//        dpt.setResponsable(agt2);

//        agentService.supprimer(agt1);
        agt1 = agt4;
        agentService.modifier(agt1);

    }

}