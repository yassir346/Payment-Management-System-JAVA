import DAO.Impl.AgentDaoImpl;
import DAO.Impl.DepartementDaoImpl;
import config.DB;
import models.Agent;
import models.Departement;
import models.TypeAgent;

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
        DepartementDaoImpl saveDptTest = new DepartementDaoImpl();

        Agent agt1 = new Agent("nom", "prenom", "email", "password", 1, TypeAgent.OUVRIER, dpt, null);
        Agent agt2 = new Agent("ahmed", "foulan", "email2", "password3", 1, TypeAgent.STAGIAIRE, dpt, null);

        dpt.setResponsable(agt2);

//        test.save(agt2);
//
//        try{
//            test.save(agt2);
//            System.out.println("row has been inserted");
//
//        }catch (Exception e){
//            e.getMessage();
//            System.out.println("hsbdcuhbszu");
//        }

        test.delete(agt1);

//        saveDptTest.saveDepartement(dpt);







    }




}