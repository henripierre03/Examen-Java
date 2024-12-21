package gestion_commercial.dao;

import java.sql.*;

public class Database implements IDataBase {

    private Connection conn;
    private String tableName;

    public Database() {
        conn = null;
    }

    public void closeConnexion() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeSelect(String sql) {
        ResultSet rs = null;
        Statement stmt = null;
        try {
            // 1. Ouvre la Connexion
            openConnexion();
            // 2. Crée un objet Statement
            stmt = conn.createStatement();
            // 3. Exécute la requête
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int executeUpdate(String sql, byte[] image) {
        int result = 0;
        PreparedStatement stmt = null;
        try {
            // 1. Ouvre la Connexion
            openConnexion();
            // 2. Prépare la requête
            stmt = conn.prepareStatement(sql);
            if (image != null) {
                stmt.setBytes(1, image);  // Ajoute l'image en tant que paramètre
            }
            // 3. Exécute la requête
            if (sql.toLowerCase().startsWith("insert")) {
                // Pour une requête d'insertion, retourne l'ID inséré
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    result = rs.getInt(1);  // Retourne le dernier ID inséré
                }
            } else {
                // Pour une requête de mise à jour ou suppression, retourne le nombre de lignes affectées
                result = stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            closeConnexion();
        }
        return result;
    }

    public void openConnexion() {
        try {
            if (conn == null || conn.isClosed()) {
                // Chaine de Connexion
                String url = "jdbc:sqlserver://DESKTOP-Q57ESL7\\SQLEXPRESS01;databaseName=gescom_ism_2021;integratedSecurity=true;";
                conn = DriverManager.getConnection(url);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
