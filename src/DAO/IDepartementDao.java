package DAO;

import models.Agent;
import models.Departement;

import java.sql.SQLException;
import java.util.List;

public interface IDepartementDao{
    public  int save(Departement departement) throws SQLException;
    public  int delete(int id) throws SQLException;
    public int update(Departement departement) throws SQLException;
    public List<Departement> getAll() throws SQLException;
    public Departement findByID(int id) throws SQLException;
    public Departement findByName(String nomDepartement) throws SQLException;
    public void assignerResponsable(Departement departement, Agent agent) throws SQLException;



}
