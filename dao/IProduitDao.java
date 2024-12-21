package gestion_commercial.dao;

import gestion_commercial.dto.ProduitDto;
import gestion_commercial.models.Produit;
import java.sql.ResultSet;

public interface IProduitDao extends IDAO<Produit> {
    ResultSet findProduitByReference(String reference);
    int update(ProduitDto produit);
}
