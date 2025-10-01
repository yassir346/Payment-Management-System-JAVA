package DAO.Impl;

import DAO.IPaiementDao;
import config.DB;
import models.Agent;
import models.Paiement;
import models.TypePaiement;
import org.w3c.dom.html.HTMLImageElement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PaiementDaoImpl implements IPaiementDao {

    static Connection connection;

    static {
        try {
            connection = DB.connect();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Paiement creerPaiement(Paiement paiement, Agent agent) throws SQLException {
        String sql = "INSERT INTO payments(typepayment, amount, date, motif, conditionvalide, agent_id) VALUES(?::typepayment,?,?::date,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(paiement.getTypePaiement()));
        preparedStatement.setDouble(2, paiement.getMontant());
        preparedStatement.setString(3, paiement.getDate().toString());
        preparedStatement.setString(4,paiement.getMotif());
        preparedStatement.setBoolean(5,paiement.isConditionValid());
        preparedStatement.setInt(6,agent.getIdAgent());
        preparedStatement.executeUpdate();

        return paiement;
    }

    @Override
    public Paiement modifierPaiement(Paiement paiement) throws SQLException {
        String sql = "UPDATE payments SET typepayment=? , amount=? , date=? , motif=? , conditionvalide=? , agent_id=? , WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, String.valueOf(paiement.getTypePaiement()));
        preparedStatement.setDouble(2, paiement.getMontant());
        preparedStatement.setString(3, paiement.getDate().toString());
        preparedStatement.setString(4, paiement.getMotif());
        preparedStatement.setBoolean(5, paiement.isConditionValid());
        preparedStatement.setInt(6, paiement.getAgent().getIdAgent());
        preparedStatement.executeUpdate();
        return paiement;
    }

    @Override
    public int supprimerPaiement(int id) throws SQLException {
        String sql = "DELETE FROM payments WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        int num = preparedStatement.executeUpdate();
        return num;
    }

    @Override
    public Paiement getById(int id) throws SQLException {

        String sql = "SELECT * FROM payments WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        Paiement paiement = null;
        while(resultSet.next()){
            paiement.setIdPaiement(resultSet.getInt("id"));
            paiement.setTypePaiement(TypePaiement.valueOf(resultSet.getString("typepaiment")));
            paiement.setMontant(resultSet.getDouble("amount"));
            paiement.setDate(resultSet.getDate("date").toLocalDate());
            paiement.setMotif(resultSet.getString("motif"));
            paiement.setConditionValid(resultSet.getBoolean("conditionvalide"));
        }
        return paiement;
    }

    @Override
    public List<Paiement> getByAgentId(Agent agent) throws SQLException {
        String sql = "SELECT * FROM payments WHERE agent_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, agent.getIdAgent());
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Paiement> paiements = null;
        while(resultSet.next()){
            Paiement paiement = new Paiement();
            paiement.setIdPaiement(resultSet.getInt("id"));
            paiement.setTypePaiement(TypePaiement.valueOf(resultSet.getString("typepaiment")));
            paiement.setMontant(resultSet.getDouble("amount"));
            paiement.setDate(resultSet.getDate("date").toLocalDate());
            paiement.setMotif(resultSet.getString("motif"));
            paiement.setConditionValid(resultSet.getBoolean("conditionvalide"));
            paiement.setAgentId(resultSet.getInt("agent_id"));
            paiements.add(paiement);
        }
        return paiements;
    }

    @Override
    public List<Paiement> paiements() throws SQLException {
        String sql = "SELECT * FROM payments";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Paiement> paiements = new ArrayList<>();

        while(resultSet.next()){
            Paiement paiement = new Paiement();
            paiement.setIdPaiement(resultSet.getInt("id"));
            paiement.setTypePaiement(TypePaiement.valueOf(resultSet.getString("typepaiment")));
            paiement.setMontant(resultSet.getDouble("amount"));
            paiement.setDate(resultSet.getDate("date").toLocalDate());
            paiement.setMotif(resultSet.getString("motif"));
            paiement.setConditionValid(resultSet.getBoolean("conditionvalide"));
            paiement.setAgentId(resultSet.getInt("agent_id"));
            paiements.add(paiement);
        }
        return paiements;
    }

    @Override
    public List<Paiement> paiementsParType(String type) throws SQLException {
        String sql = "SELECT * FROM payments WHERE typepayment = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, type);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Paiement> paiements = new ArrayList<>();

        while(resultSet.next()){
            Paiement paiement = new Paiement();
            paiement.setIdPaiement(resultSet.getInt("id"));
            paiement.setTypePaiement(TypePaiement.valueOf(resultSet.getString("typepaiment")));
            paiement.setMontant(resultSet.getDouble("amount"));
            paiement.setDate(resultSet.getDate("date").toLocalDate());
            paiement.setMotif(resultSet.getString("motif"));
            paiement.setConditionValid(resultSet.getBoolean("conditionvalide"));
            paiement.setAgentId(resultSet.getInt("agent_id"));
            paiements.add(paiement);
        }
        return paiements;
    }

    @Override
    public List<Paiement> paiementsParMontant(Double montant) throws SQLException {
        String sql = "SELECT * FROM payments WHERE amount = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, montant);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Paiement> paiements = new ArrayList<>();

        while(resultSet.next()){
            Paiement paiement = new Paiement();
            paiement.setIdPaiement(resultSet.getInt("id"));
            paiement.setTypePaiement(TypePaiement.valueOf(resultSet.getString("typepaiment")));
            paiement.setMontant(resultSet.getDouble("amount"));
            paiement.setDate(resultSet.getDate("date").toLocalDate());
            paiement.setMotif(resultSet.getString("motif"));
            paiement.setConditionValid(resultSet.getBoolean("conditionvalide"));
            paiement.setAgentId(resultSet.getInt("agent_id"));
            paiements.add(paiement);
        }
        return paiements;
    }

    @Override
    public List<Paiement> paiementsParDate(Date date) throws SQLException {
        String sql = "SELECT * FROM payments WHERE date = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDate(1, (java.sql.Date) date);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Paiement> paiements = new ArrayList<>();

        while(resultSet.next()){
            Paiement paiement = new Paiement();
            paiement.setIdPaiement(resultSet.getInt("id"));
            paiement.setTypePaiement(TypePaiement.valueOf(resultSet.getString("typepaiment")));
            paiement.setMontant(resultSet.getDouble("amount"));
            paiement.setDate(resultSet.getDate("date").toLocalDate());
            paiement.setMotif(resultSet.getString("motif"));
            paiement.setConditionValid(resultSet.getBoolean("conditionvalide"));
            paiement.setAgentId(resultSet.getInt("agent_id"));
            paiements.add(paiement);
        }
        return paiements;
    }
}
