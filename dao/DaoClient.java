package gestion_commercial.dao;

import gestion_commercial.models.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoClient extends Database implements IClientDao {

    private String tableName;

    public DaoClient() {
        this.tableName = "client";
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Client> findAll() {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public Client findById(int id) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public List<Client> findClientByTelephone(String telephone) {
        String sql = "SELECT id, nom_complet, adresse FROM utilisateur WHERE telephone LIKE ?";
        List<Client> clients = new ArrayList<>();
        
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + telephone + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nomComplet = rs.getString("nom_complet");
                String adresse = rs.getString("adresse");

                Client client = new Client(id, nomComplet, adresse);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clients;
    }

    @Override
    public int insert(Client obj) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @Override
    public int update(Client obj) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
