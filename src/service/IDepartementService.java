package service;

import models.Agent;
import models.Departement;

import java.sql.SQLException;
import java.util.List;

public interface IDepartementService {
    Departement save(Departement departement) throws SQLException;
    Departement update(Departement departement) throws SQLException;
    void delete(int id) throws SQLException;
    List<Departement> getAll() throws SQLException;
    Departement findById(int id) throws SQLException;
    Departement findByName(String nomDep) throws SQLException;
    void assignerResponsable(Departement departement, Agent responsable) throws SQLException;

}
