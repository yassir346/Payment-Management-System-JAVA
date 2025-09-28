package service.Ipml;

import DAO.Impl.DepartementDaoImpl;
import models.Agent;
import models.Departement;
import service.IDepartementService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartementServiceIplm implements IDepartementService {

    DepartementDaoImpl departementDao;

    public DepartementServiceIplm(){
        this.departementDao = new DepartementDaoImpl();
    }


    @Override
    public Departement save(Departement departement) throws SQLException {
        if(departement != null){
            try{
                int num = departementDao.save(departement);
                if(num > 0){
                    System.out.println("Departement ajouté.");
                }else{
                    System.out.println("Depatement n'est pas ajouté.");
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return departement;
    }

    @Override
    public Departement update(Departement departement) throws SQLException {
        try {
            this.departementDao.update(departement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departement;
    }

    @Override
    public void delete(int id) throws SQLException {
        try{
            this.departementDao.delete(id);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Departement> getAll() throws SQLException {
        List<Departement> departements = new ArrayList<>();
        try{
            this.departementDao.getAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return departements;
    }

    @Override
    public Departement findById(int id) throws SQLException {
        Departement departement = null;
        try {
            departement = this.departementDao.findByID(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departement;
    }

    @Override
    public Departement findByName(String nomDep) throws SQLException {
        Departement departement = null;
        try {
            departement = this.departementDao.findByName(nomDep);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departement;
    }

    @Override
    public void assignerResponsable(Departement departement, Agent responsable) throws SQLException {
        try{
            int num = this.departementDao.assignerResponsable(departement, responsable);
            if(num == 1){
                System.out.println("responsable est ajouté avec succés");
            }else {
                System.out.println("responsable n'est pas ajouté");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
