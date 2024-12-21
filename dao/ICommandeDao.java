package gestion_commercial.dao;

import gestion_commercial.models.Commande;
import gestion_commercial.models.Client;
import gestion_commercial.models.Statut;
import java.sql.ResultSet;
import java.util.Date;

public interface ICommandeDao extends IDAO<Commande> {
    ResultSet findAllCommandes(Date date);
    ResultSet findAllCommandes(Date date, Statut etat);
    ResultSet findAllCommandes(Date date, Statut etat, Client client);
}
