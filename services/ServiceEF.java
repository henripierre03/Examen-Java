package gestion_commercial.services;

import gestion_commercial.dto.ProduitDto;
import gestion_commercial.entity.*;
import gestion_commercial.models.*;
import java.util.*;
import java.sql.*;

public class ServiceEF {

    private Database dao = new Database();

    // Ajouter une commande
    public int addCommande(Commande commande, List<ProduitDto> produits, Client client) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Ajouter un produit
    public int addProduit(Produit prod) {
        dao.getProduits().add(prod);
        return dao.saveChanges();
    }

    // Ajouter un utilisateur
    public int addUser(User user) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Supprimer un produit
    public int deleteProduit(int id) {
        Produit prodDel = dao.getProduits().stream()
                             .filter(prod -> prod.getId() == id)
                             .findFirst()
                             .orElse(null);
        if (prodDel != null) {
            dao.getProduits().remove(prodDel);
            return dao.saveChanges();
        }
        return 0;  // 0 pour échec de la suppression
    }

    // Supprimer un utilisateur
    public int deleteUser(int id) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Rechercher un client par numéro
    public DataTable searchClientByNumero(String numero) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Rechercher un produit par référence
    public DataTable searchProduitByReference(String reference) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Rechercher un utilisateur par login et mot de passe
    public User searchUserLoginAndPassword(String login, String password) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Afficher toutes les catégories
    public DataTable showAllCategories() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Afficher toutes les commandes
    public List<Commande> showAllCommandes() {
        return dao.getCommandes();
    }

    // Afficher toutes les commandes par date
    public List<Commande> showAllCommandes(Date date) {
        return dao.getCommandes().stream()
                  .filter(cmde -> cmde.getDateCmde().compareTo(date) == 0)
                  .sorted(Comparator.comparing(Commande::getDateCmde).reversed())
                  .toList();
    }

    // Afficher toutes les commandes par statut
    public List<Commande> showAllCommandes(Statut etat) {
        return dao.getCommandes().stream()
                  .filter(cmde -> cmde.getStatut().toString().equals(etat.toString()))
                  .sorted(Comparator.comparing(Commande::getDateCmde).reversed())
                  .toList();
    }

    // Afficher toutes les commandes par téléphone
    public List<Commande> showAllCommandes(String telephone) {
        return dao.getCommandes().stream()
                  .filter(cmde -> cmde.getUtilisateur().getTelephone().equals(telephone))
                  .toList();
    }

    // Afficher une commande par ID
    public Commande showCommandeById(int id) {
        return dao.getCommandes().stream()
                  .filter(cmde -> cmde.getId() == id)
                  .findFirst()
                  .orElse(null);
    }

    // Afficher toutes les commandes par statut et téléphone
    public List<Commande> showAllCommandes(Statut etat, String telephone) {
        return dao.getCommandes().stream()
                  .filter(cmde -> cmde.getStatut().toString().equals(etat.toString()) &&
                                 cmde.getUtilisateur().getTelephone().equals(telephone))
                  .sorted(Comparator.comparing(Commande::getDateCmde).reversed())
                  .toList();
    }

    // Afficher tous les produits
    public DataTable showAllProduits() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Afficher tous les rôles
    public DataTable showAllRole() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Afficher toutes les sous-catégories
    public DataTable showAllSousCategories() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Afficher toutes les sous-catégories d'une catégorie par ID
    public DataTable showAllSousCategories(int idCat) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Afficher tous les utilisateurs
    public DataTable showAllUsers() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    // Mettre à jour un produit
    public int updateProduit(Produit prod) {
        Produit prodUp = dao.getProduits().stream()
                            .filter(prods -> prods.getId() == prod.getId())
                            .findFirst()
                            .orElse(null);
        if (prodUp != null) {
            dao.getProduits().remove(prodUp);
            dao.getProduits().add(prod);
            return dao.saveChanges();
        }
        return 0;
    }

    // Mettre à jour une commande
    public int updateCommande(Commande cmd) {
        Commande cmdeUp = dao.getCommandes().stream()
                             .filter(cmde -> cmde.getId() == cmd.getId())
                             .findFirst()
                             .orElse(null);
        if (cmdeUp != null) {
            cmdeUp.setStatut(cmd.getStatut());
            return dao.saveChanges();
        }
        return 0;
    }

    // Mettre à jour un utilisateur
    public int updateUser(User user) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
}
