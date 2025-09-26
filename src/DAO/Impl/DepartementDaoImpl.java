package DAO.Impl;

import DAO.IDepartementDao;
import config.DB;
import models.Agent;
import models.Departement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartementDaoImpl implements IDepartementDao {

    static Connection connection;

    static {
        try{
            connection = DB.connect();
        }catch(SQLException e){
            e.getMessage();
        }
    }

    @Override
    public int save(Departement departement) throws SQLException {

        String sql = "INSERT INTO departments(iddepartement, nom) VALUES(?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, departement.getIdDepartement());
        preparedStatement.setString(2, departement.getNom());
        return preparedStatement.executeUpdate();
    }

    @Override
    public int delete(int id) throws SQLException {
        String sql = "delete from departments where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }

    @Override
    public int update(Departement departement) throws SQLException {
        String sql = "update departments set nom = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, departement.getNom());
        preparedStatement.setInt(2, departement.getIdDepartement());
        return preparedStatement.executeUpdate();
    }

    @Override
    public List<Departement> getAll() throws SQLException {
        String sql = "select * from departements";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Departement> departements = new ArrayList<>();
        while (resultSet.next()) {
            Departement department = new Departement();
            department.setIdDepartement(resultSet.getInt("id"));
            department.setNom(resultSet.getString("nom"));

        }
        return departements;
    }

    @Override
    public Departement findByID(int id) throws SQLException {
        String sql = "select * from departements where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        Departement department = new Departement();
        while (resultSet.next()) {
            department.setIdDepartement(resultSet.getInt("id"));
            department.setNom(resultSet.getString("nom"));
        }
        return department;
    }

    @Override
    public Departement findByName(String nomDepartement) throws SQLException {
        String sql = "select * from departements where nom = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, nomDepartement);
        ResultSet resultSet = preparedStatement.executeQuery();
        Departement department = new Departement();

        if (!resultSet.isBeforeFirst()) {
            System.out.println("ResultSet is empty.");
            return null;
        } else {
            while (resultSet.next()) {
                department.setIdDepartement(resultSet.getInt("id"));
                department.setNom(resultSet.getString("nom"));
            }
        }
        return department;
    }

    @Override
    public void assignerResponsable(Departement departement, Agent responsable) throws SQLException {
        String sql = "update agents set department_id = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, departement.getIdDepartement());
        preparedStatement.setInt(2, responsable.getIdAgent());
        preparedStatement.executeUpdate();
    }
}

