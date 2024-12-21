package gestion_commercial.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface IDataBase {

    void openConnexion() throws SQLException;

    void closeConnexion() throws SQLException;

    int executeUpdate(String sql, byte[] image) throws SQLException;

    ResultSet executeSelect(String sql) throws SQLException;
}
