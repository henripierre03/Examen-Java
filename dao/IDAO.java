package gestion_commercial.dao;

import java.sql.ResultSet;
import java.util.List;

public interface IDAO<T> {
    int insert(T obj);
    int update(T obj);
    int delete(int id);
    ResultSet findAll();
    T findById(int id);
}
