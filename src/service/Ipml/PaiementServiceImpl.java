package service.Ipml;

import DAO.IPaiementDao;
import DAO.Impl.PaiementDaoImpl;
import models.Agent;
import models.Paiement;
import service.IPaiementService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaiementServiceImpl implements IPaiementService {
    private IPaiementDao paiementDao;

    public PaiementServiceImpl() {
        this.paiementDao = new PaiementDaoImpl();
    }

    @Override
    public Paiement creerPaiement(Paiement paiement, Agent agent) throws SQLException {
        try{
            Paiement paiement1 = this.paiementDao.creerPaiement(paiement, agent);
            if(paiement1 != null){
                System.out.println("Paiement est créé");
            }else{
                System.out.println("paiement n'est pas créé");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return paiement;
    }

    @Override
    public Paiement modifierPaiement(Paiement paiement) throws SQLException {
        Paiement paiement1;
        try{
            paiement1 = this.paiementDao.modifierPaiement(paiement);
            if(paiement1 != null){
                System.out.println("Paiement est modifié");
            }else{
                System.out.println("paiement n'est pas modifié");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return paiement;
    }

    @Override
    public void supprimerPaiement(int id) throws SQLException {
        try{
            int num = this.paiementDao.supprimerPaiement(id);
            if(num != 0){
                System.out.println("Paiement est supprimé");
            }else{
                System.out.println("paiement n'est pas supprimé");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Paiement getById(int id) throws SQLException {
        Paiement paiement = new Paiement();
        try{
            paiement = this.paiementDao.getById(id);
            if(paiement != null){
                System.out.println("Paiement est trouvé");
            }else{
                System.out.println("paiement n'est pas trouvé");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return paiement;
    }

    @Override
    public List<Paiement> getByAgentId(Agent agent) throws SQLException {
        List<Paiement> paiements = new ArrayList<>();
        try{
            paiements = this.paiementDao.getByAgentId(agent);
            if(paiements != null){
                System.out.println("list Paiement est trouvé");
            }else{
                System.out.println("Listpaiement n'est pas trouvé");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return paiements;
    }

    @Override
    public List<Paiement> paiements() throws SQLException {
        List<Paiement> paiements = new ArrayList<>();
        try{
            paiements = this.paiementDao.paiements();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return paiements;
    }

    @Override
    public List<Paiement> paiementsParType(String type) throws SQLException {
        List<Paiement> paiements = new ArrayList<>();
        try{
            paiements = this.paiementDao.paiementsParType(type);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return paiements;
    }

    @Override
    public List<Paiement> paiementsParMontant(Double montant) throws SQLException {
        List<Paiement> paiements = new ArrayList<>();
        try{
            paiements = this.paiementDao.paiementsParMontant(montant);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return paiements;
    }

    @Override
    public List<Paiement> paiementsParDate(Date date) throws SQLException {
        List<Paiement> paiements = new ArrayList<>();
        try{
            paiements = this.paiementDao.paiementsParDate(date);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return paiements;
    }
}
