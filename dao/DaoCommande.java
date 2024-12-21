package gestion_commercial.dao;

import gestion_commercial.models.Client;
import gestion_commercial.models.Commande;
import gestion_commercial.models.Statut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class DaoCommande extends Database implements ICommandeDao {

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public DataTable findAll() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public DataTable findAllCommandes(Date date) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public DataTable findAllCommandes(Date date, Statut etat) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public DataTable findAllCommandes(Date date, Statut etat, Client client) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Commande findById(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public int insert(Commande commande) {
        String sql = "INSERT INTO commande (date_cmde, total, statut, client_id) " +
                     "VALUES (?, ?, 'Encours', ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, new String[]{"ID"})) {

            stmt.setTimestamp(1, new Timestamp(new Date().getTime())); // Date actuelle
            stmt.setDouble(2, commande.getTotal());
            stmt.setInt(3, commande.getClient().getId());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                // Récupérer l'ID généré
                var rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1); // Retourner l'ID inséré
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // En cas d'erreur ou d'absence de résultat
    }

    @Override
    public int update(Commande obj) {
        t
