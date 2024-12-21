package gestion_commercial.dao;

import gestion_commercial.models.Client;
import java.sql.ResultSet;

public interface IClientDao extends IDAO<Client> {
    ResultSet findClientByTelephone(String telephone);
}
