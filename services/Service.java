package gestion_commercial.services;

import gestion_commercial.dao.*;
import gestion_commercial.dto.ProduitDto;
import gestion_commercial.models.*;
import java.util.*;
import java.sql.*;

public class Service {

    // Couplage faible avec les DAO
    private IUserDao userDao;
    private IClientDao clientDao;
    private ICommandeDao cmdeDao;
    private IRoleDao roleDao;
    private IProduitDao produitDao;
    private IDetailDao detailDao;
    private ISousCategorie sousCatDao;

    // Constructeur sans dépendance
    public Service() {}

    // Injection de dépendance via le constructeur
    public Service(IUserDao userDao, IClientDao clientDao, ICommandeDao cmdeDao,
                   IRoleDao roleDao, IProduitDao produitDao, IDetailDao detailDao, ISousCategorie sousCatDao) {
        this.userDao = userDao;
        this.clientDao = clientDao;
        this.cmdeDao = cmdeDao;
        this.roleDao = roleDao;
        this.produitDao = produitDao;
        this.detailDao = detailDao;
        this.sousCatDao = sousCatDao;
    }

    // Getters et Setters
    public IUserDao getUserDao() { return userDao; }
    public void setUserDao(IUserDao userDao) { this.userDao = userDao; }

    public IClientDao getClientDao() { return clientDao; }
    public void setClientDao(IClientDao clientDao) { this.clientDao = clientDao; }

    public ICommandeDao getCmdeDao() { return cmdeDao; }
    public void setCmdeDao(ICommandeDao cmdeDao) { this.cmdeDao = cmdeDao; }

    public IRoleDao getRoleDao() { return roleDao; }
    public void setRoleDao(IRoleDao roleDao) { this.roleDao = roleDao; }

    public IProduitDao getProduitDao() { return produitDao; }
    public void setProduitDao(IProduitDao produitDao) { this.produitDao = produitDao; }

    public IDetailDao getDetailDao() { return detailDao; }
    public void setDetailDao(IDetailDao detailDao) { this.detailDao = detailDao; }

    public ISousCategorie getSousCatDao() { return sousCatDao; }
    public void setSousCatDao(ISousCategorie sousCatDao) { this.sousCatDao = sousCatDao; }

    // Ajouter une commande
    public int addCommande(Commande commande, List<ProduitDto> produits, Client client) {
        commande.setClient(client);
        int idCmde = cmdeDao.insert(commande);
        for (ProduitDto produitDto : produits) {
            DetailCommande detail = new DetailCommande();
            detail.setProduit(produitDto.dtoToModel());
            detail.setCommande(new Commande(idCmde));
            detail.setQteCom(produitDto.getQteComd());
            if (detailDao.insert(detail) != 0) {
                produitDto.setQteStock(produitDto.getQteStock() - produitDto.getQteComd());
                produitDao.update(produitDto);
            }
        }
        return idCmde;
    }

    // Ajouter un produit
    public int addProduit(Produit produit) {
        return produitDao.insert(produit);
    }

    // Ajouter un utilisateur
    public int addUser(User user) {
        return userDao.insert(user);
    }

    
